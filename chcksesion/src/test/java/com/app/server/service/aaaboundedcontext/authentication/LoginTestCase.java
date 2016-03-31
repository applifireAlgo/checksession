package com.app.server.service.aaaboundedcontext.authentication;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import com.app.shared.aaaboundedcontext.authentication.Login;
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
import com.app.shared.aaaboundedcontext.authentication.User;
import com.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.app.shared.aaaboundedcontext.authentication.Question;
import com.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.app.shared.aaaboundedcontext.authentication.UserData;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
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
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

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

    private Login createLogin(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        User user = new User();
        user.setChangePasswordNextLogin(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("WW0gBmk8OEKbOTpXGwQexjQjQ001GukyNg5i6vLuPklmNncQrc");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainIcon("iphwbTyJR4pb3tDqXUAyfwVxTaxTWrl5fYqsOLOH6QfZRrBuGE");
        useraccessdomain.setDomainName("N0xYr9jEMdousjfyTAivOhNfVjCaTd212P4u1xU19zOvon0LzW");
        useraccessdomain.setDomainHelp("XdXciIFK4IWuHQ5ZAdxTwVnvijtQBKevHAfD9cVPuG6ZLhzwr5");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelDescription("aFH9vzLGrbRquFdS1m6ZkL2Erp9vdiuWe7kVVzIMilc2wNX0SW");
        useraccesslevel.setLevelIcon("xujipuT2jjUVWFaTYchWpkGJUgd9hSUMcfpJxVY4wOthTIoCON");
        useraccesslevel.setLevelHelp("mwSMVpx5CqU0nRfZcc2N9Zx8frNtMYcjbr963Mzi37rX34y7N9");
        useraccesslevel.setLevelName("jIgF2cfvxHQQyozBdaUwWR5q2nWsmCgTKJs3EJsDtggVHB5YJI");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setChangePasswordNextLogin(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordAlgo("7hlxdJJawZrb90sA1rDNLQpEGwSxFFj1GtrUaB5Mx6YIBXd3re");
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459343752354l));
        user.setIsLocked(1);
        user.setSessionTimeout(441);
        user.setAllowMultipleLogin(1);
        user.setMultiFactorAuthEnabled(1);
        user.setUserAccessCode(57429);
        user.setIsDeleted(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459343752355l));
        user.setGenTempOneTimePassword(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionIcon("thZKcEYgMqro5a4ieJC2gRECizmT7yPFWirWfWjlD9GnCh5mwZ");
        question.setLevelid(3);
        question.setQuestion("9UvWkLd7MsfqzX8mFo4q1wrrtMGG8Yp1CvZGxEllq8GbIStkwd");
        question.setQuestionDetails("Rfp2TVrzRp");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        passrecovery.setUser(user);
        passrecovery.setAnswer("VdV02trt2bPqXU2PgLi9qQ3lRI17o91KbbGGw6MdCNQhKGB1Yk");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordExpiry(4);
        userdata.setOneTimePassword("SJQXqEfxMz9wSE9qn9b0JutWSgogGfm9");
        userdata.setPassword("c9OHxU2r3eVgwe5BeePwDeu8kuNkBoUug67fodyToUVfr6xGKi");
        userdata.setOneTimePasswordExpiry(11);
        userdata.setOneTimePassword("E4nEtw5WfaLkeo0QgJlaUoafxTpCTeES");
        userdata.setPassword("riOfMALqvYbfAN3uclRgrrFZJxisX0EZJWSG79QoHBQ9iINrO2");
        userdata.setUser(user);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459343754199l));
        userdata.setLast5Passwords("hNtp6fMV2gdaJpHsmbMxPlHtdK03zNZs7v2oruMpHRfDYXTZg2");
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setPhoneNumber("8bdZTN0D3LZEcFoPUg0Q");
        corecontacts.setNativeFirstName("ACRjYmqc4NqQ3brSLzTWJOsQ0G7HhCrgirscRVq5igQA5tpcEP");
        corecontacts.setMiddleName("4dwkyKKaKfcUbzb6JGWsEUPQqvwaCeNieSfXJhsghozzuzGtAd");
        corecontacts.setNativeMiddleName("NFbJKJMsbIG6c0IVIAqrTc2kei2GhUWT7oji2aUyzqDpFn05Wp");
        Language language = new Language();
        language.setAlpha4parentid(2);
        language.setLanguageType("wAzLnjKjJf3KSb32bwFBmATBQHd3heTF");
        language.setLanguageIcon("c5aG2xfloH5ldLALG1s3Tw7sQscxSaD18DdleiYwfEfhdKEPys");
        language.setAlpha2("wI");
        language.setAlpha3("XRM");
        language.setLanguage("GZG3llJdJsPgzNGMJNecJqoBRYYmLmKDmriYC9q7fP9yCpTTnn");
        language.setAlpha4("Egtr");
        language.setLanguageDescription("YNzZ5eqF9iH3YL5kENGBTuA4LxWuG9tY0vrkf73iJm3tecJYj7");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("Xve6AXXATjRSTMmWZiqlXoQi6AGxboSEmNQd0NthXynmJOw8Lv");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("YoWV5ZhQOhmFnDylrTeaIem5dJZHuwp2OX4mL0eIOyx6YNhfoX");
        timezone.setCountry("w084byuOkelW9wX3aYx42FWBNQ2q4U1zEnFFoxLK7VPSfcOJL2");
        timezone.setUtcdifference(6);
        timezone.setCities("1NNLevHW7AhnvBYaHxAbnT9LlSSWFr6fENDfXWvL0uQwNym5Zq");
        timezone.setGmtLabel("0yQNty09JsXB2ifNNbWjMiVgP1hlDpXzE5RBVBwgosa2T3GLDK");
        Gender gender = new Gender();
        gender.setGender("Omhzt1cttCxVOoSgkxBbxMzpNc3E89SH2He2OhwINYfpzZ5woX");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        corecontacts.setPhoneNumber("emSJC1tEGIo1NFgTwESP");
        corecontacts.setNativeFirstName("bMGvkKdTyubfz3cqvrglNxwGxzeZcdgoHbxIK1QunqtheCwqqq");
        corecontacts.setMiddleName("xyfvRhnc08gL779ZjmIHrn38MiNzN8Bf1pNWVnCYCb4xlQMvCm");
        corecontacts.setNativeMiddleName("ateA0Qrlrbk8IjmITdQYC7vDKJrqe83fwwstlmIepP418lxDzy");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("b1FQ9tKVjdK9alMiuszjE4BQpY2wef26j9PgHQp8fzERGSOu3k");
        corecontacts.setEmailId("mWVNw2qeSQOnNeRknFd0cBO1A6FCcLdjsFvJ5G5QHtvNPizy0n");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459343755284l));
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(99);
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459343755862l));
        corecontacts.setNativeLastName("nvturPnUmikBtP8bVqUJ5lxYiRjarVd6wk8vsPmLk2lMxmber4");
        corecontacts.setNativeTitle("1Z2uoqfQN4u7EmvEwGDeMIQ87vXEIECsO4XoXA5lxBbd0wX2uD");
        corecontacts.setLastName("jpavC6q304IN0fsvm7bKpHbN51TYNRqvUN8CMqZX0xEEsFMvZB");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLatitude("RIu7rCIaIL9MxoQy5WxStdpkcWBqPEjfPxT3ECvZi72Jf4anU1");
        Country country = new Country();
        country.setCapitalLatitude(6);
        country.setCurrencySymbol("o1M68tVjQK5Pxo1tBqwzZmJyHVwoBZgl");
        country.setCapitalLongitude(8);
        country.setCapital("InVAzFfYNfB3q0XoPWxFPAao3m3rynGC");
        country.setCountryFlag("UG0ykCl2V34qpWSaZAYFrRnKuP8omA7ONlBcUQCIjhHEaK3J7g");
        country.setCurrencyCode("5VM");
        country.setCountryCode2("Wun");
        country.setCountryCode1("kMT");
        country.setCountryName("DurgXo6kreQTqpS6nEVPdCWeyF5SaJwx95A07BFcPev2YF39T9");
        country.setCurrencyName("C2awBEOBcgSPEJ08MWDThBJrzoJTTXyzJNPxZbmNPIDY8DQzLP");
        country.setIsoNumeric(548);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("9525bI4XwAZ0d4ZLb4VoXSUtZhm3c40mh2jgO0UgNgAaVKvS1g");
        addresstype.setAddressTypeIcon("0WCN6pQeRuGdJvC3ici3xuVCK9PxbWRdS0GvNTeUP99bi0PpnV");
        addresstype.setAddressTypeDesc("IdbRdg4nVdZekKYAp5SssyDN7pegOWUQirMmws1wxKQIpyjeX0");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        State state = new State();
        state.setStateCode(1);
        state.setStateFlag("8HEsh1yBO3XK2u5hQiEGks2Sej9z0QCbx6wuRaqsxi1lqisyzt");
        state.setStateName("2SpkVFBiAJwgPbMM6lWvrymAXQw6nOWYUsnmISOLS400mCvO9u");
        state.setStateCapital("Npso2wJ5BoGKZfpaLJNfV12cs6jUlJS9MsgNi9XlDcIkuEgxwN");
        state.setStateCode(1);
        state.setStateFlag("JxskxMm2L4rY1C5lHD6w3mOQxf6Mg5xlhqsp9umahG0iiZR8SO");
        state.setStateName("RMCAqiEOr0GuIQv5rxTncutg6uIuilvBwt4udib7dHy8Uszk3R");
        state.setStateCapital("DCHSyjIerPSKk1xMj5iA6DVa9KtBJYEu9vNUQ2gxx7LnJkHjz7");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("CmuoGQz58zOAYFJiasfJHEKmowghbEAq");
        state.setStateCodeChar2("HBROImkRDsfoNvXdH9PPA8QyhvFRX0Dl");
        state.setStateCapitalLatitude(8);
        state.setStateDescription("eeCD6NZ5coQvhVenY6arTLDfkoBuKX62WTp1pKczeHL58gqFPn");
        state.setStateCapitalLongitude(3);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(3);
        city.setCityFlag("BPeYku21h2FZFbmjBgczYtX2T4CKj1Ljy2tlfK94ZKkNUFKuPl");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("eq82PmE3zCtf4asCALWHTs5fGy3bA75O");
        city.setCityCode(1);
        city.setCityLatitude(8);
        city.setCityName("FkkxcXppjkcbgKIT1Fl6FROfuVo5quYoXJgMreNVGJl2qa59wq");
        city.setCityDescription("E5PMWBYhsvXgzODI9vriu7CVMxQQUcx9GEhRMTt7LCOft8sWXj");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setLatitude("TDtHrkYmkU7cgLZFndfAaRsS9bQpKBSk2VhrWpWjMDBpzoqznA");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("1YPTpIuAdnRue9Mnx3DLnaSl0puhPFfBj07mJEZ7AZAOfGeAdq");
        address.setZipcode("aeHMLk");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("tCI5LMW915AzRjzXOBrMtwP6zeDnKVziqbpSZBU5KKxGFolkgm");
        address.setAddressLabel("igeDvwFxssw");
        address.setLongitude("Cljw8KvlIZU4Q6Mf5CrSXG5Q6ns4mLBwfS6qgm73P8llLGKJrV");
        address.setAddress3("t74lVeNzEeOIIHyW1m2IMHYmaxKaP0C0pQR2wKMd9agEeWt4Cn");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("");
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("lHlNlBFOQjdWKLl4A5bf4wFTupHtXpA6D4osgPwn3XBaZ73026");
        communicationtype.setCommTypeDescription("dd7PswH2JuT02y0BRzl95l78RXsvSw73HDvTADU6YzUNTKDyuR");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("r1QxOgl29PBzciGSSQAWmDiF1WBxZEjUAle9YBQHELsK7b2AKM");
        communicationgroup.setCommGroupName("dAeZ56TPzTnR6bJ8zJTRV3uUkSVcZeQga1sx1ngcnA8IKyPWu6");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeName("4eHzgQSIRCOEFxVDBiU08FeGP1bZQhtY0tgNBXvbHaz1jk17mr");
        communicationtype.setCommTypeDescription("aALVhM2lgB7sx4ijbFKvgoYyexU2wv3qkGTM9IIsNE2Pcs1n59");
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
        Login login = new Login();
        login.setFailedLoginAttempts(7);
        login.setIsAuthenticated(true);
        login.setServerAuthImage("cCkDQmuGbeR0A0jGmdn38uB4x9sBZ6gc");
        login.setLoginId("S4SlrDEfZbXa56t8z2sp2n4LdFMS21PSbTlEIgTWw7zdI1jqKf");
        user.setUserId(null);
        login.setUser(user);
        login.setServerAuthText("9rXHWEjP2MMxUptI");
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(1);
            login.setServerAuthImage("0OYamYKazQ5xGBQiiXsjVDKfgXkj1vP5");
            login.setLoginId("b36smcB3squGjnS4aAJZueqDGlUF5ATOA4jzYtyT3d2fjJ57Ik");
            login.setVersionId(1);
            login.setServerAuthText("it3XGGL5wE7fLPbd");
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLogin(EntityTestCriteria contraints, Login login) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "fa6Jc2yW3emZSVaAP1zzzbgGLgLbe2jn4y89zTjgKoTKpl02quGgLBHcNFXP3uuXqJHWCzNA364rRi2zUQa5rc0qbzmbB89mAJME2EZXDiBuhemhf6zovOKnsun6qJ2HWFN6u54I1AOfJ3YrIogMUc0c5ECpbhqgKGWqVJxgI0kycjOHXaRt8RZNTSRkPeiAS45SJCYGX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "7bTgWOK0Zse1I4h8vYFwhwTuz8A94qzWC"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "F8sgdbI60MNbRCRUZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 13));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
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
