package com.cg.go.greatoutdoor.wishlist.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.greatoutdoor.product.service.ProductServiceImpl;
import com.cg.go.greatoutdoor.wishlist.dao.IWishlistRepository;
import com.cg.go.greatoutdoor.wishlist.entity.WishlistItemEntity;
import com.cg.go.greatoutdoor.wishlist.exception.WishlistException;
@Transactional
@Service
public class WishlistServiceImpl  implements IWishlistService{
private static final Logger Log = LoggerFactory.getLogger(ProductServiceImpl.class);
		
	    @Autowired
	IWishlistRepository daoWishlist;

	
     @Override
	public List<WishlistItemEntity> findAllItems() {
		
        List<WishlistItemEntity> list=new ArrayList<WishlistItemEntity>();
        list=daoWishlist.findAllItems();
        return list;
	}

	@Override
	public List<WishlistItemEntity> findWishlist(String userId) {
	     List<WishlistItemEntity> list=new ArrayList<WishlistItemEntity>();
        list=daoWishlist.findWishlist(userId);
      	return list;
	}

	@Override
	public WishlistItemEntity findWishlistItem(String productId, String userId) {
	     WishlistItemEntity wishlistObject =daoWishlist.findWishlistItem(productId,userId);
		return wishlistObject;
	}

	@Override
	public void addProductToWishlist(String prodId, long wishlistID) {
		//if(prodId==null||prodId.isEmpty()){
         //throw new Exception("productid is null or empty");
		//}
		
        daoWishlist.addProductToWishlist(prodId, wishlistID );
        
      
		
	}

	@Override
	public void deleteWishlistItem(String productId, String userId) throws WishlistException {
		
        daoWishlist.deleteWishlistItem(productId, userId);
      
	}

	@Override
	public void deleteWishlist(String userId) throws WishlistException {
		
        daoWishlist.deleteWishlist(userId);
       
		
	}

	@Override
	public WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem) throws WishlistException {
		if(wishlistItem==null){
			throw new WishlistException("invalid wishlistitem");
		}
		
        WishlistItemEntity wishlistObject=daoWishlist.addWishlistItem(wishlistItem);
      
		return wishlistObject;
	}

}
