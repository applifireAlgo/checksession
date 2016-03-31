package com.app.server.service.organizationboundedcontext.contacts;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    private CoreContacts createCoreContacts(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("AOaDTwzVoyHv1eEbpAGLSdf4gB9qCWM5aRMjFkTwas5F6jsS86");
        timezone.setUtcdifference(9);
        timezone.setCities("AKvT4MEKrkCrF25dEK4EepwKaPh0GksnlW6PdnsNeItb44CAA9");
        timezone.setCountry("KuQibBeHQ1n39HleS7ZFX7G1h8ySZUwsJG3BdR720aDWzpGnlS");
        timezone.setGmtLabel("4VAjb1H8A4JdYHWh9TBXpRsrpkychy13pfZuNtCXJvTSlPJaSi");
        Title title = new Title();
        title.setTitles("K5F9YO8jgibvpe2zvzQArBZWW34bmeieVx3EgWqh0eIulfKmPy");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setAlpha4("Z8Nu");
        language.setAlpha2("td");
        language.setAlpha3("hGT");
        language.setAlpha4parentid(1);
        language.setLanguage("6U8MlLYAYM4tlskLKaGK1NWON8OVWAFpMR6eFZlGU9jXyQHV0C");
        language.setLanguageDescription("nWwiR6TkG79GjUEqQkxEW5MeSfS1ORDnBwOnfuLaVDFnM3dE2m");
        language.setLanguageIcon("p2r6ZMwharTxnKzXnwA9DlRVxf22t8t6ImtVizuztMJ70iCp6c");
        language.setLanguageType("GyPetY60Ukr2d3e4a1PpiKn2mAdcnNzw");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("p9pfJKnJMIKBETXrzaHT7lfytSjoaBf4pdG7qwt33lLcg9kUqD");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeLastName("zuHgH6NbpxZjy4JRz9q82cngL9Pwfdm3tenG5ykfMqDXwSv8KM");
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setFirstName("QLTgFmoD2bu9UA4UGHoLDUpnVHlNCNLRK8pJLFD1FEL3SO5gnn");
        corecontacts.setLastName("t3Dup0WoQ9gFIBxdmvMS573hk0M3KVRh0YfpaLdYwnDmCWKnpk");
        corecontacts.setMiddleName("WDOkcXpUe9058DlQqWrHAPNYfaANphHrnC1gIAWArhRvomQ6gI");
        corecontacts.setNativeMiddleName("tzySuadjPaOI9mcGSOPcwPXFkVwGTTEJl5SPZfd0sos9P1Yhf2");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("FEq7peShsOWOPkuNiRFZOAOHIKqgE3uBeLqYJ2J3RzKRlIaNMq");
        corecontacts.setNativeFirstName("k1lJrO1OKsTzIBnn7Akn16D08GUQUjQTE0nP8epxgRvgMzdhk3");
        corecontacts.setAge(121);
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459427330961l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459427330962l));
        corecontacts.setPhoneNumber("RXAuJtj1VR0klNFLgJGF");
        corecontacts.setNativeTitle("c8YSlIPyv3B2UZBxemG6JxIZSIC5ym0prdJHO6SsK9P8tvsJRg");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLongitude("MYRI0upk5BM0VEAqEdmetCnCa2If1YGPkuYegqPpRAYBENWSEy");
        address.setAddress1("ZCc15xNSFFs6bJrpe2DFWepKapnOCm0l0NZmF4WYCqUaO1y2E4");
        Country country = new Country();
        country.setCountryCode1("du4");
        country.setCountryName("ggY69Hk1hGMS5m9tpmXF1gPKlMfQG5qCwwWEQvqypiToltB9My");
        country.setCurrencySymbol("fcRJTY1O60bvukigPmu1oC7RtjX2yM6H");
        country.setCapitalLongitude(11);
        country.setCountryCode2("OSY");
        country.setCountryFlag("hc17SlG5qrtDOV1ujqSSuAJDWIh94IpfBf0A1Q1ppITCrWQmRT");
        country.setCapital("r6XqR4ooWGC3PsYHYFSMdJYHisU6E0P1");
        country.setIsoNumeric(337);
        country.setCapitalLatitude(10);
        country.setCurrencyName("X5hQlVYqcaigrBipvesT0L4PV7IguvwhMbUAYSXPmQFfMXfvmU");
        country.setCurrencyCode("6LN");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateName("a6wJKG8bHuuPsBIq7xyGlEp0Upk86HScyaVH4xu9wEEV93SzQe");
        state.setStateName("tcZb7dlLZXUTGg7Xsj3nuBBEcWmhNurVx1uFSOgvlbTlCIqP9l");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateFlag("mqoxCy5hlMlfqC765I1lTqdVGZwnJmLKqaD7Bvuq1BOJii8VVy");
        state.setStateCodeChar3("sSpAdWRVEGCU2Pnl98d14Xdbal4DHp94");
        state.setStateCapital("6MMEgGR2EqGvScOCUsAXOsTyhbm1C2IG1ocObLPCIMz5w1gGeg");
        state.setStateCode(1);
        state.setStateDescription("gEnhWv4ZSgeio83kr4zqezAzlWXNbYJfvsBER28XSCZPAZh4Jw");
        state.setStateCapitalLongitude(6);
        state.setStateCapitalLatitude(7);
        state.setStateCodeChar2("nSWMtOBC1F2YATUdlz1WZwPJltjOD93Y");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityLongitude(2);
        city.setCityFlag("ZATU5pVDA3gx3A5hc8yz6h536mHA9Fsweo5QSfhLIqG9vwOYsV");
        city.setCityDescription("BCAcIHWgw4p9CoS07rL1PaEZLdxO8UGdnt35bP4xT1f2Lk119S");
        city.setCityCodeChar2("FgTUNe3H4AdB2Sir2Y6G0zqALAnax6rM");
        city.setCityCode(3);
        city.setCityLatitude(10);
        city.setCityLongitude(8);
        city.setCityFlag("6BUMLxycBqovKR9s3CV8Dr7HppaY5cM1zDpKadjviALM3njdLK");
        city.setCityDescription("knApiZENzwjZVKG5eZXpNbMucp4iMBZwCmQAzYcN4cnN3FNcjn");
        city.setCityCodeChar2("239tlUdhpIbnu9BlqN89fprQST1LrxsP");
        city.setCityCode(1);
        city.setCityLatitude(6);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("vUlILhmCZS5agdP3AOT71J79PJfEC83nFyWBPzMdhtGPuuRHDn");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("T5NxTksKkoU9nQxzN7Z7wy87uvRMZk6QSfZlzMT6Gy9mXPclro");
        addresstype.setAddressTypeIcon("GH5ruKN26dnjEq5IvsG8HLRqqW3ZjDmGYykO9wcCuL1xhJjYmJ");
        addresstype.setAddressType("QDfrwMjl7C0wFlTlFZI8ZpdIisLP9JmwRCTA4kE4E86xhZZyw6");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setLongitude("4ZXN7hraiZ62vsOgZcqmDvRHiC0Ls4h52MIu3RwUJIGOLx9J4b");
        address.setAddress1("kzwxBQD2NCjQtagdBZvkJAf5a7xMxzlsJbpxjsmAhVNNzLNwnA");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("sKnhYP6gedhAh1Aqjx3oFuujNlQzzxc1vdjRC1LbDWLzH9xJyf");
        address.setLatitude("clQ8FJPnqOsdFlwcC9ucc62sp7xXW5i0lW51JaVEImujr5ZlFW");
        address.setAddress3("lKKeNDI5vtwTet4d8O4mTboz3je0rfLu22OxnC6PXVc7dDVG0p");
        address.setAddressLabel("njUHLTPT9hI");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("2K7MSt");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("xLkJgs6PXrcmwNa1pzCmOyoDDo9tKdHfiogA1r4bKky7lbyaae");
        communicationtype.setCommTypeName("cZVfxrU4LeKES1aI5VsdegdAdxlMOWWFnYIEL6Fwp1ghEtTSMJ");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("trIhSbQRPNdmeBpWCrWKOkxrwKF9xmacaM84A4rJ0GZziIdXWO");
        communicationgroup.setCommGroupName("qNxcGP8iEGiTFE5jJzkb0iECNWSg1LpUKkwTziJYbKVd9HcCY8");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeDescription("1HD6v9i0x2CDdRVBQhsKBc0hb8QbmmP2TjEt4q6Ut7Un7fSosA");
        communicationtype.setCommTypeName("L82PsVMreRDr3Iq9Jq1sibsy5JfI471jEGxtaLSfCcDWDin8s6");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("ascIzSENqHd0q2gsoPEPpb4ZwOXobHmjLwGVfTbmXVb2USGMLR");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setNativeLastName("7zMzjYSAuj6GPtEdgKiYSEVwUiXG6NWHjwAmtF0hiCRi9fEYyZ");
            corecontacts.setFirstName("qjPdffQJHnewHbnOxgD5rev16VlGwECOY5SRHIjIsQUjdLVJLT");
            corecontacts.setLastName("fXmJkStku4NEBvm1mviLWDGJpqSb7Ft4h5IqhmKoMgeJgSLI0W");
            corecontacts.setMiddleName("ccGnPPDydIjNxvQHAoEPF2JvNNHWN3VLTv7VB1jWHYwPuFbTy3");
            corecontacts.setNativeMiddleName("8oovmpcjGiSAQcoPrXjgWNjrVsITxN10IpV5ATQxwCv4HJZgC9");
            corecontacts.setEmailId("EZqI0vucISSdTHO2ox3qCFp8UeqmAKNNSJP51EtV0LW9Nmk6c2");
            corecontacts.setNativeFirstName("Clhydoab9gkL5HM4MUzT9qPeGvLtBdFuMaLOaMm6vXGhqEdREc");
            corecontacts.setAge(79);
            corecontacts.setVersionId(1);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1459427332528l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1459427332598l));
            corecontacts.setPhoneNumber("vgj1mGzNuNHrcwvtduAl");
            corecontacts.setNativeTitle("UcDyR5UBT9lWAqd6laRrYI9YlcxHAlnmX9OZktKg7zuptiBTOk");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "ILYfD9PNxzjSndYoQrRnRlNCIgtxZV5rUrK2puubWSqKnc7cFj7HN0NQ35DEA449pxZtMVTqDrYn476TmZuP21Hs3r215SlTVQ8zFDhocsf8JoSruSrMONd5lhM3Ko8ZVdaS2m48bi2fREK9stngqsH28TAcH6bTM0EsdC4qX2SIrXi7u1sxbLvaEYAavicAgsB9ZeNFw0hzlfCoIQ9FtShb4r74HEiwnjwBWWHy5l15jVUTVX4yyVrG1AhvPDQyZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "WYYkmL4xmfmObhHmjvcx8VvVorzr2c4uqiygBWJ41BRh3rgpqDxcZBK4W4xjgdJqqOaj1GurDT52aztAH3otPZL7MVBydpkuw7G1Y3yhzmZdu3aAnEXHV1yhxbyNXzBRR9WG25ei9OENb8Fywh0DXWywsRqqKL73y7ctWJrCW6ugq0QNnNQ5tyhrPGONxuTklT6y2bqYFmYcj1UzVfTFlGcYD7p9TogqjejVqKJ7fJKIoVjoU0FiteynZPbahDVpN"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "qnon4HPEv6NgMb5pHo3YdB4OhEMTXKZYWejpcUIYZW5BKNHrNEe0XKt0WPLNiu7CeiEsAcb90ZwfB2YcJP7KKGmPAMdzsrxPTrzJuJXStfDTpcKTrLbQ2GVXYPIadbA6GC4GoSZNHsOpIdL7M9k2sla7QoaS5iFpMxdbYYFIbMmxatnzIbYLbqXzBlPnQAmmSCw9mSTUaRXNLhsV6JAbL0Hh9kZqBoGZtNF8oDY4xuhlTGZrYfVoMHu2d7ItwUViI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "etoAwdN1CdYlOn7Nxfyh4F5MfCa0nvDNKY0myPkzZcNvfeOae6dtuJLVuulTMwett"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "K2APet4QcMCUE4y40uoGYrS8yxqY6Gm9Km7MEWYIJvG3P5MLugFBK3vvI8bqn0dsvbJm6YaFOkE1BIvbzdhvuDdx9O1iO56oZpRMYuko37cx60OGLB8LlWxrcgtFwni5A2bRXTVCaJ3bBU6Fg6lSJEMXDQjqUbrk8ekL8eVVURs6kbGYfWcp91NTYTp4kkm3ufOhRXTnObhj8dtfDGXhcV8VzZRPWt3iJSw47HMAa9qf0pgYMMhMe7RgxWJQZUrvD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "urfe5lqcJVRabB1QaaFRwXWdW7Pv73EwFBBTVfKz5uFbCP1bbV101AERd7UrGaOPjO48QbUJOS641kUY5cVYgZVRqzpIi5zYkebwJuYSQWanUjX0xRgxAeFighWuhdtdapXayd67TMhiPeZzBuU2U8s1VWqczfgu0LXuiJHZiXE6KCrtjpgiKpNooFXWpKsDDu6pIZjQZk6GfzsdEvJ9JuCtwUulcZ0iqeUbecXuA3VSNHyLgWgpYKrcA2EPVsai9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "PsyrJMG2Li8T1uDzHaJ5G88SV6Hkmxd4MgjwJNFFIsRWf0rL4wGnbFiguo4u7sx3s2DZyDzffOwUHexYnC4ZcTAQdvC4oGSFjaBlty2V4LjKijBN0bgPSucFBcwURMLbG8bhY9bBuWvB9VbPySoy0VDMQKORPGfQBpxDUgAVvH3vs3HJDOyDbBt6cMgm4naaJLCOXfxxxPBXgVPfcKGFuZedvdzMCr5ZqFVBiY3OGN1uhlffuaAYgWlQhDo5MpSvZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 177));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "UTq0oYvwwWLUpntltSz4AfwEH69up1bcEAQqxsA1vZcwowuR8SjJ46BKiXnimvXJkqAhTHehS6Q6UohkGyU5kEbDFlzZJEVGQ0v0azgCKQk0Sf7m2OnXGOMV9pBCmdst4hQW8s3hquUPAC2jXLwiFLSJGGP9dkgyNjbuSvcypqxU2Gcr1dKbxzAP5nkAIHxVUMoTKig8ymhSfTLE7l2mlUsknS3QFJj0pv0fb9qxZn57XTyWWeZgetpkJHFHbdpo1"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "d2N6G2OJUGTAQJ2A0mDII"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
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
