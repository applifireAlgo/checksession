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
        country.setCountryCode1("vj5");
        country.setCountryName("f1fp5sCH0E7Svoiv0fR9s0coqc5Sd49XZbrS5DuOwXPedz9UJf");
        country.setCurrencySymbol("8y07YupYQCo1UXDIoYz9cEm7OiRjZqpy");
        country.setCapitalLongitude(10);
        country.setCountryCode2("7Pn");
        country.setCountryFlag("ETqNyd8tiIM7ZQk1FzgAu0OYuvZq5USwM2fI1y3WpOdI45xySA");
        country.setCapital("VC7nHsZEUUzfdzXYbi1DQJT3JcZ5LQXR");
        country.setIsoNumeric(989);
        country.setCapitalLatitude(2);
        country.setCurrencyName("6QICUZ4aFVC3ccMkptmn7nbQvpW1uDe3qMnJzC02fdgdlOKQZQ");
        country.setCurrencyCode("hwD");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateName("cI14NAimcoXJAUT2EYBnL86gXPqSr8CvkPITePmKBcAVgKHpyu");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateFlag("SdYzXPIts5vdbVw1qgv7YcUa3NNHRqwDd6dXB08fL87sHjl3zk");
        state.setStateCodeChar3("teV0EI7tmOGwA9b7R2XFHsxzed2Fq76E");
        state.setStateCapital("NIW29NuHH0DjSsjEJEVj1fUGrHalWS4hkD7Od6xarnaXCSX7KJ");
        state.setStateCode(2);
        state.setStateDescription("LbeRNw09dNEaUswcuYy72sRU5dmr69vWBKSg7Dk3OW7jhSu0PY");
        state.setStateCapitalLongitude(6);
        state.setStateCapitalLatitude(8);
        state.setStateCodeChar2("VuQv4CB4bV1PlNwjQzy2YOXjSfcBH010");
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
            state.setStateName("NUgEw10YbB5Hubc3lUju0GcCWuRFzHycRjjSzJCTQ1JYM3x8jW");
            state.setVersionId(1);
            state.setStateFlag("Y1HPvvoG317PSqnEdQLdPgpQb24qLhUP7GIkAbJnDskerGNcVG");
            state.setStateCodeChar3("N5RRwO0evaIcCg6g482THDoeujDiFFxO");
            state.setStateCapital("bBFAltQJc36XGNVjtKtNEUTvWOcRHj1FrkjGRA1xCg3FaiHHQZ");
            state.setStateCode(2);
            state.setStateDescription("QDv0OBf6j1zYYGyY30gVyYViaY61I106GT63kUYZg41afMJQr4");
            state.setStateCapitalLongitude(2);
            state.setStateCapitalLatitude(2);
            state.setStateCodeChar2("Ip2BY0blPoHhVGa02bsE5KbvqlGhVADO");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "WeL3eZ4sZHx4Wyj1jcPgwxs3ybO7sdKrWw0iHr4B4mVLH7lS5WAt5lrURmKZNtmzuLGFqWQZizwOdk3JQSdxRmLksqxUHLoQCOyKaB0b6o6cyCtJSIjgIGW7lggym27lRnpabZRhjyCR6x1zKfhC2maGC7kz1xUvZz8qUf7TgX9YzA4ZrwYBwP9A2hrM3VBs8pvOIFPKD4gYeLIdNlVH5inTT9QqDrv2rD3OVIbmTTmfkXyNSz5d62t1rx2vlaouA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 4));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "4LDm4kGZnHhOWnaIpCvK3Pz78UiR7tOuJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "YmetNkXWc3odeftXliv3l4RmFUUZJLt2t"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "8vU6eftmyshsqyXPjsZzMNcBTqIgxff6ruFthknWqfPlbtbdsSKtFKozBRnRA4UudcubyhQPw3p4OxpGINpIrSMi7jYh169GfhEs5BobnAfZckh6gP8Sh323qW0MzSFtQ60PKNtFRk3CiEf0ydMbw5idO0L4GNBiEm9cy2hS6ddpQYsBMFRTeTGMKno64N1Pn8ETrNkBb78KXRnqRDKGhF4RxNjfw4cz9IfAaWqXZ8hIZuawspnAgrkWDkdBusdR4"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "1mWVp1y4gRDsyKixiRdk2kbaEYJfx2I60UE8Jlz3tHzpwJu0fLE2i46rLVTruQdAFZK4QTbVL0AMjwnSj415vvbxDXM6lXUc3luxrAXy24OSUtAkA3gIQLdOsZCBnz6nz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "VMKQauIguiVilp8bb8jHvS2waQ4O9QIdPqsJEnIYa0vOkL1VBnSSVXMRXT641NXICHZ98Nlhn4qPK0K5CZs2oJpodBsFGa39pbtaGgZbvCcKh6VBBIuf6OEESmONacJuh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 12));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 13));
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
