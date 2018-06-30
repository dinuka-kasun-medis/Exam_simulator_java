/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.view.admin;

import edu.ijse.gdse37.genius.connector.ServerConnector;
import edu.ijse.gdse37.genius_common.controllers.ResultController;
import edu.ijse.gdse37.genius_common.model.Result;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

/**
 * FXML Controller class
 *
 * @author Dinuka
 */
public class ChartController implements Initializable {

    @FXML
    CategoryAxis xAxis;
    @FXML
    NumberAxis yAxis;
    @FXML
    LineChart studentsResultChart;

    ArrayList<String> examList = new ArrayList<>();
    ArrayList<Series> seriesList = new ArrayList<>();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addExams();
        for (Series series : seriesList) {
            studentsResultChart.getData().add(series);
        }
    }

    /*Method for get all exams*/
    private void addExams() {
        try {
            ResultController resultController = ServerConnector.getServerConnector().getResultController();
            ArrayList<String> resultsFiles = resultController.getAllResultFiles();
            int j=resultsFiles.size()-1;
            for (int i = 0; i <10; i++) {
                if (j>=0) {
                    examList.add(resultsFiles.get(j));
                }
                j--;
            }
//            for (String resultsFile : resultsFiles) {
//                examList.add(resultsFile);
//                System.out.println("exam list add");
//            }
            addSeries();
        } catch (NotBoundException ex) {
            Logger.getLogger(ChartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ChartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ChartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*Method for create a new series*/
    private void addSeries(){
        for (String string : examList) {
            XYChart.Series series = new XYChart.Series();
            seriesList.add(series);
            series.setName(string.substring(0, string.length() - 4));
            addData(string, series);
        }
    }
    
    /*Method for add data to series © Dinuka Kasun Medis*/
    private void addData(String name,Series seriesName){
        try {
            ResultController resultController=ServerConnector.getServerConnector().getResultController();
            String exam_id=name.substring(0, 5);
            String date=name.substring(5,15);
            ArrayList<Result> results=resultController.getAllResult(exam_id, date);
            for (Result result : results) {
                seriesName.getData().add(new XYChart.Data(result.getStudent_id(), result.getResult()));
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(ChartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ChartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ChartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
