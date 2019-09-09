package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DosEstructuras {

	public static void main(String[] args) {
		Integer totalAcciones = null;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			totalAcciones = Integer.parseInt(in.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Cola cola = new Cola();
		Pila pila = new Pila();
		
		for(int c = 0; c < totalAcciones; c++) {
			String accion = null;
			
			try {
				accion = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(accion.equals("meter datos")) {
				try {
					Integer dato = Integer.parseInt(in.readLine());
					cola.offer(dato);
					pila.push(dato);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(accion.equals("sacar datos")) {
				Nodo nodoPila = pila.pop();
				Nodo nodoCola = cola.remove();
				
				System.out.println(nodoPila.dato + " " + nodoCola.dato);
			}
		}
	}
	
	static class Cola {
		Nodo inicio;
		
		public void offer(Integer dato) {
			Nodo newNodo = new Nodo(dato);
			
			if(inicio == null) {
				inicio = newNodo;
			} else {
				Nodo nodoAux = inicio;
				Nodo anterior = null;
				
				while(nodoAux != null) {
					anterior = nodoAux;
					nodoAux = nodoAux.anterior;
				}
				
				anterior.anterior = newNodo;
				newNodo.siguiente = anterior;
			}
		}
		
		public Nodo remove() {
			if(inicio == null) 
				return null;
			
			Nodo nodoAux = inicio;
			Nodo nodoSig = inicio.anterior;
			
			inicio = nodoSig;
			
			if(nodoSig != null) {
				nodoSig.siguiente = null;
			}
			
			nodoAux.anterior = null;
			nodoAux.siguiente = null;
			
			return nodoAux;
		}
	}
	
	static class Pila {
		Nodo fin;
		
		public void push(Integer dato) {
			Nodo newNodo = new Nodo(dato);
			
			if(fin == null) {
				fin = newNodo;
			} else {
				Nodo nodoAux = fin;
				
				newNodo.anterior = nodoAux;
				nodoAux.siguiente = newNodo;
				
				fin = newNodo;
			}
		}
		
		public Nodo pop() {
			if(fin == null) 
				return null;
			
			Nodo nodoAux = fin;
			fin = nodoAux.anterior;
			return nodoAux;
		}
	}


	static class Nodo {
		Integer dato;
		Nodo siguiente;
		Nodo anterior;
		
		public Nodo(Integer dato) {
			this.dato = dato;
		}
	}
}
