package hello;

public class Usuario {
	
	private String user;
	private String senha;
	private String email;
	private String numeroDaConta;
	private Saldo saldo;
	private Conta conta;
	
	


	public Usuario(String user, String senha, String email,String numeroDaConta, Saldo saldo,Conta conta) {
		this.user = user;
		this.senha = senha;
		this.email = email;
		this.numeroDaConta = numeroDaConta;
		this.saldo = saldo;
		this.conta = conta;
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
	
	public Saldo getSaldo() {
		return saldo;
	}

	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	

}
