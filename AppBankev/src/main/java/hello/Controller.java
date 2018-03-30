//Controller é de como eu irei mandar as informações que o model me passam e de como elas entram

package hello;
import static spark.Spark.get;

import java.util.ArrayList;
import java.util.List;
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
	
}
