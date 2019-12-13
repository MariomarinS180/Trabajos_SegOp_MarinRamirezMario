import java.util.Arrays;

public class FuncionHASH {
	String []arr;
	int tamaño,contador;
	public FuncionHASH(int tam) {
		tamaño=tam;
		arr=new String[tam];
		Arrays.fill(arr, "-1");

	}
	public void funcioHash(String[] cadArr, String[] arr) {
		for (int i = 0; i < cadArr.length; i++) {
			String elemento= cadArr[i];
			int indiceArr=Integer.parseInt(elemento)%7;
			System.out.println("El indice es  " + indiceArr+"  para el elemento o valor  "+elemento);
			while(arr[indiceArr]!= "-1") {
				indiceArr++;
				System.out.println("Ocurrio una colision  "+(indiceArr-1)+" Cambiar al indice "+indiceArr );
				indiceArr%=tamaño;
			}
			arr[indiceArr]=elemento;
		}
	}
	public void mostrar() {
		int incremento = 0,i,j;
		for ( i = 0; i < 1; i++) {
			incremento+=8;
			for ( j = 0; j < 71; j++) {
				System.out.format("| %3s"+ "", j);
			}
			System.out.print("|");
	for (int n = 0; n < 71; n++) {
		System.out.print("-");
	}
	System.out.println();
	for ( j =incremento-8; j < incremento; j++) {
		if (arr[j].contentEquals("-1")) {
			System.out.print("|       ");
		}else {
			System.out.print(String.format("| %3s"+ "",arr[j]));
		}
	}
	System.out.print("|");
	for ( j = 0; j < 71; j++) {
		System.out.print("-");
	}
	System.out.println();
		}
	}
	public String buscarClave(String elemento) {
		int indiceArr=Integer.parseInt(elemento)%7;
		int contador=0;
		while(arr[indiceArr]!="-1") {
			if(arr[indiceArr]==elemento) {
				System.out.println("El elemento "+ elemento+ "fue encontrado en el indice "+indiceArr);
				return arr[indiceArr];
				
			}
			indiceArr++;
			indiceArr%=tamaño;
			contador++;
			if(contador>7) {
				break;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FuncionHASH ob =new FuncionHASH(8);
		String [] elementos= {"20","33","21","10","12","14","56","100"};
		ob.funcioHash(elementos, ob.arr);
		ob.mostrar();
		String buscado=ob.buscarClave("333");
		if(buscado==null) {
			System.out.println("el elemento no buscado no esta");
		}
	}
}