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
import com.app.server.repository.organizationboundedcontext.location.VillageRepository;
import com.app.shared.organizationboundedcontext.location.Village;
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
import com.app.shared.organizationboundedcontext.location.Region;
import com.app.server.repository.organizationboundedcontext.location.RegionRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Taluka;
import com.app.server.repository.organizationboundedcontext.location.TalukaRepository;
import com.app.shared.organizationboundedcontext.location.District;
import com.app.server.repository.organizationboundedcontext.location.DistrictRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class VillageTestCase extends EntityTestCriteria {

    @Autowired
    private VillageRepository<Village> villageRepository;

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

    private Village createVillage(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Region region = new Region();
        region.setRegionDescription("YbpRuVLtdxRIGY2wJQHlLXH7fBoVN3TDGMJ93539kbpfBVBlSG");
        region.setRegionLongitude(1);
        region.setRegionCodeChar2("qgeg3sCjQXClz660F3YgU5RFhSLvcwG3");
        region.setRegionFlag("sDwnL8XP4I0jqda9xwDBZfsozeoBUESE7WJz40p828lAv5bxlh");
        Country country = new Country();
        country.setCountryCode1("qvG");
        country.setCountryName("3zGjkpWxcOHcRNZiz3h6MB6eCoQk1Rn9qz951jWx2VJJMBhgQN");
        country.setCurrencySymbol("p9PQztkcPOXlBrT8jGMqBb3z8Z0j5LpD");
        country.setCapitalLongitude(2);
        country.setCountryCode2("WNo");
        country.setCountryFlag("T6NRKbgiRoz3XJf8hsI6hZvwNjLrRwlOdgWbTmDAWNfGGVE2k0");
        country.setCapital("qvder6qELyd3K29NxyLUiNezUOnPqyf6");
        country.setIsoNumeric(628);
        country.setCapitalLatitude(4);
        country.setCurrencyName("dj5iw9XmjV5FfnvQWjCnf5IVdOPBQi97QGRNzNOA9whY1nvF6h");
        country.setCurrencyCode("djr");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateName("cnGdKsrlDtJcC2N3bIIOPlOmGWhJSob6m9r3SKF2EK0toAI9aJ");
        state.setStateName("FHfblFDJcO83NouhEtp9LwHkHQqpDfg8ggOEy3DlRcizSqqcqA");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateFlag("g4oVVgObN08uiakgnpstqdlkq0KFLA769IkgnxnGK7Q34yStc3");
        state.setStateCodeChar3("baYj9lqoQ9k089s8oSCFXCvqzDM1JfRB");
        state.setStateCapital("ioizkrbg8fd5HB0GQoJpqVGsS11NijNi6yJeJXY5xkiTJ5vbL1");
        state.setStateCode(1);
        state.setStateDescription("lyp2VbDNSWOdzl3ptavHT2mJI3apMuXDHpAenH6YMZggzdA6z1");
        state.setStateCapitalLongitude(10);
        state.setStateCapitalLatitude(10);
        state.setStateCodeChar2("53Oc7BOwLaPv93MiGtr7TYBJxPRHN02F");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        region.setRegionDescription("eqpNy2Tq0ou1CtDfbc5QABAdGUZyItEeRMMIuC60hyJ3fVDno2");
        region.setRegionLongitude(10);
        region.setRegionCodeChar2("FIr9Sw52i0lYUnHzDJc4tEekunEYDRXl");
        region.setRegionFlag("3v7ftyGIfe9axJEfLC7tylmyNGn1rFe87hRQNVyTzp9J5igKwx");
        region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        region.setRegionCode1(1);
        region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        region.setRegionName("iJNawJAuOboOuKQePvfBapHFgwM5wrSjG9HprjDSgDGKWBDqgH");
        region.setRegionLatitude(8);
        Region RegionTest = new Region();
        if (isSave) {
            RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
        }
        Taluka taluka = new Taluka();
        taluka.setTalukaLatitude(4);
        taluka.setTalukaFlag("Y0PGkHdTRNpNXCBRSV2kToIFPBsua84R2KGzj7mk5iPamkeRr2");
        taluka.setTalukaCode("Xt9fGo8ij7oWom7fAlfmXYVoKWGl4mvz");
        taluka.setTalukaLongitude(1);
        taluka.setTalukaName("xcJk7YGPBUzxebRsmPiKGItCBe7bS63bSw7CSMA5ToPQcWtmUD");
        District district = new District();
        district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        district.setDistrictLatitude(11);
        district.setDistrictLongitude(7);
        district.setDistrictFlag("HcZ7Q3k1rOQ2cOiW18e0T9sSK4MnN4s0y1hiJeBq0ehCHnFyDI");
        district.setName("K6YuhU4cRtXbIeoUMMyzgc97j7wpDLztFi67hRBDGCqD3iQ6Cj");
        district.setDistrictDescription("ed1QB9CuTim07z5CdmdwmGlbQgwD5ldcdwRuoHMVyMV1yvumXb");
        district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        district.setCode2("KiBFzjNAo2DQbnyJggmRQvxNkeNXIsgt");
        District DistrictTest = new District();
        if (isSave) {
            DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
        }
        taluka.setTalukaLatitude(8);
        taluka.setTalukaFlag("Zl4sigs5UCWziDudkpBOzlKDKpEfURdgUnZF57IyBV86OiPjkf");
        taluka.setTalukaCode("NTbfKXtikeRhSqBKPxPqOdZ7Tu8v1D7H");
        taluka.setTalukaLongitude(3);
        taluka.setTalukaName("Cp9m7BCefhf5hKM0F7xXU5nqfb8U3vh1GNZUolFfcYk61lvgBH");
        taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        taluka.setTalukaDescription("UiBglgdwOc09Kg5DfpLhC9jdZ0zuA4mU4oF5rQdui4W61B5YVb");
        taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
        taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        Taluka TalukaTest = new Taluka();
        if (isSave) {
            TalukaTest = talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
        }
        Village village = new Village();
        village.setVillageLongtitude(2);
        village.setVillageName("n51kom5OeUt37htD8gNIbr8y3iPbODa20aOjZ83yxMJKySdR9B");
        village.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        village.setVillageLatitude("vtFF0gffefb");
        village.setVillageCode("GTEkgduO44pUBmIo736opaVAUy09bIEI");
        village.setTalukaaId((java.lang.String) TalukaTest._getPrimarykey()); /* ******Adding refrenced table data */
        village.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        village.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        village.setDistrictId((java.lang.String) DistrictTest._getPrimarykey());
        village.setVillageDescription("eRtUQjCnxljAkORDJntEui0jKo7J3kNig9zkrjPjD6wS9YEGbu");
        village.setVillageFlag("oJU4oAwUckw4BDyJykfKiiuPs2wScEdUHqmAyG6UprLwMGAQFQ");
        village.setEntityValidator(entityValidator);
        return village;
    }

    @Test
    public void test1Save() {
        try {
            Village village = createVillage(true);
            village.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            village.isValid();
            villageRepository.save(village);
            map.put("VillagePrimaryKey", village._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

    @Autowired
    private DistrictRepository<District> districtRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            Village village = villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
            village.setVillageLongtitude(2);
            village.setVillageName("zb5sjjM5BcPJA1UsYO5jZwrGWEoTfSg2apRu7fjymkPzQva57T");
            village.setVillageLatitude("f2TrYf69fFO");
            village.setVersionId(1);
            village.setVillageCode("r11Au8okIoMTdeJwTaH7i8veuUZ8lrAt");
            village.setVillageDescription("MRmOoUjeOqj3lmoBgH383e935O82atld6xEuHeRAvlTenwqD0Q");
            village.setVillageFlag("k6GVQDRu2hJVKBpi1ObWzc59Ju0xQD3D1TznJcpW6xjr50ULuh");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            villageRepository.update(village);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<Village> listofregionId = villageRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
            if (listofregionId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytalukaaId() {
        try {
            java.util.List<Village> listoftalukaaId = villageRepository.findByTalukaaId((java.lang.String) map.get("TalukaPrimaryKey"));
            if (listoftalukaaId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Village> listofcountryId = villageRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            java.util.List<Village> listofstateId = villageRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3findBydistrictId() {
        try {
            java.util.List<Village> listofdistrictId = villageRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
            if (listofdistrictId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.delete((java.lang.String) map.get("VillagePrimaryKey")); /* Deleting refrenced data */
            talukaRepository.delete((java.lang.String) map.get("TalukaPrimaryKey")); /* Deleting refrenced data */
            districtRepository.delete((java.lang.String) map.get("DistrictPrimaryKey")); /* Deleting refrenced data */
            regionRepository.delete((java.lang.String) map.get("RegionPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateVillage(EntityTestCriteria contraints, Village village) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            village.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            village.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            village.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            villageRepository.save(village);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "villageName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "villageName", "zQt90n9pT1Xt0nxuniQHf2CTiak1aIXlbLaeYeT1xe9wICr48bcJ26N12C2d5uVfWFTPcf1h7GPGlDShWuUZ6THwlHdiDrke6wkdT19LwpdREtp1HXcIVDPBGSS3h219TjhZbqOhXEVcMcdAjnepzU5eic4XeuGjGuyocmapVmEl37LzueaSUPAlPKF1MLf4d3fljwLNCCkXL1aEby4C8f9dPO7wSpJtRwcq5QEcxAYWN9Ia2U6cM2PKxJAQvKHyX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "villageDescription", "QrSzgxCyxCmCbQJtMWxtPppRNwKfImzdjodl2LFBgEqcQE134vmtF8v1JTcqSnev9hhN9gRzvQMe3wZM1OPAA3vfhRmll2FNpFf6uPKfaohRUHIMRrdQzBO7nGgTExzkjtOfyMYvS2fJ4FY56t9F9BMzSkEyVbWYCTOMnGNplJtc4sIjDLUfLJ0y0VRFpB2GQowlEyKGXjCf4z8G6RTBUwWEdJhjXS1pXQFZuvnWwLCDf5LELkHM8ISdVz9Wm2DQf"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "villageFlag", "vEr16sBUPGKQNT8MM1uBiORL76M6GHAMDIJeKKo8Pxg2otHUHrRiQwl0guCvOtYPp"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "villageCode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "villageCode", "eIoITGBS0Kb3a8nnjWeJBM76oHBxJUmvq"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "villageLatitude", "R9fZ5KKSdFhY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "villageLongtitude", 22));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Village village = createVillage(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = village.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(village, null);
                        validateVillage(contraints, village);
                        failureCount++;
                        break;
                    case 2:
                        village.setVillageName(contraints.getNegativeValue().toString());
                        validateVillage(contraints, village);
                        failureCount++;
                        break;
                    case 3:
                        village.setVillageDescription(contraints.getNegativeValue().toString());
                        validateVillage(contraints, village);
                        failureCount++;
                        break;
                    case 4:
                        village.setVillageFlag(contraints.getNegativeValue().toString());
                        validateVillage(contraints, village);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(village, null);
                        validateVillage(contraints, village);
                        failureCount++;
                        break;
                    case 6:
                        village.setVillageCode(contraints.getNegativeValue().toString());
                        validateVillage(contraints, village);
                        failureCount++;
                        break;
                    case 7:
                        village.setVillageLatitude(contraints.getNegativeValue().toString());
                        validateVillage(contraints, village);
                        failureCount++;
                        break;
                    case 8:
                        village.setVillageLongtitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateVillage(contraints, village);
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
