//Controller é de como eu irei mandar as informações que o model me passam e de como elas entram

package hello;
import static spark.Spark.get;
import static spark.Spark.post;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;
public class Controller {

	private Modelo modelo;

	public Controller(Modelo modelo){
		this.modelo = modelo;
	}
	
	public void loginUsuario() {
//		get("/usuario/:username/:password", (req, res) ->{
//			Usuario usuarioLogando = new Usuario(req.params(":username"), req.params(":password"));
//			boolean usuario_encontrado = modelo.logarUsuario(usuarioLogando.getUser(), usuarioLogando.getSenha());
//			return new Gson().toJson(usuario_encontrado);
//		});
		
		post ("/usuario/login", new Route() {
			public Object handle(final Request request, final Response response) throws JSONException{
	            response.header("Access-Control-Allow-Origin", "*");
	            JSONObject json = new JSONObject(request.body()); // Aqui ele recebera todo o corpo de JSON enviado pelo HTML
	            String userName = json.getString("userName");
	            String password = json.getString("password");
	            return modelo.logarUsuario(userName, password);
//	               boolean usuario = modelo.logarUsuario(userName, password);
//	                if(usuario != false){
//	                    JSONArray jsonResult = new JSONArray();
//	                    JSONObject jsonObj = new JSONObject();
//	                    jsonObj.put("status", 1);
//	                    jsonObj.put("userName", userName);
//	                    jsonResult.put(jsonObj);
//	                    return jsonResult;
//	                } else {
//	                }
//	            JSONArray jsonResult = new JSONArray();
//	            JSONObject jsonObj = new JSONObject();
//	            jsonObj.put("status", 0);
//	            jsonResult.put(jsonObj);
//	            return jsonResult;		
			}
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
	
	public String buscarContaUsuarioControll () {
		get("/buscarContaUsuarioControll/:usuario", (req,res)->{
			List<Usuario> UsuariosEncontrados = modelo.buscarUsuarioPorUser(req.params(":usuario"));
//			System.out.println(UsuariosEncontrados.get(0).getNumeroDaConta());
//			System.out.println(modelo.buscarContaUsuario(UsuariosEncontrados.get(0).getCpf(),UsuariosEncontrados.get(0).getNumeroDaConta()).toString());
					return new Gson().toJson(modelo.buscarContaUsuario(UsuariosEncontrados.get(0).getCpf(),UsuariosEncontrados.get(0).getNumeroDaConta())); //ALTERAR A PESSOA DO RETORNO ALEM DO 0!!! ISSO AQUI É GAMBIARRA HARDCORE
		});
		return null;
	}
	
	
	
	
}
