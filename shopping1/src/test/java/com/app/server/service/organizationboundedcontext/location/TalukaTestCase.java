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
import com.app.server.repository.organizationboundedcontext.location.TalukaRepository;
import com.app.shared.organizationboundedcontext.location.Taluka;
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
public class TalukaTestCase extends EntityTestCriteria {

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

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

    private Taluka createTaluka(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Region region = new Region();
        region.setRegionDescription("pQDh7kHwzsWaj5tiylyBp7rZqk4jYtinBPJdV8Mb2qSkC2pjrJ");
        region.setRegionLongitude(5);
        region.setRegionCodeChar2("faMMhn7WhTkRyT19BbGJ8FotHmzLLI0v");
        region.setRegionFlag("VHbXfj8d35Wqv2mzm1Ny4IIO49SKXjM8oHTfDFYGXNmYEtrD4A");
        Country country = new Country();
        country.setCountryCode1("D1O");
        country.setCountryName("rbbQQy3ihDWLTxhRsndPCfxCUgNhflVcvH91QL8IxYRR4gMG8T");
        country.setCurrencySymbol("axdLB0Es5zMWRMcMirz2B7rrVExM3VSO");
        country.setCapitalLongitude(4);
        country.setCountryCode2("FSF");
        country.setCountryFlag("RmLgxxGhS2ryY4hxVJRqthtoJpvHq1s7sSMCa11548XjI4PAX3");
        country.setCapital("6gfn6rzvgzbk34HABQGAa8oQuJhkBzUC");
        country.setIsoNumeric(887);
        country.setCapitalLatitude(3);
        country.setCurrencyName("UXWif9lNxpQyyQYQAQ81fKs3NoAqgKpP4U7fPQkepTRPPngP8Q");
        country.setCurrencyCode("nSq");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateName("xsln8aGJRk2TWiGuxOV4pSDLPli08rVpjWVIWsFCmi4BaoVlCS");
        state.setStateName("4cK0N6On8uiuCUbBCm7VLL0Hla7bNNNK7Yr59KhK6L6ehvofNE");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateFlag("r4xhf9phz7iSELLlq87UpAwYIpJAirhFTqk7TCMRUzc4tn4PA6");
        state.setStateCodeChar3("jPKhzbuSwvrYRAhkhVtcmJ1znBzjvyAI");
        state.setStateCapital("V39FSFKQA29osLuvBhPLylmFr0dDtrMvNWdM6KgY6rw2eAZd8P");
        state.setStateCode(2);
        state.setStateDescription("LTYzB2Qs51BlPeoPHkcaBMcP3R86FFt80mpG0X2Vn7jlsnICVP");
        state.setStateCapitalLongitude(10);
        state.setStateCapitalLatitude(1);
        state.setStateCodeChar2("6V3jLSWjJai7qFWaErap4DTvevwQNwhL");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        region.setRegionDescription("O5jHqnW4yJ0RSTWWvx5ZDoYmRnfciuZLFkJjiEplOrMIeUxz6E");
        region.setRegionLongitude(8);
        region.setRegionCodeChar2("CnUGWjPKGv93AB9Wklep1q9UZicGJ1BN");
        region.setRegionFlag("pLiHoMclFsE0Eq2i23XVXovBK2li35lAUWhp5qVynOJ82fcg63");
        region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        region.setRegionCode1(1);
        region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        region.setRegionName("1PAbEQT0Fn2mXc7TTWcDOOTTgf8J7LlO4E7hv2dIlPL0vb6L5P");
        region.setRegionLatitude(3);
        Region RegionTest = new Region();
        if (isSave) {
            RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
        }
        District district = new District();
        district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        district.setDistrictLatitude(7);
        district.setDistrictLongitude(2);
        district.setDistrictFlag("Wl8Ar5JENq4tw7FOQIktt6nGGqx20CPhTqkAFN8sbGsKOWCibC");
        district.setName("snJm6nl8AzfKDho0URTKix82tKXyETHsCDV64j8tVpq6TNugYi");
        district.setDistrictDescription("42TTsUZIDzeu8JrouXgN5gCXE70KqzJ4AO5m4r9e9WrMLtNu1g");
        district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        district.setCode2("0pzJ8RE0wXbHTZ4VQ60u1SSixrEcAiYu");
        District DistrictTest = new District();
        if (isSave) {
            DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
        }
        Taluka taluka = new Taluka();
        taluka.setTalukaLatitude(7);
        taluka.setTalukaFlag("FElkEspMhQ9nuFvUKdIURKRXNFe8RuMvp0Q01YpYFsnSDCMKkx");
        taluka.setTalukaCode("dyBaaPtjQMAuab7QmMZti9OrEdFWwLu0");
        taluka.setTalukaLongitude(4);
        taluka.setTalukaName("Y3PH0qCiSmt0zBtc0sxUmAdhz2BsZuSAYDpGiXcMCQwbEqYIAw");
        taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        taluka.setTalukaDescription("5SsryvBk4W2daku95t870HnKMsyopVYbfXpblL3to6b7yXejxw");
        taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
        taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        taluka.setEntityValidator(entityValidator);
        return taluka;
    }

