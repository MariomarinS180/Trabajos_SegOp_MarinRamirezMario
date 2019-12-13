import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Ordenar {
	static class Burbuja{
		static long tInicio, tfin;
		public static void ordenarBurbujaUno(int numeros[]) {
			tInicio = System.nanoTime(); 
			for (int i = 1; i < numeros.length; i++) {
				for (int j = 0; j < numeros.length -i; j++) {
					if(numeros[j]>numeros[j+1]) {
						int aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux; 
					}
				}
			}
			tfin = System.nanoTime();
		}//ordenar burbuja uno
		
		
		public static void ordenarBurbujaDos(int numeros[]) {
			tInicio = System.nanoTime();
			int i = 1;
			boolean ordenado = false;
			while ((i < numeros.length) || (ordenado == false)) {
				i = i + 1;
				ordenado = true;
				for (int j = 0; j < numeros.length - i; j++) {
					if (numeros[j] > numeros[j + 1]) {
						ordenado = false;
						int aux = numeros[j];
						numeros[j] = numeros[j + 1];
						numeros[j + 1] = aux;
					}
				}
			tfin = System.nanoTime();
			}
		}//ordenar burbuja dos
		
		public static void ordenarBurbujaTres(int numeros[]) {
			tInicio = System.nanoTime();
			int i = 1;
			boolean ordenado = true;
			do {
				i = i + 1;
				for (int j = 0; j < numeros.length - i; j++) {
					if (numeros[j] < numeros[j + 1]) {
						ordenado = false;
						int aux = numeros[j];
						numeros[j] = numeros[j + 1];
						numeros[j + 1] = aux;
					}
				}
			} while (i < numeros.length || ordenado == true);
			tfin = System.nanoTime();
		}//ordenar burbuja 3
	}//class burbuja 
	
	public void mostrarVector (int vector[]) {
		System.out.println(Arrays.toString(vector));
	}//mostrarVector
}//class ordenar
public class PruebaBurbuja{
	public static void main (String [] args) {
		
		/*
		 * 1) Object.clone()
		 * 2) System.arrayCopy
		 * 3) Arrays.copyOf(array, long)
		 * 4) Arrays.copyOfRange(array, long)
		 */
		
		
		Ordenar or = new Ordenar(); 
		//Generar aleatoriamente 1 millon de números. 
		int datos[] = {30, 200, 6, 10, 65, 70, 150, 4, 200, 1}; 
		int datosCopia[] = datos.clone(); 
		/*int millon [] = new int[1000];
		System.out.println("LLenando vector con Mil de números...");
		for (int i = 0; i < millon.length; i++) {
		millon[i] = new Random().nextInt(); 
		}
		System.out.println("Llenado finalizado...");
		*/
		
		System.out.println("Vector desordenado:");
		or.mostrarVector(datos);
			
		Ordenar.Burbuja.ordenarBurbujaUno(datos);
		System.out.println("Vector ordenado por BURBUJA 1: ");
		or.mostrarVector(datos);
		System.out.println("Tiempo de ejecucion --> " + (Ordenar.Burbuja.tfin - Ordenar.Burbuja.tInicio) + " Nanosegundos");
		System.out.println("===================================================");
		System.out.println("Vector desordenado:");
		or.mostrarVector(datosCopia);
		Ordenar.Burbuja.ordenarBurbujaDos(datosCopia);
		System.out.println("Vector ordenado por BURBUJA 2: ");
		or.mostrarVector(datosCopia);
		System.out.println("Tiempo de ejecucion --> " + (Ordenar.Burbuja.tfin - Ordenar.Burbuja.tInicio)+ "Nanosegundos");
		System.out.println("===================================================");
		System.out.println("Vector desordenado:");
		or.mostrarVector(datosCopia);
		Ordenar.Burbuja.ordenarBurbujaTres(datosCopia);
		System.out.println("Vector ordenado por BURBUJA 3: ");
		or.mostrarVector(datosCopia);
		System.out.println("Tiempo de ejecucion --> " + (Ordenar.Burbuja.tfin - Ordenar.Burbuja.tInicio)+ "Nanosegundos");
		
		Scanner e = new Scanner(System.in);
		byte opc = 0; 
		System.out.println("^ VECTOR PEQUEÑO DE PRUEBA ^");
		System.out.println("Ingrese un opción para generar un vector de n numeros:\n1.-1,000\n2.-10,000\n3.-100,000\n4.-1,000,000 ");
		opc = e.nextByte();
		switch (opc) {
		case 1:
			System.out.println("Generando vector con 1,000 numeros...");
			int mil [] = new int[1000];
			System.out.println("Llenando vector con 1,000 de números...");
			for (int i = 0; i < mil.length; i++) {
			mil[i] = new Random().nextInt();
			}
			int milCopia[] = mil.clone();
			System.out.println("Llenado Finalizado.");
			System.out.println("Vector ordenado por BURBUJA 1");
			Ordenar.Burbuja.ordenarBurbujaUno(mil);
			or.mostrarVector(mil);
			System.out.println("Tiempo de ejecucion --> " + (Ordenar.Burbuja.tfin - Ordenar.Burbuja.tInicio)+ " Nanosegundos");
			System.out.println("=============================================================================");
			System.out.println("Vector ordenado por BURBUJA 2");
			Ordenar.Burbuja.ordenarBurbujaDos(milCopia);
			or.mostrarVector(milCopia);
			System.out.println("Tiempo de ejecucion --> " + (Ordenar.Burbuja.tfin - Ordenar.Burbuja.tInicio)+ " Nanosegundos");
			System.out.println("=============================================================================");
			System.out.println("Vector ordenado por BURBUJA 3");
			Ordenar.Burbuja.ordenarBurbujaTres(milCopia);
			or.mostrarVector(milCopia);
			System.out.println("Tiempo de ejecucion --> " + (Ordenar.Burbuja.tfin - Ordenar.Burbuja.tInicio)+ " Nanosegundos");
			break;
		case 2:
			System.out.println("Generando vector con 10,000 numeros...");
			int cienmil [] = new int[10000];
			System.out.println("Llenando vector con 10,000 de números...");
			for (int i = 0; i < cienmil.length; i++) {
			cienmil[i] = new Random().nextInt();
			}
			int cienmilCopia[] = cienmil.clone();
			System.out.println("Llenado Finalizado.");
			System.out.println("Vector ordenado por BURBUJA 1");
			Ordenar.Burbuja.ordenarBurbujaUno(cienmil);
			or.mostrarVector(cienmil);
			System.out.println("Tiempo de ejecucion --> " + (Ordenar.Burbuja.tfin - Ordenar.Burbuja.tInicio)+ " Nanosegundos");
			System.out.println("=============================================================================");
			System.out.println("Vector ordenado por BURBUJA 2");
			Ordenar.Burbuja.ordenarBurbujaDos(cienmilCopia);
			or.mostrarVector(cienmilCopia);
			System.out.println("Tiempo de ejecucion --> " + (Ordenar.Burbuja.tfin - Ordenar.Burbuja.tInicio)+ " Nanosegundos");
			System.out.println("=============================================================================");
			System.out.println("Vector ordenado por BURBUJA 3");
			Ordenar.Burbuja.ordenarBurbujaTres(cienmilCopia);
			or.mostrarVector(cienmilCopia);
			System.out.println("Tiempo de ejecucion --> " + (Ordenar.Burbuja.tfin - Ordenar.Burbuja.tInicio)+ " Nanosegundos");
			break;
		case 3:
			System.out.println("Generando vector con 100,000 numeros...");
			int diezmil [] = new int[10000];
			System.out.println("Llenando vector con 100,000 de números...");
			for (int i = 0; i < diezmil.length; i++) {
			diezmil[i] = new Random().nextInt();
			}
			int diezmilCopia[] = diezmil.clone();
			System.out.println("Llenado Finalizado.");
			System.out.println("Vector ordenado por BURBUJA 1");
			Ordenar.Burbuja.ordenarBurbujaUno(diezmil);
			or.mostrarVector(diezmil);
			System.out.println("Tiempo de ejecucion --> " + (Ordenar.Burbuja.tfin - Ordenar.Burbuja.tInicio)+ " Nanosegundos");
			System.out.println("=============================================================================");
			System.out.println("Vector ordenado por BURBUJA 2");
			Ordenar.Burbuja.ordenarBurbujaDos(diezmilCopia);
			or.mostrarVector(diezmilCopia);
			System.out.println("Tiempo de ejecucion --> " + (Ordenar.Burbuja.tfin - Ordenar.Burbuja.tInicio)+ " Nanosegundos");
			System.out.println("=============================================================================");
			System.out.println("Vector ordenado por BURBUJA 3");
			Ordenar.Burbuja.ordenarBurbujaTres(diezmilCopia);
			or.mostrarVector(diezmilCopia);
			System.out.println("Tiempo de ejecucion --> " + (Ordenar.Burbuja.tfin - Ordenar.Burbuja.tInicio)+ " Nanosegundos");
			break;

		case 4:
			System.out.println("Generando vector con 1,000,000 numeros...");
			int millon [] = new int[1000000];
			System.out.println("Llenando vector con 1,000,000 de números...");
			for (int i = 0; i < millon.length; i++) {
			millon[i] = new Random().nextInt();
			}
			int millonCopia[] = millon.clone();
			System.out.println("Llenado Finalizado.");
			System.out.println("Vector ordenado por BURBUJA 1");
			Ordenar.Burbuja.ordenarBurbujaUno(millon);
			or.mostrarVector(millon);
			System.out.println("Tiempo de ejecucion --> " + (Ordenar.Burbuja.tfin - Ordenar.Burbuja.tInicio)+ " Nanosegundos");
			System.out.println("=============================================================================");
			System.out.println("Vector ordenado por BURBUJA 2");
			Ordenar.Burbuja.ordenarBurbujaDos(millonCopia);
			or.mostrarVector(millonCopia);
			System.out.println("Tiempo de ejecucion --> " + (Ordenar.Burbuja.tfin - Ordenar.Burbuja.tInicio)+ " Nanosegundos");
			System.out.println("=============================================================================");
			System.out.println("Vector ordenado por BURBUJA 3");
			Ordenar.Burbuja.ordenarBurbujaTres(millonCopia);
			or.mostrarVector(millonCopia);
			System.out.println("Tiempo de ejecucion --> " + (Ordenar.Burbuja.tfin - Ordenar.Burbuja.tInicio)+ " Nanosegundos");
			break;
		default: System.out.println("Insercción inválida.");
			break;
		}	
	}//main
}//class