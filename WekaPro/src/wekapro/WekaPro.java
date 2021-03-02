/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapro;

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
        MyKnowleadgeModel model = new MyKnowleadgeModel("C:\\Program Files\\Weka-3-8-5\\data\\iris.arff");
        System.out.println(model);
        model.saveDta("E:\\Data\\LTHDT\\Data\\iris.arff");
        model.saveData2CSV("E:\\Data\\LTHDT\\Data\\iris_CSV.csv");
    }
    
}
