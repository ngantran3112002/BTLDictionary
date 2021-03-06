/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dictionaryapplication;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HH
 */
public class deleteWordJFrame extends javax.swing.JFrame {

    /**
     * Creates new form deleteWordJFrame
     */
    public deleteWordJFrame() {
        initComponents();
        errorJLabel1.setText("  ");
        errorJLabel2.setText("  ");
    }

    public void deleteWord() {
        String word= deleteWordJTextField.getText();
        if (word.equals("")) {
            errorJLabel1.setText("Vui lòng nhập từ muốn xóa!");
        } else if (!Data.ListOfWords.containsKey(word)) {
            errorJLabel1.setText("Từ không tồn tại!");
        } else {
            errorJLabel1.setText(" ");
            Data.ListOfWords.remove(word);
            DictionaryApplication.setListModel();
            try {
                Data.addNewWordToFile(word, "*delete");
            } catch (IOException ex) {
                Logger.getLogger(deleteWordJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            errorJLabel2.setText("Đã xóa từ!");
        }

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        deleteWordJTextField = new javax.swing.JTextField();
        deleteJButton = new javax.swing.JButton();
        errorJLabel1 = new javax.swing.JLabel();
        errorJLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Xóa từ");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nhập từ muốn xóa:");

        deleteJButton.setText("Xóa");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });

        errorJLabel1.setForeground(new java.awt.Color(255, 0, 0));
        errorJLabel1.setText("jLabel2");

        errorJLabel2.setForeground(new java.awt.Color(0, 153, 51));
        errorJLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorJLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(errorJLabel2))
                    .addComponent(deleteWordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(deleteWordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorJLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteJButton)
                    .addComponent(errorJLabel2))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        // TODO add your handling code here:
        deleteWord();
    }//GEN-LAST:event_deleteJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteJButton;
    private javax.swing.JTextField deleteWordJTextField;
    private javax.swing.JLabel errorJLabel1;
    private javax.swing.JLabel errorJLabel2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
