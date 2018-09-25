package hello;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

import java.time.LocalDate;


/* Aplicando o Singleton de Modelo*/ 
//private static Modelo modelo;

//modelo = model.getInstance();


/* Aplicando o Singleton de Modelo*/ 

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
		
		controller.listarConta();
		
		controller.buscarSaldo();
		
		controller.confBanco();
		
		controller.buscarContaUsuarioControll();
		
				
    }
    
    public static void inicializarUsuarios(){
//    	List<Usuario> database = new ArrayLis	t<Usuario>();

    		modelo.limpaUsuario();
    		modelo.limpaBancos();
    		modelo.limpaContas();
    		modelo.limpaUsuario();
	    	modelo.cadastrarUsuario(new Usuario("Lucas Domingos", "123456789", "1@1.com","lucasdlg","123", "987654321"));
	    	modelo.cadastrarUsuario(new Usuario("Karinao Silva", "123456788", "2@2.com","karinaoS","124", "987654323"));
	    	modelo.cadastrarSaldo(new Saldo("987654321","Bradesco",5000.00));
	    	modelo.cadastrarBanco(new Banco("987654321","Bradesco","bradesco@email.com"));
	    	modelo.cadastrarConta(new Conta("33333333333","102030",50.30,789456,false,null));
	    	modelo.cadastrarConta(new Conta("33333333333","102030",60.30,889456,true,null));
	    	modelo.cadastrarConta(new Conta("33333333333","102030",150.30,989456,false,null));
    	
    }
}
