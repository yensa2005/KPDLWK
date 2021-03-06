/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapro;

import weka.classifiers.trees.J48;

/**
 *
 * @author ttysa
 */
public class WekaPro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //        MyKnowleadgeModel model = new MyKnowleadgeModel("C:\\Program Files\\Weka-3-8-5\\data\\iris.arff");
        //        System.out.println(model);
        //        model.saveData("E:\\Data\\LTHDT\\Data\\iris.arff");
        //        model.saveData2CSV("E:\\Data\\LTHDT\\Data\\iris_CSV.csv");

        //MyAprioriModel
        //     MyAprioriModel model = new MyAprioriModel("C:\\Program Files\\Weka-3-8-5\\data\\supermarket.arff",
        //                                               "-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1",
        //                                               "-R 1-9,11,57,70,79-81,88-89,98,100-102,107-114,116-120,122-130,137-179,189,192-199,201-216");
        //     
        //        model.mineAssociationRules();
        //        System.out.println(model);
        //    MyAprioriModel model = new MyAprioriModel("C:\\Program Files\\Weka-3-8-5\\data\\weather.numeric.arff",
        //                                              "-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1",
        //                                              "-R 2-3");
        //     
        //        model.mineAssociationRules();
        //        System.out.println(model);
        //MyFPGrowthModel
//            MyFPGrowthModel model = new MyFPGrowthModel("C:\\Program Files\\Weka-3-8-5\\data\\supermarket.arff",
//                                                        "-P 2 -I -1 -N 10 -T 0 -C 0.8 -D 0.05 -U 1.0 -M 0.2", 
//                                                        "-R 1-9,11,57,70,79-81,88-89,98,100-102,107-114,116-120,122-130,137-179,189,192-199,201-216");
//           model.mineAssociationRules();
//           System.out.println(model);
        //    MyFPGrowthModel model = new MyFPGrowthModel("C:\\Program Files\\Weka-3-8-5\\data\\weather.nominal.arff",
        //                                                "-P 2 -I -1 -N 10 -T 0 -C 0.7 -D 0.05 -U 1.0 -M 0.2", 
        //                                                "-N -R first-last");
        //    model.mineAssociationRules();
        //    System.out.println(model);
        //    } 
        //RemovePercentage
        //        MyKnowleadgeModel model = new MyKnowleadgeModel("C:\\Program Files\\Weka-3-8-5\\data\\iris.arff", null, null);
        //        model.trainset = model.divideTrainTest(model.dataset, 30, false);
        //        model.testset = model.divideTrainTest(model.dataset, 30, true);
        //        System.out.println(model);
        //        System.out.println(model.trainset.toSummaryString());
        //        System.out.println(model.testset.toSummaryString());
        //Resample
        //        MyKnowleadgeModel model = new MyKnowleadgeModel("C:\\Program Files\\Weka-3-8-5\\data\\iris.arff", null, null);
        //        model.trainset = model.divideTrainTestR(model.dataset, 70, false);
        //        model.testset = model.divideTrainTestR(model.dataset, 70, true);
        //        System.out.println(model);
        //        System.out.println(model.trainset.toSummaryString());
        //        System.out.println(model.testset.toSummaryString());
        //MyDecisionTreeModel
//        MyDecisionTreeModel model = new MyDecisionTreeModel("C:\\Program Files\\Weka-3-8-5\\data\\iris.arff",
//                "-C 0.25 -M 2", null);
//        model.buildDecisionTree();
//        model.evaluateDecisionTree();
//        System.out.println(model);
//
////        model.saveModel("C:\Users\ttysa\OneDrive\Desktop\goc\data\\decisiontree.model", model.tree);
//        model.tree = (J48) model.loadModel("C:\\Users\\ttysa\\OneDrive\\Desktop\\goc\\data\\decisiontree.model");
//        model.predictClassLabel(model.testset);
        //NaiveBayes
//        MyNaiveBayesModel model = new MyNaiveBayesModel();
//        model.buildNaiveBayes("C:\\Users\\ttysa\\OneDrive\\Desktop\\data-exp\\iris_train.arff");
//        model.evaluateNaiveBayes("C:\\Users\\ttysa\\OneDrive\\Desktop\\data-exp\\iris_test.arff");
//        model.predictClassLabel("C:\\Users\\ttysa\\OneDrive\\Desktop\\data-exp\\iris_unlabel.arff",
//                "C:\\Users\\ttysa\\OneDrive\\Desktop\\data-exp\\iris_predict_nb.arff");
//
//        System.out.println(model);
        //Neural Network
//        
        MyNeuralNetworkModel model = new MyNeuralNetworkModel("",
                "-L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H a -R",
                null);
        model.buildNeuralNetwork("C:\\Users\\ttysa\\OneDrive\\Desktop\\data-exp\\iris_train.arff");
        model.evaluateNeuralNetwork("C:\\Users\\ttysa\\OneDrive\\Desktop\\data-exp\\iris_test.arff");
        model.predictClassLabel("C:\\Users\\ttysa\\OneDrive\\Desktop\\data-exp\\iris_unlabel.arff",
                "C:\\Users\\ttysa\\OneDrive\\Desktop\\data-exp\\iris_predict_ann.arff");

        System.out.println(model);
    }
}
