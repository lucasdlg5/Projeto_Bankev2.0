package hello;

public class Saldo {
	
	private String numeroDaContaSaldo;
	private double valor;
	
	public Saldo(String numeroDaContaSaldo, double valor){
		this.numeroDaContaSaldo = numeroDaContaSaldo;
		this.valor = valor;
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
