package com.cg.go.greatoutdoor.wishlist.service;

import java.util.List;

import com.cg.go.greatoutdoor.wishlist.entity.WishlistItemEntity;
import com.cg.go.greatoutdoor.wishlist.exception.WishlistException;


public interface IWishlistService {
	
	List<WishlistItemEntity> findAll();

	

	WishlistItemEntity findWishlistItem(String productId, int userId);
	void addProductToWishlist(String prodId,int wishlistID);
	void deleteWishlistItem(String productId, int userId) throws WishlistException;
	WishlistItemEntity findWishListById(int wishlistID);
	void deleteByUserId(int userId) ;

	WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem);

	List<WishlistItemEntity> findByUserId(int userId);

}
