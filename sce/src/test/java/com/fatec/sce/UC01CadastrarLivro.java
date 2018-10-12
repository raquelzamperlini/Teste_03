package com.fatec.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fatec.sce.model.Livro;

public class UC01CadastrarLivro {
	
	@Test
	public void CT01CadastrarLivroComDadosValidos() {
		try {
			// Cenário
			Livro livro;
			// Ação
			livro = ObtemLivro.comDadosValidos();
		} catch (RuntimeException e) {
			// Verificação
			fail("Não deve falhar");
		}
	}

	@Test
	public void CT02CadastrarLivroComISBN_em_branco() {
		// Cenário
		Livro livro;
		try {
			// Ação
			livro = ObtemLivro.comISBNInvalido_branco();
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("ISBN invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT03CadastrarLivroComISBN_nulo() {
		// Cenário
		Livro livro;
		try {
			// Ação
			livro = ObtemLivro.comISBNInvalido_nulo();
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("ISBN invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT04CadastrarLivro_com_sucesso_getIsbn() {
		// Cenário
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		
		assertEquals("121212", livro.getIsbn());
	}
	
	@Test
	public void CT05CadastrarLivroComTitulo_em_branco() {
		// Cenário
		Livro livro;
		try {
			// Ação
			livro = ObtemLivro.comTituloInvalido_branco();
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("Titulo invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT06CadastrarLivroComTitulo_nulo() {
		// Cenário
		Livro livro;
		try {
			// Ação
			livro = ObtemLivro.comTituloInvalido_nulo();
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("Titulo invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT07CadastrarLivro_com_sucesso_getTitulo() {
		// Cenário
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		
		assertEquals("Engenharia de Software", livro.getTitulo());
	}
	
	@Test
	public void CT08CadastrarLivroComAutor_em_branco() {
		// Cenário
		Livro livro;
		try {
			// Ação
			livro = ObtemLivro.comAutorInvalido_branco();
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("Autor invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT09CadastrarLivroComAutor_nulo() {
		// Cenário
		Livro livro;
		try {
			// Ação
			livro = ObtemLivro.comAutorInvalido_nulo();
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("Autor invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT10CadastrarLivro_com_sucesso_getAutor() {
		// Cenário
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
			// Cenário
			Livro umLivro = new Livro();
			// Ação
			umLivro.setIsbn("121212");
			umLivro.setTitulo("Engenharia de Software");
			umLivro.setAutor("Pressman");
		} catch (RuntimeException e) {
			// Verificação
			fail("Não deve falhar");
		}
	}

	@Test
	public void CT02CadastrarLivroComISBN_em_branco() {
		// Cenário
		Livro livro = new Livro();
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		try {
			// Ação
			livro.setIsbn("");
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("ISBN invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT03CadastrarLivroComISBN_nulo() {
		// Cenário
		Livro livro = new Livro();
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		try {
			// Ação
			livro.setIsbn(null);
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("ISBN invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT04CadastrarLivro_com_sucesso_getIsbn() {
		// Cenário
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		
		assertEquals("121212", livro.getIsbn());
	}
	
	@Test
	public void CT05CadastrarLivroComTitulo_em_branco() {
		// Cenário
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setAutor("Pressman");
		try {
			// Ação
			livro.setTitulo("");
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("Titulo invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT06CadastrarLivroComTitulo_nulo() {
		// Cenário
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setAutor("Pressman");
		try {
			// Ação
			livro.setTitulo(null);
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("Titulo invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT07CadastrarLivro_com_sucesso_getTitulo() {
		// Cenário
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		
		assertEquals("Engenharia de Software", livro.getTitulo());
	}
	
	@Test
	public void CT08CadastrarLivroComAutor_em_branco() {
		// Cenário
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		try {
			// Ação
			livro.setAutor("");
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("Autor invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT09CadastrarLivroComAutor_nulo() {
		// Cenário
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		try {
			// Ação
			livro.setAutor(null);
			fail("Deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// Verificação
			assertEquals("Autor invalido", e.getMessage());
		}
	}
	
	@Test
	public void CT10CadastrarLivro_com_sucesso_getAutor() {
		// Cenário
		Livro livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		
		assertEquals("Pressman", livro.getAutor());
	}
*/	
}
