package database;

import java.sql.SQLException;

public class PolyNameDatabase extends MySQLDatabase{
    public PolyNameDatabase() throws SQLException{
        super("localhost", 3306, "polynames", "Marel", "M@relsig@n152");
    }
}
