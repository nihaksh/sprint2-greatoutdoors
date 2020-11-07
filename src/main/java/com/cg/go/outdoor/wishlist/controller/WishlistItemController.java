package com.cg.go.outdoor.wishlist.controller;


import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.greatoutdoor.wishlist.dto.CreateWishlistItemRequest;
import com.cg.go.greatoutdoor.wishlist.dto.WishlistItemDetails;
import com.cg.go.greatoutdoor.wishlist.entity.WishlistItemEntity;
import com.cg.go.greatoutdoor.wishlist.exception.WishlistException;
import com.cg.go.greatoutdoor.wishlist.service.IWishlistService;
import com.cg.go.greatoutdoor.wishlist.util.WishlistUtil;



@RequestMapping("/WishlistItemEntity")
@RestController
public class WishlistItemController {
	@Autowired
	public IWishlistService wishlistService;
	@Autowired
	private WishlistUtil wishlistutil;
	/**
     * effective URL will be http://localhost:8585WishlistItemEntity/add
	 * @throws WishlistException 
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public WishlistItemDetails add(@RequestBody CreateWishlistItemRequest requestData) {
    	WishlistItemEntity additem =wishlistService.addWishlistItem(new WishlistItemEntity(requestData.getUserId(), requestData.getProductId()));
         return wishlistutil.toDetails(additem);
    }

    @GetMapping("/get/user/{id}")
	public List<WishlistItemDetails> fetchCustomer(@PathVariable("id") String userId) 
	{
    	List<WishlistItemEntity> add = wishlistService.findByUserId(userId);
		return wishlistutil.toDetails(add);
		
	}
	@RequestMapping("/viewallItems")
	public List<WishlistItemEntity> findAllItems(){
		return wishlistService.findAll();
	}

 
    
    @DeleteMapping("/remove/{id}")
    public String deleteWishlist(@PathVariable("id") int userId) {
        wishlistService.deleteByUserId(userId);
        String response = "removed product with id=" + userId;
        return response;
    }
    
    
	
    

  

}
