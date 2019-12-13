import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Impresion {
	private String identificadorDeImpresion;
	private byte tamaño;
	private int cantidad;
	public Impresion(String identificadorDeImpresion, byte tamaño, int cantidad) {
		this.identificadorDeImpresion = identificadorDeImpresion;
		this.tamaño = tamaño;
		this.cantidad = cantidad;
	}

	public String getIdentificadorDeImpresion() {
		return identificadorDeImpresion;
	}

	public void setIdentificadorDeImpresion(String identificadorDeImpresion) {
		this.identificadorDeImpresion = identificadorDeImpresion;
	}

	public byte getTamaño() {
		return tamaño;
	}

	public void setTamaño(byte tamaño) {
		this.tamaño = tamaño;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Impresion [identificadorDeImpresion=" + identificadorDeImpresion + ", tamaño=" + tamaño + ", cantidad="
				+ cantidad + "]";
	}

}

interface RegistroImpresiones {
	public void vaciar();

	public Impresion mostrarFrente();

	public Impresion mostrarFin();

	public boolean insertarElemento(Impresion a);

	public boolean eliminarElemento();

	public boolean vacia();

	public boolean llena();

	public int cantidadElementos();

	public String imprimir();

	public boolean agregarACola(Impresion a);

	public int hojasImpresas(Impresion a);

	public int mostraBytes(Impresion a);
}

class ImplementacionFilaEstatica implements RegistroImpresiones {

	private Impresion[] filaImpresiones = new Impresion[10];
	private int fr;
	private int fn;

	public ImplementacionFilaEstatica(int t) {
		fn = 0;
		fr = fn - 1;

	}

	@Override
	public void vaciar() {
		fn = 1;
		fr = fn - 1;
	}

	@Override
	public Impresion mostrarFrente() {
		if (vacia()) {
			return null;
		} else {
			return filaImpresiones[fr];
		}

	}

	@Override
	public Impresion mostrarFin() {
		if (vacia()) {
			return null;
		} else {
			return filaImpresiones[fn];
		}

	}

	@Override
	public boolean insertarElemento(Impresion a) {
		if (llena() || fr == 0) {

			return false;
		} else {
			fn++;
			filaImpresiones[fn] = a;
			return true;
		}
	}

	@Override
	public boolean eliminarElemento() {
		if (vacia()) {
			return false;
		} else {
			if (fn == fr) {
				fr--;
				return true;
			}
			fn--;
			return true;
		}

	}

	@Override
	public boolean vacia() {
		if (fr == 0 && fn == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean llena() {
		if (fn == filaImpresiones.length) {
			return true;

		}
		return false;
	}

	@Override
	public int cantidadElementos() {
		if (vacia()) {
			return 0;
		}
		return fn;
	}

	@Override
	public String imprimir() {
		
		return toString();
	}

	@Override
	public boolean agregarACola(Impresion a) {
		insertarElemento(a);
		return true;
	}

	@Override
	public int hojasImpresas(Impresion a) {

		return a.getCantidad();
	}

	@Override
	public int mostraBytes(Impresion a) {

		return a.getTamaño();
	}

}

class ImplementacionFilaDinamica implements RegistroImpresiones {

	Queue<Impresion> filaImpresion = new LinkedList<Impresion>();

	@Override
	public void vaciar() {
		filaImpresion.clear();
	}

	@Override
	public Impresion mostrarFrente() {
		if (vacia()) {
			return null;
		} else {
			return filaImpresion.peek();
		}
	}

	@Override
	public Impresion mostrarFin() {
		if (vacia()) {
			return null;
		} else {
			return filaImpresion.peek();
		}
	}

	@Override
	public boolean insertarElemento(Impresion a) {
		if (llena()) {
			return false;
		} else {
			filaImpresion.add(a);
			return true;
		}

	}

	@Override
	public boolean eliminarElemento() {
		if (vacia()) {
			return false;
		}else {
		filaImpresion.remove();
		return false;
		}
	}

	@Override
	public boolean vacia() {
		return filaImpresion.isEmpty();
	}

	@Override
	public boolean llena() {
		return false;
	}

	@Override
	public int cantidadElementos() {
		
		return filaImpresion.size();
	}

	@Override
	public String imprimir() {
		
		return toString();
	}

	@Override
	public boolean agregarACola(Impresion a) {
		filaImpresion.add(a);
		return false;
	}

	@Override
	public int hojasImpresas(Impresion a) {
		a.getCantidad();
		return 0;
	}

	@Override
	public int mostraBytes(Impresion a) {
		a.getTamaño();
		return 0;
	}

}
public class Prueba {
	public static void main(String[] args) {
		ImplementacionFilaEstatica f1 = new ImplementacionFilaEstatica(0);
		Scanner e = new Scanner(System.in);
		Impresion i1 = new Impresion("HP DESKJET", (byte) 20, 10);
		byte opc = 0;
		do {
			System.out.println("Ingrese una opcion");
			System.out.println("1.-Imprimir\n2.- Agregar a cola de Impresión\n3.- Mostrar total de hojas impresas\n4.- Mostrar total de bytes recibidos de impresion\n5.- Salir");
			opc = e.nextByte();
			switch (opc) {
			case 1:
				System.out.println("Imprimiendo...");
				f1.imprimir();
				System.out.println("Se imprimió con ÉXITO");
				break;
			case 2:
				System.out.println("Agregando a cola de IMPRESIÓN");
				System.out.println("ESPERE...");
				f1.agregarACola(i1);
				System.out.println("Agregadas las hojas con ÉXITO");
				break;
			case 3:
				
				System.out.println("Total de hojas: " +f1.hojasImpresas(i1));
				break;
			case 4:
				System.out.println("BYTES recibidos: "+f1.mostraBytes(i1));
				break;
			case 5:
				System.out.println("Salió.");
				break;
			default: System.out.println("No está en el MENU");
				break;
			}
		} while (opc != 5);
		e.close();
	}
}