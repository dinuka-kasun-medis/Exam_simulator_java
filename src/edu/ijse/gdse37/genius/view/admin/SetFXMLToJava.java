/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.view.admin;

import com.sun.javafx.application.PlatformImpl;
import java.io.IOException;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javax.swing.JPanel;

/*
 * class for javaFx to Java © Dinuka Kasun Medis
 *
 * @author Dinuka
 */

/**
 *
 * @author Dinuka
 */

public class SetFXMLToJava {

    /**
     *
     * @param jp
     */
    public static void setFXMLToPanel(JPanel jp) {
        PlatformImpl.startup(
                new Runnable() {
            @Override
            public void run() {
                AnchorPane paneAnchor = null;
                try {
                    FXMLLoader fx = new FXMLLoader(getClass().getClassLoader().getResource("chart.fxml"));
                    fx.setBuilderFactory(new JavaFXBuilderFactory());
                    paneAnchor = (AnchorPane) fx.load(getClass().getResource("chart.fxml").openStream());
                } catch (IOException ex) {
                    System.out.println("error at JavaFx to java...");
                }
                Scene scene = new Scene(paneAnchor, jp.getWidth(), jp.getHeight());
                final JFXPanel jFXPanel = new JFXPanel();
                jFXPanel.setScene(scene);
                jp.add(jFXPanel);
                jp.revalidate();
            }
        });
    }
}
