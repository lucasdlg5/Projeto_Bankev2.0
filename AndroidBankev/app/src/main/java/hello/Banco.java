package hello;//package hello;

public class Banco {
	
	
	private String cpf;
	private String nomeBanco;
	private String email;
	
	
	public Banco(String cpf, String nomeBanco, String email) {
		this.cpf = cpf;
		this.nomeBanco = nomeBanco;
		this.email = email;
	}
	
	
	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
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
