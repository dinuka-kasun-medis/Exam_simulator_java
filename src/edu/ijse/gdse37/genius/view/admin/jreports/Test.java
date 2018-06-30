/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.view.admin.jreports;

/**
 *
 * @author Dinuka
 */
public class Test {
    
}
/*
private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
        String total=TotalAmountText.getText();
        String invoiceNo=InvoiceNoText.getText();
        String name=customerNameText1.getText();
        HashMap<String , Object> h1=new HashMap<String , Object>();
        h1.put("param1", total);
        h1.put("invoiceNo", invoiceNo);
        h1.put("name", name);
        try {
            InputStream is= getClass().getResourceAsStream("reports/Invoice.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(is);
            JasperPrint jp=JasperFillManager.fillReport(jr, h1,new JRTableModelDataSource(detailTable.getModel()));
            JasperViewer.viewReport(jp);
        } catch (JRException ex) {
            Logger.getLogger(NewInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
*/