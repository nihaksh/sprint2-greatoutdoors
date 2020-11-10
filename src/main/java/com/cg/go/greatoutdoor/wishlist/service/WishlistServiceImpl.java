package com.cg.go.greatoutdoor.wishlist.service;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.greatoutdoor.product.service.ProductServiceImpl;
import com.cg.go.greatoutdoor.wishlist.dao.IWishlistRepository;
import com.cg.go.greatoutdoor.wishlist.entity.WishlistItemEntity;
import com.cg.go.greatoutdoor.wishlist.exception.WishlistException;
import com.cg.go.greatoutdoor.wishlist.exception.WishlistNotFoundException;
@Transactional
@Service
public class WishlistServiceImpl  implements IWishlistService{
private static final Logger Log = LoggerFactory.getLogger(ProductServiceImpl.class);
		
	    @Autowired
	private IWishlistRepository wishlistRepository;

	
     @Override
	public List<WishlistItemEntity> findAll() {
		
        List<WishlistItemEntity> list=new ArrayList<WishlistItemEntity>();
        list=wishlistRepository.findAll();
        return list;
	}

	@Override
	public List<WishlistItemEntity> findByUserId(int userId) {
		List<WishlistItemEntity> optional=wishlistRepository.findByUserId(userId);
		return optional;
	}

	@Override
	public void deleteByUserId(int userId){
		Optional<WishlistItemEntity> optional=wishlistRepository.findById(userId);
		if(!optional.isPresent()){
            throw new WishlistNotFoundException("Product not found for id="+userId);
        }
		List<WishlistItemEntity> wishlist= findByUserId(userId);
		for(WishlistItemEntity item : wishlist)
		{
			//WishlistRepository.deleteById(item.getWishlistId());
			wishlistRepository.delete(item);
		}
		
       
		
	}

	@Override
	public WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem){
	//	if(wishlistItem==null){
		//throw new WishlistException("invalid wishlistitem");
		//}
		boolean exists=wishlistItem.getWishlistId()!=0 &&  wishlistRepository.existsById(wishlistItem.getWishlistId());
        if(exists){
            throw new WishlistException("Wishlist already exists for id="+wishlistItem.getUserId());
        }
        WishlistItemEntity wishlistObject=wishlistRepository.save(wishlistItem);
      
		return wishlistObject;
	}

	@Override
	public WishlistItemEntity findWishlistItem(String productId, int userId) {
		 List<WishlistItemEntity> list = findByUserId(userId);
         for (WishlistItemEntity entity:list){
         List<String>products=  entity.getProductId();
         if(products!=null && products.contains(productId)){
             return entity;
         }
        }

        throw new WishlistNotFoundException("wishlist not found for user="+userId+" product="+productId);

    }
	
	


	@Override
	public void addProductToWishlist(String prodId, int wishlistID) {
		 WishlistItemEntity entity = findWishListById(wishlistID);
	        List<String> productIds = entity.getProductId();
	        if (productIds == null) {
	            productIds = new ArrayList<>();
	            entity.setProductId(productIds);
	        }
	        if (!productIds.contains(prodId)) {
	            productIds.add(prodId);
	            wishlistRepository.save(entity);
	        }

	    
		
		
	}
@Override
	public WishlistItemEntity findWishListById(int wishlistID) {
		
	Optional<WishlistItemEntity> optional =	wishlistRepository.findById(wishlistID);
	if(!optional.isPresent()){
        throw new WishlistNotFoundException("wishlist not found for id="+wishlistID);
    }
		return optional.get();
	}

	@Override
	public void deleteWishlistItem(String productId, int userId) throws WishlistException {
		WishlistItemEntity entity = findWishlistItem(productId, userId);

        List<String> productIds = entity.getProductId();
        if (productIds == null || !productIds.contains(productId)) {
            return;
        }
        productIds.remove(productId);
        wishlistRepository.save(entity);
    }

	
	

}
