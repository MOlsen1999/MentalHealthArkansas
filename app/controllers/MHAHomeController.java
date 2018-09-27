package controllers;

import akka.http.javadsl.model.headers.Age;
import models.*;
import play.Logger;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.naming.Name;
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

        String citysql = "SELECT m FROM MentalHealthProfessional m";
        List<MentalHealthProfessional> cities= jpaApi.em().createQuery(citysql,MentalHealthProfessional.class).getResultList();



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

        return ok(views.html.iamaprovider.render(titles,cities,insurances,diagnoses,expertises,therapies,languages));
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

        String[] expertise = map.get("expertise");
        Logger.debug("Checkbox: " + form.get("expertise[]"));

        if (expertise != null)
        {
            for (String expertiseId:expertise)
            {
                SpecialExpertise specialExpertise = new SpecialExpertise();
                specialExpertise.setExpertiseId(specialExpertise.getExpertiseId());
                specialExpertise.setExpertiseId(Integer.parseInt(expertiseId));
                jpaApi.em().persist(specialExpertise);
            }
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



        MentalHealthProfessional mentalHealthProfessional = new MentalHealthProfessional();

       /* int titleId = Integer.parseInt(form.get("titleName"));
        String firstName = form.get("firstName");
        String lastName = form.get("lastName");
        String address = form.get("address");
        String city = form.get("city");
        String stateId = form.get("stateId");
        int zipcode = Integer.parseInt(form.get("zipcode"));
        String phone = form.get("phone");
        int languageId = Integer.parseInt(form.get("languageId"));
        String insuranceId = form.get("insuranceId");
        String diagnosisId = form.get("diagnosisName");
        String expertiseName = form.get("expertiseName");
        String therapyName = form.get("therapyName");

        mentalHealthProfessional.setTitleId(titleId);
        mentalHealthProfessional.setFirstName(firstName);
        mentalHealthProfessional.setLastName(lastName);
        mentalHealthProfessional.setAddress(address);
        mentalHealthProfessional.setCity(city);
        mentalHealthProfessional.setStateId(stateId);
        mentalHealthProfessional.setZipcode(zipcode);
        mentalHealthProfessional.setPhoneNumber(phone);
        mentalHealthProfessional.setLanguageId(languageId);*/





        return ok(views.html.providerdbinputreturnpage.render());
    }

    @Transactional(readOnly = true)
    public Result getMentalHealthProfessionalDetail()
    {
        String sql ="SELECT NEW models.MentalHealthProfessionalDetail(t.titleName, m.lastName, m.firstName, m.address, m.city, m.stateId, m.zipcode, m.minPatientAge, m.maxPatientAge, s.suffixId, s.suffix, m.phoneNumber) " +
                " FROM MentalHealthProfessional m JOIN Title t ON m.titleId = t.titleId " +
                "JOIN Suffix s ON m.suffixId = s.suffixId";

        List<MentalHealthProfessionalDetail> name = jpaApi.em().createQuery(sql,MentalHealthProfessionalDetail.class).getResultList();
        return ok(views.html.providersearchreturnpage.render(name));

        /*"SELECT NEW models.ProductDetail(p.productId, p.productName, p.unitPrice, c.categoryName, s.companyName)" +
                "FROM Product p JOIN Category c ON p.categoryId = c.categoryId " +
                "JOIN Supplier s ON p.supplierId = s.supplierId";*/

         //String titleName, String lastName, String firstName, String address, String city, String stateId, Integer zipcode, Integer minPatientAge, Integer maxPatientAge, Integer suffixId) {
    }
}

