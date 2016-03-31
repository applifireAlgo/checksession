package com.app.server.service.organizationboundedcontext.location;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.location.CurrencyRepository;
import com.app.shared.organizationboundedcontext.location.Currency;
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
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CurrencyTestCase extends EntityTestCriteria {

    @Autowired
    private CurrencyRepository<Currency> currencyRepository;

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

    private Currency createCurrency(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCountryCode1("Rjq");
        country.setCountryName("OrtD191KZzVBYU2Ea2wz1LDUObH0jmYAHZGTLA1x4FiJE6IWtW");
        country.setCurrencySymbol("KgWDV2KhMCP6DPZwffoWUCKgIQnh3j39");
        country.setCapitalLongitude(6);
        country.setCountryCode2("Ibj");
        country.setCountryFlag("JEnEDcMWC4YNQ6G2chh1Zr9xmzyVrShyU5wxFSnf1a98jq4E4k");
        country.setCapital("ArXOxjPQc3w7ysTXJxegtW6DP7CNXRXC");
        country.setIsoNumeric(844);
        country.setCapitalLatitude(6);
        country.setCurrencyName("amaOSj5eDCKB4xz4eheqiM9yRjBtR55jJCVGp5Zvieeh1GC4AJ");
        country.setCurrencyCode("hlw");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        Currency currency = new Currency();
        currency.setUnicodeDecimal("T4XdEFtr5dpHR9ZYNNQPA4L2kLnD0481rsAXBixWPKqqsMbF7g");
        currency.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        currency.setUnicodeHex("G70ZdlzqDumtQMS11pm6EMP0MHQvO9I9CGpUuJohrZoK4LjKm2");
        currency.setCurrencyCode("zVaA9JJpjHQ2L8AyKvGQSYVSrJQnCifW76XCgWW992El6jyRRr");
        currency.setEntityValidator(entityValidator);
        return currency;
    }

    @Test
    public void test1Save() {
        try {
            Currency currency = createCurrency(true);
            currency.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            currency.isValid();
            currencyRepository.save(currency);
            map.put("CurrencyPrimaryKey", currency._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CurrencyPrimaryKey"));
            Currency currency = currencyRepository.findById((java.lang.String) map.get("CurrencyPrimaryKey"));
            currency.setUnicodeDecimal("rjfzPuj55YeFD0P8E6PiuoxpxsOp6x2Uc4D9zb91YIQbLSNYmp");
            currency.setVersionId(1);
            currency.setUnicodeHex("CzNMkF8dRWHB4PpQ5mFRsruVpTza5YwXTpZMMDMwls4DkyBPcj");
            currency.setCurrencyCode("5tmcTFq2NvQuv27zi5Ft0d6YLKhQWVOitheToeMYv3X2eYsB2K");
            currency.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            currencyRepository.update(currency);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CurrencyPrimaryKey"));
            currencyRepository.findById((java.lang.String) map.get("CurrencyPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Currency> listofcountryId = currencyRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CurrencyPrimaryKey"));
            currencyRepository.delete((java.lang.String) map.get("CurrencyPrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCurrency(EntityTestCriteria contraints, Currency currency) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            currency.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            currency.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            currency.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            currencyRepository.save(currency);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "currencyCode", "qyTc2wLfNYhcvfbs4uMACpmzSNonIDtAEZa0HU7Zw02cW8VY90WMyp3dGneTOyrGnSULfSRsJuE8XZJiA8gs58a6reE1zqPxEiXdsak1JeeKmZpr9SEehfIHOzhxBxQpZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "unicodeDecimal", "2yQwXwWcQ9ocdBXFHd8a8NIo91L6zKGPEP6bw25NGCo6ZN5EoqFxurCfpNgjdAKJN9mrTuYfkeAovYoitK7PJ4SU6XLYbMcNQKUxeVcdCenSveZKLcAedQplGW0hZ1as6"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "unicodeHex", "hEZ3DLkYLzR7axtvWeGc6sOTMskOXhGTc0xsGLLggsUsxdKCo5cEA1gMDxFA945eRuciUJNT5CdeDMfuZGOKX7yHKnY374Iat68VbOhMurSiJAwCsKSVIYVWibTSrCMNR"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Currency currency = createCurrency(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = currency.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        currency.setCurrencyCode(contraints.getNegativeValue().toString());
                        validateCurrency(contraints, currency);
                        failureCount++;
                        break;
                    case 2:
                        currency.setUnicodeDecimal(contraints.getNegativeValue().toString());
                        validateCurrency(contraints, currency);
                        failureCount++;
                        break;
                    case 3:
                        currency.setUnicodeHex(contraints.getNegativeValue().toString());
                        validateCurrency(contraints, currency);
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
