/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.itemmanagerUI;

import javax.swing.JOptionPane;
import model.Item;

public class ItemManagerUI extends javax.swing.JPanel {

    private ItemManagerDelegate delegate;
    public ManagerState managerState;
    
    public interface ItemManagerDelegate {
        void itemManagerIsInEditMode();
        void itemManagerIsQuitEditMode();
        void itemManagerCreatedNewItem(Item newItem);
        void itemManagerDeletedItem();
    }
    
    public void setDelegate(ItemManagerDelegate delegate) {
        this.delegate = delegate;
    }
    
    public enum ManagerState {
    INVENTORYITEMSELECTED, NOTHINGSELECTED, NEWITEMISBEINGCREATED, ITEMISBEINGEDITED, NOUSER
    }
    
    public void setManagerState(ManagerState state) {
        this.managerState = state;
        this.updateButtonsStates();
    }
    
    //Inital SetUp
    public ItemManagerUI() {
        initComponents();
        this.DisableItemFields();
        this.managerState = ManagerState.NOUSER;
        this.updateButtonsStates();
    }
    
    public void clearItemFields() {
        jItemNameTF.setText("");
        jItemSellPriceTF.setText("");
        jItemStockPriceTF.setText("");
        jItemCountTF.setText("");
        jItemWeightTF.setText("");
    }
    
    public void DisableItemFields() {
        jItemNameTF.setEditable(false);
        jItemSellPriceTF.setEditable(false);
        jItemStockPriceTF.setEditable(false);
        jItemCountTF.setEditable(false);
        jItemWeightTF.setEditable(false);
        jRemoveCountButton.setEnabled(false);
        jAddCountButton.setEnabled(false);
    }
    
    public void EnableItemFields() {
        jItemNameTF.setEditable(true);
        jItemSellPriceTF.setEditable(true);
        jItemStockPriceTF.setEditable(true);
        jItemWeightTF.setEditable(true);
        jRemoveCountButton.setEnabled(true);
        jAddCountButton.setEnabled(true);
    }
    
    public void SetItemInManager(Item item) {
        jItemNameTF.setText(item.getItemName());
        jItemSellPriceTF.setText(Float.toString(item.itemSellPrice));
        jItemStockPriceTF.setText(Float.toString(item.itemBuyPrice));
        jItemCountTF.setText(Integer.toString(item.itemCount));
        jItemWeightTF.setText(Float.toString(item.itemWeight));
    }
    
