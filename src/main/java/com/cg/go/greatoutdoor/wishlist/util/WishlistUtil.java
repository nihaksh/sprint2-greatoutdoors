package com.cg.go.greatoutdoor.wishlist.util;




import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.go.greatoutdoor.wishlist.dto.WishlistItemDetails;
import com.cg.go.greatoutdoor.wishlist.entity.WishlistItemEntity;



@Component
public class WishlistUtil {
	public List<WishlistItemDetails> toDetails(Collection<WishlistItemEntity> wishlistItem) {
		List<WishlistItemDetails> desired = new ArrayList<>();
		for (WishlistItemEntity add : wishlistItem) {
			WishlistItemDetails details = toDetails(add);
			desired.add(details);
		}
		return desired;
	}

	public WishlistItemDetails toDetails(WishlistItemEntity add) {
		return new WishlistItemDetails(add.getWishlistId(),add.getUserId(),add.getProductId());
	}
}
