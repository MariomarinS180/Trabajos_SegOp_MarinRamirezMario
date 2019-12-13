
/*
 * 1) Crear lista enlazada 
 * 2) Agregar elemento
 * 2a) Al inicio
 * 2b) Al final
 * 2c) En posicion especifica
 * 3) Eliminar elemento
 * 3a) Al inicio
 * 3b) Al final
 * 4) Recorrer lista 
 * 5) Buscar elemento
 * 6) Vacia
 * 7) Cantidad elementos 
 * 8) Vaciar lista
 * 
 * 
 * =====================
 * Actividad: 
 * 1. Crear Lista
 * 2. Verificar Lista vacia
 * 3. Insertar elemento
 * 		3a. Inicio
 * 		3b. Final
 *      3c. En posición específica (opcional) 
 * 4. Eliminar elemento
 * 		4a. Inicio
 * 		4b. Final     
 * 		4c. Especifico (opcional)
5. Mostrar cantidad de elementos 
 */


public class ListaEnlazada {

	Nodo nodoInicio;
	Nodo nodoFin;
	//1.- Crear lista.
	public ListaEnlazada() {
		nodoFin = nodoInicio = null;
	}
	//2.- Verficar lista vacia
	public void verificarListaVacia() {
		if(nodoInicio == null & nodoFin == null) {
			System.out.println("La lista está vacia");
		}else {
		}
	}
	
	//3a insertar elemento al inicio
	public void agregarElementoAlIncio(int dato) {
		Nodo nodoNuevo = new Nodo(dato);
		if (nodoInicio == null) {
		nodoFin = nodoInicio = nodoNuevo;
		}else {
			nodoNuevo.setEnlace(nodoInicio);
			nodoInicio = nodoNuevo;
		}	
	}
	//3b insertar elemento al final
	public void agregarElementoAlFinal( int dato ) {
		Nodo nodoNuevo = new Nodo (dato);
		if(nodoFin == null) {
			nodoInicio = nodoFin = nodoNuevo;
		}else {
			nodoNuevo.setEnlace(nodoFin);
			nodoFin = nodoNuevo;
		}
	}
	//4a)Eliminar elemento al Inicio
		public void eliminarElementoAlInicio() {
			if (nodoInicio == null) {
			}else {
				nodoInicio = nodoInicio.getEnlace();
			}
		}
		//4b) Eliminar elemento al Final
		public void eliminarElementoAlFInal() {
			Nodo nuevo = nodoInicio;
			if (nodoFin == null) {
			}else {
				while(nuevo.getEnlace()!=null){
					nodoFin = nuevo;
					nuevo = nuevo.getEnlace();
				}
				nodoFin.setEnlace(null);
				}
			}
		//5 Mostrar Elementos
		public void mostrarElementos() {
			Nodo nodoActual = nodoInicio;
			while (nodoActual != null) {
				System.out.print("["+nodoActual.getDato()+"]");
				nodoActual = nodoActual.getEnlace();
				}
			}
		//EN CLASE==================
	//mostrar 2a
	public void mostrarElementoAlInicio() {
		Nodo nodoActual = nodoInicio;
		while(nodoActual != null) {
			System.out.print("["+nodoActual.getDato()+"]-|>");
			nodoActual = nodoActual.getEnlace();
		}
	}
	//mostrar 2b
	public void mostrarElementoAlFinal() {
		Nodo nodoActual = nodoFin;
		while(nodoActual != null) {
			System.out.print("["+nodoActual.getDato()+"]-|>");
			nodoActual = nodoActual.getEnlace();
			//EN CLASE==================
		}
	}
	
}//class
