class Operaciones{
	String a[];
	String b[];
	String a1;
	String b1;
	public static boolean esPrimo(int numero){
		int contador = 2;
		boolean primo=true;
		while ((primo) && (contador!=numero)){
			if (numero % contador == 0)
				primo = false;
			contador++;
		}
		return primo;
	}
	public void primos() {
		String primos ="";
		for (int i=0; i<=100 ;i++) {
			if (esPrimo(i)) {
				primos = primos+","+i;
			}
		}
		a1=primos;
		a = primos.split(",");
	}
	public void Divisores() {
		String divisores = "";
		int num = 350;
		for(int i = 1;i<=num;i++){
			if (num % i== 0){
				divisores = divisores+","+i;
			}
		}
		b1 = divisores;
		b = divisores.split(",");
		
	}
	public void union() {
		int u = 0;
		String v = "";
		String b2 = "";
		
		for (int i = 1; i < b.length; i++) {
			b2 = b2+b[i]+",";
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i].equals(b[j])) {
					
				} else {
					u=u+1;
				}
			}
			if (u==b.length) {
				v = v + a[i]+",";
			} 
			u = 0;
		}
		v = v + b2;
		System.out.println(v);
		
	}

	public void interseccion() {
		int u = 0;
		String v = "";
		
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i].equals(b[j])) {
					
				} else {
					u=u+1;
				}
			}
			if (u<b.length) {
				v = v + a[i]+",";
			} 
			u = 0;
		}
		System.out.println(v);	
	}
	public void diferencia() {
		int u=0;
		String v = "";
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i].equals(b[j])) {
					
				} else {
					u=u+1;
				}
			}
			if (u==b.length) {
				v = v + a[i]+",";
			} 
			u = 0;
		}
		System.out.println(v);
	}
}
public class PruebaConjuntos {
	public static void main(String[] args) {
		Operaciones op = new Operaciones();
		op.primos();
		op.Divisores();
		System.out.println("Conjutno A: "+op.a1+"\nConjunto B: "+op.b1+"\n");
		System.out.print("Union: ");
		op.union();
		System.out.print("Intersección: ");
		op.interseccion();
		System.out.print("Diferencia: ");
		op.diferencia();
	}//main
}//class