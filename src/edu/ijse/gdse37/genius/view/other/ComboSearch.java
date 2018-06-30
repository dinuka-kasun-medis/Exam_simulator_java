/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.view.other;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Dinuka
 */
public class ComboSearch {

    private ArrayList<String> arrayList;
    private JTextField textField;

    public ComboSearch() {

    }

    /*Method for search combo © Dinuka Kasun Medis*/
    public void setSearchableCombo(final JComboBox cmb, boolean mustSort, final String noReultsText) {
        arrayList = new ArrayList<>();
        final int itemCount = cmb.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            boolean exists = false;
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(j).equalsIgnoreCase(String.valueOf(cmb.getItemAt(i)))) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                arrayList.add(String.valueOf(cmb.getItemAt(i)));
            }
        }
        if (mustSort) {
            Collections.sort(arrayList);
        }
        cmb.setEditable(true);
        textField = (JTextField) cmb.getEditor().getEditorComponent();
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                int key = evt.getKeyCode();
                if (!(key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_ENTER || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_UP)) {
                    String text = textField.getText();
                    int caret = textField.getCaretPosition();
                    cmb.hidePopup();
                    cmb.removeAllItems();
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).toUpperCase().startsWith(text.substring(0, caret).toUpperCase())) {
                            cmb.addItem(arrayList.get(i));
                        }
                    }
                    cmb.showPopup();
                    if (cmb.getItemCount() == 0) {
                        cmb.addItem(noReultsText);
                    }
                    textField.setText(text);
                    textField.setCaretPosition(caret);
                } else if (key == KeyEvent.VK_ESCAPE) {
                    cmb.setSelectedItem(textField.getText());
                    cmb.hidePopup();
                } else if (key == KeyEvent.VK_ENTER && cmb.getSelectedIndex() == -1) {
                    if (cmb.getItemCount() == 1 && !cmb.getItemAt(0).equals(noReultsText)) {
                        cmb.setSelectedIndex(0);
                    } else if (cmb.getItemCount() > 1) {
                        cmb.setSelectedIndex(0);
                    }
                }
            }
        });
    }
}
