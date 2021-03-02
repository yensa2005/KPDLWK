/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapro;

import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author ttysa
 */
public class MyKnowleadgeModel {
    DataSource source;
    Instances dataset;

    public MyKnowleadgeModel() {
    }
    
    public MyKnowleadgeModel(String filename) throws Exception {
        this.source = new DataSource(filename);
        this.dataset = source.getDataSet();
    }
    
    public void saveDta(String filename) throws IOException{
        ArffSaver outData = new ArffSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(filename));
        outData.writeBatch();
        System.out.println("Finished");
    }
    
    public void saveData2CSV(String filename) throws IOException{
        CSVSaver outData = new CSVSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(filename));
        outData.writeBatch();
        System.out.println("Converted");
        
    }

    @Override
    public String toString() {
        return dataset.toSummaryString();
    }
}
