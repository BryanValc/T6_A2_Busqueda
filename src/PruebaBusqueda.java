import java.util.Arrays;
import java.util.Scanner;


class Insercion {
	
	public static int[] ordenacionInsercion(int nums[]) {
		int numeros[]=nums.clone();
		int aux;
		
		for (int i = 1; i < numeros.length; i++) {
			aux=numeros[i];
			for (int j=i-1; j>=0 && numeros[j]>aux ; j--) {
				numeros[j+1]=numeros[j];
				numeros[j]=aux;
			}
			
		}
		
		return numeros;
		
	}
	
}//class Insercion


class Menu{
	static Scanner input = new Scanner(System.in);
	
	public static void impresionNumeros(int[] nums) {
		System.out.println();
		
		int max = nums[0];
	    for (int a : nums) {
	        if (a > max)
	            max = a;
	    }
	    int maxS= Integer.toString(max).length();
		
		if (nums.length<=900) {
			for (int i = 0; i < nums.length; i++) {
				
				if(i!=0 && i%((int)Math.sqrt(nums.length))==0) {
					System.out.println();
				}else if(i==0) {
					System.out.print("[");
				}
				System.out.print(nums[i]);
				for (int k = 0; k < (maxS-Integer.toString(nums[i]).length()); k++) {
					System.out.print(' ');
				}
				if(i==0) {
					System.out.print(' ');
				}else {
					System.out.print("  ");
				}
				
			}
		}else {
			System.out.println("El arreglo es demasiado largo y el menu se puede bugear, solo se van a imprimir 900 muestras");
			int salto = (int)(nums.length/900);
			int j = -1;
			for (int i = (int)(salto/2); i < nums.length; i+=salto) {
				j+=1;
				if(i!=0 && j%30==0) {
					System.out.println();
				}else if(i==salto) {
					System.out.print("[");
				}
				System.out.print(nums[i]);
				for (int k = 0; k < (maxS-Integer.toString(nums[i]).length()); k++) {
					System.out.print(' ');
				}
				if(i==0) {
					System.out.print(' ');
				}else {
					System.out.print("  ");
				}
				
			}
		}
		System.out.println("]");
	}
	
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

	public boolean busquedaBin(int[] numeros, int valorBuscado) {
		int[] contador= new int[2];

		int inicio=0;
		int fin=numeros.length-1;
		int x=0;
		contador[0]++;
		while (inicio<=fin) {
			int puntero=(int)((inicio+fin)/2);
			contador[1]++;
			if (valorBuscado == numeros[puntero]) {
				x=1;
				break;
			}else if(valorBuscado>numeros[puntero]) {
				inicio=puntero+1;
			}else {
				fin=puntero-1;
			}
				
		}
		System.out.println("Numero de recorridos "+contador[0]);
		System.out.println("Numero de comparaciones "+contador[1]);
		return x==1;

	}

}

class Hash{
	String[] arreglo;
	int tamaño;
	int contador;
	int [] contador1=new int[2];
	public void reiniciarContador() {
		contador1[0]=0;
		contador1[1]=0;
	}
	public void mostrarContador() {
		System.out.println("Numero de recorridos "+contador1[0]);
		System.out.println("Numero de comparaciones "+contador1[1]);
		contador1[0]=0;
		contador1[1]=0;
	}
	// Constructor
	public Hash(int tam) {
		tamaño = tam;
		arreglo = new String[tam];
		Arrays.fill(arreglo, "-1");
	}

	public void funcionHash(String[] cadArreglo, String[] arreglo) {
		int i;
		// Ciclo para asiganar a la varible elemento el valor de la cadena
		contador1[0]++;
		for (i = 0; i < cadArreglo.length; i++) {
			String elemento = cadArreglo[i];
			int indiceArreglo = Integer.parseInt(elemento) % 20;
			System.out.println("Indice: " + indiceArreglo + " para " + elemento);
			// Mpetodo para solucionar una colision
			contador1[0]++;
			while (arreglo[indiceArreglo] != "-1") {
				contador1[1]++;
				;
				indiceArreglo++;
				System.out.println("Colisión en el indice: " + (indiceArreglo - 1) + " cambiando por " + indiceArreglo);
				indiceArreglo %= tamaño; 
			}
			arreglo[indiceArreglo] = elemento;
		}
	}

