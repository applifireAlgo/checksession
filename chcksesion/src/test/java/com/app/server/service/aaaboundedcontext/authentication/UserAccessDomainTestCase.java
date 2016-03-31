package com.app.server.service.aaaboundedcontext.authentication;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("HElEjxBYnBvTzZCWq7Z0u2NDHvL5Giz7PpfpmCIL1L3ypqoGAe");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainIcon("Ky1UXiAyDYeVTcyLEI41oYZqmUi9LfCRWFXUpvYiYA7ObarFNF");
        useraccessdomain.setDomainName("713kWUuLhsaWjGhNCMTcDAhPOHFMnUsKZK6p67oh8J4CPYBCoC");
        useraccessdomain.setDomainHelp("iNw4dzs15M06xFOvQiz2pRnwFjnpHLlLrFiTlHxy6GPkl08tnc");
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setDomainDescription("kvH9AcxeGttMtp6eQbYzLA91Yq189vtBYpGb9Nr4jUKribGKkn");
            useraccessdomain.setUserAccessDomain(38743);
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainIcon("DJMfbU8aNa7YHlm3ky2AK99OYwyXuKjfoQKWIilU1Hmk0xVmYK");
            useraccessdomain.setDomainName("Xe4GnuzGdBk9o5fSvACEovy5QSpd9dnV8SLQcFebGWWw0kOjR6");
            useraccessdomain.setDomainHelp("MeDBgCy4iNI6li1N8FyfEflAjjvCjS955CaMB8k2FhDksbgrOO");
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 148296));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "a1VJPiEktnSzmmltw6iSnk9TVTVQDhdM0s7VUiPrftj6io0Y6hmf2vkpDNL8nierHyNV5TTHgyp0OBJMZUjefjd15eIvGt8ctKPEIgBoVEGZf8r4wVn5ZG1FeNyhxTxW1bPmvrZrzh07HY2E08Xi9qm344zkEG5QJNGVSRPya8OJ3g7jGNrjnRZhn8SgWD5EeMJAUxWkMZElRFXPAuQB784RO8WIB5MPccIPWidsQE4ph1Y1ixiMfjGXp1DhTPwKm"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "nbQvVIwPE4wV18Kze7IJ9a0mCxbiEMTrOl3gxZbAuK85gWMfW88HPIV0LdohkLcmr01BoBoxky9v3zxlHSermqeGHWcTO78CqCSYrx2zlPvnh5dRhzgZ7BW3UMbAZg3QNygFrUZajDNTrTEi5rnH7AnkkRUQG7FTx1QB14sbvmXv9kKITTVUS5irKv4eAJGbsjy3cFMST6TrY2PeYXEiZ52cOHIlVai29m1F2yXKEAqx5zXxQoXCdbgUtamLcjp9l"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "1ROlOFCD3D22qDegDkmzGVOnz578FSXHhXul2EKOk9QSDriLsn0CotUojZrpP0vNUXxLUJqVKtOpgX8m7l42c0tnj4aBmqiMXjjLDHake32mt8ftZUyJBj6JdA6h71Wa86nMDL5HO3qjBAbPaQJGZaF9hQSwE0SY7oHFAu3WaeYIpHyf4m0qXNLM8wnkmfYHZrww7pGBjiGXxEgsUmlcHZ49kU2TODnHy55Wh4QcCz74KLXlmjjsqvYoYmeSJmlQK"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
