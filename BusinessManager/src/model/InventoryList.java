//hello
package model;

import java.util.*;

/**
 *InventoryList contains all the items being sold by a seller, and all items that a buyer can buy.
 * @author Owner
 */
public class InventoryList {
    
    ArrayList<Item> list; //= new ArrayList();
    
    /**
     * constructor function. Makes a new ArrayList
     */
    public InventoryList() {
        list = new ArrayList();
        
        //TESTING
        for (int i=0; i<5; i++){
            Item item = new Item();
            
            Random rand = new Random();
            int randomNum = rand.nextInt((2000 - 10) + 1) + 10;
            
            item.itemName = "Random Item" + randomNum;
            item.itemCount = i;
            item.itemWeight = item.itemWeight*i;
            item.itemBuyPrice = (float)((item.itemSellPrice * i)+ 0.79); 
            
            list.add(item);
        }
    }
    
    /**
     * Getter for the list instance.
     * @return
     */
    public ArrayList getList() {
        return list;
    }
    
    /**
     * Getter for the size of this list instance
     * @return
     */
    public int getSize() {
        return list.size();
    }
    
    /**
     * Adds an item to the list.
     * @param item
     */
    public void addNewItem (Item item) {
        list.add(item);
    } 
    
    /**
     * Returns the item at the given index.
     * @param index
     * @return
     */
    public Item getItemAtIndex (int index){
        Item item = (Item)list.get(index);
        return item;
    }
    
    /**
     * Removes the item at the specified index.
     * @param index
     */
    public void removeItemAtIndex (int index) {
        list.remove(index);
    }
    
    
    
}
