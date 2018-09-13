package hello;

//import com.db4o.query.Query;

public class Admin {
	
	private String nomeAdmin;
	private String senhaAdmin;
	
	public Admin(String nomeAdmin,String senhaAdmin){
		this.nomeAdmin = nomeAdmin;
		this.senhaAdmin = senhaAdmin;
		
	}
	
	public String getNomeAdmin(){
		return nomeAdmin;
	}
	public void setNomeAdmin(String nomeAdmin){
		this.nomeAdmin = nomeAdmin;
	}
	
	public String getSenhaAdmin(){
		return senhaAdmin;
	}
	public void setSenhaAdmin(String senhaAdmin){
		this.senhaAdmin = senhaAdmin;
	}



}
