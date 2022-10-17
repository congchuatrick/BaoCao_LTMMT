/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tvn_ltmmt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class frmClient extends javax.swing.JFrame {

    /**
     * Creates new form frmClient
     */
    public final static String SERVER_IP = "127.0.0.1"; //Địa chỉ IP là 127.0.0.1
    public final static int SERVER_PORT = 7; //Có giả trị từ 0 ..65535
  
    public frmClient() {
        initComponents();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPlaintext = new javax.swing.JTextArea();
        txtKey = new javax.swing.JTextField();
        btnEncrypt = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnSendServer = new javax.swing.JButton();
        btnDecrypt = new javax.swing.JButton();
        btnDemSoTu = new javax.swing.JButton();
        btnHoanVi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TCP - Ceasar Cipher");

        jLabel2.setText("Plaintext:");

        jLabel3.setText("Key:");

        txtPlaintext.setColumns(20);
        txtPlaintext.setRows(5);
        jScrollPane1.setViewportView(txtPlaintext);

        btnEncrypt.setText("Encrypt");
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });

        txtResult.setColumns(20);
        txtResult.setRows(5);
        jScrollPane2.setViewportView(txtResult);

        jLabel4.setText("Result:");

        btnSendServer.setText("Send Server");
        btnSendServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendServerActionPerformed(evt);
            }
        });

        btnDecrypt.setText("Decrypt");
        btnDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptActionPerformed(evt);
            }
        });

        btnDemSoTu.setText("Word Count");
        btnDemSoTu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDemSoTuActionPerformed(evt);
            }
        });

        btnHoanVi.setText("Hoán vị");
        btnHoanVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanViActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKey)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEncrypt)
                        .addGap(18, 18, 18)
                        .addComponent(btnSendServer)
                        .addGap(18, 18, 18)
                        .addComponent(btnDecrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDemSoTu)
                        .addGap(18, 18, 18)
                        .addComponent(btnHoanVi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEncrypt)
                            .addComponent(btnSendServer)
                            .addComponent(btnDecrypt)
                            .addComponent(btnDemSoTu)
                            .addComponent(btnHoanVi))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
        try {
            int k = Integer.valueOf(this.txtKey.getText());
            String br = this.txtPlaintext.getText();
            this.txtResult.setText(mahoa(br, k));         
        } catch (Exception e) {
                e.printStackTrace();
        } 
    }//GEN-LAST:event_btnEncryptActionPerformed

    private void btnSendServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendServerActionPerformed
        Socket socket = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connected: " + socket);
            
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            
            dout.writeInt(1);
            int k = Integer.valueOf(this.txtKey.getText());
            dout.writeInt(k);
            String rs = txtResult.getText();
            byte[] data = rs.getBytes("UTF-8");
            dout.writeInt(data.length);
            dout.write(data);
        } catch (IOException ex) {
            Logger.getLogger(frmClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSendServerActionPerformed

    private void btnDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptActionPerformed
        Socket socket = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connected: " + socket);
            
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            
            dout.writeInt(2);
            int lenghtn = din.readInt();
            byte[] data = new byte[lenghtn];
            din.readFully(data);
            String str = new String(data, "UTF-8");
            System.out.println(str);
            txtResult.setText(str);
        } catch (IOException ex) {
            Logger.getLogger(frmClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDecryptActionPerformed

    private void btnDemSoTuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDemSoTuActionPerformed
        Socket socket = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connected: " + socket);
            
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            
            dout.writeInt(3);
            int lenghtn = din.readInt();
            byte[] data = new byte[lenghtn];
            din.readFully(data);
            String str = new String(data, "UTF-8");
            System.out.println(str);
            
            int lenghtn1 = din.readInt();
            byte[] data1 = new byte[lenghtn1];
            din.readFully(data1);
            String str1 = new String(data1, "UTF-8");
            System.out.println(str1);
        } catch (IOException ex) {
            Logger.getLogger(frmClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDemSoTuActionPerformed

    private void btnHoanViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanViActionPerformed
        Socket socket = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connected: " + socket);
            
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            
            dout.writeInt(4);
            int lenghtn = din.readInt();
            byte[] data = new byte[lenghtn];
            din.readFully(data);
            String str = new String(data, "UTF-8");
            txtResult.setText(str);
        } catch (IOException ex) {
            Logger.getLogger(frmClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHoanViActionPerformed

    private String mahoa (String br, int k) {
        String kq = "";
        int n = br.length();
        for (int i = 0; i < n; i++) {
            kq+=mahoakt(br.charAt(i), k);
        }
        return kq;
    }
    
    char mahoakt(char c, int k) {
        if (!Character.isLetter(c)) return c;
        return (char) ((((Character.toUpperCase(c) - 'A') + k) % 26 + 26) % 26 + 'A');
    }
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
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDecrypt;
    private javax.swing.JButton btnDemSoTu;
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JButton btnHoanVi;
    private javax.swing.JButton btnSendServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextArea txtPlaintext;
    private javax.swing.JTextArea txtResult;
    // End of variables declaration//GEN-END:variables
}
