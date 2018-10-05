package com.fatec.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fatec.sce.model.Livro;

public class UC01CadastrarLivro {
	
	@Test
	public void CT01CadastrarLivroComDadosValidos() {
		try {
			// Cenário
			Livro umLivro = new Livro();
			// Ação
			umLivro.setIsbn("121212");
			umLivro.setTitulo("Engenharia de Softwar");
			umLivro.setAutor("Pressman");
		} catch (RuntimeException e) {
			// Verificação
			fail("Não deve falhar");
		}
	}
	
}
