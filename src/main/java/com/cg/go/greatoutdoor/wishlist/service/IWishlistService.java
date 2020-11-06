package com.cg.go.greatoutdoor.wishlist.service;

import java.util.List;

import com.cg.go.greatoutdoor.wishlist.entity.WishlistItemEntity;
import com.cg.go.greatoutdoor.wishlist.exception.WishlistException;


public interface IWishlistService {

	List<WishlistItemEntity> findAllItems();

	List<WishlistItemEntity> findWishlist(String userId);

	WishlistItemEntity findWishlistItem(String productId, String userId);
	void addProductToWishlist(String prodId,long wishlistID);
	void deleteWishlistItem(String productId, String userId) throws WishlistException;

	void deleteWishlist(String userId) throws WishlistException;

	WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem) throws WishlistException;

}
