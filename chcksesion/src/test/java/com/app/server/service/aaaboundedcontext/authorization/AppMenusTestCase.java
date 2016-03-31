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
        appmenus.setMenuAccessRights(2);
        appmenus.setMenuIcon("3h5OJFAEpJrQJ8SJKUcD82ld8VFJxvPCrMdBXLTnnG5hKKfF9g");
        appmenus.setAppType(2);
        appmenus.setMenuAction("ONPqkHObtwLuDgCWYKeBPgBB1QzVVMWf3bE7IYtGT10BT96sc5");
        appmenus.setRefObjectId("SxUtUiMxEWluSxal82hQ9Qhr8zSZrCU8qw6x9N3UKfNfCUPJVB");
        appmenus.setMenuHead(true);
        appmenus.setUiType("9SF");
        appmenus.setAppId("mNOo9f9Ye9Picuct6g7C3CWhyeUk41RkZCyCLSAza3DIjCTQZB");
        appmenus.setMenuCommands("aOtU68PqazFGyPzsWYkxuXVcCbabZBjmoJPAmEb0tLjiXLVlEO");
        appmenus.setMenuTreeId("9bCOhgwTRk4kyKEmszJaxukgnGIbXvp51x51pC8JHNbPiUlBzJ");
        appmenus.setAutoSave(true);
        appmenus.setMenuLabel("37JsHnLpoaXoLKdixcVpQkQFxtcUjojnm4jpEMfR7ou6Ub7Gpo");
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
            appmenus.setMenuAccessRights(7);
            appmenus.setMenuIcon("NtuqqaHg3qaX3pzLhhUtL8zOkYI8itEqQ2LE0DlaDew6Qn0VH7");
            appmenus.setAppType(2);
            appmenus.setMenuAction("hkElG04UZk3UBR0Xl1SUeKnX4XE0PuChZFxbaP1oguVaaQj387");
            appmenus.setRefObjectId("7mv1xWjCwZCdYJSYo8DduXxmLJ0u5CBwDQCKmViu0qUSxy9rHV");
            appmenus.setUiType("5VW");
            appmenus.setAppId("RVgNXiIIOK7zmIQeHRiSyogV0MCN367fiiOIm24alxXmZ83IqA");
            appmenus.setMenuCommands("wks1y9UTjWSYTAW8jDS9sf2LwK30sHYvVvGh9rDbWPKtylluD5");
            appmenus.setMenuTreeId("x9rumUG6ghD9yLrkLDnKjGlh4PEYJepdkL7NTEfpnWHccA5gLM");
            appmenus.setVersionId(1);
            appmenus.setMenuLabel("2Dy4iyFelVoA9bh2KkjHUMRDFzxYTgiUvD8MsDJQwB1C6sJdlJ");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "nseST347zAUjKOBRuenNnRimH9OttvAG3nP5XhYuKy26DbRf5yO1p5lY5rlhxw4cRU4Wh9U9HsDZLLs6V7rcD7F5GaNfcoKLAM5veOR8fEJTp5OmGrntn6L9bdSWnKXlZ9ekbVYM2hQDUcrTOwAH1Svd4E28qW1UyYzxt5wB0U48PqaRm2WubE9w8afstuscRlaYAB8S4mXTAsGVfettjga27RTBJYvO9c54Op76CTVu15A35c5JLJegTOGAJBV8L"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "DqfCpQz35uIdOAFz8aAP2wqxSgSTodQZOPsF4a7N4KSmOnNjpgPyUmJzEdZJQ62DkW23NIfEHoliv8JVXZiCkthgkg80ZGmiDLOYj9D1pkUXDgsgNV7GupT6WhCvMHvMcetBuQfL5ftuj9n45oy9EnSNZfcPwSBhHhbtjmR61pPDQN6c50FRHQMnNQZQ9oUS221QdHR2tf3ejjKoNuJ6QRl00lkaSgqH6hapmu7IrDK788KiflIhEr0t3WHaWszkH"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "dVpRLVMVKJp8HU7qJXHWXldqivLjVbHHKdsFrGuor3d2TjQt1jMGaOrXG1dMb3W4pWfNwgPFcLUAoCPOzRdrF3QAysKkQDDdqjaZfdQJHX8dqLosJ0lY7IapmfyF5ptMIJbSzaVC8G5yimgQ1oo9KvdryE10e92NpLyTrayqpV5udhrhKC2gtz21UohW51o5viNy19Ktg2U7ysu9iX2m4y5ZesDAXIQi0G20rOVoLGUFVODA8uPZiQ0heLgQlaAKy"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "gIZgjXytyorVposy2dZtdRbT6LyoLwZl3nEPxSM3zaXqD22U2dwGbXtWVicxRRuZ8"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "W8K6SKHOr3rM0mewSirLTe77l7SyqegIGfJPrmcsgZWACEXLchjDHzF34l5TGjQ33Pb59OVcR30AMxNsfrija7A2GmPakjOOuhNKAVW0Ohu4pVjjOoBPEwXh8bMscypmSJ00clqLYDZKJbfu0az1rAOo714Gu2ZeBFcqpQn4wfAAkLvMJRTzepGiT3sZs4nnP8qpPpz3vz4KpM4Zo5OuoedawmSmWMQIbtsRr6iXvpiBbnmITz5kHWJ1wmJ5NAYIs"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "EzBL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "5rse9lpWBqsqzXV3kyKBn83FfC9cyLZpc279TyQuAV3Tvk3pkuIBikQ8pIYEkpmSC8OVVLUkGZ0wgpSXKpYh0xpDiyAA6giwWJBkTXLaMd5BNYpfMtOPEjWrn23sz7KRlS70A8uIEGcCecag4gNY9Rc0OqcIwHpNpZwpC5BVoEV9GCXflY6N5YcCJ0JuUb7u2JrzHWB8Zf462ZcIIrx6V7c6b84qAWk0k4GigGrVWJGqZbZbhT5S8vA6OsT7oPRQq"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 16));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "6VVaXGUQgLJkT3veR1T8GMW88Asen2GzXHHrEPWUQCSvauUFhyHsaejZgaIJ4vMGG6iSjwBVHgKc3bSSmXyvkHWCqxp0G2H7V1oMlA0GempIzzI0AxMNj3LieybIUFBihw9EJrzMQvbZ5Ntly11RQUsg5G7EAEGLq0dNOfghdpb9wjthUL7YtIUGXcbGIz1CnIQhftfnKrqcv0aPTaMcP878jfGtKdBKkmTl5TKA5aihT2Hvkb2gv0eapJxjfuO47"));
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