    @Test
    public void test1Save() {
        try {
            Taluka taluka = createTaluka(true);
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            taluka.isValid();
            talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
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
    private DistrictRepository<District> districtRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            Taluka taluka = talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
            taluka.setTalukaLatitude(8);
            taluka.setTalukaFlag("VSCVBIYJ6ZLmiARRfJQj1af8B2iG20ViV6uoDb1SibztXH6PjY");
            taluka.setTalukaCode("uARfHcGRUsuliVDCZizAdM9WhTahsKp3");
            taluka.setTalukaLongitude(5);
            taluka.setTalukaName("QTXcjSGaY5cREHEUn8jh6ckrbkXC5kBuUngpLOeiqpy2IuU6bo");
            taluka.setVersionId(1);
            taluka.setTalukaDescription("Rqa2bdXU5TcP4E3jjkA1vKXkps02ZVJNzTjJXN3VUa0sxk9rGW");
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            talukaRepository.update(taluka);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<Taluka> listofregionId = talukaRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
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
    public void test3findBydistrictId() {
        try {
            java.util.List<Taluka> listofdistrictId = talukaRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
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
    public void test3findBystateId() {
        try {
            java.util.List<Taluka> listofstateId = talukaRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            java.util.List<Taluka> listofcountryId = talukaRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
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

    private void validateTaluka(EntityTestCriteria contraints, Taluka taluka) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            taluka.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            taluka.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            taluka.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            talukaRepository.save(taluka);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "talukaName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "talukaName", "3YJ7XFXKcalQt8EcutFrMQY7MssFJ95ofS38L36xi76SjaNVxaMeU2tcNrCTYKOifGiqIQ1ljaNWtadF7qgBXngb86AJRTLilM7uHsoqK49C3RKTJjKx3dbAv284Q8Lw0oRZdfxBfibgaNx1b5PSTLgtrJdvZzWPz8iaWgvlq3ZrWEpA20BPn8iVXn0y8uAVBHeNbAGySwGubIc8wMnOCSzkdZp9lM8RJSi5Ahy9dP32FFi475g4pXhBJinFmiO1k"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "talukaCode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "talukaCode", "Ed2ZBtJqxLVYvFKsCakpj9yg2rvnQbWwJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "talukaDescription", "EXw1IeETG89GlBsb0JRn3Z4nVyHENQytYOTJXPh5A3QZ7lXhNsryjlME2RoP8d5KH6nB8ssNZp78YolpfTsswCz2Ry8xRfLWbz8Cc0MSQgary8gNlY0LsPJqA1pag0IzL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "talukaFlag", "a8rhnyVtDT5o5FpKg731VTKAbnudOZwK9xGdORHiZm2lzNOArxtj4JeMDXd6dodLZtphx6smbco4ECdG5vQtyNRz43NZDOR99pxfMkYMYHJxQuoXVt0N7dkJ2Xwr4KHyo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "talukaLatitude", 12));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "talukaLongitude", 19));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Taluka taluka = createTaluka(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = taluka.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(taluka, null);
                        validateTaluka(contraints, taluka);
                        failureCount++;
                        break;
                    case 2:
                        taluka.setTalukaName(contraints.getNegativeValue().toString());
                        validateTaluka(contraints, taluka);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(taluka, null);
                        validateTaluka(contraints, taluka);
                        failureCount++;
                        break;
                    case 4:
                        taluka.setTalukaCode(contraints.getNegativeValue().toString());
                        validateTaluka(contraints, taluka);
                        failureCount++;
                        break;
                    case 5:
                        taluka.setTalukaDescription(contraints.getNegativeValue().toString());
                        validateTaluka(contraints, taluka);
                        failureCount++;
                        break;
                    case 6:
                        taluka.setTalukaFlag(contraints.getNegativeValue().toString());
                        validateTaluka(contraints, taluka);
                        failureCount++;
                        break;
                    case 7:
                        taluka.setTalukaLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateTaluka(contraints, taluka);
                        failureCount++;
                        break;
                    case 8:
                        taluka.setTalukaLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateTaluka(contraints, taluka);
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
