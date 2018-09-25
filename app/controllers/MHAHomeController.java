package controllers;

import akka.http.javadsl.model.headers.Age;
import models.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;


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

    public Result getProviderInfo()
    {
        return ok(views.html.iamaprovider.render());
    }

    public Result postProviderInfo()
    {
        return ok(views.html.providerdbinputreturnpage.render());
    }
    @Transactional(readOnly = true)


    public Result getMentalHealthProfessionalDetail()
    {
        String sql ="SELECT NEW models.MentalHealthProfessionalDetail(t.titleName, m.lastName, m.firstName, m.address, m.city, m.stateId, m.zipcode, m.minPatientAge, m.maxPatientAge, s.suffixId, s.suffix) " +
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

