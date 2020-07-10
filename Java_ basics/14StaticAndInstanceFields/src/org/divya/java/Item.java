package org.divya.java;

/*
 * Instance methods can access static methods or fields but static methods can't access instance methods directly
 * 
 */
public class Item {
	static int itemID;
	String itemDes;
	
	
	public static void show() {
		
		itemID = 1;
		new Item().itemDes = "Shirt"; //non-static members are accessed by referencing with class object
	}
	
	public void showID() {
		
		itemID = 10;
		itemDes = "Trousers";
	}

}
