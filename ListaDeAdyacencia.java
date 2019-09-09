package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ListaDeAdyacencia {
	
	public static void main(String ... args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//Tamaño máximo dato 
		Integer vertices = null;
		//Tamaño for loop
		Integer aristas = null;
		
		try {
			String[] datos = in.readLine().split("\\s+");
			vertices = Integer.parseInt(datos[0]);
			aristas = Integer.parseInt(datos[1]);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Lista[] listas = new Lista[vertices];
		for(int b = 0; b < vertices; b++){
			listas[b] = new Lista();
		}
		
		for(int c = 0; c < aristas; c++) {
			Integer verticeA = null;
			Integer verticeB = null;
			
			try {
				String[] verticesString = in.readLine().split(" ");
				verticeA = Integer.parseInt(verticesString[0]);
				verticeB = Integer.parseInt(verticesString[1]);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			listas[verticeA].insertar(verticeB);
			listas[verticeB].insertar(verticeA);
		}
		
		// Impresión
		for(int d = 0; d < listas.length; d++) {
			System.out.print(d+ ": ");
			listas[d].imprimir();
			System.out.println();
		}
	}
	
	static class Lista {
		Nodo inicio;
		
		public void insertar(int dato) {
			Nodo newNodo = new Nodo(dato);
			
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
		
		public void imprimir() {
			if(inicio != null) {
				Nodo aux = inicio;
				Nodo ant = null;
				
				while(aux != null) {
					ant = aux;
					aux = aux.siguiente;
					
					System.out.print(ant.dato);
					if(aux != null) {
						System.out.print("->");
					}
				}
			}
		}
	}
	
	static class Nodo {
		Nodo siguiente;
		int dato;
		
		public Nodo(int dato) {
			this.dato = dato;
		}
	}
}