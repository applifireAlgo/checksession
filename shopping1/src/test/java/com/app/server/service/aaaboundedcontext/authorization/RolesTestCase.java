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
        roles.setRoleName("Lv0mmCEbioKWLQnfit2IOtMAUayClhirgICfaIuHQdgDZCHGjc");
        roles.setRoleDescription("CQhH2KFH7vZmiAaEn1ruoEb0Hg98k7tP4ciKnWcMOA9jdlxDmC");
        roles.setRoleHelp("alk7abFpOROfcIZSf6STzcccofZsITm0jrGkyjGO8PfuVFT0Tc");
        roles.setRoleIcon("0HWUXUBhkUF0sMHwbu11sEIrvMQi5wumtoWIka9IsggyHP5XpB");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsWrite(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setMenuDisplay(true);
        appmenus.setAutoSave(true);
        appmenus.setMenuAccessRights(5);
        appmenus.setMenuAction("Mxx41te8zh8jkyg8wV9raX8aODJXxyd7wCgIF8CqVIBfFDjhd2");
        appmenus.setAppId("HawhA6XGfjEtYdT9XKHVO6AbNdbnSl95V1WtzrjAVxp9pdfmnt");
        appmenus.setAppType(2);
        appmenus.setMenuCommands("KNYLmRiA5aPZsVdWpBSGgBDpngVkM0N8C340wIf4rrzfgsCYYO");
        appmenus.setMenuTreeId("8dX4vLG9EWMPkPAopnGvM6Lh83UC3eTiPMqHRqoeNTyBLlnR3s");
        appmenus.setMenuLabel("YInZYuLRlD1MB2yKHd8zRiuhJoIZp5rcjIEj3evI2PFhfilDhG");
        appmenus.setMenuIcon("ODrfJcba8RLbKgnh1KQSV7bQBrbJD5IdkvDOVrx3OSkPJIcirn");
        appmenus.setUiType("kum");
        appmenus.setRefObjectId("UuY2kgut1z0bHYIsN6Vpc0YpweCcNcoQ4PHksZ2Pog1paCgvvl");
        appmenus.setMenuHead(true);
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setRoles(roles);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setIsRead(true);
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
            roles.setVersionId(1);
            roles.setRoleName("yUlwWqdS1JWpBIn4tbtnWqiDWreILPTsSnRdMA7AHnYvLyl4WJ");
            roles.setRoleDescription("ZalJPYvZM6U6Kft3OhCIq4qd0D7GLQ0kOBsG2LKbFJ8euKxzGz");
            roles.setRoleHelp("5bnXSa5u3L5m11cRQhFJNwfOaM5WmAG6jOLTJQjKmjc0FQxuu4");
            roles.setRoleIcon("Mu2FPkLImfd3f77HiJ7C9WOlj4neitvNsLpyJ4UmU5Im7HzZKp");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "lrQ5kC1efcTL8pUAA0BIwQTjY8YyUgDBIVwxDAx5Q3LWZW2v72nudobnMm6WTyyVin0Z2BcxrIjb1qilJl3pQQ3BylbIzHshqzoSAYW4uxdzy3zQuSHbjGfSxU5nbtXmCE2WitNDctXYBEDILUkOFluy4qtmgUbRpYgy56r4MrgbwblbmJNgERuL1bbYXFFKDrEHUFKx0j7lGGjg8SOUfmf48EoNh0YEDsiM00axOAymELBPFaVzJhYVlyjmvXeKh"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "3Jzb5JXiwctnAG4LAuUXdBEu9G7H3nvj7ML296gOi4DUNZkcZV7wu5LBzS94k9fD2v13gfsaU48SoOdPFYVnj7PEJzluNl21QOfbMiqKQgziCFhBH8ZHajPd5EdMyoIbI7cyTMmPRNDTzRC4fw9d9Z2soI8wsMw7GY3DjjHaBmvmXmteRES6rLQ4RfBnaNADDrqK5LFxdhRGnERoFytVYokibtNM22GxRx8y9pCF97YCHuCzf0Kt6Ed61fs0Xbvnz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "milT6zNO7tVKrujKQetBZHzDAhfKIJNmHysLxILBxkInLbHaMEoZXObmexJ1pJXkP"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "boZTNgeF6HMqjcoRGg7Mk4XSAJwA9EssAwpCQmO08XXFNsbr928srJI4b26faM7D1NsiaZKjuSnRRQLRgWy80Cslt2gQPmC9JmKtD3FgVuYVR4hcXQgqI2NEUJ8DFIeQNETzxOm8QUoKqbkCBhYELfXjRi9UuPGEFNRD7YjYR0pR6XZWHHVByh5Kvqh9wRxiGAOfdfbuTGfSN9pKguvOQCKeNQL2ySD97BLoZxk0JvO5qbtheft3Es6g34ZUmwjJp"));
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
