/*Validaï¿½ï¿½o do login para login diferente para cada tipo de usuï¿½rio
Admin
- inserir usuarios
- habilitar logins
- ver todos os usuarios ativos no sistema
- Editar informaï¿½ï¿½es gerais

Usuï¿½rio
- O usuï¿½rio pode visualizar a lista de bancos existentes
- Logar o usuï¿½rio
- O usuï¿½rio pode buscar o seu banco por nome
- O usuï¿½rio pode visualizar a lista de bancos existentes
- Buscar o saldo do usuï¿½rio
- Pagar a conta
- Notificar o usuï¿½rio se hï¿½ conta em atraso
- O Administrador pode adicionar novos bancos
- O Administrador pode editar 


Requisitos nï¿½o funcionais

*/


package hello;

import java.util.LinkedList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

/*
Para os imports aparecer é necessario:

- Criar uma pasta lib na raiz do projeto, adicionar o arquivo db4o-8.0.249.16098-all-java5.jar
- Ir no arquivo build.graddle e adicionar uma linha em 'dependencies {'
	- compile files("lib/db4o-8.0.249.16098-all-java5.jar")
- Depois devemos adicionar estes imports na classe Modelo.java
- Após isso, dentro do Eclipse, clicar com botao direito em sima do arquivo 'build.gradle' -> Gradle -> Refresh Gradle Project

Espere alguns munitos ou reinicie o projeto, ele irá identificar os imports!!

*/

public class Modelo {
	
	/*
	 * Aplicando o Singleton - Para privar de que se inicie varias instancias de Banco varias vezes dentro do código
	 * Atravez de um construtor privado (so pode ser usado dentro da classe Modelo - Logo para usar precisamos instanciar o modelo e usar 
	 * o modelo = modelo.getInstance) iremos verificar na criação se ele está nulo ou nao.
	 * Caso esteja, ainda nao foi criado uma instanciação, caso sim, ele irá ignorar a criação secundária.
	 * */
	private static Modelo modeloUniqueInstance;
	

	public static Modelo getInstance() {
		if (modeloUniqueInstance == null) {
			modeloUniqueInstance = new Modelo();
		}
		return modeloUniqueInstance;
	}
	
	/*
	 * Aplicando o Singleton - Para privar de que se inicie varias instancias de Banco varias vezes dentro do código
	 * 
	 */

	//private List<Usuario> usuarios = new LinkedList<Usuario>();
	ObjectContainer usuarios = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/usuarios.db4o");

	//private List<Banco> bancos = new LinkedList<Banco>();
	ObjectContainer bancos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/bancos.db4o");
	
	//private List<Admin> admins = new LinkedList<Admin>();
	ObjectContainer admins = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/admins.db4o");
	
	//private List<Conta> contas= new LinkedList<Conta>();
	ObjectContainer contas = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/contas.db4o");
	
	//private List<Saldo> saldos = new LinkedList<Saldo>();
	ObjectContainer saldos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/saldos.db4o");

	public void cadastrarUsuario(Usuario usuario) {
		//usuarios.add(usuario);
		usuarios.store(usuario);
		usuarios.commit();
	}
	
	public void cadastrarConta(Conta conta) {
		//contas.add(conta);
		contas.store(conta);
		contas.commit();
	}
	
	public void cadastrarSaldo(Saldo saldo) {
//		saldos.add(saldo);
		saldos.store(saldo);
		saldos.commit();
	}

	public void cadastrarBanco(Banco banco) {
//		bancos.add(banco);
		bancos.store(banco);
		bancos.commit();
	}

	public void cadastrarAdmin(Admin admin) {
		if (adminRepetidas(admin.getNomeAdmin(), admin.getSenhaAdmin())) {
//			admins.add(admin);
			admins.store(admin);
			admins.commit();
		}
	}

	public boolean adminRepetidas(String nomeAdmin, String senhaAdmin) {
		
		Query query = admins.query();
		query.constrain(Admin.class);
	    ObjectSet<Admin> admins = query.execute();
		
		for (Admin admin : admins) {
			if (admin.getNomeAdmin().equals(nomeAdmin) || admin.getSenhaAdmin().equals(senhaAdmin))
				return false;
		}
		return true;
	}

