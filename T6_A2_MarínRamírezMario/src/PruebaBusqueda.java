import java.util.Scanner;

class MetodosBusqueda{
	//BUSQUEDA BINARIA 
	long tInicio1 = 0; 
	long tfin = 0;
	long comparaciones1 = 0;
	long intercambios1 = 0;
	long recorridos1 = 0;
	int busquedaBinaria(int vector[], int posicionIzq, int posicionDer, int elementoA_Buscar) { 
		tInicio1 = System.nanoTime();     
		for (int i = 0; i < vector.length; i++) {
			comparaciones1++;
		}
		for (int i = 0; i < vector.length; i++) {
		recorridos1++;
		if (posicionDer >= posicionIzq) { 
			intercambios1++;
	            int mitad = posicionIzq + (posicionDer - posicionIzq) / 2; 
	            // Si el elemento está presente en el
	            // medio en sí
	            if (vector[mitad] == elementoA_Buscar) 
	                return mitad; 
	            // Si el elemento es más pequeño que el medio, entonces 
	            // solo puede estar presente en el subconjunto izquierdo
	            if (vector[mitad] > elementoA_Buscar) 
	            	
	                return busquedaBinaria(vector, posicionIzq, mitad - 1, elementoA_Buscar); 
	            //De lo contrario, el elemento solo puede 
	            //estar presente en la submatriz derecha
	            return busquedaBinaria(vector, mitad + 1, posicionDer, elementoA_Buscar); 
	            
	        }
	}//fin del for
	        //Llegamos aquí cuando el elemento no está presente en la matriz
	        return -1;  
	   }
	
	//BUSQUEDA SECUENCIAL
	public  int busquedaSecuencial(int []arreglo,int dato){
		tInicio1 = System.nanoTime(); 
		for (int i = 0; i < arreglo.length; i++) {
			comparaciones1++;
		}
		
		int posicion = -1;
		  for(int i = 0; i < arreglo.length; i++){
		      if(arreglo[i] == dato){
		    posicion = i;
		    break;//
		   }
		      intercambios1++;
		 }recorridos1++;
		return posicion;
	}
}//class
public class PruebaBusqueda {

	public static void main(String[] args) {
		MetodosBusqueda mb = new MetodosBusqueda(); 
		Scanner e = new Scanner(System.in);
		byte opc = 0;
		int buscar = 0;
		int b2 = 0;
		System.out.println("Elija un Metodo de Busqueda:\n1) Búsqueda Secuencial\n2)Búsqueda Binaria");
		opc = e.nextByte(); 
		switch (opc) {
		case 1:
			System.out.println("Busqueda Secuencial...");
			int vector2[] = new int [100];
			for (int i = 0; i < vector2.length; i++) {
				vector2[i] = (int) (Math.random() * (100 - 0));
				//System.out.println("Vector "+i +": " +vector2[i]);
			}
			System.out.println("Elemento a buscar: " );
			b2 = e.nextByte(); 
			
			int n = vector2.length; 
			int resultado = mb.busquedaSecuencial(vector2, b2);
			if (resultado == -1) {
				System.out.println("No se encontró el número " + b2);
			}else {
				System.out.println("Encontrado en la posición " + resultado);
			}
			System.out.println("Tiempo de ejecución: " + (mb.tInicio1)+ " nanosegundos");
			System.out.println("Comparaciones: "+ mb.comparaciones1);
			System.out.println("Intercambios: " +mb.intercambios1);
			System.out.println("Recorridos: "+mb.recorridos1);
			break;
		case 2: 
			System.out.println("Búsqueda Binaria.");
			int vector[] = new int [100];
			for (int i = 0; i < vector.length; i++) {
				vector[i] = (int) (Math.random() * (100 - 0));
				//System.out.println("Vector "+i +": " +vector[i]);
			}
			System.out.println("Elemento a buscar: ");
			buscar = e.nextInt(); 
			int n2 = vector.length; 
			int resultado2 = mb.busquedaBinaria(vector, 0, n2-1, buscar); 
			if (resultado2 == -1) {
				System.out.println("No se encontró el número " + buscar);
			}else {
				System.out.println("Encontrado en la posición " + resultado2);
			}
			System.out.println("Tiempo de ejecución: " + (mb.tInicio1)+ " nanosegundos");
			System.out.println("Comparaciones: "+ mb.comparaciones1);
			System.out.println("Intercambios: " +mb.intercambios1);
			System.out.println("Recorridos: "+mb.recorridos1);
			break;
		default:
			break;
		}	
	}
}