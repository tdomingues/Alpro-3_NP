package br.pucrs.alpro3;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public class Arvore {

	private static class Nodo {
		int chave;
		Nodo direito;
		Nodo esquerdo;

		Nodo(int chave) {
			this.chave = chave;
		}
	}

	private Nodo raiz;
	private int contador;

	/**
	 * 
	 * @param chave
	 * @return
	 */
	public boolean contem(int chave) {
		return contem0(raiz, chave);
	}

	private boolean contem0(Nodo nodo, int chave) {
		if (nodo == null) {
			return false;
		}
		if (nodo.chave < chave)
			return contem0(nodo.direito, chave);
		else if (nodo.chave > chave)
			return contem0(nodo.esquerdo, chave);
		else
			return true;
	}

	/**
	 * Deve gerar exceção no caso de chave duplicada.
	 * @param chave
	 */
	public void inserir(int chave) {
		raiz = inserir0(raiz, chave);
	}

	private Nodo inserir0(Nodo nodo, int chave) {
		if (nodo == null) {
			contador++;
			return new Nodo(chave);
		}
		if (nodo.chave < chave)
			nodo.direito = inserir0(nodo.direito, chave);
		else if (nodo.chave > chave)
			nodo.esquerdo = inserir0(nodo.esquerdo, chave);
		else
			throw new IllegalArgumentException("chave duplicada");
		return nodo;
	}

	@Override
	public String toString() {
		List<Integer> chaves = new ArrayList<>();
		toString0(raiz, chaves);
		return chaves.toString();
	}

	private void toString0(Nodo nodo, List<Integer> chaves) {
		if (nodo == null)
			return;
		toString0(nodo.esquerdo, chaves);
		chaves.add(nodo.chave);
		toString0(nodo.direito, chaves);
	}

	/**
	 * 
	 * @return
	 */
	public int tamanho() {
		return contador;
	}

	/**
	 * 
	 * @return
	 */
	public int altura() {
		return altura0(raiz);
	}

	private int altura0(Nodo nodo) {
		if (nodo == null)
			return -1;
		return 1 + Math.max(altura0(nodo.esquerdo), altura0(nodo.direito));
	}

}
