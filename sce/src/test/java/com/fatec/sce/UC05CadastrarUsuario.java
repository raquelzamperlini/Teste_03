package com.fatec.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fatec.sce.model.Livro;
import com.fatec.sce.model.Usuario;

public class UC05CadastrarUsuario {

	
	@Test
	public void CT01CadastrarUsuarioComDadosValidos() {
		try {
			// Cenario
			Usuario usuario;
			// Acao
			usuario = ObtemUsuario.comDadosValidos();
		} catch (RuntimeException e) {
			// Verificacao
			fail("Nao deve falhar");
		}
	}

	@Test
	public void CT02CadastrarUsuarioComRa_em_branco() {
		// Cenario
		Usuario usuario;
		try {
			// Acao
			usuario = ObtemUsuario.comRaInvalido_branco();
			fail("Deveria lancar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("RA invalido", e.getMessage());
		}
	}

	@Test
	public void CT03CadastrarUsuarioComRa_nulo() {
		// Cenario
		Usuario usuario;
		try {
			// Acao
			usuario = ObtemUsuario.comRAInvalido_nulo();
			fail("Deveria lancar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("RA invalido", e.getMessage());
		}
	}

	@Test
	public void CT04CadastrarUsuario_com_sucesso_getRa() {
		// Cenario
		Usuario usuario = new Usuario();
		usuario.setRa("123456");
		usuario.setNome("Usuario da Silva");

		assertEquals("123456", usuario.getRa());
	}
	
	@Test
	public void CT05CadastrarUsuarioComNome_em_branco() {
		// Cenario
		Usuario usuario;
		try {
			// Acao
			usuario = ObtemUsuario.comNomeInvalido_branco();
			fail("Deveria lancar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("Nome invalido", e.getMessage());
		}
	}

	@Test
	public void CT06CadastrarUsuarioComNome_nulo() {
		// Cenario
		Usuario usuario;
		try {
			// Acao
			usuario = ObtemUsuario.comNomeInvalido_nulo();
			fail("Deveria lancar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("Nome invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT07CadastrarUsuario_com_sucesso_getNome() {
		// Cenario
		Usuario usuario = new Usuario();
		usuario.setRa("123456");
		usuario.setNome("Usuario da Silva");

		assertEquals("Usuario da Silva", usuario.getNome());
	}
	
// Codigo antes de refatorar para padrao Data Builder
/*
	@Test
	public void CT01CadastrarUsuarioComDadosValidos() {
		try {
			// Cenario
			Usuario usuario = new Usuario();
			// Acao
			usuario.setRa("12121212");
			usuario.setNome("Usuario da Silva");
		} catch (RuntimeException e) {
			// Verificacao
			fail("Nao deve falhar");
		}
	}

	@Test
	public void CT02CadastrarUsuarioComRa_em_branco() {
		// Cenario
		Usuario usuario = new Usuario();
		usuario.setNome("Usuario da Silva");
		try {
			// Acao
			usuario.setRa("");
			fail("Deveria lancar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("RA invalido", e.getMessage());
		}
	}

	@Test
	public void CT03CadastrarUsuarioComRa_nulo() {
		// Cenario
		Usuario usuario = new Usuario();
		usuario.setNome("Usuario da Silva");
		try {
			// Acao
			usuario.setRa(null);
			fail("Deveria lancar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("RA invalido", e.getMessage());
		}
	}

	@Test
	public void CT04CadastrarUsuario_com_sucesso_getRa() {
		// Cenario
		Usuario usuario = new Usuario();
		usuario.setRa("123456");
		usuario.setNome("Usuario da Silva");

		assertEquals("123456", usuario.getRa());
	}
	
	@Test
	public void CT05CadastrarUsuarioComNome_em_branco() {
		// Cenario
		Usuario usuario = new Usuario();
		usuario.setRa("123456");
		try {
			// Acao
			usuario.setNome("");
			fail("Deveria lancar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("Nome invalido", e.getMessage());
		}
	}

	@Test
	public void CT06CadastrarUsuarioComNome_nulo() {
		// Cenario
		Usuario usuario = new Usuario();
		usuario.setRa("123456");
		try {
			// Acao
			usuario.setNome(null);
			fail("Deveria lancar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("Nome invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT07CadastrarUsuario_com_sucesso_getNome() {
		// Cenario
		Usuario usuario = new Usuario();
		usuario.setRa("123456");
		usuario.setNome("Usuario da Silva");

		assertEquals("Usuario da Silva", usuario.getNome());
	}
*/
}
