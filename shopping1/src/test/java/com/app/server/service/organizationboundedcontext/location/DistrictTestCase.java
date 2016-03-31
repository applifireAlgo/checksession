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
import com.app.server.repository.organizationboundedcontext.location.DistrictRepository;
import com.app.shared.organizationboundedcontext.location.District;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class DistrictTestCase extends EntityTestCriteria {

    @Autowired
    private DistrictRepository<District> districtRepository;

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

    private District createDistrict(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Region region = new Region();
        region.setRegionDescription("dLIjC5I6ORHXv9PlZSg49EyTaaroX00WGq6bMBMrdoeqDnfBSa");
        region.setRegionLongitude(8);
        region.setRegionCodeChar2("ZqtNUCv5iaGqLldDdQZLH4jQ8SRnjpfa");
        region.setRegionFlag("FAgrsV8YmrOubIRD85B5BgG8srkLX5y3BHh6pw7MjlB2N2IAGI");
        Country country = new Country();
        country.setCountryCode1("x4F");
        country.setCountryName("T9I51bP4ANCS6Kfd5IVMa2RejNDRbl9pFm30dMBLzemImTu1gH");
        country.setCurrencySymbol("Rvx4LRwcC6D5afDOL2xYMEabsMDH8IAr");
        country.setCapitalLongitude(9);
        country.setCountryCode2("Cud");
        country.setCountryFlag("Yc2JyP0kyJJRtqBYrVEDu2uRr5kfRtQ4ixstO2jr5j4Nu8XUMx");
        country.setCapital("DINfv1JbE8ai8mpvPH3bFcQTerxEcwRg");
        country.setIsoNumeric(675);
        country.setCapitalLatitude(9);
        country.setCurrencyName("NeFtbonbmhTCdF9LSo7yoGd2VRrcJWznJWuWelHpTHFkI27SIz");
        country.setCurrencyCode("yFy");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateName("foTL9nWVKkj8n07NIZW6JPHUQVyr8ZAHL3AMViYGW6702a1Efb");
        state.setStateName("ZvR9g9VV4hGaSWeeqEoqmUW5ISTv8OrHspQQnYLpW16rxFyp66");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateFlag("zbFU5KaLzGzoKjGbzM5j6zEKSp9s06ffQMTlasCX5KgGgb8nvC");
        state.setStateCodeChar3("0qyHOSZquKvTELSoukZVhyjgmmtCFL0S");
        state.setStateCapital("kGtzsyo1QrfpVQ1z6kG3OvGrF2PbuILlloQZCvjbYpDTFIcHr0");
        state.setStateCode(1);
        state.setStateDescription("JH8F7MGTzYElX1vKEptDtnAQ0zTTodHikg1skMI0IC0GyA5kjx");
        state.setStateCapitalLongitude(7);
        state.setStateCapitalLatitude(7);
        state.setStateCodeChar2("w8TRoOxkcFiqNLqwaX4PlVOqeHJthHNp");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        region.setRegionDescription("VtLUB80ZHrXcBssLliQtRAftCeFl8l5fiYjSCDCf1h9W8mKDxi");
        region.setRegionLongitude(6);
        region.setRegionCodeChar2("o96N9K72ZZtu9d1S2GM2PBhBA1hOzquY");
        region.setRegionFlag("cZcaiXrtU4vTN1YOneTWKV64MrI7WgGCRIXbWK5AKft3s60DgE");
        region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        region.setRegionCode1(2);
        region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        region.setRegionName("RVV3obA4nVFP1nT4pZSk54pUfHveNF85qxmGIqx5wW96LyKXgs");
        region.setRegionLatitude(10);
        Region RegionTest = new Region();
        if (isSave) {
            RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
        }
        District district = new District();
        district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        district.setDistrictLatitude(5);
        district.setDistrictLongitude(5);
        district.setDistrictFlag("8jP1TFwfcBntOM44dJgHU8Qw28ECJtX4tfWNUb2Nx9d1UMzSEd");
        district.setName("FA0x6T59biOF6uameRVmDcPvULFCMemF7RK738hoWf0d2PirKn");
        district.setDistrictDescription("zc4jsp8y9Owr8hKzDequp7GXGqJthsADId7glsnM0DRyVRGbvk");
        district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        district.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        district.setCode2("E0IPBJjKCUZ7ZAMpGXpwLSgnY1Xy51ZV");
        district.setEntityValidator(entityValidator);
        return district;
    }

    @Test
    public void test1Save() {
        try {
            District district = createDistrict(true);
            district.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            district.isValid();
            districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("DistrictPrimaryKey"));
            District district = districtRepository.findById((java.lang.String) map.get("DistrictPrimaryKey"));
            district.setDistrictLatitude(11);
            district.setDistrictLongitude(2);
            district.setDistrictFlag("ecw5LPsc0D4Xj9FOzRSMwadOZoGNmgm5sSK0Pb6aLzDQDaXIDb");
            district.setName("V1iuMKKaib9wwWnJqRjQUUExSUkhPjAuri8Ihhm8Mw8f5Cyet3");
            district.setDistrictDescription("0QDippzC4kNTvYXFIUKzcPufJU34bXiBDGSIefpHZU5Co79fOR");
            district.setCode2("amsVMem7U6L2F0tiBAuKBx2oUKYqL7DK");
            district.setVersionId(1);
            district.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            districtRepository.update(district);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<District> listofregionId = districtRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("DistrictPrimaryKey"));
            districtRepository.findById((java.lang.String) map.get("DistrictPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<District> listofstateId = districtRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3findBycountryId() {
        try {
            java.util.List<District> listofcountryId = districtRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("DistrictPrimaryKey"));
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

    private void validateDistrict(EntityTestCriteria contraints, District district) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            district.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            district.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            district.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            districtRepository.save(district);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "Name", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "name", "faNy5yClz17GWbxeKKwfOuRUIQOBV8uaZRynSlxL6v8uN9PAjMoK7DUQdWafAEXaxf6LEskoi6pJMRACuIPHIsVryPLF0DLUjaoES0MLlJ138ZMJ1b6sBRwzJpuNLYGKrLz6eQYXxOpA0mtk0NCZBJBYqHy4KXcleNXMm9PaR6xn9YbUw9Cg3e26W5QnggmvOcHjruhaR4wHikHRBPPAKZYr9xQeufykRfshZMZN5QD9dCrcLuRYViZTntlBNYNTe"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "code2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "code2", "0v9CKbr5WX9Q5wYdiRLgvLL9OI3ToyiDT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "districtDescription", "NMW5u6baPJl6lkx0uBER7nd9GFzJ1nqEcYGXW4ogD7u6VDdjzSYQqv9z6ZT34IWAppRz463k4UrZxAylxumca5tNJKeNcDPBnQCDhUGcv9StbeyEkYDOIIa78I5NN8LMD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "districtFlag", "STMFeBSLfMtsYPylX6HA9lVn3cyBBaLCzNMQzy87thm2NmZqKvYNebxlZLIUn9UceFegxDjrzZuFRXFD35OVSgqn04cUR8DOYLwncn8c3d15tUM62957NZldyVcn27Lcd"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "districtLatitude", 21));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "districtLongitude", 22));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                District district = createDistrict(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = district.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(district, null);
                        validateDistrict(contraints, district);
                        failureCount++;
                        break;
                    case 2:
                        district.setName(contraints.getNegativeValue().toString());
                        validateDistrict(contraints, district);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(district, null);
                        validateDistrict(contraints, district);
                        failureCount++;
                        break;
                    case 4:
                        district.setCode2(contraints.getNegativeValue().toString());
                        validateDistrict(contraints, district);
                        failureCount++;
                        break;
                    case 5:
                        district.setDistrictDescription(contraints.getNegativeValue().toString());
                        validateDistrict(contraints, district);
                        failureCount++;
                        break;
                    case 6:
                        district.setDistrictFlag(contraints.getNegativeValue().toString());
                        validateDistrict(contraints, district);
                        failureCount++;
                        break;
                    case 7:
                        district.setDistrictLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateDistrict(contraints, district);
                        failureCount++;
                        break;
                    case 8:
                        district.setDistrictLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateDistrict(contraints, district);
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
