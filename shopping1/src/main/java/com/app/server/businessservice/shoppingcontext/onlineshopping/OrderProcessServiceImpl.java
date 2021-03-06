package com.app.server.businessservice.shoppingcontext.onlineshopping;
import org.springframework.stereotype.Service;
import com.athena.deo.camel.utility.ExternalIntegrationCaller;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.shoppingcontext.onlineshopping.PaymentDetails;
import com.app.shared.shoppingcontext.onlineshopping.TransactionResponse;

@Service
public class OrderProcessServiceImpl {

    @Autowired
    private ExternalIntegrationCaller externalIntegrationCaller;

    public TransactionResponse processOrder(PaymentDetails paymentDetails) throws Exception {
        try {
            java.util.HashMap map = new java.util.HashMap();
            map.put("paymentDetails", paymentDetails);
            com.app.shared.shoppingcontext.onlineshopping.TransactionResponse transactionresponse = (com.app.shared.shoppingcontext.onlineshopping.TransactionResponse) externalIntegrationCaller.executeRoute("FC88FD0D-FB74-4072-B85D-109B036272A6", map);
            return transactionresponse;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
