package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.PolyNameDatabase;
import models.Joueurs;

public class JoueurDao {

    private PolyNameDatabase database;

    public JoueurDao() {
        try {
            this.database = new PolyNameDatabase();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
    }

    public Joueurs insertJoueur(Joueurs joueur) {
        String sql = "INSERT INTO Joueurs (nomJoueur, role) VALUES (?, ?)";
    
        try {
            PreparedStatement myPreparedStatement = this.database.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            myPreparedStatement.setString(1, joueur.nomJoueur());
            myPreparedStatement.setString(2, joueur.role());
    
            int affectedRows = myPreparedStatement.executeUpdate();
    
            if (affectedRows > 0) {
                ResultSet generatedKeys = myPreparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);

                    return this.findById(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    

    public ArrayList<Joueurs> findAll(){

        try {

            PreparedStatement myPreparedStatement = this.database.prepareStatement("SELECT * FROM joueurs;");

            ResultSet results = myPreparedStatement.executeQuery();

            ArrayList<Joueurs> joueurs = new ArrayList<Joueurs>();


            while(results.next())
            {
                final int id = results.getInt("id");
                final String nomJoueur = results.getString("nomJoueur");
                final String role = results.getString("role");

                Joueurs joueur = new Joueurs(id, nomJoueur,role);
                joueurs.add(joueur);
            }
            System.out.println(joueurs);


            return joueurs;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Joueurs>();
        }
    }


    public Joueurs findById(int id) throws SQLException{
        PreparedStatement myPreparedStatement = this.database.prepareStatement("SELECT * FROM Joueurs WHERE id = ?;");
        myPreparedStatement.setInt(1, id);

        ResultSet results = myPreparedStatement.executeQuery();

        if(results.next())
        {
            final int IdJoueur = results.getInt("id");
            final String nomJoueur = results.getString("nomJoueur");
            final String role = results.getString("role");

            return new Joueurs(IdJoueur, nomJoueur, role);
        }

        return null;
    }
}


