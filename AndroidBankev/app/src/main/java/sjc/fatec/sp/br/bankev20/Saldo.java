package hello;

public class Saldo {
	
	private String numeroDaContaSaldo;
	private double valor;
	private String banco;
	
	public Saldo(String numeroDaContaSaldo,String banco, double valor){
		this.numeroDaContaSaldo = numeroDaContaSaldo;
		this.valor = valor;
		this.banco=banco;
	}
	
	public String getBanco() {
		return banco;
	}



	public void setBanco(String banco) {
		this.banco = banco;
	}



	public String getNumeroDaContaSaldo() {
		return numeroDaContaSaldo;
	}
	public void setNumeroDaContaSaldo(String numeroDaContaSaldo) {
		this.numeroDaContaSaldo = numeroDaContaSaldo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

}
