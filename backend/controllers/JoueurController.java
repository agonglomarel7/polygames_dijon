package controllers;

import dao.JoueurDao;
import webserver.WebServerContext;

public class JoueurController {

    static public JoueurDao joueursDao = new JoueurDao();

    static public void findAll(WebServerContext context) {
        context.getResponse().json(joueursDao.findAll());
    }

    static public void createJoueur(WebServerContext context){
        context.getResponse().json(joueursDao.insertJoueur(null));
    }

}