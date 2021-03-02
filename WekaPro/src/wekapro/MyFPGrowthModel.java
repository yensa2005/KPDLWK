/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapro;

import weka.associations.FPGrowth;
import weka.core.Instances;

/**
 *
 * @author ttysa
 */
public class MyFPGrowthModel extends MyKnowleadgeModel {
    Instances newData;
    FPGrowth fp;

    public MyFPGrowthModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
        this.fp = new FPGrowth();
        
    }
    
    public void mineAssociationRules() throws Exception {
        //loc du lieu
        //this.newData = removeData(this.dataset);
          this.newData = convert2Binary(this.dataset);
        
        //thiet lap thong so
        fp.setOptions(model_options);
        
        //khai pha
        fp.buildAssociations(this.newData);
        
    }

    @Override
    public String toString() {
        return fp.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
