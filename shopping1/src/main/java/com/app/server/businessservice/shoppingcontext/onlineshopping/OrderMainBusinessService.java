package com.app.server.businessservice.shoppingcontext.onlineshopping;
import com.app.server.repository.shoppingcontext.onlineshopping.OrderMainRepository;
import com.app.shared.shoppingcontext.onlineshopping.OrderMain;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class OrderMainBusinessService {

    @Autowired
    private OrderMainRepository orderMainRepository;

    public void update(OrderMain entity) throws SpartanPersistenceException {
        try {
            if (entity.isHardDelete()) {
                orderMainRepository.delete(entity.getOrderId());
            } else {
                orderMainRepository.deleteOrderDetails(entity.getDeletedOrderDetailsList());
                orderMainRepository.update(entity);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    public void update(List<OrderMain> entity) throws SpartanPersistenceException {
        try {
            for (OrderMain _ordermain : entity) {
                if (_ordermain.isHardDelete()) {
                    orderMainRepository.delete(_ordermain.getOrderId());
                } else {
                    orderMainRepository.deleteOrderDetails(_ordermain.getDeletedOrderDetailsList());
                    orderMainRepository.update(_ordermain);
                }
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in updating Entity", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }
}
