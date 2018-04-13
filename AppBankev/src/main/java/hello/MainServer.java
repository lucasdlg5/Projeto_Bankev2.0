package hello;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

import java.time.LocalDate;


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
//        Modelo modelo = new Modelo();
		staticFileLocation("/static/");

		inicializarUsuarios();
		Controller controller = new Controller(modelo);
		
		controller.loginUsuario();
		
		controller.listarUsuariosSistema();
		
		controller.listarumUnicoUsuariosSistema();
		
		controller.cadastrarUsuario();
				
    }
    
    public static void inicializarUsuarios(){
//    	List<Usuario> database = new ArrayList<Usuario>();

    	modelo.cadastrarUsuario(new Usuario("lucasdlg", "123", "1@1.com", "teste1", new Saldo("sssK2033J", 100.0), new Conta(25.00,123456,false, LocalDate.of(2017,11,20))	));
    	modelo.cadastrarUsuario(new Usuario("lucasdlg2", "1232"));
    	modelo.cadastrarUsuario(new Usuario("admin123", "admin123", "2@2.com","teste1", new Saldo("sssK2033J", 100.0), new Conta(25.00,123456,false, LocalDate.of(2017,11,20))));
    	modelo.cadastrarUsuario(new Usuario("1", "123456"));
    	
//		database.add(new Usuario("lucasdlg", "123", "1@1.com", null, null, null));
//		database.add(new Usuario("kevao", "1234", "2@2.com", null, null, null));
//		database.add(new Usuario("karinao", "1235", "3@3.com", null, null, null));
//		database.add(new Usuario("matheus", "1236", "4@4.com", null, null, null));
//		
    }
}
