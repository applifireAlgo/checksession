package com.app.server.service.aaaboundedcontext.authorization;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.app.shared.aaaboundedcontext.authorization.AppMenus;
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
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuDisplay(true);
        appmenus.setAutoSave(true);
        appmenus.setMenuAccessRights(3);
        appmenus.setMenuAction("Sd0PJhHExl7yxP8uw4vb4K4e49TuFTdIz17QPb9nswUeNuFx7d");
        appmenus.setAppId("4ooD95nEtjEMO9ZvXxa2mNVdMzhP7fZv7Ym5MNN9IHZiHwCswH");
        appmenus.setAppType(1);
        appmenus.setMenuCommands("JqXQvm0c5XSJmnFN8segoAXmt2W3gWX2I3ASON0fmKCYOUcPRG");
        appmenus.setMenuTreeId("kdFcrEyFn6l2QTa5tbDQxX45QndfTnnsrAhwaRfDFdvdAheJNW");
        appmenus.setMenuLabel("wyhhlZ6wdwUYxMvLOp8scT5HUCCUrzwMfbfAfI3JgUE2NQwrkC");
        appmenus.setMenuIcon("OpW6TPq6cF4hltmwG5wOT2I4CoGK9aP3bihw3FrfTUKtMtjAaO");
        appmenus.setUiType("Dw8");
        appmenus.setRefObjectId("OBPsROCr4VPdqQuunFChMw1rMK84BOqVjGeKa8ZQhUxjywkwvN");
        appmenus.setMenuHead(true);
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setMenuAccessRights(1);
            appmenus.setMenuAction("YYuaogK75UBJ8QV3Rpl8Ck6UkKTorl7fIQGdK5OtD8BZqKVh1u");
            appmenus.setAppId("f7XwzGxwSvS2ouJTWjj5cmnyUZ6qb8nlFirSUHDi96sMAm4daV");
            appmenus.setAppType(2);
            appmenus.setMenuCommands("9zeLq2zuMAXh6l1sDcexAwaCFdNQJ3cbAgf4rAmE6A2ALGKePH");
            appmenus.setMenuTreeId("XdzeOuEbWKZIqYOSrujb349AC5N2vZM8hnRyhtFLryrzQQo8lJ");
            appmenus.setMenuLabel("muZUVZNaITHIL5q7JGhocrm68qq0sRlMB3ccO8mWLSQpU8LgUa");
            appmenus.setMenuIcon("cWBMAgLTkigC5M9gIfHr1wJCKtLYTy8ZrECsJGudlJuoNBrTLF");
            appmenus.setUiType("ooK");
            appmenus.setVersionId(1);
            appmenus.setRefObjectId("y7ywQWVh6ccPvANHKkq58QoreuWQ6kWXCiBnZRpxwTjFZHQzw2");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "tuCBPYOcJqp1BvFKf6xHFVEMMNhrIZ6HVfwbKNTyLkVQRbi0ben281giFUh2TRw2oJP0Qo1zNmtu90pL7xzcCGIcuVcshiIJF2YmxKIAH5eBWu3euM0x13GIVUYQTMzFs72Z6EiKp4OiOE9QLM1WMbMrzqUK3bjZebSGXXYDl9EglfBymnVpSGueiU1Qu6jeTbmhOvRkjPgnW9oW4WPjBk7jlQAkcVvhli3XawZ6zTp9X0CVVYWTfh3IvTGaFce4g"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "wxfGLj6Uvk7ZiCAz1dAOX1q6Cu6Ep6iJp9kMYuns0Q95psVSQh3ZvZPD1xjoVZOO03Q2Fw8u9hkUMVTYorCnQmi5RkJhWrDVuYUV2aupXuwH0jepBcq8bMEQv2yPUs6gIIupZmr7QSZ13cjokdZUlw9UCSk1OOMqDkjiH4s7f0fgOG4ocpnVV7EqgbtXwlBQTokbrKW97jX4sjja7x6MSnltAX4J81QpB9DhLvROqEJjiRbgkpvYhF8Nd77Ylo85q"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "UBCjrOPZIooWmymYUEXuWhoZVWdtoUeeCtWVL1MoQJI8MJSMSQozMIntixWWpJp9q5hXT4f2PLUQOYFEy4ZrfkBlM6B5VHhIBlwqPfn0G6ZTSDmnkHOmYTK02WkwmTpfIT2fSs3lafOnxZW6FYUygezPSDsDgYxKrpHgoEpi4CmMVIcxWFJqJiRLyp4HEbxZVAsSAfcfX1iD5z2n2tCInUCXZcsMKJcUcIHiuYWw34pwJkuTek1iYPvLuMzOrzZTB"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "bg5Cok0TdE1AEUDHME7PZyY8WhUCfAEoNUvqGNnR1VfFYtMWKGxor9HAncnDUXBux"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "96hHDFSAliAMcpY8U48a8MjpJG8jX6FhcC5NeIOLOCS7wkU967rprFc2y6rFlzWhharF9VGfEaqgv63ckUofq5zug0xldY9dMs8eJxVlsuyOXkyuDVPSa4cMXVXJaiH7QKurcpETYgA611Polz41WqWOP46g3l5LFbLnn3BBRMC1ivLuNQBX67DxDjrpkXy9GTxy10egG1m9v2u71GilwgODg64ft1LO6eK1YxsR59ptOhXJNl9kWWRiM99NTaFgD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "7gj8"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "e0T6yw5hAC6oG2uwyL7V4aFJ0VZJ6J38ikf9rVzH3Ymwb3UqU870GIMhEcs4bbe9EyFn0hDRUv1CQUdnzvG95eLaTJnfjs5VwJYJWPCrjMK9EHevCjXZ3E7tG2p5Y2c9hAKLZ9dLchxdPYuLVLqud1n8OeVOit8RouDz3YjkH9OuHhsQPRkeBRffZNNMVGqYBZQHGA5HiThSlt565lZu8q2N1w7CsnmLdkvc6dY7jS6mJ8t62ra2qkH3plO4hfwAz"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "nCTKDvCcvevDnCpCriTjdzzGfk06ur9HXPYCsAUH6zxSlGT1I38GOxgjG3x2ZRFk04pLQkG8L9Iom6wphxRBPOIdBJWxOfl1dH7tRatLlihPrCZZtNWMJ8VCqcNVnipxnEZ23rrmYiOdVtnLb73BD25tsoGdwBMofalVmaygS9lZ0myfshhSl0eyaBMX3aUpOvbc296dAw9buycOgJhogeUWRikzAoETNtlfXJjFalFfBOATilFc0WNY6psozx30D"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
