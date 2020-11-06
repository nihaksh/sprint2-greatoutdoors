package com.cg.go.greatoutdoor.wishlist.dto;

import java.util.List;

import javax.persistence.ElementCollection;

public class WishlistItemDetails {
	private long wishlistId;
    private int userId;
    @ElementCollection
    private List<String> productId;
    public WishlistItemDetails() {}
	public WishlistItemDetails(long wishlistId, int userId, List<String> productId) {
		
		this.wishlistId = wishlistId;
		this.userId = userId;
		this.productId = productId;
	}
	public long getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(long wishlistId) {
		this.wishlistId = wishlistId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<String> getProductId() {
		return productId;
	}
	public void setProductId(List<String> productId) {
		this.productId = productId;
	}
}
