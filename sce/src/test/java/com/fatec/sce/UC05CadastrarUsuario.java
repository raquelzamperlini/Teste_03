package com.fatec.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fatec.sce.model.Livro;
import com.fatec.sce.model.Usuario;

public class UC05CadastrarUsuario {

	@Test
	public void CT01CadastrarUsuarioComDadosValidos() {
		try {
			// Cenário
			Usuario usuario = new Usuario();
			// Ação
			usuario.setRa("12121212");
			usuario.setNome("Usuario da Silva");
		} catch (RuntimeException e) {
			// Verificação
			fail("Não deve falhar");
		}
	}

	@Test
	public void CT02CadastrarUsuarioComRa_em_branco() {
		// Cenário
		Usuario usuario = new Usuario();
		usuario.setNome("Usuario da Silva");
		try {
			// Ação
			usuario.setRa("");
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("RA invalido", e.getMessage());
		}
	}

	@Test
	public void CT03CadastrarUsuarioComRa_nulo() {
		// Cenário
		Usuario usuario = new Usuario();
		usuario.setNome("Usuario da Silva");
		try {
			// Ação
			usuario.setRa(null);
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("RA invalido", e.getMessage());
		}
	}

	@Test
	public void CT04CadastrarUsuario_com_sucesso_getRa() {
		// Cenário
		Usuario usuario = new Usuario();
		usuario.setRa("123456");
		usuario.setNome("Usuario da Silva");

		assertEquals("123456", usuario.getRa());
	}
	
	@Test
	public void CT05CadastrarUsuarioComNome_em_branco() {
		// Cenário
		Usuario usuario = new Usuario();
		usuario.setRa("123456");
		try {
			// Ação
			usuario.setNome("");
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("Nome invalido", e.getMessage());
		}
	}

	@Test
	public void CT06CadastrarUsuarioComNome_nulo() {
		// Cenário
		Usuario usuario = new Usuario();
		usuario.setRa("123456");
		try {
			// Ação
			usuario.setNome(null);
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("Nome invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT07CadastrarUsuario_com_sucesso_getNome() {
		// Cenário
		Usuario usuario = new Usuario();
		usuario.setRa("123456");
		usuario.setNome("Usuario da Silva");

		assertEquals("Usuario da Silva", usuario.getNome());
	}

}
