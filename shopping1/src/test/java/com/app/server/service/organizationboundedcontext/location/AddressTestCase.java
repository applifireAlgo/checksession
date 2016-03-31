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
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.Address;
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
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase extends EntityTestCriteria {

    @Autowired
    private AddressRepository<Address> addressRepository;

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

    private Address createAddress(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCountryCode1("Co7");
        country.setCountryName("Q2UCOApj4Xgknx3ducLYCPWuIM6Ir8D3wiz9OuMMFT3zHAN3Kq");
        country.setCurrencySymbol("cjtsTy2ne6jlln7it6Gaa2dyxNQAZ01v");
        country.setCapitalLongitude(1);
        country.setCountryCode2("pI6");
        country.setCountryFlag("doSYzcTC1qXe2y2rgW5rMVfbFrauV89T5BZrGrDVBQwjgtEcxN");
        country.setCapital("BpFj7nuozS5TMFgQIHkeOueas8eAkuMF");
        country.setIsoNumeric(521);
        country.setCapitalLatitude(5);
        country.setCurrencyName("EZuIMpHP1EKS9Rf9p4xmAJr6i0mfUgSASLzDhVTOdGVytw5oOJ");
        country.setCurrencyCode("bcj");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateName("aXcN92AxiG5tEXBgtuPNLt9w7Z1cgGGZJyrxJ89e4CwwOgnxPf");
        state.setStateName("PPAUobITBDRbr7WWkmYKT8RERCTGlJYSQbVA8Tro2P6EaDzO3E");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateFlag("zIojI32gMEW72ymV2R2YzUmTeA9spbT8GbdxIQzj5A11hsLxPi");
        state.setStateCodeChar3("jGNSI865BhNw4mp3hUM4A4AN50kjvimy");
        state.setStateCapital("tOI5f4huOwWTnERjp5wrxxyEdQoAesgz9zbElFpHEf9lmsqrWZ");
        state.setStateCode(2);
        state.setStateDescription("0w7dhlspYck9QA0vO2JMsUM9CtkshCuF9ws27BrbjC00cj9rMz");
        state.setStateCapitalLongitude(1);
        state.setStateCapitalLatitude(3);
        state.setStateCodeChar2("z3IF73d0keKU8KfYYgJvOApWuaUMRYuq");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityLongitude(10);
        city.setCityFlag("1TkmBlQeUl3ULOUMSmttJIdIAX6luYknaIxtDk3qqd6pSL88xb");
        city.setCityDescription("3buvlJCjWzVPdbyAqKcz0cfUXNaBcBz3doe1Obugp8BCPzYuY5");
        city.setCityCodeChar2("5O9dF97w99DO7IeXJsDQHzzjLWnWDfi4");
        city.setCityCode(3);
        city.setCityLatitude(7);
        city.setCityLongitude(9);
        city.setCityFlag("hBr2pabqgsUAD5acYf2NTVmIklGc2DHXZV2QaX3N8xj4TevFGG");
        city.setCityDescription("z8eQLv064G40yCqtm69FJhCD3NoTiMsKQcC2xe6WP9TFAmapGU");
        city.setCityCodeChar2("DfZqrkja4bb6Vm9QqkNCpTFkmEBNwOvj");
        city.setCityCode(3);
        city.setCityLatitude(1);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("ewBGAa7BTv9fYKTzCSJHGtQJZAZOrt4Rz3S13p02Z5AiZdduv2");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("yyK431Ps7GQDmywIKOr7Oyrafi3V4h2HfkibuTc60Y9HHokWAo");
        addresstype.setAddressTypeIcon("udZy14cCikbqauLMuFOIJ4i5mmzP8MJ1aW3LzxCg79QUaDQFwf");
        addresstype.setAddressType("W2qJfExeCjjtqoLADmr61d8K9Qngys2WDAeaTkvWv33ENbzGQC");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Address address = new Address();
        address.setLongitude("ohzpYPTsTOZOM51OtvhdpDmANniuKQtdHDUE6NwRltJxhV11EL");
        address.setAddress1("i3ti0JL4gOZboijQlel2rjPDuQ8bDAELYeyunpdgdE9d6WgdZW");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("kMul6KGP97hSplGQsIXmN0orl7dN8uah114eUM3JHpwr9O7lCc");
        address.setLatitude("pKkVUh7hd0C544wcpIMwLNGcdDd7QucFpWo4Faz8BICviFroL0");
        address.setAddress3("KNE5OuahDIFpeil6gRs1HKehT6kYIxjuvm9yTTgTUYvhNjqYNl");
        address.setAddressLabel("3IntgbqUpEz");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
        address.setZipcode("xb59xG");
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress(true);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
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

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setLongitude("9IBzHyE63AMGgURy9LOs2HBgpDVU6F0GAQULXGG1HwEXKvp2e3");
            address.setAddress1("HWV4gbJtMHKPSYzixGCjzrjVCBz074UJkkWuCgpB591HsFaMfg");
            address.setAddress2("s51T0xGjZnEzGTtwTdzo4j26mwB9g32fbt9DWVHCXR3mv49MGg");
            address.setLatitude("yMVB3ebAox0CoBjsWOaweO3tcOa0LSehaoZ3xSL8OAZrFbLv2s");
            address.setAddress3("zEvcUvSvYFz4PMLmOzbgSYURqZgIqBXGsLC3k6m8Yrb6EgwnTX");
            address.setAddressLabel("q6xvhdyRasm");
            address.setVersionId(1);
            address.setZipcode("2gleUy");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "U4okQGC8vRwA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "3GX11421Um3pj6z4ZyFMdc9zvfuWTPMHEWiZl45XcpyHtEN3PZIu8USj0"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "AgIuiYH498eOcjQSMkrM9LcKmDmncySEQ2Mx5If8WlHf6f8XGgqvbGwV8"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "SPV2Z6WZsmq7XsJuse2AQtKq7e6BOBW7fle2blidslveUSUCePXYRcujI"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "frNapgy"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "Js2ca5Kzma11rszLPW0MfwtS1tDrPFUbG5U0HpmHbnG1Sp3OI4klxaCHhTsXqyYNy"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "VUMLW3NdQcafdLgdS9wP0Ib8ubjG4RIbE4MiwLHEI8ARgHYHkthWUxrwOaDx60rda"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = address.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        address.setAddressLabel(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 2:
                        address.setAddress1(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 3:
                        address.setAddress2(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 4:
                        address.setAddress3(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(address, null);
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 6:
                        address.setZipcode(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 7:
                        address.setLatitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 8:
                        address.setLongitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
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
