//Controller é de como eu irei mandar as informações que o model me passam e de como elas entram

package hello;
import static spark.Spark.get;

import java.util.List;

//import java.util.ArrayList;
//import java.util.List;
import com.google.gson.Gson;
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
	
	public void buscarSaldo() {
		get("/buscarSaldo/:numeroConta",(req,res)->{
			List<Saldo> SaldoEncontrado = modelo.buscarSaldo(req.params(":numeroConta"));
			return new Gson().toJson(SaldoEncontrado);
		});
	}
	
	public void confBanco() {
		get("/confBanco/:numConta",(req,res)->{
			boolean resp= modelo.confBankEx(req.params(":numConta"));
			return new Gson().toJson(resp);
		});
	}
	
	public void listarConta() {
		get("/buscarConta/:cpf/:numeroConta",(req,res)->{
			List<Conta> ContaEncontrada = modelo.buscarContaUsuario(req.params(":cpf"), req.params(":numeroConta"));
			return new Gson().toJson(ContaEncontrada);
		});
	}
	
	public void listarumUnicoUsuariosSistema() {
		get("/buscaListUsuarios/:usuario", (req, res) -> {
			List<Usuario> UsuariosEncontrados = modelo.buscarUsuarioPorUser(req.params(":usuario"));
			return new Gson().toJson(UsuariosEncontrados);
			
		});
		
	}
	
	public void cadastrarUsuario() {
		get("/addUsuario/:nomecompleto/:cpf/:email/:user/:senha/:numeroDaConta",(req,res)->{
			
			modelo.cadastrarUsuario(new Usuario(req.params(":nomecompleto"),req.params(":cpf"),req.params(":email"),req.params(":user"),req.params(":senha"),req.params("numeroDaConta")));
			return new Gson().toJson(modelo.getUsuarios());
		});
	}
	
}
