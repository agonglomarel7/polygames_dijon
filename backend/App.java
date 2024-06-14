import controllers.IndicesController;
import controllers.JoueurController;
import controllers.MotsController;
import webserver.WebServer;
import webserver.WebServerContext;


public class App {
    public static void main( String[] args) {
        try {
            WebServer webServer = new WebServer();


            // Démarrage du serveur sur le port 8080
            webServer.listen(8080);
            webServer.getRouter().post(
                "/joueurs",
                (WebServerContext context) ->{JoueurController.createJoueur(context);}

            );

            webServer.getRouter().get(
                "/joueurs",
                (WebServerContext context) ->{JoueurController.findAll(context);}

            );
            webServer.getRouter().get(
                "/mots",
                (WebServerContext context) ->{MotsController.findAll(context);}

            );

            
        webServer.getRouter().post(
            "/indices",
            (WebServerContext context) -> { IndicesController.createIndices(context); }
        );

            System.out.println("Démarrage du serveur");

        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
/*
public static void main(String[] args) {
    WebServer server = new WebServer(); // Crée une instance du serveur
    try {
        server.listen(8080); // Démarre le serveur sur le port 8080
        server.getRouter().get("/", (context) -> {
            String html = "<html><body><h1>Welcome to the Web Server</h1></body></html>";
            context.getResponse().ok(html, "text/html"); // Définit une route pour la racine
        });
    } catch (IOException e) {
        e.printStackTrace(); // Affiche les erreurs de démarrage du serveur
    }
}*/