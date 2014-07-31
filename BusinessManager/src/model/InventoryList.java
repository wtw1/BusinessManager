//hello
package model;

import java.util.*;

public class InventoryList {
    
    ArrayList<Item> list; //= new ArrayList();
    
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
            item.itemBuyPrice = (float)((item.itemBuyPrice * i)+ 0.79); 
            
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
