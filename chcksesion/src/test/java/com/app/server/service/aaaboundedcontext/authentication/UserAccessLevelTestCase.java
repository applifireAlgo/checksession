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
        useraccesslevel.setLevelDescription("LM8pedz2UcLzVknWo2AFgNdJGJBbvwFIQraLLefc5hlCldxijP");
        useraccesslevel.setLevelIcon("gMMc3Tvd6kiJO4WK1MuUGS5xhrO6ICzKtbJhmtq7g5U5Imqv1B");
        useraccesslevel.setLevelHelp("ZSci6Y3QIFODTEBoDjBQBhATXzAbrtKxOyacrWbJRjxoTAO6Y6");
        useraccesslevel.setLevelName("nVZR2HFRC8ab9OTmDV7bmeS3PSEebp4pyp0Hs3JWeSkOKUM6do");
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
            useraccesslevel.setLevelDescription("2dbQ5iD5MadlTwQh1tqlHO39CT7Vj0cAoH2Rb1GpGHGY3iY5pm");
            useraccesslevel.setLevelIcon("RZAPCskSLtElhKkXRJyfkBObIj0rvDLoEzAtTIq0Pldv5yIP5t");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelHelp("8Mx0VGp4UdPCddLiU43HlBhxKnCi0FNhmtvryAqNmrI7Bh5yUv");
            useraccesslevel.setLevelName("HMhdpjzqflDXfxIJY0mx8TEzTtGMWDXOhkIm2ONhRuJCncao86");
            useraccesslevel.setUserAccessLevel(87103);
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 137983));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "gbfqZrLnP1uagMiLFju2cjy4LOdqiIsEF27crWery2MbRmkO2EkUfWc4thsXFwtok3zln7RgZ9AmzplI2EYOthMKFpzcqMPpFOsqVOVJ3sHEFEbxeSgS2t9Ju4alLjSq8VCCBNGStarJzPewfxrqRnHKMjpM8eTQIvBGds4lC7SRXv8quMAabSzpLc6nrnTJVbLmuwoTOWVZulq0srDPWo0z8Rs1iRZyJ77m88B6Q2b9tsdOwZKI8IYDQK4JscL1b"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "I2Ou0rUMSwhWR3C9ykh3hHLQF4CIG7p9s013AprpTOc5k2Cs4LSP2cBBEd6O3yF2ALeDTMRxPuyEMYBCko5MwmgP6RcD7NFHwasj9woTFkJ2ANrcMVC4kdIOdKZuTsp1PH1vlJqApYQLlr05vww2G66TxJ1pJRvzCSv90Ad5FdHGEbzyUqjPJC6cwIyd4TLap9u7sutxR8kf7WbP9r8vgjGPecaAFpvOWeKr8D7fK1bn1OHpseXh5ndVYzXMBVdxD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "6FXzAPbqIWoQ3rofLV3kpXS4qOmUmsybdpCds9UwNYiBmwTEJ3E5MooUDzogg5Q8Rg4ueeCTX51Sp0zI2rYruBolX2ZmOufGKmthmlXvhxhWk6I9eQMe4dwLi6uNSUvB4soQp6cpD69a2asyZmBRruSqMZmfioCEEhYFUVKsNMjvYr6mcMmVCD1nkw6r2aoWiZKVmx96OH6RBUQB729XbnDIm1CjJLc5imzbK8I5oDhy3adfWGlfOBuwQ19qkNsyk"));
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
