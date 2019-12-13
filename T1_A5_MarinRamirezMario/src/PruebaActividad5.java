import java.util.Arrays;
class DatosAlumnos {
	private String nombre;
	private String primerAp;
	private String segundoAp;
	private byte edad;
	private String direccion;
	private String telefono;
	private String correoElectronico;
	private String redesSociales[];
	private String carreraDeInteres[];
	private String escuelaPrecedencia;
	private String bachilleratoCursado;
	
public DatosAlumnos(String nombre, String primerAp, String segundoAp, byte edad, String direccion, String telefono,
			String correoElectronico, String[] redesSociales, String[] carreraDeInteres, String escuelaPrecedencia,
			String bachilleratoCursado) {
		this.nombre = nombre;
		this.primerAp = primerAp;
		this.segundoAp = segundoAp;
		this.edad = edad;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.redesSociales = redesSociales;
		this.carreraDeInteres = carreraDeInteres;
		this.escuelaPrecedencia = escuelaPrecedencia;
		this.bachilleratoCursado = bachilleratoCursado;
	}//constructor

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getPrimerAp() {
	return primerAp;
}

public void setPrimerAp(String primerAp) {
	this.primerAp = primerAp;
}

public String getSegundoAp() {
	return segundoAp;
}

public void setSegundoAp(String segundoAp) {
	this.segundoAp = segundoAp;
}

public byte getEdad() {
	return edad;
}

public void setEdad(byte edad) {
	this.edad = edad;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getCorreoElectronico() {
	return correoElectronico;
}

public void setCorreoElectronico(String correoElectronico) {
	this.correoElectronico = correoElectronico;
}

public String[] getRedesSociales() {
	return redesSociales;
}

public void setRedesSociales(String[] redesSociales) {
	this.redesSociales = redesSociales;
}

public String[] getCarreraDeInteres() {
	return carreraDeInteres;
}

public void setCarreraDeInteres(String[] carreraDeInteres) {
	this.carreraDeInteres = carreraDeInteres;
}

public String getEscuelaPrecedencia() {
	return escuelaPrecedencia;
}

public void setEscuelaPrecedencia(String escuelaPrecedencia) {
	this.escuelaPrecedencia = escuelaPrecedencia;
}

public String getBachilleratoCursado() {
	return bachilleratoCursado;
}

public void setBachilleratoCursado(String bachilleratoCursado) {
	this.bachilleratoCursado = bachilleratoCursado;
}
//GETTERS AND SETTERS

@Override
public String toString() {
	return " ======> DatosAlumnos <======\n Nombre: " + nombre + ", Primer Apellido: " + primerAp + ", Segundo Apellido: " + segundoAp + ", Edad: " + edad
			+ ", Dirección: " + direccion + ", Teléfono: " + telefono + ", Correo Electronico: " + correoElectronico
			+ ", Redes Sociales: " + Arrays.toString(redesSociales) + ", Carrera De Interes: "
			+ Arrays.toString(carreraDeInteres) + ", Escuela de Precedencia: " + escuelaPrecedencia
			+ ", Bachillerato Cursado: " + bachilleratoCursado;
}

}//class DatosAlumnos
class RegistroAlumno{
	
	DatosAlumnos[] vectorAlumnos = new DatosAlumnos[10];
	
	
	public boolean registrarAlumno(DatosAlumnos as) {
		for (int i = 0; i < vectorAlumnos.length; i++) {
			if (vectorAlumnos[i]==null) {
				vectorAlumnos[i] = as;
				break;
			}
		}
		return false;
	}
	
	public boolean eliminarAlumno(int posicion) {
		for (int i = 0; i < vectorAlumnos.length; i++) {
			if (i == posicion)
				vectorAlumnos[i]=null;	
		}	
		return false;
	}
	public void imprimirAlumnos() {
		for (int i = 0; i < vectorAlumnos.length; i++) {
			System.out.println(vectorAlumnos[i]);
		}
	}
	@Override
	public String toString() {
		return "RegistroAlumno [vectorAlumnos=" + Arrays.toString(vectorAlumnos) + "]";
	}	
}//class RegistroAlumno
public class PruebaActividad5{
	public static void main(String[] args) {
		String redesSociales1[] = {"FB", "TW", "IG"};
		String carrerasDeInteres1[] = {"Ingeniería en Sistemas Computacionales", "Administración"};
		String carrerasDeInteres2[] = {"Ingeniería en Software", "ISC"};
		String carrerasDeInteres3[] = {"Ingeniería en Mecátronica", "Ingeniería Mecánica"};
		String carrerasDeInteres4[] = {"Ingeniería en Industrias Alimentarias", "Nutrición"};
		String carrerasDeInteres5[] = {"L.C en Administración", "Contador Público"};
		RegistroAlumno ra = new RegistroAlumno();
		System.out.println("Ficha de Ingreso: 001");
		DatosAlumnos da1 = new DatosAlumnos("Mario", "Marín", "Ramírez", (byte)19, "Pino Suarez", "4949494001", "alumno1@gmail.com", redesSociales1, carrerasDeInteres1, "COBAEG", "GENERAL");
		ra.registrarAlumno(da1);
		System.out.println(da1);
		System.out.println("=====================");
		System.out.println("Ficha de Ingreso: 002");
		DatosAlumnos da2 = new DatosAlumnos("Javier", "Sanchez", "Hurtado", (byte)20, "Pino Suarez", "4949494002", "alumno3@gmail.com", redesSociales1, carrerasDeInteres2, "COBAEG", "GENERAL");
		ra.registrarAlumno(da2);
		System.out.println(da2);
		System.out.println("=====================");
		System.out.println("Ficha de Ingreso: 003");
		DatosAlumnos da3 = new DatosAlumnos("Fernanda", "Montoya", "Acevedo", (byte)19, "Pino Suarez", "4949494003", "alumno3@gmail.com", redesSociales1, carrerasDeInteres3, "FRANCISCO GARCIA SALINAS", "GENERAL");
		ra.registrarAlumno(da3);
		System.out.println(da3);
		System.out.println("=====================");
		System.out.println("Ficha de Ingreso: 004");
		DatosAlumnos da4 = new DatosAlumnos("Manuel", "Carrillo", "Gutierrez", (byte)18, "Pino Suarez", "4949494004", "alumno4@gmail.com", redesSociales1, carrerasDeInteres4, "CETIS", "PROGRAMACIÓN");
		ra.registrarAlumno(da4);
		System.out.println(da4);
		System.out.println("=====================");
		System.out.println("Ficha de Ingreso: 005");
		DatosAlumnos da5 = new DatosAlumnos("Juanito", "Perez", "Lopez", (byte)21, "Prolongado 2", "4949494005", "alumno5@gmail.com", redesSociales1, carrerasDeInteres5, "CBETA", "FÍSICO MATEMÁTICO");
		ra.registrarAlumno(da5);
		System.out.println(da5);
		ra.eliminarAlumno(2);
	}//main
}//clas