/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Admin
 */
public class MyNeuralNetworkModel extends MyKnowleadgeModel {

    MultilayerPerceptron neural;

    public MyNeuralNetworkModel() {
        super();
    }

    public DataSource getSource() {
        return source;
    }

    public MyNeuralNetworkModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
    }

    public void buildNeuralNetwork(String filename) throws Exception {
        //doc train set vao bo nho
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes() - 1);
        //Huan luyen mo hinh mang neural
        this.neural = new MultilayerPerceptron();
        neural.setOptions(this.model_options);
        neural.buildClassifier(this.trainset);
    }

    public void evaluateNeuralNetwork(String filename) throws Exception {
        //doc test set vào bo nho
        setTestset(filename);
        this.testset.setClassIndex(this.testset.numAttributes() - 1);
        //danh gia mo hinh bang 10-fold cross validation
        Random rnd = new Random(1);
        int folds = 10;
        Evaluation eval = new Evaluation(this.trainset);
        eval.crossValidateModel(neural, this.testset, folds, rnd);
        System.out.println(eval.toSummaryString(
                "\nKet qua danh gia mo hinh 10-fold cross validation\n----------\n", false));
    }

    public void predictClassLabel(String fileIn, String fileOut) throws Exception {
        //doc du lieu can du doan vao bo nho
        DataSource ds = new DataSource(fileIn);
        Instances unlabel = ds.getDataSet();
        unlabel.setClassIndex(unlabel.numAttributes() - 1);
        //du doan classLabel cho tung instance
        for (int i = 0; i < unlabel.numInstances(); i++) {
            double predict = neural.classifyInstance(unlabel.instance(i));
            unlabel.instance(i).setClassValue(predict);

        }
        //xuat ket qua ra màn hinh
        BufferedWriter outWriter = new BufferedWriter(new FileWriter(fileOut));
        outWriter.write(unlabel.toString());
        outWriter.newLine();
        outWriter.flush();
        outWriter.close();
    }

    @Override
    public String toString() {
        return this.neural.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
