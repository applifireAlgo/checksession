package com.app.server.service.shoppingcontext.onlineshopping;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.shoppingcontext.onlineshopping.BrandRepository;
import com.app.shared.shoppingcontext.onlineshopping.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.shoppingcontext.onlineshopping.Category;
import com.app.server.repository.shoppingcontext.onlineshopping.CategoryRepository;
import com.app.shared.shoppingcontext.onlineshopping.Product;
import com.app.server.repository.shoppingcontext.onlineshopping.ProductRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class BrandTestCase extends EntityTestCriteria {

    @Autowired
    private BrandRepository<Brand> brandRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private Brand createBrand(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Category category = new Category();
        category.setCategoryName("9bnUrJEICF2SoABlIrWj0JIW1qL5BH6sSdfY37BodQMSN09Vmx");
        Product product = new Product();
        product.setProductName("DmZjltoU1REDFFfMDVguSs9G2A9En8E0sQU8Z4oglkVFsQRzXV");
        Product ProductTest = new Product();
        if (isSave) {
            ProductTest = productRepository.save(product);
            map.put("ProductPrimaryKey", product._getPrimarykey());
        }
        category.setCategoryName("DrHNcF1NrZCDBfn1LXTHB6nXysxRXYJGjGJjeZYW3a8IWGE9TH");
        category.setProductId((java.lang.String) ProductTest._getPrimarykey()); /* ******Adding refrenced table data */
        Category CategoryTest = new Category();
        if (isSave) {
            CategoryTest = categoryRepository.save(category);
            map.put("CategoryPrimaryKey", category._getPrimarykey());
        }
        Brand brand = new Brand();
        brand.setCategoryId((java.lang.String) CategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        brand.setBrandName("YZUptyp1nByR6mfTGOW8WG239FKczRkCocMVWRDAx8Fw9jsK4m");
        brand.setProductId((java.lang.String) ProductTest._getPrimarykey());
        brand.setEntityValidator(entityValidator);
        return brand;
    }

    @Test
    public void test1Save() {
        try {
            Brand brand = createBrand(true);
            brand.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            brand.isValid();
            brandRepository.save(brand);
            map.put("BrandPrimaryKey", brand._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CategoryRepository<Category> categoryRepository;

    @Autowired
    private ProductRepository<Product> productRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("BrandPrimaryKey"));
            Brand brand = brandRepository.findById((java.lang.String) map.get("BrandPrimaryKey"));
            brand.setBrandName("B1wuOkkI1SbwnSHEeR667uWVqdoYw8zfo6JSPehwe1CUD2LbsS");
            brand.setVersionId(1);
            brand.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            brandRepository.update(brand);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycategoryId() {
        try {
            java.util.List<Brand> listofcategoryId = brandRepository.findByCategoryId((java.lang.String) map.get("CategoryPrimaryKey"));
            if (listofcategoryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("BrandPrimaryKey"));
            brandRepository.findById((java.lang.String) map.get("BrandPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByproductId() {
        try {
            java.util.List<Brand> listofproductId = brandRepository.findByProductId((java.lang.String) map.get("ProductPrimaryKey"));
            if (listofproductId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("BrandPrimaryKey"));
            brandRepository.delete((java.lang.String) map.get("BrandPrimaryKey")); /* Deleting refrenced data */
            categoryRepository.delete((java.lang.String) map.get("CategoryPrimaryKey")); /* Deleting refrenced data */
            productRepository.delete((java.lang.String) map.get("ProductPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateBrand(EntityTestCriteria contraints, Brand brand) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            brand.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            brand.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            brand.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            brandRepository.save(brand);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "brandName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "brandName", "V63zKPjeL1Hk7itcH0FkZRpdS439eBWgLlXUMi1gcv7Ia0DR1YHUwSlwrOhDdFRDnfZmPdKGVmjCDiOrZezrZrpKKdUFTBHqJsdRvlewjpEv4eINLdhpNyaLf71vb3sdLB041vETNAos13dimnGtGC3YsnTnmOwycLmpiKvBm6wLmpzu2tvgFpeP6TPm01j4qOwETRTm0OPY9f0Tz38y5EeXXPjxdgyillDTaRRpomeUpVPXDoJdEL1Aj1AhOTnIV"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Brand brand = createBrand(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = brand.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(brand, null);
                        validateBrand(contraints, brand);
                        failureCount++;
                        break;
                    case 2:
                        brand.setBrandName(contraints.getNegativeValue().toString());
                        validateBrand(contraints, brand);
                        failureCount++;
                        break;
                }
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}