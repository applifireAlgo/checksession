package com.app.server.repository.shoppingcontext.onlineshopping;
import com.athena.server.repository.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;

@SourceCodeAuthorClass(createdBy = "q@yc.com", updatedBy = "", versionNumber = "1", comments = "Repository for Cart Transaction table", complexity = Complexity.MEDIUM)
public interface CartRepository<T> extends SearchInterface {

    public List<T> findAll() throws SpartanPersistenceException;

    public T save(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void delete(String id) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void update(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> findByItemId(String itemId) throws Exception, SpartanPersistenceException;

    public List<T> findByUserId(String userId) throws Exception, SpartanPersistenceException;

    public T findById(String cartId) throws Exception, SpartanPersistenceException;
}
