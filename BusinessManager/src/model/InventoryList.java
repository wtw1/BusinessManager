
package model;

import java.util.*;

public class InventoryList {
    
    ArrayList list; //= new ArrayList();
    
    public InventoryList() {
        list = new ArrayList();
        
        //TESTING
        for (int i=0; i<5; i++){
            Item item = new Item();
            item.itemName = "Random Item" + i;
            //item.itemID = i;
            item.itemWeight = item.itemWeight*i;
            list.add(item);
        }
    }
    
    public ArrayList getList() {
        return list;
    }
    
    public int getSize() {
        return list.size();
    }
    
    public void addNewItem (Item item) {
        list.add(item);
    } 
    
    public Item getItemAtIndex (int index){
        Item item = (Item)list.get(index);
        return item;
    }
    
    public void removeItemAtIndex (int index) {
        list.remove(index);
    }
    
    
    
}
