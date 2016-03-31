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
        useraccessdomain.setDomainDescription("pYYwE7DDHM3cAJPlDjTiWEvi2StYLknKHgxhmrnVF9jr1oRdMB");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainIcon("7UUGP3i63pYKRooxyZKaFk0LmGO4AkRLGCB49mz7f2nwi0g4aQ");
        useraccessdomain.setDomainHelp("MViN004caQeiySt7Po0pdqVvxTQwjRL2wzAK5qSaXkW7gDykbu");
        useraccessdomain.setDomainName("fwzc3J0eMaazpmTjedPksJ9H6FVim4XwZ0r62cJZVfHWBAEyYB");
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
            useraccessdomain.setDomainDescription("xm7exShV19b0Mct45Ko5k1VxBepg50Tuq4B0gkOF3It2fs6yCE");
            useraccessdomain.setUserAccessDomain(79700);
            useraccessdomain.setDomainIcon("qJ6RoKjJAQF9l8A3lvIBpxetYXO4rnqD8CYyXoFdon04pj8dxS");
            useraccessdomain.setDomainHelp("mFpCmRswH2VPyQbRAac3bOJZdG1zQlFseEom5AnYHgrDwLXIIR");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainName("hgv6hbt6IiOprV65pcwcNOnBfBWh8hfbbTISWqOvVaXdBsWshv");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 128854));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "XsoeVV4YcxuIgvEyTNbLxnV6DxdiE9t7Xem5A2012i1FPvFJOXMD0JpmvvXaKV2iWLB299iwnMxtdB0GnYqqFuycNoVBd7VR4TEaczuhc7qaUgQRqTHxrMj53WvKqmdGmGrwlI7t4LwNlX9zYlFqJokLJ2ncsbq3ZelMfBm8Yh7NzrO8WIjVfx63NyfnJ2buNRS7jHWWIpSTcnIK83NCadT9OK3k7Fwhoq10Pf2RsdOc6puSCHoWVf0PZHp6JBOIB"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "4wqK2PP7ab6gChJPDHvgIp3lJCowtzJqZgiBweABqEyPqgBW547gSLyeQWvOSc1Q7Ozg90Y6PVBnqw33HSiNy24JEuZLJxIlSq55qawdp5eX32ZMzWaLhJEneT3SwNOb4ELZJ9QcPmGy3ZZ3g6WCzcIxKPGq6UqnKsAJOqKJWnzolliLc20ujas4Yr3viZRfkaVV11bSdYiHGDUDRMl9Wc3vvQ1CkvjSrCd57bodWn0YdP9lmoWsELndfUGUxvJJh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "LayLHMH5LQVG2V4agkSqw62xCYRVKwSNWjhIjayM8nUlHEHCCMt2i5i8QgsSgrlvcKZT6HFRHoiVQX91lQQu5y1owiOk63QkKkDdKHIvvwJm2vIUf6XZe7uPlN6YSWfPXqhktfTiAn1pzF8n1BqyR0857dEBxySkMyWKUTtdvRcL0I6Bqk1phzVEt5dKDU9EFEfyfb4K7zevzy6aeJ55rIBviHy42sZ9RpelaAExUgHQ1Y2IjiW0711lVPBvhdFff"));
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