    public void updateButtonsStates() { 
        switch (managerState) {
            case INVENTORYITEMSELECTED:
                System.out.println("INVENTORYITEMSELECTED");
                jEditButton.setEnabled(true);
                jCancelButton.setEnabled(false);
                jUpdateAddButton.setEnabled(false);
                jDeleteItemButton.setEnabled(false);
                jNewItemButton.setEnabled(true);

                break;
                    
            case NOTHINGSELECTED:
                System.out.println("NOTHINGSELECTED");
                jEditButton.setEnabled(false);
                jCancelButton.setEnabled(false);
                jUpdateAddButton.setEnabled(false);
                jDeleteItemButton.setEnabled(false);
                jNewItemButton.setEnabled(true);

                break;
                         
            case NEWITEMISBEINGCREATED:
                System.out.println("NEWITEMISBEINGCREATED");
                jEditButton.setEnabled(false);
                jCancelButton.setEnabled(true);
                jUpdateAddButton.setEnabled(true);
                jDeleteItemButton.setEnabled(false);
                jNewItemButton.setEnabled(false);

                break;
                        
            case ITEMISBEINGEDITED:
                System.out.println("ITEMISBEINGEDITED");
                jEditButton.setEnabled(false);
                jCancelButton.setEnabled(true);
                jUpdateAddButton.setEnabled(true);
                jDeleteItemButton.setEnabled(true);
                jNewItemButton.setEnabled(false);

                break;
                
            case NOUSER:
                System.out.println("NOUSER");
                jEditButton.setEnabled(false);
                jCancelButton.setEnabled(false);
                jUpdateAddButton.setEnabled(false);
                jDeleteItemButton.setEnabled(false);
                jNewItemButton.setEnabled(false);

                break;
                
            default:
                System.out.println("DEFAULT");
                break;
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
        jLabel2 = new javax.swing.JLabel();
        jNewItemButton = new javax.swing.JButton();
        jEditButton = new javax.swing.JButton();
        jUpdateAddButton = new javax.swing.JButton();
        jCancelButton = new javax.swing.JButton();
        jDeleteItemButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jItemStockPriceTF = new javax.swing.JTextField();
        jItemCountTF = new javax.swing.JTextField();
        jItemNameTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jRemoveCountButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jItemWeightTF = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jItemSellPriceTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jAddCountButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setText("Inventory Manager");

        jNewItemButton.setText("New Item");
        jNewItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewItemButtonActionPerformed(evt);
            }
        });

        jEditButton.setText("Edit Item");
        jEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditButtonActionPerformed(evt);
            }
        });

        jUpdateAddButton.setText("Add/Update Item");
        jUpdateAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUpdateAddButtonActionPerformed(evt);
            }
        });

        jCancelButton.setText("Cancel");
        jCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelButtonActionPerformed(evt);
            }
        });

        jDeleteItemButton.setText("Delete Item");
        jDeleteItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteItemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jUpdateAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jNewItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jDeleteItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(65, 65, 65))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jEditButton)
                    .addComponent(jUpdateAddButton))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNewItemButton)
                    .addComponent(jCancelButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDeleteItemButton)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jItemStockPriceTF.setEditable(false);

        jItemCountTF.setEditable(false);

        jItemNameTF.setEditable(false);

        jLabel8.setText("BuyPrice:");

        jLabel17.setText("kg");

        jRemoveCountButton.setText("<");

        jLabel9.setText("Count:");

        jItemWeightTF.setEditable(false);

        jLabel16.setText("$");

        jLabel7.setText("SellPrice:");

        jLabel15.setText("$");

        jItemSellPriceTF.setEditable(false);

        jLabel4.setText("Weight:");

        jAddCountButton.setText(">");

        jLabel5.setText("Name:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(60, 60, 60)
                        .addComponent(jItemNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jItemSellPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jItemStockPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jItemWeightTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jItemCountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jRemoveCountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jAddCountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jItemNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jItemSellPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel15)))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jItemStockPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel16)))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jItemCountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRemoveCountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddCountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jItemWeightTF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel17)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jNewItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewItemButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("New Item Pressed");
        this.clearItemFields();
        this.setManagerState(ManagerState.NEWITEMISBEINGCREATED);
        this.delegate.itemManagerIsInEditMode();
        
        jItemCountTF.setText("0");
        this.EnableItemFields();
        
        
    }//GEN-LAST:event_jNewItemButtonActionPerformed

    private void jCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("Cancel Pressed");
        this.delegate.itemManagerIsQuitEditMode();
        
        if (this.managerState == ManagerState.NEWITEMISBEINGCREATED){
            this.clearItemFields();
            this.setManagerState(ManagerState.NOTHINGSELECTED);
        }else {
            this.setManagerState(ManagerState.INVENTORYITEMSELECTED);
        }
        this.DisableItemFields();
        
    }//GEN-LAST:event_jCancelButtonActionPerformed

    private void jUpdateAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUpdateAddButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("Update/Add Pressed");
        boolean isValidItem = false;
        Item newItem = new Item();
        while (!isValidItem) {
            try {        
                newItem.itemName = jItemNameTF.getText();
                newItem.itemBuyPrice = Float.parseFloat(jItemStockPriceTF.getText());
                newItem.itemSellPrice = Float.parseFloat(jItemSellPriceTF.getText());
                newItem.itemCount = Integer.parseInt(jItemCountTF.getText());
                newItem.itemWeight = Float.parseFloat(jItemWeightTF.getText());
                isValidItem = true;
            } catch(NumberFormatException e) { 
                JOptionPane.showMessageDialog(null, "Fix Item Fields");
                return;
            }
        }
        this.delegate.itemManagerCreatedNewItem(newItem);
        this.DisableItemFields();
        if(this.managerState == ManagerState.NEWITEMISBEINGCREATED) {
            this.clearItemFields();
            this.setManagerState(ManagerState.NOTHINGSELECTED);
        } else {
            this.setManagerState(ManagerState.INVENTORYITEMSELECTED);
        }
        
        this.delegate.itemManagerIsQuitEditMode();
    }//GEN-LAST:event_jUpdateAddButtonActionPerformed

    private void jEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("Edit Item Pressed");
        
        this.setManagerState(ManagerState.ITEMISBEINGEDITED);
        this.delegate.itemManagerIsInEditMode();
        this.EnableItemFields();
    }//GEN-LAST:event_jEditButtonActionPerformed

    private void jDeleteItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteItemButtonActionPerformed
        // TODO add your handling code here:
        this.delegate.itemManagerDeletedItem();
        this.clearItemFields();
        this.DisableItemFields();
        this.setManagerState(ManagerState.NOTHINGSELECTED);
        this.delegate.itemManagerIsQuitEditMode();
    }//GEN-LAST:event_jDeleteItemButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddCountButton;
    private javax.swing.JButton jCancelButton;
    private javax.swing.JButton jDeleteItemButton;
    private javax.swing.JButton jEditButton;
    private javax.swing.JTextField jItemCountTF;
    private javax.swing.JTextField jItemNameTF;
    private javax.swing.JTextField jItemSellPriceTF;
    private javax.swing.JTextField jItemStockPriceTF;
    private javax.swing.JTextField jItemWeightTF;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jNewItemButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jRemoveCountButton;
    private javax.swing.JButton jUpdateAddButton;
    // End of variables declaration//GEN-END:variables
}
