import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pelicula{
	private String titulo;
	private	String genero;
	public Pelicula() {
	}
	public Pelicula(String titulo, String genero) {
		this.titulo = titulo;
		this.genero = genero;
	}//constructor
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}//GETTERS AND SETTERS	
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", genero=" + genero + "]";
	}	
}//class Pelicula
interface RentaPeliculas{
	public void cima();
	 public void insertarElementos();
	 public void eliminar_Elemento();
	 public void vaciar_Pila();
	public void mostrar_CIMA();
	public void cantidadElementos();
	public String titulo (Pelicula rentar);
	public String genero (Pelicula rentar);	
}//INTERFACE 
class ImplementacionPilaDinamica implements RentaPeliculas{
	private Pelicula [][] registroDatos = new Pelicula[1][1]; 
	private int nums[][];
	private int cima;
	public void PilaEstatica(int tam) {
		nums = new int [tam][tam];
		cima = -1;
	}
	@Override
	public void cima() {
		cima = -1;
	}
	@Override
	public String titulo(Pelicula r) {
		return r.getTitulo();
	}
	@Override
	public String genero(Pelicula r) {
		return r.getGenero();
	}
	@Override
	public void insertarElementos() {	
		 LinkedList<String> pila = new LinkedList<>();
		    pila.add("Stars Wars");
		    pila.add("Fast And Furios");
		    pila.add("Avengers");
		    pila.add("IT: Chapter TWO");	
	}
	@Override
	public void eliminar_Elemento() {
		 LinkedList<String> pila=new LinkedList<>();
		 pila.peek();
	}
	@Override
	public void vaciar_Pila() {
		 LinkedList<String> pila=new LinkedList<>();
		 pila.clear();
	}
	@Override
	public void mostrar_CIMA() {
		cima();
	}
	public void cantidadElementos() {
		System.out.println("Peliculas disponibles: " + 4);
	}
}//Class ImplementacionFilaEstatica
class ImplementacionPilaDinamic extends ImplementacionPilaDinamica {
	Queue<Pelicula> registroDatos = new LinkedList<Pelicula>();	
}
public class Actividad2 {
	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		ImplementacionPilaDinamica ifl = new ImplementacionPilaDinamica();
		boolean r = true;
		byte opc = 0;
		do {
			System.out.println("Eliga una Opción \n1)Cargar BD de Peliculas\n2)Rentar Pelicula\n3)Devolver Pelicula\n4)Mostrar Cantidad de Peliculas Disponible\n5)Salir");
		opc = e.nextByte();
		switch (opc) {
		case 1:
			System.out.println("CARGANDO PELICULAS...");
			ifl.PilaEstatica(4);
			ifl.insertarElementos();
			break;
		case 2:
			System.out.println("Rentando Película...");
			System.out.println("Ingrese el nombre de la pelicula: ");
			String name = e.next(); 
			ifl.mostrar_CIMA();
			System.out.println("RENTA CON ÉXITO");
			break;
		case 3:
			System.out.println("Devolver Película");
			System.out.println("Ingrese el motivo: ");
			String mot = e.next(); 
			ifl.eliminar_Elemento(); 
			System.out.println("PELICULA devuelta al almacén");
			break;
		case 4:
			System.out.println("Cantidad de Películas...");
			ifl.cantidadElementos(); 
			break;
		case 5:
			System.out.println("Salio");
			break;
		default: System.out.println("NO está en la LISTA.");
			break;
		}//switch
		} while (opc != 5);
	}//main
}//class
