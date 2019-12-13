import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MetodosOrdenamiento{
	long tInicio = 0; 
	long recorridos = 0;
	long comparaciones = 0;
	long intercambios = 0; 
public void intercalacion(int[] arregloA, int[] arregloB) {
	
	tInicio  = System.nanoTime();
		
		int i, j, k;
		int arregloC[] = new int[arregloA.length + arregloB.length];
		// Repetir minetras los arreglos A y B tengan elementos a comparar
		for (i = j = k = 0; i < arregloA.length && j < arregloB.length; k++) {
			recorridos++;
			comparaciones++;
			if (arregloA[i] < arregloB[j]) {
				intercambios++;
				arregloC[k] = arregloA[i];
				i++;

			} else {
				intercambios++;
				arregloC[k] = arregloB[j];
				j++;
			}

		}
		// Añadir sobrantes del arreglo A en caso de haberlos
		for (; i < arregloA.length; i++, k++) {
			recorridos++;
			intercambios++;
			arregloC[k] = arregloA[i];
		}
		// Añadir sobrantes del arreglo B en caso de haberlos
		for (; j < arregloB.length; j++, k++) {
			recorridos++;
			intercambios++;
			arregloC[k] = arregloA[j];
		}
	}

public int[] mezclaDirecta(int[] arreglo) {
	tInicio  = System.nanoTime(); 
	int i, j, k;

	comparaciones++;
	if (arreglo.length > 1) {

		int nElementosIzq = arreglo.length / 2;
		int nElementosDer = arreglo.length - nElementosIzq;
		int arregloIzq[] = new int[nElementosIzq];
		int arregloDer[] = new int[nElementosDer];

		// Cepiando los elementos al primer arreglo
		for (i = 0; i < nElementosIzq; i++) {
			intercambios++;
			recorridos++;
			arregloIzq[i] = arreglo[i];

		}
		// Copiando los elementos al segundo arreglo
		for (i = nElementosIzq; i < nElementosIzq + nElementosDer; i++) {
			intercambios++;
			recorridos++;
			arregloDer[i - nElementosIzq] = arreglo[i];

		}
		// Recursividad
		arregloIzq = mezclaDirecta(arregloIzq);
		arregloDer = mezclaDirecta(arregloDer);

		i = 0;
		j = 0;
		k = 0;

		while (arregloIzq.length != j && arregloDer.length != k) {
			recorridos++;
			comparaciones++;
			if (arregloIzq[j] < arregloDer[k]) {
				intercambios++;
				arreglo[i] = arregloIzq[j];
				i++;
				j++;

			} else {
				arreglo[i] = arregloDer[k];
				intercambios++;
				i++;
				k++;

			}

		}
		// Arreglo final
		while (arregloIzq.length != j) {
			recorridos++;
			intercambios++;
			arreglo[i] = arregloIzq[j];
			i++;
			j++;

		}
		while (arregloDer.length != k) {
			recorridos++;
			intercambios++;
			arreglo[i] = arregloDer[k];
			i++;
			k++;

		}
	} // fin del c++; if

	return arreglo;
}


public void Mezclanatural(int[] arreglo) {
	tInicio = System.nanoTime(); 
	int izquierda=0,izq=0,derecha=arreglo.length-1,der=derecha;
	boolean ordenado=false;
	do {
		ordenado=true;
		izquierda=0;
		while (izquierda<derecha){
			izq=izquierda;
			while(izq<derecha&&arreglo[izq]<=arreglo[izq+1]) {
				izq++;
			}
			der=izq+1;
			while(der==derecha-1||der<derecha&&arreglo[der]<=arreglo[der+1]) {
				der++;	
			}
			if (der<=derecha) {
				mezclaDirecta2(arreglo);
				ordenado=false;
			}
			izquierda=izq;
			
		}
	}while(!ordenado);
	
	}

public void mezclaDirecta2(int[] arreglo) {
	tInicio = System.nanoTime(); 
	int i,j,k;
	if (arreglo.length>1) {
		int nElementosIzq=arreglo.length/2;
		int nElementosDer=arreglo.length-nElementosIzq;
		int arregloIzq[]=new int [nElementosIzq];
		int arregloDer[]=new int [nElementosDer];
		for (i = 0; i < nElementosIzq; i++) {
			arregloIzq[i]=arreglo[i];
		}
		for (i = nElementosIzq; i < nElementosIzq+nElementosDer; i++) {
			arregloDer[i-nElementosIzq]=arreglo[i];
		}
		arregloIzq=mezclaDirecta(arregloIzq);
		arregloDer=mezclaDirecta(arregloDer);
		i=0;
		j=0;
		k=0;
		while(arregloIzq.length!=j&&arregloDer.length!=k) {
			if(arregloIzq[j]<arregloDer[k]) {
				arreglo[i]=arregloIzq[j];
				i++;
				j++;
			}else {
				arreglo[i]=arregloDer[k];
				i++;
				k++;
			}
		}
		while(arregloIzq.length!=j) {
			arreglo[i]=arregloIzq[j];
			i++;
			j++;
		}
		while(arregloDer.length!=k) {
			arreglo[i]=arregloDer[k];
			i++;
			k++;
		}
	}
}
}//class
public class Prueba {
	public static void main(String[] args) {
		
		Scanner e = new Scanner(System.in);
		MetodosOrdenamiento mo = new MetodosOrdenamiento(); 
		int vector[] = new int[1000]; 
		for (int i = 0; i < vector.length; i++) {
			vector[i] = (int) (Math.random() * (100 - 0));
		}
		int vectorCopia[] = vector.clone(); 
		
		int vector10k[] = new int[10000]; 
		for (int i = 0; i < vector10k.length; i++) {
			vector[i] = (int) (Math.random() * (100 - 0));
		}
		int vectorCopia10k[] = vector10k.clone(); 
		
		int vector100k[] = new int[100000]; 
		for (int i = 0; i < vector10k.length; i++) {
			vector[i] = (int) (Math.random() * (100 - 0));
		}
		int vectorCopia100k[] = vector100k.clone(); 
		
		int vector1000k[] = new int[1000000]; 
		for (int i = 0; i < vector10k.length; i++) {
			vector[i] = (int) (Math.random() * (100 - 0));
		}
		int vectorCopia1000k[] = vector1000k.clone(); 
		
		
		byte opc = 0;
		do {
		System.out.println("Con cuantos numeros desea trabajar\n1).-1,000\n2).-10,000\n3).-100,000\n4).-1,000,000\n5).- Salir");
		System.out.print("Elija una opcíon:");
		opc = e.nextByte();
		switch (opc) {
		case 1:
			System.out.println("Método Intercalacion");
			System.out.println("Vector " + Arrays.toString(vector) );
			mo.intercalacion(vector, vector);
			System.out.println("Tiempo de Ejecución " + (System.nanoTime() - mo.tInicio)+ " Nanosegundos");
			System.out.println("Comparaciones: " + mo.comparaciones);
			System.out.println("Recorridos: " + mo.recorridos);
			System.out.println("Intercambios: " + mo.intercambios);
			System.out.println("Vector Ordenado: " +Arrays.toString(vector));
			//el codigo de intercalacion implementado no lo ORDENA!!!
			System.out.println("===============================================================");
			System.out.println("Método Mezcla Directa");
			mo.tInicio = System.nanoTime();
			System.out.println("Vector " + Arrays.toString(vectorCopia) );
			mo.mezclaDirecta(vectorCopia);
			System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - mo.tInicio));
			System.out.println("Comparaciones: " + mo.comparaciones);
			System.out.println("Recorridos: " + mo.recorridos);
			System.out.println("Intercambios: " + mo.intercambios);
			System.out.println("Arreglo Ordenado: " + Arrays.toString(vectorCopia));																																																										
			System.out.println("===============================================================");
			System.out.println("Método Mezcla Natural");
			System.out.println("Vector " + Arrays.toString(vectorCopia) );
			mo.Mezclanatural(vectorCopia);
			System.out.println("Arreglo ordenado");
			System.out.println("Comparaciones: " + mo.comparaciones);
			System.out.println("Recorridos: " + mo.recorridos);
			System.out.println("Intercambios: " + mo.intercambios);
			System.out.println("Vector Ordenado " + Arrays.toString(vectorCopia) );
			break;
		case 2:
			System.out.println("Método Intercalacion");
			System.out.println("Vector " + Arrays.toString(vector10k) );
			mo.intercalacion(vector10k, vector10k);
			System.out.println("Tiempo de Ejecución " + (System.nanoTime() - mo.tInicio)+ " Nanosegundos");
			System.out.println("Comparaciones: " + mo.comparaciones);
			System.out.println("Recorridos: " + mo.recorridos);
			System.out.println("Intercambios: " + mo.intercambios);
			System.out.println("Vector Ordenado: " +Arrays.toString(vector10k));
			//el codigo de intercalacion implementado no lo ORDENA!!!
			System.out.println("===============================================================");
			System.out.println("Método Mezcla Directa");
			mo.tInicio = System.nanoTime();
			System.out.println("Vector " + Arrays.toString(vectorCopia10k) );
			mo.mezclaDirecta(vectorCopia10k);
			System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - mo.tInicio));
			System.out.println("Comparaciones: " + mo.comparaciones);
			System.out.println("Recorridos: " + mo.recorridos);
			System.out.println("Intercambios: " + mo.intercambios);
			System.out.println("Arreglo Ordenado: " + Arrays.toString(vectorCopia10k));																																																										
			System.out.println("===============================================================");
			System.out.println("Método Mezcla Natural");
			System.out.println("Vector " + Arrays.toString(vectorCopia10k) );
			mo.Mezclanatural(vectorCopia10k);
			System.out.println("Arreglo ordenado");
			System.out.println("Comparaciones: " + mo.comparaciones);
			System.out.println("Recorridos: " + mo.recorridos);
			System.out.println("Intercambios: " + mo.intercambios);
			System.out.println("Vector Ordenado " + Arrays.toString(vectorCopia10k));
			break; 
		case 3: 
			System.out.println("Método Intercalacion");
			System.out.println("Vector " + Arrays.toString(vector100k) );
			mo.intercalacion(vector100k, vector100k);
			System.out.println("Tiempo de Ejecución " + (System.nanoTime() - mo.tInicio)+ " Nanosegundos");
			System.out.println("Comparaciones: " + mo.comparaciones);
			System.out.println("Recorridos: " + mo.recorridos);
			System.out.println("Intercambios: " + mo.intercambios);
			System.out.println("Vector Ordenado: " +Arrays.toString(vector100k));
			//el codigo de intercalacion implementado no lo ORDENA!!!
			System.out.println("===============================================================");
			System.out.println("Método Mezcla Directa");
			mo.tInicio = System.nanoTime();
			System.out.println("Vector " + Arrays.toString(vectorCopia100k) );
			mo.mezclaDirecta(vectorCopia100k);
			System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - mo.tInicio));
			System.out.println("Comparaciones: " + mo.comparaciones);
			System.out.println("Recorridos: " + mo.recorridos);
			System.out.println("Intercambios: " + mo.intercambios);
			System.out.println("Arreglo Ordenado: " + Arrays.toString(vectorCopia100k));																																																										
			System.out.println("===============================================================");
			System.out.println("Método Mezcla Natural");
			System.out.println("Vector " + Arrays.toString(vectorCopia100k) );
			mo.Mezclanatural(vectorCopia100k);
			System.out.println("Arreglo ordenado");
			System.out.println("Comparaciones: " + mo.comparaciones);
			System.out.println("Recorridos: " + mo.recorridos);
			System.out.println("Intercambios: " + mo.intercambios);
			System.out.println("Vector Ordenado " + Arrays.toString(vectorCopia100k));
			break; 
		case 4: 
			System.out.println("Método Intercalacion");
			System.out.println("Vector " + Arrays.toString(vector1000k) );
			mo.intercalacion(vector1000k, vector1000k);
			System.out.println("Tiempo de Ejecución " + (System.nanoTime() - mo.tInicio)+ " Nanosegundos");
			System.out.println("Comparaciones: " + mo.comparaciones);
			System.out.println("Recorridos: " + mo.recorridos);
			System.out.println("Intercambios: " + mo.intercambios);
			System.out.println("Vector Ordenado: " +Arrays.toString(vector1000k));
			//el codigo de intercalacion implementado no lo ORDENA!!!
			System.out.println("===============================================================");
			System.out.println("Método Mezcla Directa");
			mo.tInicio = System.nanoTime();
			System.out.println("Vector " + Arrays.toString(vectorCopia1000k) );
			mo.mezclaDirecta(vectorCopia1000k);
			System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - mo.tInicio));
			System.out.println("Comparaciones: " + mo.comparaciones);
			System.out.println("Recorridos: " + mo.recorridos);
			System.out.println("Intercambios: " + mo.intercambios);
			System.out.println("Arreglo Ordenado: " + Arrays.toString(vectorCopia1000k));																																																										
			System.out.println("===============================================================");
			System.out.println("Método Mezcla Natural");
			System.out.println("Vector " + Arrays.toString(vectorCopia1000k) );
			mo.Mezclanatural(vectorCopia1000k);
			System.out.println("Arreglo ordenado");
			System.out.println("Comparaciones: " + mo.comparaciones);
			System.out.println("Recorridos: " + mo.recorridos);
			System.out.println("Intercambios: " + mo.intercambios);
			System.out.println("Vector Ordenado " + Arrays.toString(vectorCopia1000k));
			break; 
		case 5: System.out.println("Salio.");
			break; 
		default: System.out.println("Insercción inválida...");
			break;
		}		
		} while (opc != 5);
	}//main
}//class
