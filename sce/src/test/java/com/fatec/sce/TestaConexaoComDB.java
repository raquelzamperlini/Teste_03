package com.fatec.sce;

import static org.junit.Assert.*;
import org.junit.Test;
import com.fatec.sce.model.ConfiguraDB;
import com.fatec.sce.model.FabricaDeConexoes;

public class TestaConexaoComDB {
	/**
	 * Objetivo: verificar o comportamento do sistema na conexão ao DB com 
	 * configuração válida
	 * Pré-condição: a configuração default da fábrica de conexões é válida
	 */
	@Test
	public void quandoConectaComOBancoRetornaOK() {
		// Cenário
		FabricaDeConexoes fabrica;

		// Ação
		fabrica = new FabricaDeConexoes();

		// Verificação
		assertNotNull(fabrica.getConnection());
	}

	/**
	 * Objetivo: verificar o comportamento do sistema na conexão ao DB com senha de acesso
	 * inválida
	 * Pré-condição: a senha cadastrada é ""
	 */
	@Test
	public void quandoConectaComSenhaInvalida_SQLException() {
		// Cenário
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "senhaErada"; // Senha inválida

		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);

		try {
			// Ação
			fabricaDeConexoes.getConnection();
			fail("Deveria falhar");
		} catch (Exception e) {
			// Verificação
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: YES)");
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema na conexão ao DB com usuário 
	 * inválido
	 * Pré-condição: usuário inválido
	 */
	@Test
	public void quandoConectaComUsuarioInvalido_SQLException() {
		// Cenário
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "usuarioInvalido"; // Usuário inválido
		String senha = "";

		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);

		try {
			// Ação
			fabricaDeConexoes.getConnection();
			fail("Deveria falhar");
		} catch (Exception e) {
			// Verificação
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Access denied for user ''@'localhost' to database 'biblioteca'");
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema na conexão ao DB com driver 
	 * inválido
	 * Pré-condição:
	 */
	@Test
	public void quandoConectaComDriverInvalido_SQLException() {
		// Cenário
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Drive-in"; // Driver inválido
		String usuario = "root";
		String senha = "";

		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);

		try {
			// Ação
			fabricaDeConexoes.getConnection();
			fail("Deveria falhar");
		} catch (Exception e) {
			// Verificação
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(), 
					"java.lang.ClassNotFoundException: com.mysql.jdbc.Drive-in");
		}
	}

	/**
	 * Objetivo: verificar o comportamento do sistema na conexao ao DB com a porta 
	 * inválida
	 * Pré-condição:
	 */
	@Test
	public void quandoConectaComPortaInvalido_SQLException() {
		// Cenário
		String url = "jdbc:mysql://localhost:0000/biblioteca"; // Porta inválida
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "";

		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);

		try {
			// Ação
			fabricaDeConexoes.getConnection();
			fail("Deveria falhar");
		} catch (Exception e) {
			// Verificação
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),
					"com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure\n"
					+ "\nThe last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.");
		}
	}
}