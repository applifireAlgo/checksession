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
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
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
        Language language = new Language();
        language.setAlpha4parentid(9);
        language.setLanguageType("ppAUGEhV5FvYxPjY9iBO8h0hFP8Amn8x");
        language.setLanguageIcon("UvAsg1DP5atcPWfMde3Tr6zsvvZD0rsjstjaVeE63Pgdm66kET");
        language.setAlpha2("uJ");
        language.setAlpha3("f9I");
        language.setLanguage("CWcbnjtlkn9vI2kKfIUm58mPiXqDZ5Pw6HqJkJUOFFClZrDAna");
        language.setAlpha4("JMwT");
        language.setLanguageDescription("YRFekYMEfiCMpyy2Rc5zcoZTm7FnYAt7hgR1qLKDSytH8IVsKy");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("ednOxoeMTRAm3oygdlR0HjdZAIIMMykTAmy8gtXPhwIOPLyRlt");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("fA8AxSaY6EXGYUm1x7SAAwZvWLbYEmsWJ65K5K9CzO21m5MtuF");
        timezone.setCountry("6fbKkWvyUvT3zKdKnEaoWIKX7oWtZvzVY9WxxcseP2jPUEyfbA");
        timezone.setUtcdifference(10);
        timezone.setCities("MAnh0PxluIVG7S3kTBSzT8bCS3OP0oVmdMWQPTGVeFvOzTZWDi");
        timezone.setGmtLabel("wUqP9eBRbAGOTWBOppdujnyeNyECdNV6qrKDCUeQEcXmkMMTi1");
        Gender gender = new Gender();
        gender.setGender("LHepK6hZV9yjiwvZKibDjh81KBwYLexoUfVLU3dj8oOrWih1NS");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setPhoneNumber("dhs3pXMGiiwFzRxvUkhg");
        corecontacts.setNativeFirstName("C2l0fXpfHv5wwN2s8g94PcZYbHL3UMpfJ75Ua0WnMBf5tzxXKC");
        corecontacts.setMiddleName("PXsoAiKaE5LWFpOEeGlGPNprKl4kFKFT10bQUWfImraevpLD0R");
        corecontacts.setNativeMiddleName("XSkr4gznK7vZBZEX573j9Q4i93HbupTG6t4kqclKUvgBoUnRZT");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("bha2RfQzUn8DiLglbMeVzn6WxnxTBCFtStNZmgFfbuIvAKVvJl");
        corecontacts.setEmailId("okos3xBuJKAqbndwutUhMqZz4g9OIXQnoVcpgwE3bGl3pvytGw");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459343724788l));
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(111);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459343725396l));
        corecontacts.setNativeLastName("K22VYduvqMYBngsZK6bsxBdZzazi0VRGuka1d4kehXhrNcC3yr");
        corecontacts.setNativeTitle("KQC7s2Qx5Qk8wLljyawFZS3iPdrJhJj4iShcvuHQCViFhEKYFm");
        corecontacts.setLastName("MXbHdwxpOtigPfvd2kuKVjfPcGIZIbYUkRMEKrABlUV2YM2b8p");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLatitude("YQhrMwnfJ4Lg9lZxo7ToI6UtoPdEzTXvdmRWNlnkrzy6iy62wc");
        Country country = new Country();
        country.setCapitalLatitude(4);
        country.setCurrencySymbol("Hb7ssjUFThQlyYEVTyLa0yRfag7PK4x1");
        country.setCapitalLongitude(1);
        country.setCapital("Vncq7Agu212mjm9KkUnYYrikpgC3oEQE");
        country.setCountryFlag("cjCMIesaXzLHXOYTjeYht6lriQfzLyFtO5rjxce8ANSMiMea5h");
        country.setCurrencyCode("Ykl");
        country.setCountryCode2("u22");
        country.setCountryCode1("Duv");
        country.setCountryName("faSaEhfdMlr20BXZHr5s27bdgAnGgBIeCykVvw7iPdnNNHs5Ev");
        country.setCurrencyName("m5iSI9I8yL3Ckf4njXmwlmlD9bhuA8p9e23nbswF39tcjoyyOG");
        country.setIsoNumeric(798);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("2bPWhfBsIttYJhE7WuDofqsNN5bPozznSBivZbnvZBceu8drK2");
        addresstype.setAddressTypeIcon("e0lzPDrp8Gc3sykuFEhZsYLWpfakWhJ761lRG7bZCktTvrQaAR");
        addresstype.setAddressTypeDesc("LtJEgwRz8KgUUOmZiQjk5fCVqWfQgy4k4MSA8ZqK3I5DiXFIG2");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        State state = new State();
        state.setStateCode(2);
        state.setStateFlag("Kmni0eB3wrsVliO2IlVQn96W63Qye0BlTZRHeqjq352D2STz07");
        state.setStateName("pxRIVei68g8MgkPa7iEiodvHGojl75kCGTnmTsSKIjAvtulTVE");
        state.setStateCapital("8mjpdpiFDGhuVgTy7LkVnoBEeWP9XWgn1V8QLzuIQkWwHbMLnN");
        state.setStateCode(2);
        state.setStateFlag("daxV5RyVSabqJre1YJS5LZjESjVu16Dik0m44MQnAYKhlU4XOv");
        state.setStateName("vZKtBhmI4NZYRwXTztO2eEk8vl9y07Q3bmlYuf5GR6Wj2enqmD");
        state.setStateCapital("axuYbMTAaI8D2PHwC4yJLC9PkJPQjBsaf8agFDQG1biehnGZok");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("3EIWnGZ7UnwBJs5BWQLSP3ZdC48VhBfQ");
        state.setStateCodeChar2("x1nlyFJPeaAfABMWUTTnHV9M107AfOtm");
        state.setStateCapitalLatitude(3);
        state.setStateDescription("qNRevrO7EcnxF5lrSFo3vNnUYebmpS97AxIzFWYZOjCTlZwK8j");
        state.setStateCapitalLongitude(8);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(5);
        city.setCityFlag("r793O37tWBv2yrMwrh0qbF50oXjnzwKwyFBpkyFA7ikQOsNE0p");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("7dj6tJztqzjEOgoMGFJdoddc64Z4zHQB");
        city.setCityCode(1);
        city.setCityLatitude(4);
        city.setCityName("A5wnbCehTZraa2j5HoCfi7uyGba8ZlkUQheYv5oNRLXkZp1Ajw");
        city.setCityDescription("wIFR7z00FKzVS19hi7unkb9eNujuDyRxPMrGEjdFyU2rDHMjOu");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setLatitude("SDq4HEuQ2d51GZ67Y2vIUnJfWy1E5XMLScHiQmLoVutaglp1f7");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("nXid5VQ22J7njffc5ISsDItXieGr16bOyDIJmyfnsjGN0R9T9M");
        address.setZipcode("zfh1zn");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("ZfryYxRYevmNojnDZROumD4U9VWky6ic7YUU4B7nljTZ8AyMr5");
        address.setAddressLabel("SmjSZBvEkXi");
        address.setLongitude("UtcWzgZ4nHPtWNdtpCgphwxbSnCc0rm0v9hDNbVlICIqM0vwgm");
        address.setAddress3("hABUlNlrfnextHHzcSGWeO6NIbYkDULT45C0rKgcr2Zwh31vzL");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("");
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("4C5Pysm2lc4WTdPjxpziTXxHmoxun9mZrKQJJvTf0ubB5ef9zk");
        communicationtype.setCommTypeDescription("XVCOOHOZwDKzLnbuCW6tk1sT69sZLvIgD4dWJe4FplK3fGUloP");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("uWuCLGuzHyIib0vTKa9YCgrRxgn6Z6GAOkG8KuNYRAWXVeOymL");
        communicationgroup.setCommGroupName("Ky8UXBhFfYwT7BPgDtr7FvO8UhT8WiS371ApH80TEW56pToauq");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeName("NgRfMvrZfrteXZQxZwUXOn5C2kU8I1ycxy7NPn3a3Ggwq9SEvS");
        communicationtype.setCommTypeDescription("LokqYPJSuOPISqm2cbVKBi8LfLUKRIuRo5C41Qm9vu1I1FS6q4");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
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
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setPhoneNumber("rCkImnCFegHEgz8aqUFQ");
            corecontacts.setNativeFirstName("eEuO8DmhALwEScImYcaEmp1IqB1JvxqBfnE78pMXLSHE6GQZ8C");
            corecontacts.setMiddleName("TaZDrW0Pawm6uC4SgG6UerqrX8qLnfxSooO6gHD2xKAMFafxcD");
            corecontacts.setNativeMiddleName("3K1AOwlzX53ts6nPt0ibVHSlPNCnekVBqmZYV5IE8Hqrj56HHu");
            corecontacts.setFirstName("fanEa7mAwxDuSlIwI1oeYXCTRvI4AlAgRSDhQkKgBKjB69oZJ5");
            corecontacts.setVersionId(1);
            corecontacts.setEmailId("XFk0Jt2DtvSoIrZDmM5Xo35GJOjiHSpzGZLOZ5yefXmceo6848");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1459343729498l));
            corecontacts.setAge(88);
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1459343729794l));
            corecontacts.setNativeLastName("71A3LAV4ZPo3u62hhlHPBqZCdMqSIUHcaFDJaqtceYHcCpJXG5");
            corecontacts.setNativeTitle("Z4LPfVcfS2VXlocfhvuJRIYS5KFq2A9G3A7obwr1VQEVHuquNL");
            corecontacts.setLastName("bRdBzIehErX11DoBUb4tOjinBgAJLl67IM2luprhmYm6cH4VmS");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "RKu66ZSu6vCmJr5jjGnZWcFAzBPhGItKeow3QqvyjMt8fp0Us7LdmEZE8VnTudSb4Je1WCU9wlMCUwgvypD2M31xb8qGsotLUUR8wYfz2ATEdKOossVitaldXWCdDxRLOQSmjs8MbeGvq7yrANly3vJ0SXYOhkQRFwNWLuMGyLB6EJIpjXInmApQpwR8qXwhpg2JsIUFkiHz2Qk5ppfHH9PjYJZAHe8juRK6XE9Xnuur299MeAR5zKjcdNMRFovwu"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "EicuLQhERJTnCe9ubQMlWF6ZjBn03HiiiIdyr08lwPLhp5bJ842W7dUw2fGEZitaYZZwWBsT5s4okEbx2wsKxRw9eluw8VyLoBHNEKXagJlbXkMIAzFrwPElcnUmIKVRV7MVh7NZDTBVTsiWzV7cyjm88TY0SJUOxOdqz2Pc0o29AgZLSqv3n6QAQomDUXmDOE1hqwtD4AzW9KephCudIgMX9lBDC7LyltuFljh2pQzxRkHENf72TnObqz6lYjrY7"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "2PRG0y3IYCxNHzU1hsz0axsZUozUT9baSTah9064n3dyual4fpOJUzWx4n0jQVFxV2Q10zLqoMGaHQjh0isYdg1fooKzQLWZ2R5b4HCpD4PcKxxUGg5ohPrSLauJhXPBpXoXeRfT7L5usbnylvxLM0xP5RZkM88ybe4E6iXVuPSManYiLRnthZMrUA2B4mwJRHgS2TAmFCdV2ONZUdcMHdwMx8iOlLU2zrOgzuPfxL63AGoOmK3AQYkn3goUjMeGv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "4JslkkPSn2JiFioSfZAqcwl0c7PdpPoCFtN9Eog6dTkDJSXM18UeE9pvqMiZlu3ZJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "sehGpTgTAXowasL8SCdgJiDT6kmiXQv2NpPWsvBPOxf1uUaNeo5G1EGtHr0eGVoNS8mtuThEWwIaiYbt30inZgy48shTtT0VX8pw98VEORNEmBByyJ6P7JKEtwglqP6yFx8ix06VY2XXK7pUNBK2hYPTxZGZUkpBLK9EawiVA7f5gjPORiJqfY1tejdyEl1FuLPpYDlG0e5D7MDGE8teRFbiLZ94C86FdG8y1kc01DCUA1263ls23aQegoZZTQkfM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "FTXZ6MBolOPH5nu2V1UzRSVg2Hj4qdIrbQI2thrwit5xrGXMCdVZqR1zeQ2NrJPhHDOuKQ2yW8TyfHmkPBRrlWoAUKFdstEI3NtkqMaV1BuP83AXogGGw4kGHHuC9tuITYqlA9ZndPVkxl96J5P8kD70ryeed6W8vRz53jLNtYJQSdAofAAUpXVVvLlCZXiWLx4joFPNhaVhM62EqnLgoJWssnF0uIZNsWsJUsikdLsBjJ65oPZ9m0pk0Fgxngc2Q"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "4rZd4IIHzTKL0qM9tazfXR1j1K15yVIznTcwjSMVnneJR4x52QhwMAkOruU0kn3tO2yAsWfmCy3u5mnIrRyddHvrzlcde7nykKELshWO7Qr6pgU8lQ4oBONvqfxntcTNXugwdoMmKYmdNtBqi73bPYn9DAIdwwagDlSM88SjE4mF6s4qwQvU8Wr2sGJYBGDBa3kem7Jcn5nbtD66wgk4G98Dbrnuktlw38IBVqwhX3ImcZbonLAHTQYwuYS20z4hX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 231));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "MEmMyaD3Sp0Xyi0pQDCovR2qrU5gpgXob5ihx3ge4JdTdnHerso2KsfoPaARGSuUIxDQuy1wTQaPRrnba2kxOCpEykAtY1Yg7LqLsVn1iXth7tAUp31xqKgEkb4KUqTLSdGeIRQmCkf0iCeP0aTvpLGPSW0tz5hrOH4rYi5HDsJvwPNdgCXQ04WUa5THl1mYLArHAfFN9A7utrexLJOkbgYpePUwfJJoP0LVDaQuak45UXT5AeZqtUw8MB8zyqKSL"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "G16XWaYAUvtOB1tRL11ff"));
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
