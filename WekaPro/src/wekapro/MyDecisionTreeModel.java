package wekapro;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Debug;
import weka.core.Debug.Random;
import weka.core.Instances;

/**
 *
 * @author ttysa
 */
public class MyDecisionTreeModel extends MyKnowleadgeModel {

    J48 tree;

    public MyDecisionTreeModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
    }

    public void buildDecisionTree() throws Exception {
        //Tao tap du lieu train & test
        this.trainset = divideTrainTestR(this.dataset, 80, false);
        this.testset = divideTrainTestR(this.dataset, 80, true);
        this.trainset.setClassIndex(this.trainset.numAttributes() - 1);
        this.testset.setClassIndex(this.testset.numAttributes() - 1);

        //Thiet lap thong so cho mo hinh cay quyet dinh
        tree = new J48();
        tree.setOptions(this.model_options);

        //Huan luyen mo hinh voi tap du lieu train
        tree.buildClassifier(this.trainset);
    }

//    public void evaluateDecisionTree() throws Exception {
//        Evaluation eval = new Evaluation(this.trainset);
//        eval.evaluateModel(tree, this.testset);
//        System.out.println(eval.toSummaryString("\nKet qua danh gia mo hinh\n-----\n", false));
//    }
    public void evaluateDecisionTree() throws Exception {
        Random rnd = new Debug.Random(1);
        int folds = 10;
        Evaluation eval = new Evaluation(this.trainset);
        eval.crossValidateModel(tree, this.testset, folds, rnd);
        System.out.println(eval.toSummaryString("\nKet qua danh gia mo hinh 10-fold cross-ValidateModel\n-----\n", false));
    }

    public void predictClassLabel(Instances input) throws Exception {
        for (int i = 0; i < input.numInstances(); i++) {
            double predict = tree.classifyInstance(input.instance(i));
            double actual = input.instance(i).classValue();
            System.out.println("Instances " + i
                    + "; predict = " + input.classAttribute().value((int) predict)
                    + "; actual = " + input.classAttribute().value((int) actual));
            //input.instance(i).setClassValue(predict);
        }
    }

    @Override
    public String toString() {
        return tree.toSummaryString();
    }

}
