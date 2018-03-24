//Controller é de como eu irei mandar as informações que o model me passam e de como elas entram

package hello;

import static spark.Spark.get;


import java.util.List;

import com.google.gson.Gson;

public class Controller {

	private Model model;


	public Controller(Model model){
		this.model = model;
	}
	


	public void buscarCarro(){
		get("/carro/:modelo/:marca/:cor", (req, res) -> {

			Especificacao espec = new Especificacao(req.params(":modelo"), req.params(":marca"), req.params(":cor"));
			List<Carro> carrosEncontrados = model.buscarEspecificacao(espec);
			return new Gson().toJson(carrosEncontrados);

		});
	}

	public void buscarPlaca() {
		get("/carro/:placa", (req, res) -> {
			String placa = req.params(":placa");
			Carro resultado_placa = model.buscarPlaca(placa);
			return new Gson().toJson(resultado_placa);
		});
	}
	
	

	public void buscarCarroPlaca() {
		get("/carro/:placa", (req, res) -> {

			String placa = req.params(":placa");
			
			Carro carrosEncontrados2 = model.buscarPlaca(placa);
			
			return new Gson().toJson(carrosEncontrados2);
		});
	}
	
	public void buscarCarroCor() {
		//Recebendo os valores pelo LINK no site (metodo Post) e colocando na rota configurada
		get("/carroo/:cor", (req, res) -> {
			
			//Coletando e separando as informações e inserindo nas variaveis
			String carroCor = req.params(":cor");
			
			//Criando uma lista de carros (um vetor) e utilizando o METODO em MODEL de buscarCarroCor inserindo a cor do carro acima
			List<Carro> carrosCorEncontrados = model.buscarCarroCor(carroCor);
			System.out.println(carrosCorEncontrados);
			//Inserindo o resultado da lista de carros e transformando-os em Json
			return new Gson().toJson(carrosCorEncontrados);
		});
		
	}
	
	
//	public static void main(String [] args) {
//		List<Carro> database = new ArrayList<Carro>();
//
//		Model model3 = new Model();
//		
//		database.add(new Carro("AAA-1111", new Especificacao("gol", "vw", "verde")));
//		database.add(new Carro("BBB-1111", new Especificacao("fiat", "vw", "azul")));
//		database.add(new Carro("BBB-1111", new Especificacao("fiat", "vw", "amarelo")));
//		database.add(new Carro("BBB-1111", new Especificacao("fiat", "vw", "azul")));
//		database.add(new Carro("BBB-1111", new Especificacao("fiat", "vw", "azul")));
//		database.add(new Carro("BBB-1111", new Especificacao("fiat", "vw", "azul")));
//		System.out.println(database.size());
//		
//		String carroCor = "azul";
//		
//		//Criando uma lista de carros (um vetor) e utilizando o METODO em MODEL de buscarCarroCor inserindo a cor do carro acima
//		List<Carro> carrosCorEncontrados = new ArrayList<Carro>();
//		
//		
//		for (Carro carro:database) {
//			//Na qual o carro (Classe) que tenha a especificacao (Classe) na cor verde (Atributo de Especificacao) que caso encontre
//			//seja adicionado na lista criado acima carroCorEncontrado
//			
//			if(carro.getEspc().getCor().equals(carroCor)) {
//				carrosCorEncontrados.add(carro);
//			}
//		}
//		System.out.println(carrosCorEncontrados);
//		
//		
//		
//	}
//	
	//FAZER A BUSCA UTILIZANDO SOMENTE A MARCA	




}
