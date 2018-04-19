/*Validação do login para login diferente para cada tipo de usuário
Admin
- inserir usuarios
- habilitar logins
- ver todos os usuarios ativos no sistema
- Editar informações gerais

Usuário
- O usuário pode visualizar a lista de bancos existentes
- Logar o usuário
- O usuário pode buscar o seu banco por nome
- O usuário pode visualizar a lista de bancos existentes
- Buscar o saldo do usuário
- Pagar a conta
- Notificar o usuário se há conta em atraso
- O Administrador pode adicionar novos bancos
- O Administrador pode editar 


Requisitos não funcionais

*/


package hello;

import java.util.LinkedList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;

public class Modelo {

	private List<Usuario> usuarios = new LinkedList<Usuario>();

	private List<Banco> bancos = new LinkedList<Banco>();

	private List<Admin> admins = new LinkedList<Admin>();
	
	private List<Conta> contas= new LinkedList<Conta>();
	
	private List<Saldo> saldos = new LinkedList<Saldo>();

	public void cadastrarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public void cadastrarConta(Conta conta) {
		contas.add(conta);
	}
	
	public void cadastrarSaldo(Saldo saldo) {
		saldos.add(saldo);
	}

	public void cadastrarBanco(Banco banco) {
		bancos.add(banco);
	}

	public void cadastrarAdmin(Admin admin) {
		if (adminRepetidas(admin.getNomeAdmin(), admin.getSenhaAdmin())) {
			admins.add(admin);
		}
	}

	public boolean adminRepetidas(String nomeAdmin, String senhaAdmin) {
		for (Admin admin : admins) {
			if (admin.getNomeAdmin().equals(nomeAdmin) || admin.getSenhaAdmin().equals(senhaAdmin))
				return false;
		}
		return true;
	}

	public boolean contasRepetidas(String email, String numeroDaConta) {
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email) || usuario.getNumeroDaConta().equals(numeroDaConta))
				return false;
		}
		return true;
	}


	
	public List<Saldo> buscarSaldo(String numeroConta){
		List<Saldo> saldoEncontrada = new LinkedList<Saldo>();
		for(Saldo saldo:this.saldos) {
			if(saldo.getNumeroDaContaSaldo().equals(numeroConta));
			saldoEncontrada.add(saldo);
		}
		return saldoEncontrada;
	}
	
	public List<Conta> buscarContaUsuario(String cpf,String numeroDaConta){
		List<Conta> contaEncontrada = new LinkedList<Conta>();
		for(Conta conta:this.contas) {
			if(conta.getCpf().equals(cpf)) {
				contaEncontrada.add(conta);
			}
				
		}
		return contaEncontrada;
	}
	 
	
	public List<Usuario> buscarUsuarioPorUser(String user) {
		List<Usuario> userEncontrados = new LinkedList<Usuario>();
		for (Usuario usuario : this.usuarios) {
			if (usuario.getUser().equals(user))
				userEncontrados.add(usuario);
		}
		return userEncontrados;

	}

	public List<Banco> buscarBancoPorNome(String nomeBanco) {
		List<Banco> nomeBancoEncontrado = new LinkedList<Banco>();
		for (Banco banco : this.bancos) {
			if (banco.getNomeBanco().equals(nomeBanco))
				nomeBancoEncontrado.add(banco);
		}
		return nomeBancoEncontrado;

	}

	public boolean confBankEx(String cpf) {
		int conf=0;
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
		for (Usuario usuario : usuarios) {
			if (usuario.getNumeroDaConta().equals(numeroDaConta) && usuario.getUser().equals(user)) {
				if (data.isBefore(today))
					return true;
			}
		}
		return false;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public List<Banco> getBancos() {
		return this.bancos;
	}

	public List<Admin> getAdmin() {
		return this.admins;
	}

}
