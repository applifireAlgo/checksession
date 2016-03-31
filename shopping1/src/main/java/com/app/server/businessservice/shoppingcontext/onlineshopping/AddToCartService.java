package com.app.server.businessservice.shoppingcontext.onlineshopping;
import com.app.server.repository.shoppingcontext.onlineshopping.CartRepository;
import com.app.server.repository.shoppingcontext.onlineshopping.ItemRepository;
import com.app.shared.shoppingcontext.onlineshopping.Cart;
import com.app.shared.shoppingcontext.onlineshopping.Item;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class AddToCartService {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private CartRepository<Cart> cartRepository;

    @Autowired
    private ItemRepository<Item> itemRepository;

    public void addToCart(Cart entity) throws SpartanBusinessValidationFailedException, SpartanPersistenceException, Exception {
        if (entity.getItemQuantity() <= 0) {
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3007");
        }
        com.app.shared.shoppingcontext.onlineshopping.Item item = itemRepository.findById(entity.getItemId());
        if (entity.getItemQuantity() > item.getItemStock()) {
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3008");
        }
        if (entity.getItemQuantity() != null) {
            entity.setUserId(runtimeLogInfoHelper.getRuntimeLogInfo().getUserId());
            entity.setItemPrice(item.getItemPrice());
            entity.setSubTotal(item.getItemPrice() * entity.getItemQuantity());
            com.app.shared.shoppingcontext.onlineshopping.Cart cart1 = cartRepository.save(entity);
        }
    }
}
