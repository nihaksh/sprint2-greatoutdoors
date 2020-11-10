package com.cg.go.greatoutdoor.wishlist.dto;


public class AddProductToWishlistItemRequest {

   
 private String productId;
 private int wishlistId;
	
	public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public int getWishlistId() {
	return wishlistId;
}
public void setWishlistId(int wishlistId) {
	this.wishlistId = wishlistId;
}
}
	