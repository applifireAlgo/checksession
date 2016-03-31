package com.app.server.repository.shoppingcontext.onlineshopping;
import com.athena.server.repository.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.app.shared.shoppingcontext.onlineshopping.OrderDetails;

@SourceCodeAuthorClass(createdBy = "q@yc.com", updatedBy = "q@yc.com", versionNumber = "2", comments = "Repository for OrderMain Transaction table", complexity = Complexity.MEDIUM)
public interface OrderMainRepository<T> extends SearchInterface {

    public List<T> findAll() throws SpartanPersistenceException;

    public T save(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void delete(String id) throws SpartanPersistenceException;

    public void deleteOrderDetails(List<OrderDetails> orderdetails) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void update(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> findByUserId(String userId) throws Exception, SpartanPersistenceException;

    public T findById(String orderId) throws Exception, SpartanPersistenceException;
}
