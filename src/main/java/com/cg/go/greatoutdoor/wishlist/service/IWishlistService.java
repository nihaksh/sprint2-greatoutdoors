package com.cg.go.greatoutdoor.wishlist.service;

import java.util.List;

import com.cg.go.greatoutdoor.wishlist.entity.WishlistItemEntity;
import com.cg.go.greatoutdoor.wishlist.exception.WishlistException;


public interface IWishlistService {
	
	List<WishlistItemEntity> findAll();

	List<WishlistItemEntity> findByUserId(String userId);


	//WishlistItemEntity findWishlistItem(String productId, String userId);
	//void addProductToWishlist(String prodId,long wishlistID);
	//void deleteWishlistItem(int productId, String userId) throws WishlistException;

	void deleteByUserId(int userId) ;

	WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem);

}
