package APPBank;

import java.sql.Date;

public class Fatura {
	private Double valorFatura;
	private int codigoBarra;
	private boolean pago;
	private Date data;
	
	public Fatura(Double valorFatura,int codigoBarra, boolean pago,Date data){
		this.valorFatura = valorFatura;
		this.codigoBarra = codigoBarra;
		this.pago = pago;
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
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
