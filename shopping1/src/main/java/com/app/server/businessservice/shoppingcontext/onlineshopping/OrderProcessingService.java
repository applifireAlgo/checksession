package com.app.server.businessservice.shoppingcontext.onlineshopping;
import com.app.server.repository.shoppingcontext.onlineshopping.CartRepository;
import com.app.server.repository.shoppingcontext.onlineshopping.ItemRepository;
import com.app.server.repository.shoppingcontext.onlineshopping.OrderMainRepository;
import com.app.server.repository.shoppingcontext.onlineshopping.OrderTransactionRepository;
import com.app.shared.shoppingcontext.onlineshopping.Cart;
import com.app.shared.shoppingcontext.onlineshopping.Item;
import com.app.shared.shoppingcontext.onlineshopping.OrderMain;
import com.app.shared.shoppingcontext.onlineshopping.OrderTransaction;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.shoppingcontext.onlineshopping.PaymentDetails;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderProcessingService {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private OrderProcessServiceImpl orderProcessServiceImpl;

    @Autowired
    private ItemRepository<Item> itemRepository;

    @Autowired
    private SessionDataMgtService sessionService;

    @Autowired
    private CartRepository<Cart> cartRepository;

    @Autowired
    private OrderMainRepository<OrderMain> orderMainRepository;

    @Autowired
    private OrderTransactionRepository<OrderTransaction> orderTransactionRepository;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void processOrder(PaymentDetails paymentDetails) throws SpartanBusinessValidationFailedException, SpartanPersistenceException, SpartanDataNotFoundException, Exception {
        java.lang.String userIdFromSession = (java.lang.String) sessionService.getSessionData("userId");
        if (userIdFromSession == null) {
            throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("Data not found in session");
        }
        if (paymentDetails.getAmount() <= 0) {
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3009");
        }
        java.util.List<com.app.shared.shoppingcontext.onlineshopping.Cart> cartList = cartRepository.findByUserId(userIdFromSession);
        com.app.shared.shoppingcontext.acl.OrderACL orderACL = new com.app.shared.shoppingcontext.acl.OrderACL(cartList);
        com.app.shared.shoppingcontext.onlineshopping.OrderMain orderMain1 = orderMainRepository.save(orderACL.getOrder());
        com.app.shared.shoppingcontext.onlineshopping.TransactionResponse transactionresponse1 = orderProcessServiceImpl.processOrder(paymentDetails);
        com.app.shared.shoppingcontext.onlineshopping.OrderTransaction orderTransaction1 = new com.app.shared.shoppingcontext.onlineshopping.OrderTransaction();
        orderTransaction1.setOrderId(orderMain1.getOrderId());
        orderTransaction1.setTransactionId(transactionresponse1.getTransactionId());
        orderMain1.setOrderDate(new java.sql.Date(java.lang.System.currentTimeMillis()));
        orderMain1.setUserId(runtimeLogInfoHelper.getRuntimeLogInfo().getUserId());
        orderMain1.setGrandTotal(orderMain1.getTotalSubTotal());
        for (com.app.shared.shoppingcontext.onlineshopping.Cart cartListElement : cartList) {
            if (cartListElement.getItemId() != null) {
                com.app.shared.shoppingcontext.onlineshopping.Item item = itemRepository.findById(cartListElement.getItemId());
                item.setItemStock(item.getItemStock() - cartListElement.getItemQuantity());
                cartListElement.getSystemInfo().setActiveStatus(0);
                itemRepository.update(item);
                cartRepository.update(cartList);
            }
        }
        com.app.shared.shoppingcontext.onlineshopping.OrderTransaction orderTransaction2 = orderTransactionRepository.save(orderTransaction1);
        orderMainRepository.update(orderMain1);
    }
}
