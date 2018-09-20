package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class MHAHomeController extends Controller
{
    public Result getMHAHome()
    {
        return ok(views.html.home.render());
    }

    public Result getProviderSearch()
    {
        return ok(views.html.providersearch.render());
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
