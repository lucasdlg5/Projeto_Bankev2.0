package hello;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.List;


public class MainServer {
	
	final static Modelo modelo = new Modelo();
	
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 5543;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static/");

		inicializarUsuarios();

		Controller controller = new Controller(modelo);
		
		controller.loginUsuario();
				
    }
    
    public static void inicializarUsuarios(){
    	List<Usuario> database = new ArrayList<Usuario>();
    	
		database.add(new Usuario("lucasdlg", "123", "1@1.com", null, null, null));
		database.add(new Usuario("kevao", "1234", "2@2.com", null, null, null));
		database.add(new Usuario("karinao", "1235", "3@3.com", null, null, null));
		database.add(new Usuario("matheus", "1236", "4@4.com", null, null, null));
		
    }
}
