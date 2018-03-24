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


package APPBank;

import java.util.LinkedList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;

public class Modelo {

	private List<Usuario> usuarios = new LinkedList<Usuario>();

	private List<Banco> bancos = new LinkedList<Banco>();

	private List<Admin> admins = new LinkedList<Admin>();

	public void cadastrarUsuario(Usuario usuario) {
		if (!usuario.getUser().equals("") || !usuario.getSenha().equals("") || !usuario.getEmail().equals("")
				|| !usuario.getNumeroDaConta().equals("")) {
			if (contasRepetidas(usuario.getEmail(), usuario.getNumeroDaConta())) {
				usuarios.add(usuario);
			}
		}
	}

	public void cadastrarBanco(Banco banco) {
		if (!(banco.getId() == 0) || !banco.getNomeBanco().equals("") || !banco.getEmail().equals("")) {
			if (bancosRepetidos(banco.getNomeBanco(), banco.getId())) {
				bancos.add(banco);
			}
		}
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

	public boolean bancosRepetidos(String nomeBanco, int id) {
		for (Banco banco : bancos) {
			if (banco.getNomeBanco().equals(nomeBanco) || banco.getId() == id)
				return false;
		}
		return true;
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

	public boolean logarUsuario(String user, String senha) {
		for (Usuario usuario : usuarios) {
			if (usuario.getUser().equals(user) && usuario.getSenha().equals(senha))
				return true;
		}
		return false;
	}

	public Double buscarSaldo(String numeroDaContaSaldo) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNumeroDaConta().equals(numeroDaContaSaldo))
				return usuario.getSaldo().getValor();
		}
		return null;
	}

	public boolean pagarConta(int codigoBarra, Double valorFatura, Boolean pago) {
		for (Usuario usuario : usuarios) {
			if (usuario.getConta().getCodigoBarra() == codigoBarra
					&& usuario.getConta().getValorFatura().equals(valorFatura)) {
				if (pago.equals(false))
					return true;
			}
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
