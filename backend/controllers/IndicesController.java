package controllers;

import dao.IndicesDao;
import webserver.WebServerContext;

public class IndicesController {

    static public IndicesDao joueursDao = new IndicesDao();

    static public void createIndices(WebServerContext context){
        context.getResponse().json(joueursDao.insertIndices(null));
    }

} 
    

