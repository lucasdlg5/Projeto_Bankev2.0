package hello;

public class Usuario {
	
	private String nomeCompleto;
	private String cpf;
	private String user;
	private String senha;
	private String email;
	private String numeroDaConta;
	
	public Usuario( String nomecompleto,String cpf,String email,String user,String senha,String numeroDaConta) {
		this.nomeCompleto=nomecompleto;
		this.email=email;
		this.user=user;
		this.senha=senha;
		this.cpf=cpf;
		this.numeroDaConta=numeroDaConta;
		
	}

	
	public String getNomeCompleto() {
		return nomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Usuario(String user, String senha) {
		this.user = user;
		this.senha = senha;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumeroDaConta(){
		return numeroDaConta;
	}
	public void setNumeroDaConta(String numeroDaConta){
		this.numeroDaConta = numeroDaConta;
	}

}
