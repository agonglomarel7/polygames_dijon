package controllers;

import dao.MotDao;
import webserver.WebServerContext;

public class MotsController {

    static public MotDao MotDao = new MotDao();

    static public void findAll(WebServerContext context) {
        context.getResponse().json(MotDao.findAll());
    }


}