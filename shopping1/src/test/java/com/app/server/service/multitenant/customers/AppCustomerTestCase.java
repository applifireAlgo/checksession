package com.app.server.service.multitenant.customers;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.multitenant.customers.AppCustomerRepository;
import com.app.shared.multitenant.customers.AppCustomer;
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
import com.app.shared.multitenant.customers.AppCustomerCategory;
import com.app.server.repository.multitenant.customers.AppCustomerCategoryRepository;
import com.app.shared.multitenant.customers.AppCustomerType;
import com.app.server.repository.multitenant.customers.AppCustomerTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
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
public class AppCustomerTestCase extends EntityTestCriteria {

    @Autowired
    private AppCustomerRepository<AppCustomer> appcustomerRepository;

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

    private AppCustomer createAppCustomer(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        AppCustomerCategory appcustomercategory = new AppCustomerCategory();
        appcustomercategory.setCustomerCategory("2pS1aA1Z4aFeS6fyNWzUhm5yTdlFgxG5L2tw6h9mYQ4PgmjsVU");
        AppCustomerCategory AppCustomerCategoryTest = new AppCustomerCategory();
        if (isSave) {
            AppCustomerCategoryTest = appcustomercategoryRepository.save(appcustomercategory);
            map.put("AppCustomerCategoryPrimaryKey", appcustomercategory._getPrimarykey());
        }
        AppCustomerType appcustomertype = new AppCustomerType();
        appcustomertype.setSequenceId(2147483647);
        appcustomertype.setDefaults(1);
        appcustomertype.setCustomerType("p3HOktpVtv7QKW3oqAqUdxsJinAS4Mh14HNuoTy4yBYKD1d924");
        AppCustomerType AppCustomerTypeTest = new AppCustomerType();
        if (isSave) {
            AppCustomerTypeTest = appcustomertypeRepository.save(appcustomertype);
            map.put("AppCustomerTypePrimaryKey", appcustomertype._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeLastName("JVaUrCYYlGI8sYW2rKaS2Uv01olz9wV6Av8Hja0bJPX9qlQFiU");
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("FMB55afvypKw6yyhjrwefsnmuqRNQIkblWLlIRPZ4U4AzfeL5b");
        timezone.setUtcdifference(11);
        timezone.setCities("JsTJyKvqwawf8AQvL8uMwxIklJwdAPdn9t7NZkFatoAbfh1U67");
        timezone.setCountry("8bAEEep7SHirdM20JMZMJciNsl81lAV5uiu1gdFOKZDgqPCTAB");
        timezone.setGmtLabel("QnlRCJCRiDgDBEq6M31Nm529hNEZSiRKxoLmiQexZQzqduoulb");
        Title title = new Title();
        title.setTitles("0XDjwIqmYYjKEcDAYX7nhW5QeWJdyOT4rAlV4wgjhatpHj8iQQ");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setAlpha4("Un2w");
        language.setAlpha2("hz");
        language.setAlpha3("ntR");
        language.setAlpha4parentid(5);
        language.setLanguage("WCuJPf7zrq38pnAwdovdsNq8I8qrfXqU3dC5GEG5VGGuPGBzp1");
        language.setLanguageDescription("0Cdp5Y75TeG9cVQnfIo6srO2oFv9LmhHX482xi1uHM11X5MxFQ");
        language.setLanguageIcon("5EptUkIlTFEvFFGGXsnTXfPo4WxK1RO2bsfgzrbsRU06zuOvIz");
        language.setLanguageType("57BY8ZnriVwew4EPqgueb7LbV7GCm6tE");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("vxP5o8unTVormF2i6L3TPZsvSvo6d5EZ0IRiCB1Pk7D7GhEKCu");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        corecontacts.setNativeLastName("6Fh3b2Uy4cD0QhOjfB0PsaM5O0Hjp0s4IG49jhf4AxFfds6a3l");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setFirstName("cvDBGQHfGT0SaVc6FvVUrWiKyoySjHCN7G4PMm9NxJyrJLEYSF");
        corecontacts.setLastName("oLLEQiXRH83fF0A6Go27kUHuzkIWkofpCJ0lRpomXGcwLvgyzI");
        corecontacts.setMiddleName("CFWEaJFY8os9FsSfPGGyFu1m2cb5Up1sipYkbunlM0eWoil9Cd");
        corecontacts.setNativeMiddleName("JQSaUoPIBtsnjwTvnHrj8fyQi4YLcjxMG3uyZclpn1FFtADJBI");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("odfgLJXVYR8Wo5hOZntbE8MWsug9lGAhXghsEHUuDSqTs6oDof");
        corecontacts.setNativeFirstName("C1KD59xQmoOvGzEkc7nF0h5kN8NbCdvdFCq3iHsTviZ9QFIvcc");
        corecontacts.setAge(98);
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459427354031l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459427354031l));
        corecontacts.setPhoneNumber("2FGqduaIfDGVlD9VSJ4A");
        corecontacts.setNativeTitle("rZ3AeVky2KVq6j0oDD9JUs1cQZyAoohfkwftQQW95M4aVoNyiL");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLongitude("hXrC5a1CSByDO0OuI10FCdpMFm8sX7RBQMJTRgLjSrD6kIZQuo");
        address.setAddress1("xdjAyCew503SNpmlmPlJ9nrseCeJbPoMGKTkCqlZIb5TRUU73w");
        Country country = new Country();
        country.setCountryCode1("dNF");
        country.setCountryName("8QBtCBIuvObGIIY4quO5cn5qP1p6z17H7dRxNOErBzxWrPglDi");
        country.setCurrencySymbol("iGDYhavDVgvIEEm2Owllt6N3BovH9HHo");
        country.setCapitalLongitude(6);
        country.setCountryCode2("WUP");
        country.setCountryFlag("tkrQmfoOQk2XIjMpgqFhh7uiZASETn4OquK8hV3aAAzV5LzB1R");
        country.setCapital("bTchGkz5V4KZ6Vb8esAhO5tg010nLvhE");
        country.setIsoNumeric(378);
        country.setCapitalLatitude(7);
        country.setCurrencyName("WP7mnyb39rPM6NrjfEv4tuKXrzcxAcnZ2xCujY0VwVDU2aa5k0");
        country.setCurrencyCode("hL1");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateName("2PgXnr0YsStMkT0HZ4NydrT5WMfW2EwiOE3bksL0K5EiJ9UUDt");
        state.setStateName("hghL0qaefAQ4jFRjuYlAtSYlRSkwovo2JQcyQTn4B9Yl9btr1V");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateFlag("1xa8GZBHtwzRdlLdRfU4ncmBlOp6Q8MOmyx4LOOQKLxoO8d8SZ");
        state.setStateCodeChar3("hz2LgpG0y1Dudu8i0oCW8JZKodEZzrWW");
        state.setStateCapital("6YWdMUlaIji2Amid4f9jHSqgPoudJlmuHQgmcd60Ew7Cjrh8ED");
        state.setStateCode(2);
        state.setStateDescription("s5yuIedNH4j5MABfpgSflD84sQeKVUbAwQwp8IVAY4Q0ss0PjY");
        state.setStateCapitalLongitude(5);
        state.setStateCapitalLatitude(2);
        state.setStateCodeChar2("uI4ejAOZq1kWyUXXCLER0LcuNPfSqyeC");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityLongitude(10);
        city.setCityFlag("ytx5HnSxEtM7TJ9d3GWuuHjiC5eKUnlaYnjBF9cm8zDVhWZ1TN");
        city.setCityDescription("0JEwxmUJTuuuy1JhWjWdjnnUZakRgxAcGFYkWdQNio20fHXeFv");
        city.setCityCodeChar2("LXTk3ZfjlGgPoa61L1m5yya034XiHHXe");
        city.setCityCode(2);
        city.setCityLatitude(11);
        city.setCityLongitude(1);
        city.setCityFlag("dqUHASBvBL1Jcy9jojtq7FoK0lxD1icPtW1AnYA9nMuWmllqgt");
        city.setCityDescription("9rrjse4KT0hmD2qs3I2ZFAPQRTrjFN1NLiI9Ta85vNgS3kN9k3");
        city.setCityCodeChar2("YhkYAsGRj1sDILLXEnGujbWNa5ccRTeN");
        city.setCityCode(3);
        city.setCityLatitude(3);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("xm2Dl4pGF9KE8pvj72vKWSjIOscxts0zJoc8t9OCllGYsDqWTJ");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("pSL2YV9HUVCCI1D2o4jIFhDY0QMWtMFnp3IJPoGMZPZ4V2ykQT");
        addresstype.setAddressTypeIcon("9k9RyMLAp6pa1uYuhpS6njahhfsWgG6hVxwd8ko4m2O0puXLKE");
        addresstype.setAddressType("hNvR0vqTdjlj7NYZTT3Fvt775HwWJjUCqQw2u8Uft0JzfselY7");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setLongitude("iCZoYWirCuHxg5kkzbV8wuXXYzrEqOFkF7XIsd6tvS3q6shwEa");
        address.setAddress1("PTXFtIDOPR6qlKorTqAMOcMqtHXHIhaE9vap7iWLfilvkjDYBC");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("a6PaACBfO1inyZcycM5INjX3xbp0CKO7IyVJvxBLHw2Wq5aIwW");
        address.setLatitude("aLajZz9Im0jeof21MqHqkfpwE474RxpbAhnfNsExdAj8vXuZph");
        address.setAddress3("sKGI0UIJmmxoyztl2yb03SalyyzqbQ6FuC5TD017PZPvHn1XbU");
        address.setAddressLabel("HigwREmSeX6");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("ybsr0F");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("eI7wp1DUlsH3wMxA5PvIBfVkhZCpwtEKPPPNGMVFa96I7ZdaQ7");
        communicationtype.setCommTypeName("fzESVkV6yqSDhXndvWaPzj6SQT9LxzIByFOmLnGkv09GktydX1");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("kt9MAB17CLJnLMBAIXnlLwttgp9qLKZecIm2tPS4lJu0yZUtx4");
        communicationgroup.setCommGroupName("TyXZFN0Bodl8Nl73gO6BEGJzZj2uh6v6Eas0ZWhPbnZF0o5ueW");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeDescription("PrNGclPEjszusxjcqexlt6Nrq4Ye4TyOujIZunNLIr5BTTBG1P");
        communicationtype.setCommTypeName("nXmTHC1cYaMfAyndvdB63wecnd9vDFjnXAx1cyBqhgyVxaI0Bi");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("nsldNxLh2BcZZvnnD4RjNR6CQSMgaFRqfYtv0Z5P34GcZ1xxCi");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        CoreContacts CoreContactsTest = new CoreContacts();
        if (isSave) {
            CoreContactsTest = corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        }
        AppCustomer appcustomer = new AppCustomer();
        appcustomer.setCustomerName("OcdMpLYEBra8cVsebuXlPjvpsJrEJ4WIW50ic6JnVLTr5bi7Do");
        appcustomer.setAppCustomerCategory((java.lang.String) AppCustomerCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        appcustomer.setCustomerStatus(1);
        appcustomer.setAppCustomerType((java.lang.String) AppCustomerTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        appcustomer.setDeploymentModel(true);
        appcustomer.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
        appcustomer.setEvalTimePeriod(2147483647);
        appcustomer.setUserRequested(2147483647);
        appcustomer.setEntityValidator(entityValidator);
        return appcustomer;
    }

    @Test
    public void test1Save() {
        try {
            AppCustomer appcustomer = createAppCustomer(true);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appcustomer.isValid();
            appcustomerRepository.save(appcustomer);
            map.put("AppCustomerPrimaryKey", appcustomer._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppCustomerCategoryRepository<AppCustomerCategory> appcustomercategoryRepository;

    @Autowired
    private AppCustomerTypeRepository<AppCustomerType> appcustomertypeRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            AppCustomer appcustomer = appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
            appcustomer.setCustomerName("fsKhe8wpFvfO5U5UEEZAr9wvd7vGJbYkYX1kylG97BlVt4Vblp");
            appcustomer.setCustomerStatus(1);
            appcustomer.setVersionId(1);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appcustomerRepository.update(appcustomer);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerCategory() {
        try {
            java.util.List<AppCustomer> listofappCustomerCategory = appcustomerRepository.findByAppCustomerCategory((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
            if (listofappCustomerCategory.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerType() {
        try {
            java.util.List<AppCustomer> listofappCustomerType = appcustomerRepository.findByAppCustomerType((java.lang.String) map.get("AppCustomerTypePrimaryKey"));
            if (listofappCustomerType.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<AppCustomer> listofcontactId = appcustomerRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.delete((java.lang.String) map.get("AppCustomerPrimaryKey")); /* Deleting refrenced data */
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
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            appcustomertypeRepository.delete((java.lang.String) map.get("AppCustomerTypePrimaryKey")); /* Deleting refrenced data */
            appcustomercategoryRepository.delete((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppCustomer(EntityTestCriteria contraints, AppCustomer appcustomer) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            appcustomer.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appcustomer.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appcustomer.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appcustomerRepository.save(appcustomer);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "customerName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "customerName", "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"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "deploymentModel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "deploymentModel", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "customerStatus", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "customerStatus", 2));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 7, "userRequested", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "evalTimePeriod", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppCustomer appcustomer = createAppCustomer(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appcustomer.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appcustomer, null);
                        validateAppCustomer(contraints, appcustomer);
                        failureCount++;
                        break;
                    case 2:
                        appcustomer.setCustomerName(contraints.getNegativeValue().toString());
                        validateAppCustomer(contraints, appcustomer);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(appcustomer, null);
                        validateAppCustomer(contraints, appcustomer);
                        failureCount++;
                        break;
                    case 4:
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(appcustomer, null);
                        validateAppCustomer(contraints, appcustomer);
                        failureCount++;
                        break;
                    case 6:
                        appcustomer.setCustomerStatus(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppCustomer(contraints, appcustomer);
                        failureCount++;
                        break;
                    case 7:
                        field.setAccessible(true);
                        field.set(appcustomer, null);
                        validateAppCustomer(contraints, appcustomer);
                        failureCount++;
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appcustomer, null);
                        validateAppCustomer(contraints, appcustomer);
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
