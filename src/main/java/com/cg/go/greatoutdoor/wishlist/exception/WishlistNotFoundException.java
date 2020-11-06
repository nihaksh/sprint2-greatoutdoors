package com.cg.go.greatoutdoor.wishlist.exception;

public class WishlistNotFoundException extends RuntimeException{
    public WishlistNotFoundException(){

    }

    public WishlistNotFoundException(String msg){
        super(msg);
    }
}
