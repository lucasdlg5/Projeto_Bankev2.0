package hello;

public class Banco {
	
	private int id;
	private String nomeBanco;
	private String email;
	
	
	public Banco(int id, String nomeBanco, String email) {
		this.id = id;
		this.nomeBanco = nomeBanco;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeBanco() {
		return nomeBanco;
	}
	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
