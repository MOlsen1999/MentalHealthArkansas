package controllers;

import akka.http.javadsl.model.headers.Age;
import com.amazonaws.services.dynamodbv2.xspec.S;
import models.*;
import play.Logger;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import scala.Int;

import javax.inject.Inject;
import javax.naming.Name;
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
        return ok(views.html.home.render());
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



        return ok(views.html.providersearch.render(titles, insurances, diagnoses, expertises, therapies, languages, cities));
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

        return ok(views.html.iamaprovider.render(titles,cities,insurances,diagnoses,expertises,therapies,languages, organizations, suffixes));
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

        DynamicForm form = formFactory.form().bindFromRequest();
        Map<String, String[]> map = request().body().asFormUrlEncoded();

        String[] therapy = map.get("treatment");
        Logger.debug("Checkbox:" + form.get("treatment[]"));

        if(therapy != null)
        {
            for(String therapyId:therapy)
            {
                ProfessionalTherapy professionalTherapy = new ProfessionalTherapy();
                professionalTherapy.setTherapyId(professionalTherapy.getTherapyId());
                professionalTherapy.setTherapyId(Integer.parseInt(therapyId));
                jpaApi.em().persist(professionalTherapy);
            }

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


        String[] insurance = map.get("insurance");
        Logger.debug("Checkbox:" + form.get("insurance[]"));

        if (insurance != null)
        {
            for (String insuranceId : insurance) {
                InsuranceAccepted insuranceAccepted = new InsuranceAccepted();
                insuranceAccepted.setInsuranceId(insuranceAccepted.getInsuranceId());
                insuranceAccepted.setInsuranceId(Integer.parseInt(insuranceId));
                jpaApi.em().persist(insuranceAccepted);
            }
        }

        String[] diagnosis = map.get("diagnosis");
        Logger.debug("Checkbox: " + form.get("diagnosis[]"));

        if (diagnosis != null)
        {
            for(String diagnosisId:diagnosis)
            {
                ProfessionalDiagnosis professionalDiagnosis = new ProfessionalDiagnosis();
                professionalDiagnosis.setDiagnosisId(professionalDiagnosis.getDiagnosisId());
                professionalDiagnosis.setDiagnosisId(Integer.parseInt(diagnosisId));
                jpaApi.em().persist(professionalDiagnosis);
            }
        }

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




        return ok("Saved");

    }

    @Transactional(readOnly = true)
    public Result getMentalHealthProfessionalDetail()
    {
        String sql ="SELECT NEW models.MentalHealthProfessionalDetail(m.nameId, t.titleName, m.lastName, m.firstName, m.address, m.city, m.stateId, m.zipcode, m.minPatientAge, m.maxPatientAge, s.suffixId, s.suffix, m.phoneNumber) " +
                " FROM MentalHealthProfessional m JOIN Title t ON m.titleId = t.titleId " +
                "JOIN Suffix s ON m.suffixId = s.suffixId";

        List<MentalHealthProfessionalDetail> name = jpaApi.em().createQuery(sql,MentalHealthProfessionalDetail.class).getResultList();
        return ok(views.html.providersearchreturnpage.render(name));

    }

    @Transactional(readOnly = true)
    public Result getNewMentalHealthProfessional(int nameId)
    {
        String sql ="SELECT NEW models.MentalHealthProfessionalDetail(m.nameId,  t.titleName, m.lastName, m.firstName, m.address, m.city, m.stateId, m.zipcode, m.minPatientAge, m.maxPatientAge, s.suffixId, s.suffix, m.phoneNumber) " +
                " FROM MentalHealthProfessional m JOIN Title t ON m.titleId = t.titleId " +
                "JOIN Suffix s ON m.suffixId = s.suffixId " +
                " WHERE nameId = :nameId";

        MentalHealthProfessionalDetail name = jpaApi.em().createQuery(sql,MentalHealthProfessionalDetail.class).setParameter("nameId", nameId).getSingleResult();

        return ok(views.html.providerdbinputreturnpage.render(name));
    }

}

