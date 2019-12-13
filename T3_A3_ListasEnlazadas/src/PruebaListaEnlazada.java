import java.util.Scanner;

public class PruebaListaEnlazada {

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		byte opc = 0; 
		ListaEnlazada lz1 = new ListaEnlazada();
		System.out.println("BIENVENIDO A LA PRUEBA\n¿Qué desea hacer?\n1)Verificar lista vacia\n2)Insertar elemento al Inicio\n3)Insertar elemento al Final\n4)Eliminar elemento al Inicio\n5)Eliminar elemento al final");
		opc = e.nextByte();
		switch (opc) {
		case 1:
			//lz1.agregarElementoAlIncio(10);
			lz1.verificarListaVacia();
			break;
		case 2:
			lz1.agregarElementoAlIncio(10);
			lz1.agregarElementoAlIncio(20);
			lz1.agregarElementoAlIncio(30);
			lz1.agregarElementoAlIncio(40);
			lz1.agregarElementoAlIncio(50);
			lz1.mostrarElementos();
			break;
		case 3:
			lz1.agregarElementoAlFinal(60);
			lz1.agregarElementoAlFinal(70);
			lz1.agregarElementoAlFinal(80);
			lz1.agregarElementoAlFinal(90);
			lz1.agregarElementoAlFinal(100);
			lz1.mostrarElementos();
			break;
		case 4:
			lz1.agregarElementoAlIncio(10);
			lz1.agregarElementoAlIncio(20);
			lz1.agregarElementoAlIncio(30);
			lz1.agregarElementoAlIncio(40);
			lz1.agregarElementoAlIncio(50);
			lz1.eliminarElementoAlInicio();
			lz1.mostrarElementos();
			break;
		case 5:
			lz1.agregarElementoAlFinal(60);
			lz1.agregarElementoAlFinal(70);
			lz1.agregarElementoAlFinal(80);
			lz1.agregarElementoAlFinal(90);
			lz1.agregarElementoAlFinal(100);
			lz1.eliminarElementoAlFInal();
			lz1.mostrarElementos();
			break;
		default: System.out.println("No está en la lista.");
			break;
		}
		e.close();
	}
}
