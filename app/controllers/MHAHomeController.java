package controllers;

import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;


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
        return ok(views.html.providersearch.render());
    }

    public Result postReturnInfo()
    {
       return ok(views.html.returnpage.render());
    }

    public Result getProviderInfo()
    {
        return ok(views.html.iamaprovider.render());
    }


    public Result getReturnInfo()
    {
        return ok(views.html.returnpage.render());
    }
}