	public boolean contasRepetidas(String email, String numeroDaConta) {
		
		Query query = usuarios.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> usuarios = query.execute();
		
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email) || usuario.getNumeroDaConta().equals(numeroDaConta))
				return false;
		}
		return true;
	}


	
	public List<Saldo> buscarSaldo(String numeroConta){
		List<Saldo> saldoEncontrada = new LinkedList<Saldo>();
		
		Query query = saldos.query();
		query.constrain(Saldo.class);
	    ObjectSet<Saldo> saldos  = query.execute();
	    
		for(Saldo saldo:saldos) {
			if(saldo.getNumeroDaContaSaldo().equals(numeroConta));
			saldoEncontrada.add(saldo);
			//saldoEncontrada.store(saldo);
		}
		return saldoEncontrada;
	}
	
	public List<Conta> buscarContaUsuario(String cpf,String numeroDaConta){
		List<Conta> contaEncontrada = new LinkedList<Conta>();
		Query query = contas.query();
		query.constrain(Conta.class);
	    ObjectSet<Conta> contas = query.execute();
		for(Conta conta:contas) {
			if(conta.getCpf().equals(cpf)) {
				contaEncontrada.add(conta);
				//contaEncontrada.store(conta);
			}
				
		}
		return contaEncontrada;
	}
	 
	
	public List<Usuario> buscarUsuarioPorUser(String user) {
		List<Usuario> userEncontrados = new LinkedList<Usuario>();
		
		Query query = usuarios.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> usuarios = query.execute();
		
		for (Usuario usuario : usuarios) {
			if (usuario.getUser().equals(user))
				userEncontrados.add(usuario);
				//userEncontrados.store(usuario);
				
		}
		return userEncontrados;

	}

	public List<Banco> buscarBancoPorNome(String nomeBanco) {
		List<Banco> nomeBancoEncontrado = new LinkedList<Banco>();

		Query query = usuarios.query();
		query.constrain(Banco.class);
	    ObjectSet<Banco> bancos = query.execute();
	    
		for (Banco banco : bancos) {
			if (banco.getNomeBanco().equals(nomeBanco))
				nomeBancoEncontrado.add(banco);
				//nomeBancoEncontrado.store(banco);
		}
		return nomeBancoEncontrado;

	}

	public boolean confBankEx(String cpf) {
		int conf=0;
		
		Query query = bancos.query();
		query.constrain(Banco.class);
	    ObjectSet<Banco> bancos = query.execute();
	    
		for (Banco banco:bancos) {
			if (banco.getCpf().equals(cpf)) {
				conf=conf+1;
			}
		}
		if (conf>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public boolean logarUsuario(String user, String senha) {
		
		Query query = usuarios.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> usuarios = query.execute();
	    
		for (Usuario usuario : usuarios) {
			if (usuario.getUser().equals(user) && usuario.getSenha().equals(senha))
				return true;
		}
		return false;
	}


	public boolean isLate(LocalDate date) {
		LocalDate today = LocalDate.now();
		if (date.isBefore(today))
			return true;
		return false;
	}

	public boolean verificaContAtr(String user, String numeroDaConta, LocalDate data) {
		LocalDate today = LocalDate.now();
		Query query = usuarios.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> usuarios = query.execute();
		for (Usuario usuario : usuarios) {
			if (usuario.getNumeroDaConta().equals(numeroDaConta) && usuario.getUser().equals(user)) {
				if (data.isBefore(today))
					return true;
			}
		}
		return false;
	}

	public List<Usuario> getUsuarios() {
		Query query = usuarios.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> usuarios = query.execute();
		return usuarios;
	}

	public void limpaUsuario() {
		List<Usuario> allUsuario = getUsuarios();
		for(Usuario usu:allUsuario) {
			usuarios.delete(usu);	
		}
		usuarios.commit();
	}
	
	public List<Banco> getBancos() {
		Query query = bancos.query();
		query.constrain(Banco.class);
	    ObjectSet<Banco> bancos = query.execute();
		return bancos;
	}
	
	public void limpaBancos() {
		List<Banco> allBancos = getBancos();
		for(Banco ban:allBancos) {
			bancos.delete(ban);	
		}
		bancos.commit();
	}

	public List<Admin> getAdmin() {
		Query query = admins.query();
		query.constrain(Admin.class);
	    ObjectSet<Admin> admins = query.execute();
		return admins;
	}
	
	public void limpaAdmins() {
		List<Admin> allAdmin = getAdmin();
		for(Admin adm:allAdmin) {
			admins.delete(adm);	
		}
		admins.commit();
	}
	
	public List<Conta> getContas() {
		Query query = contas.query();
		query.constrain(Conta.class);
	    ObjectSet<Conta> contas = query.execute();
		return contas;
	}
	
	public void limpaContas() {
		List<Conta> allConta = getContas();
		for(Conta cnt:allConta) {
			contas.delete(cnt);
		}
		contas.commit();
	}
	
	public List<Saldo> getSaldos(){
		Query query = saldos.query();
		query.constrain(Saldo.class);
	    ObjectSet<Saldo> saldos = query.execute();
		return saldos;
	}

	public void limpaSaldos() {
		List<Saldo> allsaldos = getSaldos();
		for(Saldo sld:allsaldos) {
			saldos.delete(sld);
		}
		saldos.commit();
	}

}
