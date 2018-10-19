package com.fatec.sce;

import static org.junit.Assert.*;
import org.junit.Test;
import com.fatec.sce.model.ConfiguraDB;
import com.fatec.sce.model.FabricaDeConexoes;

public class TestaConexaoComDB {
	/**
	 * Objetivo: verificar o comportamento do sistema na conexao ao DB com 
	 * configuração válida
	 * Pre-condicao: a configuração default da fábrica de conexões é válida
	 */
	@Test
	public void quandoConectaComOBancoRetornaOK() {
		// Cenario
		FabricaDeConexoes fabrica;

		// Acao
		fabrica = new FabricaDeConexoes();

		// Verificacao
		assertNotNull(fabrica.getConnection());
	}

	/**
	 * Objetivo: verificar o comportamento do sistema na conexao ao DB com senha de acesso
	 * invalida
	 * Pre-condicao: a senha cadastrada eh ""
	 */
	@Test
	public void quandoConectaComSenhaInvalida_SQLException() {
		// Cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "senhaErada"; // Senha invalida

		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);

		try {
			// Acao
			fabricaDeConexoes.getConnection();
			fail("Deveria falhar");
		} catch (Exception e) {
			// Verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: YES)");
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema na conexao ao DB com usuario 
	 * invalido
	 * Pre-condicao: usuario invalido
	 */
	@Test
	public void quandoConectaComUsuarioInvalido_SQLException() {
		// Cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "usuarioInvalido"; // Usuário invalido
		String senha = "";

		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);

		try {
			// Acao
			fabricaDeConexoes.getConnection();
			fail("Deveria falhar");
		} catch (Exception e) {
			// Verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Access denied for user ''@'localhost' to database 'biblioteca'");
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema na conexao ao DB com driver 
	 * invalido
	 * Pre-condicao:
	 */
	@Test
	public void quandoConectaComDriverInvalido_SQLException() {
		// Cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Drive-in"; // Driver invalido
		String usuario = "root";
		String senha = "";

		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);

		try {
			// Acao
			fabricaDeConexoes.getConnection();
			fail("Deveria falhar");
		} catch (Exception e) {
			// Verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(), 
					"java.lang.ClassNotFoundException: com.mysql.jdbc.Drive-in");
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema na conexao ao DB com a porta 
	 * invalida
	 * Pre-condicao:
	 */
	@Test
	public void quandoConectaComPortaInvalido_SQLException() {
		// Cenario
		String url = "jdbc:mysql://localhost:0000/biblioteca"; // Porta invalida
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "";

		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);

		try {
			// Acao
			fabricaDeConexoes.getConnection();
			fail("Deveria falhar");
		} catch (Exception e) {
			// Verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure\n"
					+ "\nThe last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.");
		}
	}
}