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
import com.app.server.repository.organizationboundedcontext.location.RegionRepository;
import com.app.shared.organizationboundedcontext.location.Region;
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
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RegionTestCase extends EntityTestCriteria {

    @Autowired
    private RegionRepository<Region> regionRepository;

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

    private Region createRegion(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCountryCode1("WUm");
        country.setCountryName("zWSp7UWHSU7DbF1N06JVVSvCeoFn0IAKD0654EChunujhSuAZG");
        country.setCurrencySymbol("abmh4IPxDY0T3mlvVG0TtrCnC0fr2ESJ");
        country.setCapitalLongitude(2);
        country.setCountryCode2("ZCx");
        country.setCountryFlag("aVfT3KIGT5lUnoLuvBCcrNcowV01sPlwxpjUtETsuLyLLBY1Be");
        country.setCapital("bRJuqesZx3u4Eq4mbIp1FUn59cwli7yr");
        country.setIsoNumeric(90);
        country.setCapitalLatitude(6);
        country.setCurrencyName("3u8rAL9Zq3LicvFLDuJOI6UwlEsUW9p1XK1lsJHtGXYhEWo8Wr");
        country.setCurrencyCode("4sk");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateName("5TaRI8nQb2yQfN06SZ8vOwXvG42wXTLucpRSAjMun2qSbj3lyb");
        state.setStateName("AQKxDABX93cp4HvdPfYealiSAq19zJLFjS6FMpzAyItVl9AoHS");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateFlag("7OMTIsP3a7ju8HgsFPF3avhz13HjII7WAxTieu5sKKko18nvCp");
        state.setStateCodeChar3("5wTM0MWTRYJCUGdj00MpTtz0VxMmLQGD");
        state.setStateCapital("ZsMIr4542iTdcJjXuP8CShMDCmEVDzjlR3rpqOlheG6RMICc4Z");
        state.setStateCode(2);
        state.setStateDescription("vTWySNPR6ebRjfQYEFOCUb4DGL44d1rKMOUQh1qwgdSBmoNhNO");
        state.setStateCapitalLongitude(7);
        state.setStateCapitalLatitude(11);
        state.setStateCodeChar2("bZkRm9taQIFdABFDO7ysHtQlRYVyHdgp");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        Region region = new Region();
        region.setRegionDescription("OgN2MlZ7r06GRvD4LTnBPEteSrMKV8vTV6zYq5tevWOU3BnCrg");
        region.setRegionLongitude(11);
        region.setRegionCodeChar2("iFx3Qt96a28obibDgpLgqpPH76ba4B48");
        region.setRegionFlag("mt5wNNufUQWVdXFxBmP6bhuma1bdXU5mPWovtecfYgggqvApG9");
        region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        region.setRegionCode1(2);
        region.setStateId((java.lang.String) StateTest._getPrimarykey());
        region.setRegionName("8yQ748zJywogeI66S6U5RAU0aNCF2RCKQMhi7KAoic14mj45pJ");
        region.setRegionLatitude(1);
        region.setEntityValidator(entityValidator);
        return region;
    }

    @Test
    public void test1Save() {
        try {
            Region region = createRegion(true);
            region.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            region.isValid();
            regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            Region region = regionRepository.findById((java.lang.String) map.get("RegionPrimaryKey"));
            region.setRegionDescription("lOt5B6fOiimcnd1UBDjfQZUmswt1F8hRJyAQqLo08kurP5VdJQ");
            region.setVersionId(1);
            region.setRegionLongitude(1);
            region.setRegionCodeChar2("0i1tENrCClG4pSL8qK9bTecJu6NY68gQ");
            region.setRegionFlag("rJVWAzdKjxNHlTOMoj0D7p8ksE7WINecB8Rumvtu7AcYX1oWGV");
            region.setRegionCode1(2);
            region.setRegionName("sAJSXsWlNMttJ2zbhFnqefR0iRji8JLdWo5xGb2H8Q1V4FMJPR");
            region.setRegionLatitude(4);
            region.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            regionRepository.update(region);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            regionRepository.findById((java.lang.String) map.get("RegionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Region> listofcountryId = regionRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBystateId() {
        try {
            java.util.List<Region> listofstateId = regionRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            regionRepository.delete((java.lang.String) map.get("RegionPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRegion(EntityTestCriteria contraints, Region region) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            region.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            region.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            region.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            regionRepository.save(region);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "regionName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "regionName", "ofcE2Ts09ZRxFnE8urNOpsHqstAa4uySJdBK8oKvwLZwnqcnLtbcRBavC1Tx8RTsnx6bOty0MpO7s6oySi8qeqL3T2M3GL04WNK0iKV8mqb1911ji5xj5trYtAq5xjTtdUAuVFlUYcxIRLquPijzOAHo5ydrWGXeSpUVISWI0cuHjzlR3awuKVzOdLtGiUkGSmq80TZ0Aag6gVIJ3m73VdvYKNHbjcwlHOwwUyJczEeUhsSrB10PUE2U4fCk84w3Z"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "regionCode1", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "regionCode1", 5));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "regionCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "regionCodeChar2", "pN9aySgzS9MdG3siWhnFYmHmQCScwDiYg"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "regionDescription", "p2Of4ZPaw4t3pwyg1eZHpPeDPUea9gk98WddK54NZHQQgQx4n2hdkuiROdhF6LNyEwRzCbGPosqlCzt646M8uFWNk3cN7jf8o2ergPlhuwWWGbEFatlaNgEwP4SOSNCLgwhgLln8cHyJj2ai9PpCvfmKeEY0ihmS54UvGywhLq1GE2glAyjYB9WsSKtjrhbXfbOe966u9SJROjqdozYQxSw5zMsQhu4mLLtR8xVyctVkvq3ru61LJyayK8EhXHPQk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "regionFlag", "KdFSfftbu7sZFnCAbhKG6cN5NYPrxTzkzfOzIGZ1cnb97E70y35BMydkQn1Yk6oUpVliLHiKD6HfYNzxJ1RQcWERsRC9HT7SlTzl3pzGU9XxmaTQSSExVqoKOT3AzO123"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "regionLatitude", 17));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "regionLongitude", 19));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Region region = createRegion(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = region.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(region, null);
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 2:
                        region.setRegionName(contraints.getNegativeValue().toString());
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(region, null);
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 4:
                        region.setRegionCode1(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(region, null);
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 6:
                        region.setRegionCodeChar2(contraints.getNegativeValue().toString());
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 7:
                        region.setRegionDescription(contraints.getNegativeValue().toString());
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 8:
                        region.setRegionFlag(contraints.getNegativeValue().toString());
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 9:
                        region.setRegionLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateRegion(contraints, region);
                        failureCount++;
                        break;
                    case 10:
                        region.setRegionLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateRegion(contraints, region);
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
