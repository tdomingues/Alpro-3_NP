package br.pucrs.alpro3;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArvoreTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void testChaveDuplicada() {
		Arvore a = new Arvore();
		a.inserir(10);
		a.inserir(30);
		a.inserir(20);
		a.inserir(30);
	}

	@Test
	public void testArvoreVazia() {
		Arvore a = new Arvore();
		String expected = "[]";
		String actual = a.toString();
		assertEquals(expected, actual);	
	}	

	@Test
	public void testArvoreCom10() {
		Arvore a = new Arvore();
		a.inserir(10);
		String expected = "[10]";
		String actual = a.toString();
		assertEquals(expected, actual);	
	}	
	
	@Test
	public void testArvoreCom30E10E20() {
		Arvore a = new Arvore();
		a.inserir(30);
		a.inserir(10);
		a.inserir(20);
		String expected = "[10, 20, 30]";
		String actual = a.toString();
		assertEquals(expected, actual);	
	}	

	@Test
	public void testArvoreCom20E10E30() {
		Arvore a = new Arvore();
		a.inserir(20);
		a.inserir(10);
		a.inserir(30);
		String expected = "[10, 20, 30]";
		String actual = a.toString();
		assertEquals(expected, actual);	
	}	

	@Test
	public void testArvoreComTamanhoZero() {
		Arvore a = new Arvore();
		int expected = 0;
		int actual = a.tamanho();
		assertEquals(expected, actual);	
	}	
	
	@Test
	public void testArvoreComTamanhoUm() {
		Arvore a = new Arvore();
		a.inserir(10);
		int expected = 1;
		int actual = a.tamanho();
		assertEquals(expected, actual);	
	}	
	
}
