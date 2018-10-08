package controllers;

import models.*;
import play.Logger;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MHAHomeController extends Controller
{
    private FormFactory formFactory;

    private JPAApi jpaApi;

    @Inject
    public MHAHomeController(FormFactory formFactory, JPAApi jpaApi)
    {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }


    public Result getMHAHome()
    {
        return ok(views.html.mentalhealthmatch.render());
    }

    @Transactional
    public Result getProviderSearch()
    {
        String sql ="SELECT t FROM Title t";
        List<Title> titles = jpaApi.em().createQuery(sql,Title.class).getResultList();

        String insurancesql = "SELECT i FROM Insurance i";
        List<Insurance> insurances = jpaApi.em().createQuery(insurancesql,Insurance.class).getResultList();

        String diagnosisspl = "SELECT d FROM Diagnosis d";
        List<Diagnosis> diagnoses = jpaApi.em().createQuery(diagnosisspl,Diagnosis.class).getResultList();

        String expertisesql = "SELECT s FROM SpecialExpertise s";
        List<SpecialExpertise> expertises = jpaApi.em().createQuery(expertisesql, SpecialExpertise.class).getResultList();

        String therapysql = "SELECT t FROM Therapy t";
        List<Therapy> therapies = jpaApi.em().createQuery(therapysql, Therapy.class).getResultList();

        String languagesql = "SELECT l FROM Language l";
        List<Language> languages = jpaApi.em().createQuery(languagesql, Language.class).getResultList();

        String citysql = "SELECT DISTINCT m.city FROM MentalHealthProfessional m ORDER by m.city";
        List<String> cities= jpaApi.em().createQuery(citysql,String.class).getResultList();

        String servicessql = "SELECT s FROM Services s";
        List<Services> services = jpaApi.em().createQuery(servicessql,Services.class).getResultList();


        return ok(views.html.providersearch.render(titles, insurances, diagnoses, expertises, therapies, languages, cities, services));
    }


   /* @Transactional(readOnly = true)
    public Result getProviderSearchReturnInfo()
    {

        String sql ="SELECT m FROM MentalHealthProfessional m ";

        List<MentalHealthProfessional> name = jpaApi.em().createQuery(sql,MentalHealthProfessional.class).getResultList();



        return ok(views.html.providersearchreturnpage.render(name));
    }


        /*public Result postReturnInfo()
    {
       //return ok(views.html.providersearchreturnpage.render());
    }*/
    @Transactional
    public Result getProviderInfo()


    {
        DynamicForm form = formFactory.form().bindFromRequest();

        String title = form.get("title");


        String sql ="SELECT t FROM Title t";
        List<Title> titles = jpaApi.em().createQuery(sql,Title.class).getResultList();

        String insurancesql = "SELECT i FROM Insurance i";
        List<Insurance> insurances = jpaApi.em().createQuery(insurancesql,Insurance.class).getResultList();

        String diagnosisspl = "SELECT d FROM Diagnosis d";
        List<Diagnosis> diagnoses = jpaApi.em().createQuery(diagnosisspl,Diagnosis.class).getResultList();

        String expertisesql = "SELECT s FROM SpecialExpertise s";
        List<SpecialExpertise> expertises = jpaApi.em().createQuery(expertisesql, SpecialExpertise.class).getResultList();

        String therapysql = "SELECT t FROM Therapy t";
        List<Therapy> therapies = jpaApi.em().createQuery(therapysql, Therapy.class).getResultList();

        String languagesql = "SELECT l FROM Language l";
        List<Language> languages = jpaApi.em().createQuery(languagesql, Language.class).getResultList();

        String mhpsql = "SELECT m FROM MentalHealthProfessional m";
        List<MentalHealthProfessional> cities= jpaApi.em().createQuery(mhpsql,MentalHealthProfessional.class).getResultList();

        String organizationsql = "SELECT o FROM Organization o";
        List<Organization> organizations =  jpaApi.em().createQuery(organizationsql,Organization.class).getResultList();

        String suffixsql = "SELECT s FROM Suffix s";
        List<Suffix>suffixes = jpaApi.em().createQuery(suffixsql,Suffix.class).getResultList();

        String servicessql = "SELECT s FROM Services s";
        List<Services> services = jpaApi.em().createQuery(servicessql,Services.class).getResultList();

        return ok(views.html.iamaprovider.render(titles,cities,insurances,diagnoses,expertises,therapies,languages, organizations, suffixes, services));
    }

    @Transactional
    public Result postProviderInfo()
    {
        String sql ="SELECT t FROM Title t";
        List<Title> titles = jpaApi.em().createQuery(sql,Title.class).getResultList();

        String insurancesql = "SELECT i FROM Insurance i";
        List<Insurance> insurances = jpaApi.em().createQuery(insurancesql,Insurance.class).getResultList();

        String diagnosisspl = "SELECT d FROM Diagnosis d";
        List<Diagnosis> diagnoses = jpaApi.em().createQuery(diagnosisspl,Diagnosis.class).getResultList();

        String expertisesql = "SELECT s FROM SpecialExpertise s";
        List<SpecialExpertise> expertises = jpaApi.em().createQuery(expertisesql, SpecialExpertise.class).getResultList();

        String therapysql = "SELECT t FROM Therapy t";
        List<Therapy> therapies = jpaApi.em().createQuery(therapysql, Therapy.class).getResultList();

        String languagesql = "SELECT l FROM Language l";
        List<Language> languages = jpaApi.em().createQuery(languagesql, Language.class).getResultList();

        String mhpsql = "SELECT m FROM MentalHealthProfessional m";
        List<MentalHealthProfessional> cities= jpaApi.em().createQuery(mhpsql,MentalHealthProfessional.class).getResultList();

        String organizationsql = "SELECT o FROM Organization o";
        List<Organization> organizations= jpaApi.em().createQuery(organizationsql,Organization.class).getResultList();

        String  suffixsql = "SELECT s FROM Suffix s";
        List<Suffix>suffixes = jpaApi.em().createQuery(suffixsql,Suffix.class).getResultList();

        String servicessql = "SELECT s FROM Services s";
        List<Services> services = jpaApi.em().createQuery(servicessql,Services.class).getResultList();

        DynamicForm form = formFactory.form().bindFromRequest();
        Map<String, String[]> map = request().body().asFormUrlEncoded();

        String firstName = form.get("firstname");
        String lastName = form.get("lastname");

        String suffixIdText = form.get("suffix");
        Integer suffixId;

        if(suffixIdText == null || suffixIdText.equals(""))
        {
            suffixId = null;
        }
        else
        {
            suffixId = Integer.parseInt(suffixIdText);
        }

        String address = form.get("address");

        String city = form.get("city");

        String stateId = form.get("state");

        String phone = form.get("phonenumber");

        String organizationIdText = form.get("organization");
        Integer organizationId;

        if(organizationIdText == null || organizationIdText.equals(""))
        {
            organizationId = null;
        }
        else
        {
            organizationId = Integer.parseInt(organizationIdText);
        }


        String minPatientAgeText = form.get("minage");
        Integer minPatientAge ;

        if(minPatientAgeText == null || minPatientAgeText.equals(""))
        {
            minPatientAge = null;
        }
        else
        {
            minPatientAge = Integer.parseInt(minPatientAgeText);
        }

        String maxPatientAgeText = form.get("maxage");
        Integer maxPatientAge ;

        if(maxPatientAgeText == null || maxPatientAgeText.equals(""))
        {
            maxPatientAge = null;
        }
        else
        {
            maxPatientAge = Integer.parseInt(maxPatientAgeText);
        }

        String zipcodeText = form.get("zipcode");
        Integer zipcode;

        if(zipcodeText == null || zipcodeText.equals(""))
        {
            zipcode = null;
        }
        else
        {
            zipcode = Integer.parseInt(zipcodeText);
        }


        String expertise = form.get("expertise");
        Integer expertiseId ;

        if(expertise == null || expertise.equals(""))
        {
            expertiseId = null;
        }
        else
        {
            expertiseId = Integer.parseInt(expertise);
        }


        String languageIdText = form.get("language");
        Integer languageId;

        if(languageIdText == null || languageIdText.equals(""))
        {
            languageId = null;
        }
        else
        {
            languageId = Integer.parseInt(languageIdText);
        }

        String titleIdText = form.get("titleId");
        Integer titleId;

        if(titleIdText == null || titleIdText.equals(""))
        {
            titleId = null;

        }
        else
        {
            titleId = Integer.parseInt(titleIdText);
        }

        MentalHealthProfessional mentalHealthProfessional = new MentalHealthProfessional();

        mentalHealthProfessional.setTitleId(titleId);
        mentalHealthProfessional.setFirstName(firstName);
        mentalHealthProfessional.setLastName(lastName);
        mentalHealthProfessional.setMinPatientAge(minPatientAge);
        mentalHealthProfessional.setMaxPatientAge(maxPatientAge);
        mentalHealthProfessional.setAddress(address);
        mentalHealthProfessional.setCity(city);
        mentalHealthProfessional.setStateId(stateId);
        mentalHealthProfessional.setZipcode(zipcode);
        mentalHealthProfessional.setPhoneNumber(phone);
        mentalHealthProfessional.setLanguageId(languageId);
        mentalHealthProfessional.setExpertiseId(expertiseId);
        mentalHealthProfessional.setOrganizationId(organizationId);
        mentalHealthProfessional.setSuffixId(suffixId);


        jpaApi.em().persist(mentalHealthProfessional);

        String[] insurance = map.get("insurance[]");
        Logger.debug("Checkbox:" + form.get("insurance[]"));

        if (insurance != null)
        {
            for (String insuranceId : insurance) {
                InsurancAccepted insuranceAccepted = new InsurancAccepted();
                insuranceAccepted.setNameId(mentalHealthProfessional.getNameId());
                insuranceAccepted.setInsuranceId(insuranceAccepted.getInsuranceId());
                insuranceAccepted.setInsuranceId(Integer.parseInt(insuranceId));
                jpaApi.em().persist(insuranceAccepted);
            }
        }
        String[] diagnosis = map.get("diagnosis[]");
        Logger.debug("Checkbox: " + form.get("diagnosis[]"));

        if (diagnosis != null)
        {
            for(String diagnosisId:diagnosis)
            {
                ProfessionalDiagnosis professionalDiagnosis = new ProfessionalDiagnosis();
                professionalDiagnosis.setNameId(mentalHealthProfessional.getNameId());
                professionalDiagnosis.setDiagnosisId(professionalDiagnosis.getDiagnosisId());
                professionalDiagnosis.setDiagnosisId(Integer.parseInt(diagnosisId));
                jpaApi.em().persist(professionalDiagnosis);
            }
        }
        String[] therapy = map.get("treatment[]");
        Logger.debug("Checkbox:" + form.get("treatment[]"));

        if(therapy != null)
        {
            for(String therapyId:therapy)
            {
                ProfessionalTherapy professionalTherapy = new ProfessionalTherapy();
                professionalTherapy.setNameId(mentalHealthProfessional.getNameId());
                professionalTherapy.setTherapyId(Integer.parseInt(therapyId));
                jpaApi.em().persist(professionalTherapy);
            }

        }
        String[] service = map.get("services[]");
        Logger.debug("Checkbox: " + form.get("services[]"));

        if (service != null)
        {
            for (String servicesId:service)
            {
                ProfessionalServices professionalServices = new ProfessionalServices();
                professionalServices.setNameId(mentalHealthProfessional.getNameId());
                professionalServices.setServicesId(professionalServices.getServicesId());
                professionalServices.setServicesId(Integer.parseInt(servicesId));
                jpaApi.em().persist(professionalServices);
            }
        }


        return ok("Your Information was Saved into the Database!");

    }

    @Transactional(readOnly = true)
    public Result getMentalHealthProfessionalDetail()
    {
        DynamicForm form = formFactory.form().bindFromRequest();

        String title = form.get("titleId");
        Integer titleId;

        if(title == null || title.equals(""))
        {
            titleId = null;


        }
        else
        {
            titleId = Integer.parseInt(title);
        }

        String location = form.get("city");

        String language = form.get("languageId");
        Integer languageId;

        if(language == null || language.equals(""))
        {
            languageId = null;


        }
        else
        {
            languageId = Integer.parseInt(language);
        }

        String expertise = form.get("expertiseId");
        Integer expertiseId;

        if(expertise == null || expertise.equals(""))
        {
            expertiseId = null;


        }
        else
        {
            expertiseId = Integer.parseInt(expertise);
        }

        Map<String, String[]> formValues = request().queryString();
        String textValues[] = formValues.get("insurance");

        List<Integer> insurance = new ArrayList<>();
        if (textValues != null)
        {
            for (String textValue : textValues)
            {
                insurance.add(Integer.parseInt(textValue));
            }
        }
        Logger.debug("Got" + insurance.size() + "insurance");

        Map<String, String[]> formValues1 = request().queryString();
        String textValues1[] = formValues1.get("services");

        List<Integer> services = new ArrayList<>();
        if(textValues1 != null)
        {
            for(String textValue1 : textValues1)
            {
                services.add(Integer.parseInt(textValue1));
            }
        }
        Logger.debug("Got" + services.size() + "services");

        Map<String, String[]>formValues2 = request().queryString();
        String textValues2[] = formValues2.get("diagnosis");

        List<Integer>diagnosis = new ArrayList<>();
        if (textValues2 != null)
        {
            for (String textValue2: textValues2)
            {
                diagnosis.add(Integer.parseInt(textValue2));
            }
        }
        Logger.debug("Got" + diagnosis.size() + "diagnosis");


        String sql ="SELECT NEW models.MentalHealthProfessionalDetail(m.nameId, t.titleId, t.titleName, m.lastName, m.firstName, m.address, m.city, m.stateId, m.zipcode, m.minPatientAge, m.maxPatientAge, s.suffixId, s.suffix, m.phoneNumber, m.languageId, l.languageName, m.expertiseId, e.expertiseName, '' || GROUP_CONCAT(i.insuranceName), '' || GROUP_CONCAT(th.therapyName), '' || GROUP_CONCAT(d.diagnosisName), '' || GROUP_CONCAT(se.servicesName)) " +
                " FROM MentalHealthProfessional m JOIN Title t ON m.titleId = t.titleId " +
                "JOIN Suffix s ON m.suffixId = s.suffixId " +
                "JOIN Language l ON m.languageId = l.languageId " +
                    "JOIN SpecialExpertise e ON m.expertiseId = e.expertiseId " +
                "LEFT OUTER JOIN InsurancAccepted ia ON m.nameId = ia.nameId " +
                "LEFT OUTER JOIN Insurance i ON ia.insuranceId = i.insuranceId " +
                "LEFT OUTER JOIN ProfessionalTherapy pt ON m.nameId = pt.nameId " +
                "LEFT OUTER JOIN Therapy th ON pt.therapyId = th.therapyId "+
                "LEFT OUTER JOIN ProfessionalDiagnosis pd ON m.nameId = pd.nameId " +
                "LEFT OUTER JOIN Diagnosis d  ON pd.diagnosisId = d.diagnosisId "+
                "LEFT OUTER JOIN ProfessionalServices ps ON m.nameId = ps.nameId " +
                "LEFT OUTER JOIN Services se  ON ps.servicesId = se.servicesId "+

                " WHERE m.titleId = :titleId AND m.languageId = :languageId AND m.expertiseId = :expertiseId  " +
                "GROUP BY m.nameId, t.titleId, t.titleName, m.lastName, m.firstName, m.address, m.city, m.stateId, m.zipcode, m.minPatientAge, m.maxPatientAge, s.suffixId, s.suffix, m.phoneNumber, m.languageId, l.languageName, m.expertiseId, e.expertiseName ";



        if (insurance.size() > 0)
        {

            sql += "AND m.nameId IN " +
                    "(SELECT i.nameId FROM InsurancAccepted i) "+
            "WHERE i.nameId IN :nameId) " ;
        }

        if (services.size() > 0)
        {
            sql +="AND m.nameId IN "+
                    "(SELECT ps.nameId FROM ProfessionalServices ps " +
                    " WHERE ps.nameId IN :nameId) ";
        }

        if (diagnosis.size() > 0)
        {
            sql += "AND m.nameId IN " +
                    " (SELECT pd.nameId FROM ProfessionalDiagnosis pd " +
                    " WHERE pd.nameId IN :nameId ";
        }


        TypedQuery mentalHealthProfessionalDetailQuery = jpaApi.em().createQuery(sql,MentalHealthProfessionalDetail.class).setParameter("titleId", titleId);

        if(languageId != null)
        {
            mentalHealthProfessionalDetailQuery.setParameter("languageId", languageId);
        }

        if (expertiseId != null)
        {
            mentalHealthProfessionalDetailQuery.setParameter("expertiseId", expertiseId);
        }


        List<MentalHealthProfessionalDetail> name = mentalHealthProfessionalDetailQuery.getResultList();


        return ok(views.html.providersearchreturnpage.render(name ));

    }

    @Transactional(readOnly = true)
    public Result getNewMentalHealthProfessional(int nameId)
    {


        String sql ="SELECT m.nameId, t.titleId, t.titleName, m.lastName, m.firstName, m.address, m.city, m.stateId, m.zipcode, m.minPatientAge, m.maxPatientAge, s.suffixId, s.suffix, m.phoneNumber, m.languageId, l.languageName, m.expertiseId, e.expertiseName, GROUP_CONCAT(DISTINCT i.insuranceName) AS insuranceName, GROUP_CONCAT(DISTINCT th.therapyName) AS therapyName, GROUP_CONCAT(DISTINCT d.diagnosisName) AS diagnosisName, GROUP_CONCAT(DISTINCT se.servicesName) AS servicesName " +
                " FROM MentalHealthProfessional m JOIN Title t ON m.titleId = t.titleId " +
                "JOIN Suffix s ON m.suffixId = s.suffixId " +
                "JOIN Language l ON m.languageId = l.languageId " +
                "JOIN SpecialExpertise e ON m.expertiseId = e.expertiseId " +
                "LEFT OUTER JOIN InsurancAccepted ia ON m.nameId = ia.nameId " +
                "LEFT OUTER JOIN Insurance i ON ia.insuranceId = i.insuranceId " +
                "LEFT OUTER JOIN ProfessionalTherapy pt ON m.nameId = pt.nameId " +
                "LEFT OUTER JOIN Therapy th ON pt.therapyId = th.therapyId "+
                "LEFT OUTER JOIN ProfessionalDiagnosis pd ON m.nameId = pd.nameId " +
                "LEFT OUTER JOIN Diagnosis d  ON pd.diagnosisId = d.diagnosisId "+
                "LEFT OUTER JOIN ProfessionalServices ps ON m.nameId = ps.nameId " +
                "LEFT OUTER JOIN Services se  ON ps.servicesId = se.servicesId "+
                " WHERE m.nameId = :nameId " +
                "GROUP BY m.nameId, t.titleId, t.titleName, m.lastName, m.firstName, m.address, m.city, m.stateId, m.zipcode, m.minPatientAge, m.maxPatientAge, s.suffixId, s.suffix, m.phoneNumber, m.languageId, l.languageName, m.expertiseId, e.expertiseName ";


        MentalHealthProfessionalDetail name = (MentalHealthProfessionalDetail)jpaApi.em().createNativeQuery(sql, MentalHealthProfessionalDetail.class).setParameter("nameId", nameId).getSingleResult();

        return ok(views.html.providerdbinputreturnpage.render(name));
    }

    @Transactional(readOnly = true)
    public Result getDiagnosisDetails(int diagnosisId)
    {
        String diagnosisSQL = "SELECT d FROM Diagnosis d WHERE diagnosisId = :diagnosisId";

        Diagnosis diagnosis = jpaApi.em().createQuery(diagnosisSQL,Diagnosis.class).setParameter("diagnosisId",diagnosisId).getSingleResult();

        String nextDiagnosisIdSQL = "SELECT NEW models.DiagnosisId(MIN(diagnosisId))FROM Diagnosis d WHERE diagnosisId > :diagnosisId";
        DiagnosisId nextDiagnosisId = jpaApi.em().createQuery(nextDiagnosisIdSQL, DiagnosisId.class).setParameter("diagnosisId", diagnosisId).getSingleResult();

        if (nextDiagnosisId.getId() == null)
        {
            String minDiagnosisIdSQL = "SELECT NEW models.DiagnosisId(MIN(diagnosisId)) From Diagnosis d";
            nextDiagnosisId = jpaApi.em().createQuery(minDiagnosisIdSQL,DiagnosisId.class).getSingleResult();
        }

        String previousDiagnosisIdSQL = "SELECT NEW models.DiagnosisId(MAX(diagnosisId))FROM Diagnosis d WHERE diagnosisId < :diagnosisId";
        DiagnosisId previousDiagnosisId = jpaApi.em().createQuery(previousDiagnosisIdSQL, DiagnosisId.class).setParameter("diagnosisId", diagnosisId).getSingleResult();




        return ok(views.html.diagnosispage.render(diagnosis, nextDiagnosisId.getId(),previousDiagnosisId.getId()));
    }


}

