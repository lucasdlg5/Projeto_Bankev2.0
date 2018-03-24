package APPBank;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import APPBank.Modelo;

public class Teste {

	private static final Object True = null;

	@Test
	public void test() {
		Modelo modelo = new Modelo();
//		
//		//Teste de cadastramento de Usuario
//		
		modelo.cadastrarUsuario(new Usuario("Jose_Ricardo","12345","josericardo@email.com","K2033J", new Saldo("K2033J", 100.0), new Conta(25.00,123456,false, LocalDate.of(2017,11,20))));
//		modelo.cadastrarUsuario(new Usuario("Ana_Brito","21548","anabrito@email.com","J8011K", new Saldo("J8011K", 100.0),new Conta(25.00,123456,false,LocalDate.of(2017,11,30))));
//		modelo.cadastrarUsuario(new Usuario("Jose_Ricardo","12346","josericardo2017@email.com","K2034J", new Saldo("K2034J", 100.0),new Conta(25.00,123456,true,LocalDate.of(2017,12,01))));
//		modelo.cadastrarUsuario(new Usuario("Rodrigo Melo","54321","rodrigomelo@email.com","K2033J", new Saldo("K2033J", 500.0),new Conta(25.00,123456,false,LocalDate.of(2017,11,13))));
//		modelo.cadastrarUsuario(new Usuario("","","","",new Saldo("",0),new Conta(0.0,0,false,LocalDate.of(2017,11,13))));
//		modelo.cadastrarUsuario(new Usuario("Cleber_Jose","66666","cleberjose2017@email.com","C2034J", new Saldo("C2034J", 1000.0),new Conta(125.00,9874563,false,LocalDate.of(2017,11,13))));
		modelo.logarUsuario("Jose_Ricardo", "12345");
//		modelo.logarUsuario("Lucas_M", "l123");
//		
//		assertEquals(modelo.getUsuarios().size(),4);
//		
//		assertEquals(modelo.getUsuarios().get(0).getUser(),"Jose_Ricardo"); //Verifica a posição de um dado
//		//assertEquals(modelo.getUsuarios().get(0).getConta().getData(),LocalDate.of(11,11,13));
//		assertEquals(modelo.getUsuarios().get(0).getNumeroDaConta(),"K2033J");
//		assertEquals(modelo.getUsuarios().get(0).getSenha(),"12345");
//		assertEquals(modelo.buscarUsuarioPorUser("Jose_Ricardo").size(),2);
//		assertEquals(modelo.logarUsuario("Jose_Ricardo", "12345"),true);
//		//assertEquals(modelo.logarUsuario("Lucas_M", "l123"),true); //Nao loga pois nao rexiste na lista de cadastro
//		//assertEquals(modelo.logarUsuario("Jose_Ricardo", "12345"),false);
//		assertEquals(modelo.buscarSaldo("K2033J"), new Double(100.0)); //Retorna o valor contido no Saldo 
//		//assertEquals(modelo.buscarSaldo("K2033J"), new Double(-1));
//		//assertEquals(modelo.getUsuarios().get(3).getUser(),"Rodrigo Melo"); //Nao registra pois o numero da conta é igual a do José ricardo da posição 0
//		//assertEquals(modelo.buscarUsuarioPorUser("Rodrigo Melo").size(),1);
//		
//		assertEquals(modelo.getUsuarios().get(1).getUser(),"Ana_Brito");
//		assertEquals(modelo.getUsuarios().get(1).getNumeroDaConta(),"J8011K");
//		assertEquals(modelo.getUsuarios().get(1).getSenha(),"21548");
//		assertEquals(modelo.buscarUsuarioPorUser("Ana_Brito").size(),1);
//		assertEquals(modelo.getUsuarios().get(1).getConta().getData(),LocalDate.of(2017,11,30));
//		
//		assertEquals(modelo.getUsuarios().get(3).getUser(),"Cleber_Jose");
//		assertEquals(modelo.getUsuarios().get(3).getNumeroDaConta(),"C2034J");
//		assertEquals(modelo.getUsuarios().get(3).getSenha(),"66666");
//		assertEquals(modelo.buscarUsuarioPorUser("Cleber_Jose").size(),1);
//		assertEquals(modelo.getUsuarios().get(3).getConta().getData(),LocalDate.of(2017,11,13));
//		
//		//Teste de cadastramento de Banco
//		
//		modelo.cadastrarBanco(new Banco(0001,"Bradesco","bancoBradesco@email.com"));
//		modelo.cadastrarBanco(new Banco(0002,"Itau","bancoItau@email.com"));
//		modelo.cadastrarBanco(new Banco(0003,"Santander","bancoSantander@email.com"));
//		modelo.cadastrarBanco(new Banco(0004,"Safra","bancoSafra@email.com"));
//		modelo.cadastrarBanco(new Banco(0005,"Caixa","bancoCaixa@email.com"));		
//		modelo.cadastrarBanco(new Banco(0001,"Brasil","bancoBradesco@email.com"));//Nao registra(Campo repetido)
//		modelo.cadastrarBanco(new Banco(0002,"Safra","bancoSafra@email.com"));//Nao registra(Campo repetido)
//		modelo.cadastrarBanco(new Banco(0,"",""));//Nao registra(campo vazio)
//		
//		assertEquals(modelo.getBancos().size(),5);
//		
//		assertEquals(modelo.getBancos().get(0).getNomeBanco(),"Bradesco");
//		assertEquals(modelo.getBancos().get(0).getId(),0001);
//		assertEquals(modelo.getBancos().get(0).getEmail(),"bancoBradesco@email.com");
//		assertEquals(modelo.buscarBancoPorNome("Bradesco").size(),1);
//		
//		assertEquals(modelo.getBancos().get(1).getNomeBanco(),"Itau");
//		assertEquals(modelo.getBancos().get(1).getId(),0002);
//		assertEquals(modelo.getBancos().get(1).getEmail(),"bancoItau@email.com");
//		assertEquals(modelo.buscarBancoPorNome("Itau").size(),1);
//		//assertEquals(modelo.buscarBancoPorNome("Brasil").size(),2);
//		
//		//Teste de casdastramento Admin
//		
//		modelo.cadastrarAdmin(new Admin("Antonio_Almeida","senhaAntonio123"));
//		modelo.cadastrarAdmin(new Admin("Antonio_Almeida","senhaAntonio123"));//Nao registra(Campo repetido)
//		modelo.cadastrarAdmin(new Admin("Cleber_Augusto","senhaAugusto123"));
//		
//		assertEquals(modelo.getAdmin().size(),2);
//		
//		//Uso de função isLate(Retorna valor boolean, comparando a data do pagamento se está atrasado)
//		
//		//assertEquals(modelo.isLate(modelo.getUsuarios().get(0).getConta().getData()),true);
//		assertEquals(modelo.isLate(LocalDate.of(2017,11,21)),false);
//		assertEquals(modelo.isLate(LocalDate.of(2017,11,17)),true);
//		
//		assertEquals(modelo.verificaContAtr(modelo.getUsuarios().get(1).getUser(), modelo.getUsuarios().get(1).getNumeroDaConta(), modelo.getUsuarios().get(1).getConta().getData()),false);
//		assertEquals(modelo.verificaContAtr(modelo.getUsuarios().get(2).getUser(), modelo.getUsuarios().get(2).getNumeroDaConta(), modelo.getUsuarios().get(2).getConta().getData()),false);		
//		assertEquals(modelo.verificaContAtr(modelo.getUsuarios().get(3).getUser(), modelo.getUsuarios().get(3).getNumeroDaConta(), modelo.getUsuarios().get(3).getConta().getData()),true);
//	
//		
//		//Pagar conta
//		assertEquals(modelo.pagarConta(modelo.getUsuarios().get(0).getConta().getCodigoBarra(), modelo.getUsuarios().get(0).getConta().getValorFatura(),modelo.getUsuarios().get(0).getConta().getPago()),true);
//		//assertEquals(modelo.pagarConta(modelo.getUsuarios().get(1).getConta().getCodigoBarra(), modelo.getUsuarios().get(1).getConta().getValorFatura(),modelo.getUsuarios().get(1).getConta().getPago()),false);
//		assertEquals(modelo.pagarConta(modelo.getUsuarios().get(2).getConta().getCodigoBarra(), modelo.getUsuarios().get(2).getConta().getValorFatura(),modelo.getUsuarios().get(2).getConta().getPago()),false);
//
		
	}


}
