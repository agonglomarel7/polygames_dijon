package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.PolyNameDatabase;
import models.Indices;

public class IndicesDao {

    private PolyNameDatabase database;

    public IndicesDao() {
        try {
            this.database = new PolyNameDatabase();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
    }

    public Indices insertIndices(Indices indice) {
        String sql = "INSERT INTO Indices (nomIndices, nombreMots) VALUES (?, ?)";
    
        try {
            PreparedStatement myPreparedStatement = this.database.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            myPreparedStatement.setString(1, indice.nomIndices());
            myPreparedStatement.setInt(2, indice.nombreMots());
    
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

    public Indices findById(int id) throws SQLException{
        PreparedStatement myPreparedStatement = this.database.prepareStatement("SELECT * FROM Indices WHERE id = ?;");
        myPreparedStatement.setInt(1, id);

        ResultSet results = myPreparedStatement.executeQuery();

        if(results.next())
        {
            final int IdIndices = results.getInt("id");
            final String nomIndices = results.getString("nomJoueur");
            final int nombreMots = results.getInt("nombreMots");

            return new Indices(IdIndices, nomIndices, nombreMots);
        }

        return null;
    }

    public Object findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}


