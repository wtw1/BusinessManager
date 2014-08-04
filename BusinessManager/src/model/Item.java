/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 * This class defines the attributes of an item. Instances of this class go in ArrayList
 * @author Owner
 */
public class Item {
    
    /**
     * Property: sell price
     */
    public float itemSellPrice;

    /**
     * Property: buy price
     */
    public float itemBuyPrice;

    /**
     * Property: weight
     */
    public float itemWeight;

    /**
     * Property: quantity
     */
    public int itemCount;

    /**
     * Property: name of item
     */
    public String itemName;
    
   

     /**
     * constructor
     * @param sellPrice
     * @param buyPrice
     * @param ID
     * @param name
     * @param weight
     * @param count
     */
        public Item(float sellPrice, float buyPrice, int ID, String name, float weight,int count) {
        itemSellPrice = sellPrice;
        itemBuyPrice = buyPrice;
        itemWeight = weight;
        //itemID = ID;
        itemCount = count;
        itemName = name;
    }
    
    /**
     * Setter for combined attributes of an item
     * @param item
     */
    public void transformIntoItem(Item item){
        this.itemName = item.itemName;
        this.itemSellPrice = item.itemSellPrice;
        this.itemBuyPrice = item.itemBuyPrice;
        this.itemWeight = item.itemWeight;
        this.itemCount = item.itemCount;
    }
   
    /**
     *A default constructor
     */
    public Item() {
        itemSellPrice = 1.25f;
        itemBuyPrice = 1.10f;
        itemWeight = 3.35f;
        //itemID = 1;
        itemCount = 1;
        itemName = "Random Item";
    }
    
    /**
     * Getter function.
     * @return
     */
    public String getItemName() {
        return itemName;
    }
    
    /**
     * Incrementer.
     */
    public void addCount() {
        itemCount++;
     
    }

    /**
     * Decrementer.
     */
    public void remCount() {
        if(itemCount != 0){ itemCount--;}
     
    }
    
}
