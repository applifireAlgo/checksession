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
import com.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import com.app.shared.aaaboundedcontext.authorization.Roles;
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
import com.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;
import com.app.shared.aaaboundedcontext.authorization.AppMenus;
import com.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase extends EntityTestCriteria {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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

    private Roles createRoles(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Roles roles = new Roles();
        roles.setRoleDescription("un06ZONV8FYWAYDGgmH0gqSSQabP5yLvsJdka9ktneNcmTBXhQ");
        roles.setRoleName("LFZoQaTO7uxU8NfBZjfrneucxsiPCEiZxAoDIXQkd3DsrjcLpZ");
        roles.setRoleIcon("6w3U6cWS2njFySE40DX9wDGMH92ey2H9FscdlRGLyZlKum8d8C");
        roles.setRoleHelp("WmqRCTsbCGhk7uHpEYiOxAx603JcJpowl41JJ2MvF3Z01u2tKE");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsRead(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuDisplay(true);
        appmenus.setMenuAccessRights(11);
        appmenus.setMenuIcon("Wq5TzYTAt1G20px8xPDjfJdgsBUncSVL9YUIRxdZo1byKZAa2i");
        appmenus.setAppType(2);
        appmenus.setMenuAction("e8u3IAPiA2i071a0mAJbrScJcRlWuh1J1FXNB64WxLSPWqaVML");
        appmenus.setRefObjectId("xxWvOdHZnaTSsbkUIJP8t4TViT6sQXqVkA3G0Q2EYvDn1JTJa1");
        appmenus.setMenuHead(true);
        appmenus.setUiType("7UR");
        appmenus.setAppId("B6AGwMRylMfq05CQCHKp8rxg00QtPCphsL6WsFgQDIgjLIplao");
        appmenus.setMenuCommands("L23zQphLc9jHuWozSTGzoW0ogZ2P2sleFdJKYMaTFjpr0NiGNm");
        appmenus.setMenuTreeId("ICPhjjPacv4iW39qQPjVy09zDkhkT7xHhx5FpHHJvrjQrhBAZ1");
        appmenus.setAutoSave(true);
        appmenus.setMenuLabel("dlbULRmTlh5L0oliSctGNfyUr8OC3LqlurqDGoQxFFboVzT4Ir");
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsRead(true);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setRoles(roles);
        listOfRoleMenuBridge.add(rolemenubridge);
        roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
        roles.setEntityValidator(entityValidator);
        return roles;
    }

    @Test
    public void test1Save() {
        try {
            Roles roles = createRoles(true);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleDescription("42QsYoHOmsqfOrHcNvQKGXTrZT6c96753tAc7CEPOcb1ygLInQ");
            roles.setRoleName("37qomggfdGUkwxREFbMhwxxE2LEfjAk3vphyd5iCDszvNOd9CN");
            roles.setRoleIcon("1ayyIivccvtnn41G9CceuQL0YIzM6u2vkOnq140QiEbs0dkDV7");
            roles.setRoleHelp("6cdPD4r4vM7l11ePXUS78tmvUPECob8iLyA1P2aUxmqcnpFakz");
            roles.setVersionId(1);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoles(EntityTestCriteria contraints, Roles roles) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            roles.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roles.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            roles.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            rolesRepository.save(roles);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "RoleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "clEN2ooEu3POC4egEvcIj0UL600y2ktCzDMQS70hzRU8VdddGpgdNXNgD3tmVclhooSPaiT3yw55VMlubNzvpDKzikrOcZ2j3kblI5Je66iBaAzbOJmaLCNU5yogldHpbJeI1R702t5JmgXxSOujg3zjFC44WDRtc4Jlg6hgFdWaZty7ogrAl7lsMZcNSkmQhZkDJf63ATpvv74HBCn94cPA6nqHhPwtN6jL7BKwt73ieNRC0Bxx0XvUAfA44bsSX"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "r77KlSlfeYd7RkLmyIuvB8xk3kwZRjiu2t5dnJzEJoMrRMKh6EuK1RhqfoLO7Tsfcd9GYj9R3l24dCuO3jklYuZLAkGZQju5vbigZVbynq6b5YSRUc2bneyaMQCvh9xBmwXrFLOSvU5isEgdxvUmqQw9SuGeF5Ieiq7HV7lfGPf06pDI2kwQuc0HGQANHtmXShQOUsPl6EmZW2Anx8RBYKVY6qup99LJbEF6690xAz28nOVpt9mb79YJwKKi2z0ff"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "W9By1qJGu2xVjjbYPvSmYV9VN5W7FWkJ3mD7M4ZpC2cvR1QCULgVND5nJmH7J1Cdn"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "oE0GCUUzk717wpX2vNhpT9J6SXDHwAz7PoCCixHE7Mv6PbVPiolNbIxHt6ce9vus1CZNOeyzLhAcIhBMPrKRwzHdlqCAFmCE5KCGfhtUGuRTRsbDltXtipcsefyQBlIdlTSlOl4OONEez0coT6cKWAoq3BXbst1gkZ6u4qsMYRw8TadBBz2rZeN1AlRfFiP3stbABkdOO2uzyoT3tOYGAWNKlAVCMxiC5b644eFSKhpYDLFpZqxM8EySdcvDm7xIE"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Roles roles = createRoles(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = roles.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 2:
                        roles.setRoleName(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 4:
                        roles.setRoleDescription(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 5:
                        roles.setRoleIcon(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 6:
                        roles.setRoleHelp(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
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
