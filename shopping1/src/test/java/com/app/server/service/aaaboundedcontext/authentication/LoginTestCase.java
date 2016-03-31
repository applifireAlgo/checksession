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
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459427340897l));
        user.setIsLocked(1);
        user.setUserAccessCode(9);
        user.setGenTempOneTimePassword(1);
        user.setPasswordAlgo("FMX2JIkqwmI5TqbcB2oU9P3RHw4QAMYtPxWWLDKY77mIfYKq9W");
        user.setChangePasswordNextLogin(1);
        user.setIsDeleted(1);
        user.setSessionTimeout(3428);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainDescription("rhQH3Nlj74fosHXC0eiR0ahfQCaGWhk5Kakj11V4ZL7ETVOZvZ");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainIcon("boGGOgUxJHtq6iZSeuXq0LgSkKuylqSeq2IB3enRP3flgOVFro");
        useraccessdomain.setDomainHelp("8R2hq1xmzOD0x2V17qY2gdNKM4WhJpE1WKlh2s3i4B3OFG3dgV");
        useraccessdomain.setDomainName("hqYJXvNakKdZsNfjggTGfL43fdtBpbLMcj9MyouAP1AYVmAdYC");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("3PMNUEy8Xlal8u6EP9IHqhPKnXtNKm5mNiYc0TeddNvx8jhYZG");
        useraccesslevel.setLevelDescription("giZBVQAunAxK6XNDyOkpb7SglnJbCrqAlDTWV79UdxRlmSle43");
        useraccesslevel.setLevelIcon("YBc9RyNXZHt0GWsk7ekiDssYn6TG5q5QTgjOcMADL3iMI84KbS");
        useraccesslevel.setLevelName("Ez52yd9wM29kDJaiZTiDLjOhqcXhOdSzPRFTMRdyfZjkFw1nW2");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459427340956l));
        user.setIsLocked(1);
        user.setUserAccessCode(5);
        user.setGenTempOneTimePassword(1);
        user.setPasswordAlgo("JUJ5Az8nVoIiEVqvNxIS3OBM1bOSpSImMIzNe0m7wBI9rMG24X");
        user.setChangePasswordNextLogin(1);
        user.setIsDeleted(1);
        user.setSessionTimeout(2423);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setMultiFactorAuthEnabled(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459427341159l));
        user.setAllowMultipleLogin(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionIcon("pS15CPdGRgcavybwQNqhwwvHUyzwQ6jT8TvGfSXfI1weHjNZnB");
        question.setLevelid(11);
        question.setQuestionDetails("fp1tJ4VEop");
        question.setQuestion("Frz1UdJX6yKjvHUX8GKcSBwhfsSAcIuz3rgjs9veZimtDsuScT");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setUser(user);
        passrecovery.setAnswer("ybXA0edRrC7d9KrDZCeaFW39FVOJ4FwMqpTAPaI6KADosn6Puc");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setUser(user);
        userdata.setPassword("O96PIcw00F3asiuNgHtxfVE5Mkl6U1FhzGZpQfEv2YBUcAm4dl");
        userdata.setOneTimePasswordExpiry(8);
        userdata.setLast5Passwords("mvnw7u1rOMdaPfFIEvOIZy9XeaycPbZTE9joWG9mRdkGROLftD");
        userdata.setOneTimePassword("q2t9ldpP2ai2Acqve3BmXTwj1knnMHBG");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459427341869l));
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeLastName("92YCRLzTjCtaFpJcIIydTDZhsl0y2dPTDUYemSz7yKDw2dAgvt");
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("PI9DvHZZmJ79WsAQpt2oaccpwt5Sp0No269yIUqvaLIkrBbB70");
        timezone.setUtcdifference(1);
        timezone.setCities("iUOAt8sEbsAPvoYL9q8ThpuufiFfG3WwWsK4YJeIyZpG1NG6AV");
        timezone.setCountry("ueiRrNUaGiASp1HPPTdXkqNGmt4cEYxQsAEFGdKkDJ7dKEMmQA");
        timezone.setGmtLabel("wWZVh7j0opeZZiRDMGtMHs7mg178ny79nIMg1OjBOkJqZ3Bbsq");
        Title title = new Title();
        title.setTitles("08Ye4hnUafXBrpKsVZZkcuFtQQEAAvaAUpCdrHe02dcKbC2MS9");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Language language = new Language();
        language.setAlpha4("0cxK");
        language.setAlpha2("x6");
        language.setAlpha3("Ymx");
        language.setAlpha4parentid(1);
        language.setLanguage("rjobSQvE4Jnrscmz8zNCZEkneon84KstEJBTyWUTuoR7h0Sjjb");
        language.setLanguageDescription("AlyeQVrxVJSh43GIrSwqAdf9bFr1osRmg5O4rCCVJ8ClfjJIjK");
        language.setLanguageIcon("YN7L7MynyfnMHy531HpYbLDoxnnO04rkWFvdOXoCAhb6Hgoqi4");
        language.setLanguageType("jfjzQAyFicym9p7GG4IHTKlddpITrYGI");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("ns9cdeqqq0GOD6DXvHgqV1gLiRPhPsuwLKHiHEIRBX2hDtwBhU");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        corecontacts.setNativeLastName("xPLBZ78XgcRMm0H8oUUTa6JvOEyaZrE0NLp87Jyl0k2R9CdEh4");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setFirstName("fxt4wJoPql2dAEAx7aBLkQ2tmgs828SypPRoknDgN5YItCDxDD");
        corecontacts.setLastName("CUzcGrdc8wR0v6X7gzGShMyINRdt8LagsQOfM9YgUpTIcmrBJb");
        corecontacts.setMiddleName("CQ4i4qNopzYjDI0RFvgZKJI9kT3NK25OuKoZsY8b5U4Oj5iZdx");
        corecontacts.setNativeMiddleName("Axk83pcxMnLNdOsAZqYxEOSCQNQ0jKjseAPJ5Y0TLRYO4BqQNc");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("YAeVmBcrNlMTgIaHSZWbvBtRHOQou5RF5YpmNPeQ89VuejGPRm");
        corecontacts.setNativeFirstName("pwdXlx0cawXVr4DXKrUySkTB4yDg7OVozhg3DZ9dLIZJi5HpbK");
        corecontacts.setAge(50);
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459427342463l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459427342463l));
        corecontacts.setPhoneNumber("eZ0Vp37BTQkOs8FBaJYr");
        corecontacts.setNativeTitle("i1ElB3KXUoLNoEIGiyRoeYm0DyRgM003Eg5yx4BWwiWvdMNnoq");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLongitude("UxTvTpVu63TNH1n4s6qESwnj1ZueYluN5lZ4rF8FFtRPBgdmYK");
        address.setAddress1("AAlKc9jGKfsGBv529LraM3oNO5j05pGNqikUxwyhfNIiYQ2F5v");
        Country country = new Country();
        country.setCountryCode1("9qF");
        country.setCountryName("YzR9CePwODxURraqrTeTMUn03WNaXxROW7LPpOiT4RSBCK3lcB");
        country.setCurrencySymbol("L3nXur491sYB6rt7FhgYWfn8K7gKASHG");
        country.setCapitalLongitude(1);
        country.setCountryCode2("a0r");
        country.setCountryFlag("FDCJU3i1Lb2J0y5zbmL6D8vgMtNBuKZpvScOm6q438q46vtgyB");
        country.setCapital("XqnTwKWQ91tlxuh95g7fk2w5FecFF2u3");
        country.setIsoNumeric(328);
        country.setCapitalLatitude(11);
        country.setCurrencyName("7LpUwAKJxlMRlCZ0gazzZkfgAzFUxeJpTuHAA5tALLQZXoURY4");
        country.setCurrencyCode("GWH");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateName("eA9x2WytOlWLEkG4hJZSCyhodAGceExyAbMa4lsYaiefNVP6iC");
        state.setStateName("oETb8kA2v9kJwajWO6JG543uF8L0gaqyE9BZQFtmESS5Eh6xSp");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateFlag("RxVbXeDBbs6KfZiR8fi7wCnRmVNeLdi68FK23ZwoiM8fnS8yOe");
        state.setStateCodeChar3("6A1PcxHcyp4DLRaCxBNK39G8h3GmHFuC");
        state.setStateCapital("nbsOXBxvsILEjbN8H5XXfTylIkE332ZESYoMq3rT8btejVoaDv");
        state.setStateCode(1);
        state.setStateDescription("ioe6kQYnjnLgIR8ZvipNksXo1l9d4RRHkrBvEBBXrazcnZcEKH");
        state.setStateCapitalLongitude(10);
        state.setStateCapitalLatitude(9);
        state.setStateCodeChar2("FuWemlhhMAPS0RCzhX2f4SuaA5Gx997I");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityLongitude(3);
        city.setCityFlag("uaidqbRZq1TGkeJTw6iRll3mIISIeb49HWhvgcGm5blZA8z8Tr");
        city.setCityDescription("SHOIwFBr7CUqWG0n3NNAcJZjaZEl2K2L6acvlvdJowMypeSRWK");
        city.setCityCodeChar2("4zHCqLvxfBUXhLGlFUHFOPYX1NgYD9HI");
        city.setCityCode(3);
        city.setCityLatitude(6);
        city.setCityLongitude(10);
        city.setCityFlag("WT5bcoO924gfkGkJvGWmQ8NRCxOix1l4nl4UFaBrYuDEIdr97l");
        city.setCityDescription("05nXihzi03WDY0yFon5V1hW11ZjfLfeFzuTQH6fD7UxN6PJDjx");
        city.setCityCodeChar2("CnDoN8IPoCl3NMFr8o37AQiKtJgIrrFB");
        city.setCityCode(1);
        city.setCityLatitude(6);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("sQh7k7CYVhs69saukArchNnB4GZ4cJ6BnzAJgAicjJQTB85eyR");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeDesc("NStKBetwqSpafkjS3IvAAHDwHFs2eOJBx2XjEeSGAp2usSVDqJ");
        addresstype.setAddressTypeIcon("xUafpbNnlRoTyVXbdvEIkuqXPwlMBgHQkf4cPkHDTB3wmenOvP");
        addresstype.setAddressType("NySYPbMQJS97pqjMQxO5FeCactz1wWTZaMlEwTxsGkSUscU20J");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setLongitude("uttr0ebvI20IoLGHD5gIla3zfOQJJHBQgGbtFs7mu2oBa3mTTP");
        address.setAddress1("zD68JpWizl9gcxeFiH5kqzGFrKPTNFWlLaPyCi3TNdEJGuPvCg");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("rksFo12IvwVEaJeI8yCMVtkReZmlGHaybgSJvikW3mgGPJZUBF");
        address.setLatitude("rZ7VD3YaA3VXj7M2S3I33LkyR9Mf9a5dgo0dKaiDurlD1jNRPW");
        address.setAddress3("z2TWWxjXrAwj68DhrlBekpSoYRTR2EgisjXCm4MiSSnmEtdarJ");
        address.setAddressLabel("OLUw78wtTci");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("eQGSCf");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("R0vlVo7NUvvvNp4r22ssxrvj8ALfju5VqH2p3kBLrppwcU7cBu");
        communicationtype.setCommTypeName("KplTn9cUQcuZYwzUGo6rEFe9OdQ3T9BkKGPqenFB1RJSbWHXkW");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("cZ9JSjmkgfvdoue1F7JRf8KNW1pwoC2VIthnrbZQ7hlvY8WVU9");
        communicationgroup.setCommGroupName("sVP8r6tjVFajk9xmjuVXxwOM0C9PCkMahrYnlvvWq7YgE2rcgZ");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeDescription("un6LIvtOn1so9gKcnl2AoP1tN42eBw2UYhjuGTNHNiIKdJFtZd");
        communicationtype.setCommTypeName("D6vOwpaGzqGf74ypPQFJmmCDkOKWx0Fk778A3r4p7UgdGbK0uN");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("s96VjnnoG4UQx6tRveNYIu9uQC0ee2txE608ayczQrGN8y3otv");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        Login login = new Login();
        user.setUserId(null);
        login.setUser(user);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setLoginId("aZmPSYmYKW6mPqhlQpVQGY8Zem1Qwqel2bNz1FEXWGgCeP7T8Y");
        login.setServerAuthText("11c3PacDidxS3qoH");
        login.setIsAuthenticated(true);
        login.setServerAuthImage("I5BvkEba1B7RxV7QczbWhxlkuRMVmJOf");
        login.setFailedLoginAttempts(8);
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
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setLoginId("gv8ciKp7LXts9LTdewCbuEjMmr2BA2Cr9AOLgvY1iz4uTfyZE2");
            login.setVersionId(1);
            login.setServerAuthText("VPzsgMHH0vMJii26");
            login.setServerAuthImage("UDcV2XEaLM20NdIRjdnaQkmZfBoNx1Wx");
            login.setFailedLoginAttempts(8);
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
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "jjWjNK1a3XpdiSbdSgH5fq6jaqX7faIpbRBMnaO3hRiXrUb4kcuqm3KX33Y4QrGvA1lrZHPd0SOIMFeyRXa4vXtZH5slEWs3sHe8fpuC3RsDRswzNci0K72ZLZ4LLQGiuwV8vxwaF9hQMChPpKpNJQzteX0Zqq5KJBxQpLVHS8w9vT22nmLiKgiFBxM5ieD91xwjtrjDf"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "3vhH7PbaslYS5LrZHNxx4G9e7hFi3XOzR"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "O8qdR07k40VzLdO8C"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 17));
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
