package hello;

import java.time.LocalDate;

public class Conta {
	public String cpf;
	public String numeroDeConta;
	public Double valorFatura;
	public int codigoBarra;
	public Boolean pago;
	public LocalDate data;
	
	public Conta(String cpf,String numeroDeConta,Double valorFatura, int codigoBarra,Boolean pago, LocalDate data){
		this.valorFatura = valorFatura;
		this.codigoBarra = codigoBarra;
		this.pago = pago;
		this.data = data;
		this.cpf=cpf;
		this.numeroDeConta=numeroDeConta;
	}
	

	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNumeroDeConta() {
		return numeroDeConta;
	}


	public void setNumeroDeConta(String numeroDeConta) {
		this.numeroDeConta = numeroDeConta;
	}


	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValorFatura() {
		return valorFatura;
	}

	public void setValorFatura(Double valorFatura) {
		this.valorFatura = valorFatura;
	}

	public int getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(int codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public String toString() {
        return "CPF: "+this.cpf+"\nNumero da conta: "+this.numeroDeConta+"\nValor da fatura: "+this.valorFatura+"\nCodigo de Barras: "+this.codigoBarra+"\nPago? "+this.pago+"\nData: "+this.data;
    }

}
