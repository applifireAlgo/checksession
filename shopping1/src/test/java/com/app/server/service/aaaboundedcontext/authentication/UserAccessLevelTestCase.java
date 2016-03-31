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
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
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
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("OSdZHCFpooDUaIWU0onMne7CIkZ1biCmjs74KRUlafCXkZF16p");
        useraccesslevel.setLevelDescription("tsiPEjXenVZZgterolWte5lSll7a7v0g5hFIglA9yCiihZ5UMY");
        useraccesslevel.setLevelIcon("QCX9ZFgRN8nh8DII4uEV2RuMsYqakAggX8mpVAYvsF7p5DuA0m");
        useraccesslevel.setLevelName("JCrXtDxk7GR9QPdV7DepZcVuOOGwqG6Ru79Lv1rrLFY5Gcl40b");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelHelp("oZbvXC0GJE1Yy79hIZ41Z5LRLgwwxKIxBfcvIHaiaV95k9Mkcp");
            useraccesslevel.setLevelDescription("onBVuMmV0XbZn42sYnYaToCsIWF8o3vVpK6aLmvyEqVQLyhMVB");
            useraccesslevel.setLevelIcon("jwmRHom2ektMvsTJ3udy2T0dLn3xfkSCpAnib0lkXGsBc9sIUV");
            useraccesslevel.setLevelName("d2FfKkLNC9KTvNI3pNV2vQTrRHSXgIWCUiWkW4yXmK6TjHRJVQ");
            useraccesslevel.setUserAccessLevel(86549);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 126689));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "WuGliRV8zLLtPZ9ZsCsIjmFRu0O1vaYeeIoyjVehp4Grk2DZTJgGVLkkd1SXgj6XjDFmbINP9T7eqJxvr8eAOoHt3Qsg4v65bumASyZUlzTu0SNJNMK8WTkEkts7NzWq1EgtsSpMPUI0zhafecwuAtivRoFzJpr0aSHDmlASsqpqREWx8SPiqCz1ah2NMoAdEKQNlKL2JsCLIpSihBfHte6shRJhjXF3zmQ2zxnY4kpQMA6aXwH1gdXslMpaG4kH6"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "gfbD85076Ago7bWrn5XZCovzAf408GZYOUXSiyeoPJAioyEySU4dGIJPMNvcW77lEpcwfyoED4QnaUsKAYLiezzLlPVYFZupuy3V5UDsUpVqXXJX0lNTO1TMNGm3JNX6pRbOGgF6pmebPLfk9hfslv76dRVuupEr9aNY7beUwFiIdD636CLcImzjsUAtNKAhtV49xDIJzy2eocCgcgukvJ1KjZgIc8RyvkVg3dP8vnkIgqRn4hNQrT3cSMesDyhot"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "SqiTlEBpftWFSnYIVc4U8svNxplx42qhzjSuG5TTeLPePwca5sMHyIOzexZKtfUpWXDwJfjPYuWEZWVdBV19LgHDW87zAZtUmhVkeDdi0Hx4F5RuFqmhfuPkI1kxRylx10iV94FKj9XEx16axq3HepnMeWkRMaXkWeHQaGzvFQJpF9HDD4xkPnphcDOwtuvbLGJYktMFrWZnE5swDuDOqq5n9q35zlLbeOAqbhaQAesXIp7hWq8IdftgvITnmL0CF"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
