
package view.itemspanelUI;

import model.InventoryList;
import model.Item;

public class ItemsPanelUI extends javax.swing.JPanel {

    private ItemsPanelDelegate delegate;
    public InventoryList inventoryList;
    private ItemsPaneState itemsPaneState;
    
    public interface ItemsPanelDelegate {
        void inventoryItemSelected(Item selectedItem);
    }
    
    public void setDelegate(ItemsPanelDelegate delegate) {
        this.delegate = delegate;
    }
    
    public enum ItemsPaneState {
    DISABLED, ENABLED
    }
    
    public void setItemsPanelState(ItemsPaneState state) {
        this.itemsPaneState = state;
        this.updateItemsPanelState();
    }
    
    public ItemsPanelUI() {
        initComponents();
        inventoryList = new InventoryList(); //Model
        setItemsPanelState(ItemsPaneState.DISABLED);
        this.updateTableView();
    }
    
    public void deselectInventorySelection() {
        jInventoryList.clearSelection();
    }
    
    public Item getSelectedItem() {
        return inventoryList.getItemAtIndex(jInventoryList.getSelectedIndex());
    }
    
    public void removeSelectedItem() {
        int selectedIndex = jInventoryList.getSelectedIndex();
        this.deselectInventorySelection();
        inventoryList.removeItemAtIndex(selectedIndex);
        this.updateTableView();
    }

    public void updateTableView() {
    jInventoryList.setModel(new javax.swing.AbstractListModel() {
        public int getSize() { 
            return inventoryList.getSize(); 
        }
        public Object getElementAt(int i) { 
            return inventoryList.getItemAtIndex(i).getItemName();
        }
        });
    }
    
    public void updateItemsPanelState() {
        switch (itemsPaneState) {
            case ENABLED:
                System.out.println("ENABLED");
                jInventoryList.setEnabled(true);
                //jShippedList.setEnabled(false);
                jSoldList.setEnabled(false);
                break;
                    
            case DISABLED:
                System.out.println("DISABLED");
                jInventoryList.setEnabled(false);
                //jShippedList.setEnabled(false);
                jSoldList.setEnabled(false);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jInventoryList = new javax.swing.JList();
        jInventoryLabel = new javax.swing.JLabel();
        jSoldLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jSoldList = new javax.swing.JList();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jInventoryList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jInventoryList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jInventoryList.setEnabled(false);
        jInventoryList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jInventoryListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jInventoryList);

        jInventoryLabel.setText("Inventory");

        jSoldLabel.setText("Sold");

        jSoldList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSoldList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jSoldList.setEnabled(false);
        jScrollPane2.setViewportView(jSoldList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jInventoryLabel)
                        .addGap(98, 98, 98)
                        .addComponent(jSoldLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInventoryLabel)
                    .addComponent(jSoldLabel))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jInventoryListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jInventoryListValueChanged
        // TODO add your handling code here:
        if (itemsPaneState == ItemsPaneState.ENABLED) {
            int selectedIndex = jInventoryList.getSelectedIndex();
            Item selectedItem = this.inventoryList.getItemAtIndex(selectedIndex);
            this.delegate.inventoryItemSelected(selectedItem);
        }
    }//GEN-LAST:event_jInventoryListValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jInventoryLabel;
    private javax.swing.JList jInventoryList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jSoldLabel;
    private javax.swing.JList jSoldList;
    // End of variables declaration//GEN-END:variables
}
