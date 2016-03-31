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
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.State;
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
public class StateTestCase extends EntityTestCriteria {

    @Autowired
    private StateRepository<State> stateRepository;

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

    private State createState(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCapitalLatitude(6);
        country.setCurrencySymbol("JbkJn8jq5zvoF8NUxxNzBRqP9PRSDa0j");
        country.setCapitalLongitude(3);
        country.setCapital("hwebrSBL8oW0Wu4VGIKs6PbuKkYJq9Q6");
        country.setCountryFlag("rzFRLd6nT7YjPI6FkLpzYTs2q0xEVkOkjx1T1IX9fvAQ2HhppW");
        country.setCurrencyCode("jBn");
        country.setCountryCode2("TqQ");
        country.setCountryCode1("0vx");
        country.setCountryName("F5DEa1LKL8KuWfRGl5vNJwMNWs4ByTqFeunYronxJizW3NkPqp");
        country.setCurrencyName("kFQdiKYLIuVjm0h01s7QOLjbR7TlUHPfioXGqKeh5b0xNHQZ7P");
        country.setIsoNumeric(419);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCode(1);
        state.setStateFlag("2i3ejyrPqAdh70ksfDNSOMWGH4aGHoexN511TAn0bL2dnBpkIX");
        state.setStateName("QbWy0wiTFUeESTsS9joXTrVqga7UBttHnBIHYQCQkWti2cGd2M");
        state.setStateCapital("QVCvljTXRWI6Gf2maZP60qocwp8pIhNAbdwnKAHXTVZuGGbkID");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCodeChar3("tr997okW8SB7Yb82bNbcUVOp0d8zPw7V");
        state.setStateCodeChar2("QZWeCEpZnlcNarmMRjKWCRDAI2e9Aenb");
        state.setStateCapitalLatitude(10);
        state.setStateDescription("JnIVS3RvZcqcnQ6Q570RqfIewbvim9Ve5ogDTdrAwa8Yp6hhWe");
        state.setStateCapitalLongitude(6);
        state.setEntityValidator(entityValidator);
        return state;
    }

    @Test
    public void test1Save() {
        try {
            State state = createState(true);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateCode(1);
            state.setVersionId(1);
            state.setStateFlag("B3aPf9fqmljb42ZPR56T38solP8DhZBpnv6mttQNIEj8M4UoXi");
            state.setStateName("MJXze0b88giP9AAIqm9SMLVteTypY5c8r1X1KiPIRyLH3gnRBd");
            state.setStateCapital("yy0vq7lxSjynyWMSlwjHNghZQbSj63v70BqV6Woi4QP9eKdVgk");
            state.setStateCodeChar3("kwobVttHGsH9IQ5z7i4iNJVAHkgDSsHY");
            state.setStateCodeChar2("ZFTk52JjS4r8Owfay7Y3OuZzdCYHtxUW");
            state.setStateCapitalLatitude(5);
            state.setStateDescription("F20spt6fljXNBXTfsmFsZPotF33Dxaz1isfJi54ljIcxyeMCId");
            state.setStateCapitalLongitude(1);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateState(EntityTestCriteria contraints, State state) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            state.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            state.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            state.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            stateRepository.save(state);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "stateName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "uP9Bk4HuySCuUpc8mddIFfthjhPMXYwZNohEREWJQfs6hWYYprSNcM3EKcog01pJtupRUZZp239AjzhTcQ8s6YnB7oDvJe2HQCSKIK0RWjPVysRELdTLkgI6VAgoQPkitRl53lYfLQNnWc1bwEy3yozx76I1B1GPraSFbV0mvpbQC68J7yPY0wkP2vXtjlgEv663GkJgPX3HwkrQQrDRGh7RF57GFvlTQ0axad8wKRJIwgD2dzpIPtYzgJOk4b15E"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 3));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "tinqC4TwoP0zuHjk13VutAniMCyCr4DEu"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "uqY1xRKvb5iotB7drR8eOREpEEb9WPhju"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "qw6ukx9ftqakukDQXVSsTkdsNJHzbpHmU3PRnAm4zdwDlJmvbhlalZJSgTjIo0ivQ1vQfVD0UCsftF5C1E78yo8CLuBJfpx9IFC7oFwhclYHECl8Oue9DPHOcZjlpSe2PzGo9Du63DTPSs1CyYcyo9FCvgAZ0jQAah9pIzblIIMkl61UDs9PPbnzRrlEuemgTO47gkMj1MnXdTx5iYWeqvA7VmcsyoPw0Tpne7u8VMNrqy0fqHGchgQ4neyKjun3U"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "DupEWgSmiU7NFUdt45zcvMI3VJS2ROmt7zV78LhycgIFzPitpO0uYQPnRd4JJ7UJSyeJqUyYWuWcr4RljcuLKRwW93q6fdIDHcGwk4DWj6asRlWn9Vx4M9Rnj1pskRuWY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "RSbDMHdrPPVupKZOmMewHOqvgtNn4FYLUv50XAUULhNfpphmvXXvx3BNeomIKXlRCjXmcQpdAkkd2jFnOQ6OUWfMNbYf58OT5fvQQ0MUErXWmCGNu7V26ZVfXjRuSk1Fi"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 16));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 12));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = state.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 2:
                        state.setStateName(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 3:
                        state.setStateCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 5:
                        state.setStateCodeChar2(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 6:
                        state.setStateCodeChar3(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 7:
                        state.setStateDescription(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 8:
                        state.setStateFlag(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 9:
                        state.setStateCapital(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 10:
                        state.setStateCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 11:
                        state.setStateCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
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
