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
@Transactional
@Service
public class WishlistServiceImpl  implements IWishlistService{
private static final Logger Log = LoggerFactory.getLogger(ProductServiceImpl.class);
		
	    @Autowired
	IWishlistRepository WishlistRepository;

	
     @Override
	public List<WishlistItemEntity> findAll() {
		
        List<WishlistItemEntity> list=new ArrayList<WishlistItemEntity>();
        list=WishlistRepository.findAll();
        return list;
	}

	@Override
	public List<WishlistItemEntity> findByUserId(int userId) {
	     List<WishlistItemEntity> list=new ArrayList<WishlistItemEntity>();
        list=WishlistRepository.findByUserId(userId);
      	return list;
	}
/*
	@Override
	public WishlistItemEntity findWishlistItem(String productId, String userId) {
	     WishlistItemEntity wishlistObject =WishlistRepository.findWishlistItem(productId,userId);
		return wishlistObject;
	}

	@Override
	public void addProductToWishlist(String prodId, long wishlistID) {
		//if(prodId==null||prodId.isEmpty()){
         //throw new Exception("productid is null or empty");
		//}
		
		WishlistRepository.addProductToWishlist(prodId, wishlistID );
        
      
		
	}

	@Override
	public void deleteWishlistItem(String productId, String userId) throws WishlistException {
		
		WishlistRepository.deleteWishlistItem(productId, userId);
      
	}
*/
	@Override
	public void deleteByUserId(int userId){
		List<WishlistItemEntity> wishlist= findByUserId(userId);
		for(WishlistItemEntity item : wishlist)
		{
			WishlistRepository.deleteById(item.getWishlistId());
		}
		
       
		
	}

	@Override
	public WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem){
	//	if(wishlistItem==null){
		//	throw new WishlistException("invalid wishlistitem");
		//}
		
        WishlistItemEntity wishlistObject=WishlistRepository.save(wishlistItem);
      
		return wishlistObject;
	}

}
