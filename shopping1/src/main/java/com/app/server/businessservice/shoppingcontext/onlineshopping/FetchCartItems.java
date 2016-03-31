package com.app.server.businessservice.shoppingcontext.onlineshopping;
import com.app.server.repository.shoppingcontext.onlineshopping.CartRepository;
import com.app.shared.shoppingcontext.onlineshopping.Cart;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;

@Component
public class FetchCartItems {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private CartRepository<Cart> cartRepository;

    @Autowired
    private SessionDataMgtService sessionService;

    public List<Cart> fetchCartItems() throws SpartanPersistenceException, SpartanDataNotFoundException, Exception {
        java.lang.String userIdFromSession = (java.lang.String) sessionService.getSessionData("userId");
        if (userIdFromSession == null) {
            throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("Data not found in session");
        }
        java.util.List<com.app.shared.shoppingcontext.onlineshopping.Cart> cartList = cartRepository.findByUserId(userIdFromSession);
        return cartList;
    }
}
