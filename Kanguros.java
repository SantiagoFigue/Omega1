package Main;


import java.util.Scanner;

public class Kanguros {

	public static void main(String[] args) {
		int cantidad;
		int acciones;
		Lista kanguros = new Lista();
		int entero;
		String caracteres; 
		
		Scanner scanCantidades = new Scanner(System.in);
		Scanner canguritos = new Scanner(System.in);
		Scanner scanAcciones = new Scanner(System.in);
		
		cantidad = scanCantidades.nextInt();
		acciones = scanAcciones.nextInt();
		
		for (int i = 0; i < acciones; i++) {
			Scanner caracter= new Scanner(System.in);
			caracteres = caracter.nextLine();
			System.out.println("Ingreso caracter");
			switch (caracteres) {
			case "N":
				entero = canguritos.nextInt();
				kanguros.agregar(entero);
				break;
			case "A":
				kanguros.eliminar();
				
				break;
			case "C":
				kanguros.recorrer();
				break;
			case "R":
				kanguros.consumir();
				break;

			default:
				break;
			}
		}
	}

}

class Lista{
	Kanguro inicio = null;
	Kanguro fin = null;
	public void agregar(int kanguritos) {
		Kanguro nuevo = new Kanguro();
		nuevo.kanguritos = kanguritos;
		if (inicio == null) {
			inicio =  nuevo;
			nuevo.siguiente = null;
			fin = nuevo;
		}else {
			fin.siguiente = nuevo;
			nuevo.siguiente = null;
			fin = nuevo;
		}
	}
	
	public void eliminar() {
		if (inicio == fin) {
			inicio = null;
			fin = null;
		}else {
			inicio = inicio.siguiente;
		}
	}
	
	public void recorrer() {
		int contador= 0;
		Kanguro aux = inicio;
		while (aux != null) {
			aux = aux.siguiente;
			contador++;
		}
		System.out.println(contador);
	}
	
	public void consumir() {
		Kanguro aux = null;
		int contador1 = 0;
		int contador2 = 0;
		while (aux != null) {
			contador2+= aux.kanguritos;
			aux = aux.siguiente;
			contador1++;
		}
		System.out.println(contador1+contador2);
		
		
	}
}
class Kanguro{
	int kanguritos;
	Kanguro siguiente;
}