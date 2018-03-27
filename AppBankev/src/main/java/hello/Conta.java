package hello;

import java.time.LocalDate;

public class Conta {
	public Double valorFatura;
	public int codigoBarra;
	public Boolean pago;
	public LocalDate data;
	
	public Conta(Double valorFatura, int codigoBarra,Boolean pago, LocalDate data){
		this.valorFatura = valorFatura;
		this.codigoBarra = codigoBarra;
		this.pago = pago;
		this.data = data;
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

	

}
