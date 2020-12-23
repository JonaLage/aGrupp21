/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CourseController;
import model.Course;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;
import java.util.*;
/**
 *
 * @author jackie-sally
 */
public class CreateCourse extends javax.swing.JFrame {
    
    ArrayList<Course> courses; 
    /**
     * Creates new form CreateCourse
     */
    public CreateCourse() {
        initComponents();
        courses = new ArrayList<Course>();
        populateArrayList(); 
        
    }
    
    public void populateArrayList() {
        try{
           FileInputStream file = new FileInputStream("Courses.dat");
           ObjectInputStream inputFile = new ObjectInputStream(file);
           
           boolean endOfFile = false;
           
           while(!endOfFile){
               try {
                courses.add((Course)inputFile.readObject());
               }
               catch(EOFException e){
                endOfFile = true;    
               }
               catch(Exception f){
                JOptionPane.showMessageDialog(null, f.getMessage());    
               }
           }
           inputFile.close(); 
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage()); 
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextCourseName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextCredit = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonGenerate = new javax.swing.JButton();
        jCourseCode = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        jLabel1.setText("Manage Courses");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 48, -1, -1));

        jLabel2.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jLabel2.setText("Course name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jTextCourseName.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jPanel1.add(jTextCourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 211, 35));

        jLabel3.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jLabel3.setText("Credit");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 82, -1));

        jTextCredit.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jPanel1.add(jTextCredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 92, 34));

        jButtonSave.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jButtonSave.setText("Add course");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 314, 124, -1));

        jLabel4.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jLabel4.setText("Course code");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jButtonGenerate.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jButtonGenerate.setText("Generate");
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonGenerate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 174, 113, -1));

        jCourseCode.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jCourseCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCourseCodeActionPerformed(evt);
            }
        });
        jPanel1.add(jCourseCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 92, 35));

        jButton1.setFont(new java.awt.Font("Avenir", 0, 13)); // NOI18N
        jButton1.setText("Delete course");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 314, -1, -1));

        jButton2.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jButton2.setText("Save update");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 314, 124, -1));

        jButton3.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 378, 125, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
    java.util.Random r = new java.util.Random();
    int start = 10000; 
    int end = 99999; 
    int result = r.nextInt(end-start) + start; 
    String code = "C" + String.valueOf(result);
    jCourseCode.setText(code); 
    }//GEN-LAST:event_jButtonGenerateActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        CourseMenu.AddRowToJTable(new Object[]{
            jCourseCode.getText(), jTextCourseName.getText(), jTextCredit.getText()});

    if(jTextCourseName.getText().isEmpty() || jTextCredit.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter all fields!");
        }
        else {
            String courseCode = jCourseCode.getText().trim();
            String name = jTextCourseName.getText().trim();
            String credit = jTextCredit.getText().trim();
           

            /*Course course = new Course(courseCode, name, credit);*/
        }

    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jCourseCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCourseCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCourseCodeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
   
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JTextField jCourseCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextCourseName;
    private javax.swing.JTextField jTextCredit;
    // End of variables declaration//GEN-END:variables
   private CourseController coursecontroller; 
   private Course course; 
}
