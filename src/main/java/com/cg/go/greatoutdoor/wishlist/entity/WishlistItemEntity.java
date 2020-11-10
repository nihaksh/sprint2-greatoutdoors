package com.cg.go.greatoutdoor.wishlist.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "wishlists")
public class WishlistItemEntity {
    @GeneratedValue
    @Id
    private int wishlistId;
    private int userId;
    @ElementCollection
    private List<String> productId;

    public WishlistItemEntity(int userId, List<String> productId) {

        this.userId = userId;
       this.productId = productId;
    }

    public WishlistItemEntity() {
    	
    }

    public WishlistItemEntity(int userId) {
		
	}

	public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<String> getProductId() {
        return productId;
    }

    public void setProductId(List<String> productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(wishlistId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WishlistItemEntity other = (WishlistItemEntity) obj;
        if (wishlistId != other.wishlistId)
            return false;
        return true;
    }

}
