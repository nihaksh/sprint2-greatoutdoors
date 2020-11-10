package com.cg.go.greatoutdoor.wishlist.dto;

public class CreateWishlistItemRequest {
	  private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public CreateWishlistItemRequest(int userId) {
		super();
		this.userId = userId;
	}
}
