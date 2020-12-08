import java.util.Arrays;
import java.util.Scanner;

class Menu{
	static Scanner input = new Scanner(System.in);
	
	public static int validacionNatural() {
		int ret = 0;
		boolean err = false;
		do {
			try {
				ret = input.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println("entrada no valida, intente de nuevo:");
				input.nextLine();
				err=true;
			}
			if (ret>0) {
				err=false;
			}else {
				System.out.println("solo números naturales");
				err=true;
			}
		}while(err);
		return ret;
	}
	
	public static void mostrarMenu(String[] opciones) {//Imprime opciones
		System.out.println();
		for (int i = 0; i < opciones.length; i++) {
			System.out.println((i+1)+")"+opciones[i]);
		}
		System.out.println((opciones.length+1)+")Salir\n");
	}
}//class Menu

class BusquedaBinaria {

	public static boolean busquedaBin(int[] numeros, int valorBuscado) {

		int inicio=0;
		int fin=numeros.length-1;
		int x=0;
		while (inicio<=fin) {
			int puntero=(int)((inicio+fin)/2);
			if (valorBuscado == numeros[puntero]) {
				x=1;
				break;
			}else if(valorBuscado>numeros[puntero]) {
				inicio=puntero+1;
			}else {
				fin=puntero-1;
			}
				
		}
		return x==1;

	}

}

class FuncionHash {

	private String[] arreglo;
	private int tamaño;
	private int contador;
	
	public String[] getArreglo(){
		return this.arreglo;
	}

	// Constructor
	public FuncionHash(int tam) {
		tamaño = tam;
		arreglo = new String[tam];
		Arrays.fill(arreglo, "-1");
	}

	// Funcion HASH
	public void funcionHash(String[] cadArreglo, String[] arreglo) {
		int i;
		// Ciclo para asiganar a la varible elemento el valor de la cadena
		for (i = 0; i < cadArreglo.length; i++) {
			String elemento = cadArreglo[i];
			int indiceArreglo = Integer.parseInt(elemento) % 7;
			System.out.println("Indice: " + indiceArreglo + " para " + elemento);
			// Mpetodo para solucionar una colision
			while (arreglo[indiceArreglo] != "-1") {
				indiceArreglo++;
				System.out.println("Colisión en el indice: " + (indiceArreglo - 1) + " cambiando por " + indiceArreglo);
				// Cambiar al indice siguiente y asi evitar la colision
				indiceArreglo %= tamaño; // Para volver a sacar el valor
			}
			arreglo[indiceArreglo] = elemento;
		}
	}

	// Metodo para mostrar la funcion hash
	public void mostrar() {
		int incremento = 0;
		int j;

		for (int i = 0; i < 1; i++) {
			incremento += 8;
			for (j = 0; j < 100; j++) {
			}
			System.out.println("");
			System.out.println("------------------------------------------------------------------");
			for (j = incremento - 8; j < incremento; j++) {
				System.out.format(" | %3s " + " ", j);
			}
			System.out.println(" | ");
			for (int k = 0; k < 100; k++) {
			}
			System.out.println();
			for (j = incremento - 8; j < incremento; j++) {
				if (arreglo[j].equals("-1")) {
					System.out.println(" | ");
				} else {
					System.out.print(String.format(" | %3s" + " ", arreglo[j]));
				}
			}

			System.out.println("|");
			System.out.println("------------------------------------------------------------------");
			for (j = 0; j < 100; j++) {
			}
			System.out.println("");
		}
	}

	// Metodo para buscar una clave de los elementos
	public String buscarClave(String elemento) {
		
		int indiceArrglo = Integer.parseInt(elemento) % 7;
		int contador = 0;
		
		while (arreglo[indiceArrglo] != "-1") {
			if (arreglo[indiceArrglo] == elemento) {
				System.out.println("Elemento " + elemento + " se encontro en el indice" + indiceArrglo);
				return arreglo[indiceArrglo];
			}
			indiceArrglo++;
			indiceArrglo %= tamaño;
			contador++;
			if (contador > 7) {
				System.out.print("Error");
				break;
			}
		}
		return null;
	}
	
}


public class PruebaBusqueda {

	public static void main(String[] args) {
		
		int[] nums = new int[100];
		for (int i = 0; i < 100; i++) {
			nums[i]=(int)(Math.random()*100);
		}

	}

}
