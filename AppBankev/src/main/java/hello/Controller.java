//Controller é de como eu irei mandar as informações que o model me passam e de como elas entram

package hello;
import static spark.Spark.get;

import java.util.List;

//import java.util.ArrayList;
//import java.util.List;
import com.google.gson.Gson;

import spark.Route;
public class Controller {

	private Modelo modelo;

	public Controller(Modelo modelo){
		this.modelo = modelo;
	}
	
	public void loginUsuario() {
		get("/usuario/:username/:password", (req, res) ->{
			Usuario usuarioLogando = new Usuario(req.params(":username"), req.params(":password"));
			boolean usuario_encontrado = modelo.logarUsuario(usuarioLogando.getUser(), usuarioLogando.getSenha());
			return new Gson().toJson(usuario_encontrado);
		});
	}

	public void listarUsuariosSistema() {
		get("/buscaListUsuarios", (req, res) -> {
			return new Gson().toJson(modelo.getUsuarios());
			
		});
		
	}
	
	public void listarumUnicoUsuariosSistema() {
		get("/buscaListUsuarios/:usuario", (req, res) -> {
			List<Usuario> UsuariosEncontrados = modelo.buscarUsuarioPorUser(req.params(":usuario"));
			return new Gson().toJson(UsuariosEncontrados);
			
		});
		
	}
	
	public void cadastrarUsuario() {
		get("/addUsuario/:nomecompleto/:email/:user/:senha",(req,res)->{
			
			modelo.cadastrarUsuario(new Usuario(req.params(":nomecompleto"),req.params(":email"),req.params(":user"),req.params(":senha")));
			return new Gson().toJson(modelo.getUsuarios());
		});
	}
	
	public void cadastrarSaldo() {
		get ("/addSaldo/:nConta",(req,res)->{
			
			//modelo.cadastrarSaldo(new Saldo(req.params(":nConta")));
			return new Gson().toJson(modelo.cadastrarSaldo(new Saldo(req.params(":nConta"))));
		});
	}


	
}
