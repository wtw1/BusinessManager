/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

public class Item {
    
    public float itemSellPrice;
    public float itemBuyPrice;
    public float itemWeight;
    public int itemCount;
    public String itemName;
    
    // constructor
    public Item(float sellPrice, float buyPrice, int ID, String name, float weight,int count) {
        itemSellPrice = sellPrice;
        itemBuyPrice = buyPrice;
        itemWeight = weight;
        //itemID = ID;
        itemCount = count;
        itemName = name;
    }
    
    public void transformIntoItem(Item item){
        this.itemName = item.itemName;
        this.itemSellPrice = item.itemSellPrice;
        this.itemBuyPrice = item.itemBuyPrice;
        this.itemWeight = item.itemWeight;
        this.itemCount = item.itemCount;
    }
   
    public Item() {
        itemSellPrice = 1.25f;
        itemBuyPrice = 1.10f;
        itemWeight = 3.35f;
        //itemID = 1;
        itemCount = 1;
        itemName = "Random Item";
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public void addCount() {
        itemCount++;
     
    }
    public void remCount() {
        if(itemCount != 0){ itemCount--;}
     
    }
    
}
