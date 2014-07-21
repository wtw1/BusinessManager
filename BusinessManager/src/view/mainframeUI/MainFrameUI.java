/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.mainframeUI;

import model.Item;
import model.User;
import view.initloginUI.InitLoginJDialog;
import view.itemmanagerUI.ItemManagerUI;
import view.itemspanelUI.ItemsPanelUI;
import view.storeDialogUI.StoreDialogUI;

public class MainFrameUI extends javax.swing.JFrame implements view.itemmanagerUI.ItemManagerUI.ItemManagerDelegate, 
                                                               view.itemspanelUI.ItemsPanelUI.ItemsPanelDelegate,
                                                               view.initloginUI.InitLoginJDialog.LoginDelegate {
    private InitLoginJDialog login;
    public User user; 
    
    //LoginDelegate
    @Override
    public void loginWithUser(User user) {
        
        itemsPanelUI1.inventoryList = user.inventory;
        //itemsPanelUI1.updateTableView();
    }
    
    
    //ItemManagerDelegate 
    @Override
    public void itemManagerIsInEditMode() {
        System.out.println("EditMode"); 
        itemsPanelUI1.setItemsPanelState(ItemsPanelUI.ItemsPaneState.DISABLED);
        if(itemManagerUI1.managerState == ItemManagerUI.ManagerState.NEWITEMISBEINGCREATED) {
            itemsPanelUI1.deselectInventorySelection();
        }   
    }
    
    @Override
    public void itemManagerIsQuitEditMode() {
        System.out.println("EditMode"); 
        itemsPanelUI1.setItemsPanelState(ItemsPanelUI.ItemsPaneState.ENABLED);
    }
    
    @Override
    public void itemManagerCreatedNewItem(Item newItem) {
        if(itemManagerUI1.managerState == ItemManagerUI.ManagerState.NEWITEMISBEINGCREATED) {
            itemsPanelUI1.inventoryList.addNewItem(newItem);
            itemsPanelUI1.updateTableView();
        } else if(itemManagerUI1.managerState == ItemManagerUI.ManagerState.ITEMISBEINGEDITED) {
            Item selectedItem = itemsPanelUI1.getSelectedItem();
            selectedItem.transformIntoItem(newItem);
        }
    }
    
    //ItemSpaceDelegate 
    @Override
    public void inventoryItemSelected(Item selectedItem) {
        System.out.print(selectedItem.getItemName()); 
        itemManagerUI1.setManagerState(ItemManagerUI.ManagerState.INVENTORYITEMSELECTED);
        itemManagerUI1.SetItemInManager(selectedItem);
    }
    
    public void itemManagerDeletedItem() {
        itemsPanelUI1.removeSelectedItem();
    }
    
    /**
     * Creates new form MainFrameUI
     */
    public MainFrameUI() {
        initComponents();
        itemManagerUI1.setDelegate(this);
        itemsPanelUI1.setDelegate(this);
        
        login = new InitLoginJDialog(this,true);
        login.setDelegate(this);
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        itemManagerUI1 = new view.itemmanagerUI.ItemManagerUI();
        itemsPanelUI1 = new view.itemspanelUI.ItemsPanelUI();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jOpenStore = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        jMenuItem2.setText("Login");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jOpenStore.setText("Open Store");
        jOpenStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOpenStoreActionPerformed(evt);
            }
        });
        jMenu1.add(jOpenStore);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemsPanelUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(itemManagerUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(itemManagerUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(itemsPanelUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jOpenStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOpenStoreActionPerformed
        // TODO add your handling code here:
        StoreDialogUI store = new StoreDialogUI(this,true);
        store.setVisible(true);
    }//GEN-LAST:event_jOpenStoreActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
        login.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrameUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.itemmanagerUI.ItemManagerUI itemManagerUI1;
    private view.itemspanelUI.ItemsPanelUI itemsPanelUI1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jOpenStore;
    // End of variables declaration//GEN-END:variables
    

}
