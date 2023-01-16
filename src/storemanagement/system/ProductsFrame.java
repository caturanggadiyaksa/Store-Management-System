/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package storemanagement.system;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
//import net.proteanit.sql.DbUtils;
//import net.proteanit.sql.DbUtils;

/**
 *
 * @author angga
 */
public class ProductsFrame extends javax.swing.JFrame {

    String id = "";

    /**
     * Creates new form ProductsFrame
     */
    

    public void delete(String id) {

        try {
            StoreManagementSystem connect = new StoreManagementSystem();
            connect.koneksi();
            Statement statement = connect.con.createStatement();

            String sql = "delete from products where id_product = '" + id + "'";

            statement.executeUpdate(sql);
            statement.close();

            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Gagal Dihapus");
        }
    }

    public void searchByNama(String nama) {
        StoreManagementSystem connect = new StoreManagementSystem();
        connect.koneksi();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Products");
        model.addColumn("id supplier");
       
        model.addColumn("Price");
        model.addColumn("Quantity");
         model.addColumn("ID Category");
        try {
            String sql = "select * from products where nama_product like '%" + nama + "%'";
            PreparedStatement stmt = connect.con.prepareStatement(sql);
            ResultSet res = (ResultSet) stmt.executeQuery();

            while (res.next()) {

                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),});

            }
            jTable2.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchByKategori(String kategori) {
        StoreManagementSystem connect = new StoreManagementSystem();
        connect.koneksi();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Products");
        model.addColumn("id supplier");
        
        model.addColumn("Price");
        model.addColumn("Quantity");
        model.addColumn("ID Category");

        try {
            String sql = "select * from products where id_category like '%" + kategori + "%'";
            PreparedStatement stmt = connect.con.prepareStatement(sql);
            ResultSet res = (ResultSet) stmt.executeQuery();
            while (res.next()) {

                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),});

            }
            jTable2.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchByKode(String kode) {
        StoreManagementSystem connect = new StoreManagementSystem();
        connect.koneksi();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Products");
        model.addColumn("id supplier");
        
        model.addColumn("Price");
        model.addColumn("Quantity");
        model.addColumn("ID Category");
        try {
            String sql = "select * from products where id_product like '%" + kode + "%'";
            PreparedStatement stmt = connect.con.prepareStatement(sql);
            ResultSet res = (ResultSet) stmt.executeQuery();
            // lakukan perulangan
            while (res.next()) {

                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),});

            }
            jTable2.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tampil() {

        DefaultTableModel model = new DefaultTableModel();
        JButton btnTutup = new JButton("Tutup");

        model.addColumn("No");
        model.addColumn("Products");
        model.addColumn("id supplier");
       
        model.addColumn("Price");
        model.addColumn("Quantity");
         model.addColumn("ID Category");

        try {

            String url = "jdbc:mysql://localhost/store-manajemen";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = (Connection) DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM products";
            PreparedStatement stmt = koneksi.prepareStatement(query);
            ResultSet res = (ResultSet) stmt.executeQuery();

            // lakukan perulangan
            while (res.next()) {

                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),});

            }

            jTable2.setModel(model);

        } catch (Exception e) {
            System.out.println("Tidak dapat menemukan data !" + e.getMessage());
        }

    }

    public ProductsFrame() {
        initComponents();
        tampil();

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if (frameSize.height > screensize.height) {
            frameSize.height = screensize.height;
        }
        if (frameSize.width > screensize.width) {
            frameSize.width = screensize.width;
        }
        this.setLocation((screensize.width - frameSize.width) / 2,
                (screensize.height - frameSize.height) / 2);

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
        kGradientPanel3 = new store.component.KGradientPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        dropdown = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        kGradientPanel1 = new store.component.KGradientPanel();
        home = new javax.swing.JButton();
        products = new javax.swing.JButton();
        supplier = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1204, 530));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 1200));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cari");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seacrh By", "Nama Produk", "Kategori", "Kode Barang" }));
        dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropdownActionPerformed(evt);
            }
        });

        jTextField1.setText("Cari");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Hapus");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"et4", "et43", "4t34", "34t", "43t3", "43t43"},
                {"43t", "43y", "4y", "5y", "34", "w4new JButton(\"Edit\""},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUCTS");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1040, 530));

        kGradientPanel1.setPreferredSize(new java.awt.Dimension(216, 532));

        home.setText("HOME");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        products.setBackground(new java.awt.Color(0, 204, 204));
        products.setText("PRODUCTS");
        products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productsMouseClicked(evt);
            }
        });
        products.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsActionPerformed(evt);
            }
        });

        supplier.setText("SUPPLIER");
        supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierMouseClicked(evt);
            }
        });
        supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(products, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(supplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(products, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 1250, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dropdownActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        switch (dropdown.getSelectedIndex()) {
            case 1:
                searchByNama(jTextField1.getText());
                break;
            case 2:
                searchByKategori(jTextField1.getText());
                break;
            case 3:
                
                searchByKode(jTextField1.getText());
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        tampil();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        int selectRowIndex = jTable2.getSelectedRow();
        id = (String) dtm.getValueAt(selectRowIndex, 0);

//        System.out.println(id);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        delete(id);
        tampil();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        // TODO add your handling code here:
        new MenuFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_homeActionPerformed

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_homeMouseClicked

    private void productsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsActionPerformed
        // TODO add your handling code here:
        new ProductsFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_productsActionPerformed

    private void productsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_productsMouseClicked

    private void supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierActionPerformed
        // TODO add your handling code here:
        new SupplierFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_supplierActionPerformed

    private void supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        EditFrame perbarui = new EditFrame();
        if (id == null || id.equals("")) {
            JOptionPane.showMessageDialog(null, "Anda Belum Memilih Barang \nyang Akan Diedit");
        } else {
            perbarui.setVisible(true);
            dispose();

            perbarui.edit(id);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new TambahFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> dropdown;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private store.component.KGradientPanel kGradientPanel1;
    private store.component.KGradientPanel kGradientPanel3;
    private javax.swing.JButton products;
    private javax.swing.JButton supplier;
    // End of variables declaration//GEN-END:variables
}
