
package com.cg.go.greatoutdoor.wishlist.dao;

import java.util.List;

import com.cg.go.greatoutdoor.wishlist.entity.WishlistItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;




public interface IWishlistRepository extends JpaRepository<WishlistItemEntity,Integer>{
	//List<WishlistItemEntity> findAll();

	List<WishlistItemEntity> findByUserId(int userId);

	//WishlistItemEntity findWishlistItem(String productId, String userId);
	//void addProductToWishlist(String prodId,long wishlistID);
	//void deleteWishlistItem(String productId, String userId);

	//void deleteWishlistByUserId(String userId) throws WishlistException;

	//WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem);

	
}


