package Cosas;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ListGame {

	public static void main(String[] args) {
		int acciones = 0;
		int numero =0;
		
		int valor1 = 0;
		int valor2 = 0;
		
		Lista l1Parget = new Lista();
		Lista l2Aj = new Lista();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String caracter = null;
		

		try {
			do {
				acciones = Integer.parseInt(in.readLine());
			} while (((acciones < 1) || (acciones > 1000)));
		} catch (Exception e) {
			System.out.println("No se pudo");
		}
		
		
		while (acciones != 0) {
			try {
				caracter = in.readLine();
			} catch (Exception e) {
				System.out.println("No se pudo");
			}
			switch (caracter) {
			case "Q":
				if (l1Parget.inicio == null && l2Aj.inicio == null) {
					System.out.println("MARIOLA NO!");
				}else {
					l1Parget.recorrer();
					l2Aj.ordenar();
					l2Aj.recorrer();
					valor1 = l1Parget.inicio.dato;
					valor2 = l2Aj.inicio.dato;
					valor1 = Math.abs(valor1) + valor2;
					System.out.println(valor1);
					l1Parget.eliminarInicio();
					l2Aj.eliminarInicio();
				}
				acciones--;
				break;
			case "I":
				try {
					do {
						numero = Integer.parseInt(in.readLine());
					} while ((numero < -Math.pow(10, 12)) || (numero > Math.pow(10, 12)));
				} catch (Exception e) {
					// TODO: handle exception
				}
				l1Parget.agregarFinal(numero);
				l2Aj.agregarInicio(numero);
				acciones--;
				break;
			}
		}
	}
}

class Lista{
	Nodo inicio = null;
	Nodo fin = null;
	
	public void agregarFinal(int dato){
		Nodo aux = inicio;
		Nodo nuevo = new Nodo(dato);
		if (inicio == null) {
			inicio = nuevo;
			fin = nuevo;
		}else {
			while (aux.siguiente != null) {
				aux = aux.siguiente;
			}
			aux.siguiente = nuevo;
			nuevo.siguiente = null;
			aux = inicio;
		}
	}
	public void agregarInicio(int dato) {
		Nodo nuevo = new Nodo(dato);
		nuevo.siguiente = inicio;
		inicio = nuevo;
	}
	
	public void ordenar() {
		Nodo aux = inicio;
		while (aux != null){
			Nodo recorrer = aux.siguiente;
			while (recorrer != null) {
				if (aux.dato < recorrer.dato) {
					int auxxx= aux.dato;
					aux.dato = recorrer.dato;
					recorrer.dato = auxxx;
				}
				recorrer = recorrer.siguiente;
			}
			aux = aux.siguiente;
		}
	}
	
	public Integer recorrer() {
		int contador= 0;
		Nodo aux = inicio;
		while (aux != null) {
		//	System.out.println(aux.dato);
			aux = aux.siguiente;
			contador++;
		}
		return contador;
	}
	
	public void eliminarInicio() {
		if (inicio!= null) {
			Nodo aux = inicio;
			inicio = inicio.siguiente;
			aux.siguiente = null;
		}
	}
}

class Nodo{
	int dato;
	Nodo siguiente;
	
	public Nodo(int dato) {
		this.dato = dato;
	}
}
