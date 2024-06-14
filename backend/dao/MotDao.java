package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.PolyNameDatabase;
import models.Mots;

public class MotDao {

    private PolyNameDatabase database;

    public MotDao() {
        try {
            this.database = new PolyNameDatabase();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
    }
    

    public ArrayList<Mots> findAll(){

        try {

            PreparedStatement myPreparedStatement = this.database.prepareStatement("SELECT * FROM Mots;");

            ResultSet results = myPreparedStatement.executeQuery();

            ArrayList<Mots> mots = new ArrayList<Mots>();


            while(results.next())
            {
                final int id = results.getInt("idMot");
                final String nomMots = results.getString("nomMot");

                Mots mot = new Mots(id, nomMots);
                mots.add(mot);
            }
            System.out.println(mots);


            return mots;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Mots>();
        }
    }

}


