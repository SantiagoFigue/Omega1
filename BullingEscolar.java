package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BullingEscolar {
	public static void main(String ... args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Integer action = null;
		
		try {
			action = Integer.parseInt(in.readLine());
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		while(action != null && action > 0) {
			Lista lista = new Lista();
			
			for(int c = 0; c < action; c++) {
				String[] valores = null;
				
				try {
					valores = in.readLine().split("\\s+");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Integer dato = null;
				
				try {
					dato = Integer.parseInt(valores[0]) * Integer.parseInt(valores[1]) * Integer.parseInt(valores[2]);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				lista.insertar(dato, valores[3]);
			}
			
			Nodo bully = lista.getMayor();
			Nodo victima = lista.getMenor();
			
			System.out.println(bully.nombre + " took clay from " + victima.nombre + ".");
			
			try {
				action = Integer.parseInt(in.readLine());
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}
	}
	
	static class Lista {
		Nodo inicio;
		
		public void insertar(Integer dato, String nombre) {
			Nodo newNodo = new Nodo(dato, nombre);
			
			if(inicio == null) {
				inicio = newNodo;
			} else {
				Nodo aux = inicio;
				Nodo ant = null;
				
				while(aux != null) {
					ant = aux;
					aux = aux.siguiente;
				}
				
				ant.siguiente = newNodo;
			}
		}
		
		public Nodo getMayor() {
			if(inicio == null) {
				return null;
			} 
			
			Nodo nodoAux = inicio;
			Nodo nodoMayor = inicio;
			
			while(nodoAux != null) {
				if(nodoMayor.dato < nodoAux.dato) 
					nodoMayor = nodoAux;
				
				nodoAux = nodoAux.siguiente;
			}
			
			return nodoMayor;
		}
		
		public Nodo getMenor() {
			if(inicio == null) 
				return null;
			
			Nodo nodoAux = inicio;
			Nodo nodoMenor = inicio;
			
			while(nodoAux != null) {
				if(nodoMenor.dato > nodoAux.dato) {
					nodoMenor = nodoAux;
				}
				
				nodoAux = nodoAux.siguiente;
			}
			
			return nodoMenor;
		}
	}
	
	static class Nodo {
		Integer dato;
		String nombre;
		Nodo siguiente;
		
		public Nodo(Integer dato, String nombre) {
			this.dato = dato;
			this.nombre = nombre;
		}
	}
}