	// Metodo para mostrar la funcion hash
	public void mostrar() {
		int incremento = 0;
		int j;

		for (int i = 0; i < 1; i++) {
			incremento += 100;
			System.out.println("");
			System.out.println("------------------------------------------------------------------");
			for (j = incremento - 100; j < incremento; j++) {
				System.out.format(" | %3s " + " ", j);
			}
			System.out.println(" | ");
			System.out.println();
			for (j = incremento - 100; j < incremento; j++) {
				if (arreglo[j].equals("-1")) {
					System.out.println(" | ");
				} else {
					System.out.print(String.format(" | %3s" + " ", arreglo[j]));
				}
			}

			System.out.println("|");
			System.out.println("------------------------------------------------------------------");
			System.out.println("");
		}
	}

	// Metodo para buscar una clave de los elementos
	public String buscarClave(String elemento) {
		
		int indiceArrglo = Integer.parseInt(elemento) % 99;
		int contador = 0;
		contador1[0]++;
		while (arreglo[indiceArrglo] != "-1") {
			contador1[1]++;
			if (arreglo[indiceArrglo].equals(elemento)) {
				System.out.println("Elemento " + elemento + " se encontro en el indice " + indiceArrglo);
				return arreglo[indiceArrglo];
			}
			indiceArrglo++;
			indiceArrglo %= tamaño;
			contador++;
			contador1[1]++;
			if (contador > 100) {
				System.out.println("------Error-------");
				break;
			}
		}
		return null;
	}
}


public class PruebaBusqueda {

	public static void main(String[] args) {
		
		int cnt=100;
		int[] nums = new int[cnt];
		for (int i = 0; i < 100; i++) {
			nums[i]=(int)(Math.random()*100);
		}
		
		Menu.impresionNumeros(nums);
		boolean salir=false;
		String[] opciones = {"Buscar valor por Busqueda Binaria","Buscar valor por Hash"};
		
		do {
			
			Menu.mostrarMenu(opciones);
			byte opc= (byte) Menu.validacionNatural();
			
			if (opc==(opciones.length+1)) {
				salir=true;
			}else {
				switch (opc) {
				case 1:
					System.out.println("Valor a buscar:");
					int valor = Menu.validacionNatural();
					long ini = System.nanoTime();
					int[] numeros = Insercion.ordenacionInsercion(nums);
					
					BusquedaBinaria bb = new BusquedaBinaria();
					
					if(bb.busquedaBin(numeros, valor)) {
						System.out.println(valor+" encontrado");
					}else {
						System.out.println(valor+" no encontrado");
					}
					long fin = System.nanoTime();
					System.out.println("Ejecucion en milisegundos: "+(fin-ini));
					
					break;
				case 2:
					
					String[] numsHash=new String[cnt];
					for (int i = 0; i < cnt; i+=1) {
						numsHash[i]=Integer.toString(nums[i]);
					}
					
					Hash funcion = new Hash(100);
					funcion.funcionHash(numsHash, funcion.arreglo);
					
					System.out.println("Valor a buscar");
					long inic = System.nanoTime();
					String elemento = Integer.toString(Menu.validacionNatural());
					String buscarElemento = funcion.buscarClave(elemento);	
					if(buscarElemento==null) {
						System.out.println("\nElemento no encontrado");
					}
					
					funcion.mostrarContador();
					long fina = System.nanoTime();
					System.out.println("Ejecucion en milisegundos: "+(fina-inic));
					
					
					
					break;
				default:System.out.println("Opción no válida");break;
				}//switch
				Menu.impresionNumeros(nums);
			}//else
			
		} while (!salir);
		System.out.println("Fin de ejecucion");

	}

}
