package com.fatec.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fatec.sce.model.Livro;

public class UC01CadastrarLivro {
	
	/**
	 * Objetivo: verificar o comportamento da aplica
	 */
	
	@Test
	public void CT01CadastrarLivroComDadosValidos() {
		try {
			// Cenario
			Livro livro;
			// Acao
			livro = ObtemLivro.comDadosValidos();
		} catch (RuntimeException e) {
			// Verificacao
			fail("Nao deve falhar");
		}
	}

	@Test
	public void CT02CadastrarLivroComISBN_em_branco() {
		// Cenario
		Livro livro;
		try {
			// Acao
			livro = ObtemLivro.comISBNInvalido_branco();
			fail("Deveria lançar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT03CadastrarLivroComISBN_nulo() {
		// Cenario
		Livro livro;
		try {
			// Acao
			livro = ObtemLivro.comISBNInvalido_nulo();
			fail("Deveria lançar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT04CadastrarLivro_com_sucesso_getIsbn() {
		// Cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		
		assertEquals("121212", livro.getIsbn());
	}
	
	@Test
	public void CT05CadastrarLivroComTitulo_em_branco() {
		// Cenario
		Livro livro;
		try {
			// Acao
			livro = ObtemLivro.comTituloInvalido_branco();
			fail("Deveria lançar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("Titulo invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT06CadastrarLivroComTitulo_nulo() {
		// Cenario
		Livro livro;
		try {
			// Acao
			livro = ObtemLivro.comTituloInvalido_nulo();
			fail("Deveria lançar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("Titulo invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT07CadastrarLivro_com_sucesso_getTitulo() {
		// Cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		
		assertEquals("Engenharia de Software", livro.getTitulo());
	}
	
	@Test
	public void CT08CadastrarLivroComAutor_em_branco() {
		// Cenario
		Livro livro;
		try {
			// Acao
			livro = ObtemLivro.comAutorInvalido_branco();
			fail("Deveria lançar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("Autor invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT09CadastrarLivroComAutor_nulo() {
		// Cenario
		Livro livro;
		try {
			// Acao
			livro = ObtemLivro.comAutorInvalido_nulo();
			fail("Deveria lançar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("Autor invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT10CadastrarLivro_com_sucesso_getAutor() {
		// Cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		
		assertEquals("Pressman", livro.getAutor());
	}

// Código sem refatorar
/*	@Test
	public void CT01CadastrarLivroComDadosValidos() {
		try {
			// Cenario
			Livro umLivro = new Livro();
			// Acao
			umLivro.setIsbn("121212");
			umLivro.setTitulo("Engenharia de Software");
			umLivro.setAutor("Pressman");
		} catch (RuntimeException e) {
			// Verificacao
			fail("Nao deve falhar");
		}
	}

	@Test
	public void CT02CadastrarLivroComISBN_em_branco() {
		// Cenario
		Livro livro = new Livro();
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		try {
			// Acao
			livro.setIsbn("");
			fail("Deveria lançar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT03CadastrarLivroComISBN_nulo() {
		// Cenario
		Livro livro = new Livro();
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		try {
			// Acao
			livro.setIsbn(null);
			fail("Deveria lançar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT04CadastrarLivro_com_sucesso_getIsbn() {
		// Cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		
		assertEquals("121212", livro.getIsbn());
	}
	
	@Test
	public void CT05CadastrarLivroComTitulo_em_branco() {
		// Cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setAutor("Pressman");
		try {
			// Acao
			livro.setTitulo("");
			fail("Deveria lançar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("Titulo invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT06CadastrarLivroComTitulo_nulo() {
		// Cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setAutor("Pressman");
		try {
			// Acao
			livro.setTitulo(null);
			fail("Deveria lançar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("Titulo invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT07CadastrarLivro_com_sucesso_getTitulo() {
		// Cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		
		assertEquals("Engenharia de Software", livro.getTitulo());
	}
	
	@Test
	public void CT08CadastrarLivroComAutor_em_branco() {
		// Cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		try {
			// Acao
			livro.setAutor("");
			fail("Deveria lançar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("Autor invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT09CadastrarLivroComAutor_nulo() {
		// Cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		try {
			// Acao
			livro.setAutor(null);
			fail("Deveria lançar uma excecao");
		} catch (RuntimeException e) {
			// Verificacao
			assertEquals("Autor invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT10CadastrarLivro_com_sucesso_getAutor() {
		// Cenario
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		
		assertEquals("Pressman", livro.getAutor());
	}
*/	
}
