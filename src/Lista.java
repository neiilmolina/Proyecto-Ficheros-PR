import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lista {

	private ArrayList<Alumno> estudiantes = new ArrayList<Alumno>();

	public Lista() {
		super();
	}

	public ArrayList<Alumno> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Alumno> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public String toString() {
		return "Lista [estudiantes=" + estudiantes + "]";
	}

	// añadir alumno
	public void addAlumno(Alumno item) {
		estudiantes.add(item);
	}

	// metodo que sirve para sacar los alumnos del fichero y añadir un nuevo objeto
	// "Alumno"
	public void ficheroAlumno(ArrayList<String> lista, Lista alumnoLista) {
		String alumnosArray[];
		int longi = lista.size();
		String nombre;
		String grupo;
		LocalDate fecha;

		for (int i = 0; i < longi; i++) {
			if (lista.get(i) != " " + (char) 13) {
				alumnosArray = lista.get(i).split(";");
				nombre = alumnosArray[0];
				fecha = Fecha.stringAFecha(alumnosArray[1]);
				grupo = alumnosArray[2];

				alumnoLista.addAlumno(new Alumno(fecha, nombre, grupo));

				// vaciar array
				alumnosArray = null;
			}
		}
	}

	// Metodos:
	// Cumples por mes (numero)
	public void getCumpleXMes() {

		int longi = estudiantes.size();
		ArrayList<String> mes = new ArrayList<String>();

		mes.add("Enero:");
		mes.add("\n" + "Febrero:");
		mes.add("\n" + "Marzo:");
		mes.add("\n" + "Abril:");
		mes.add("\n" + "Mayo:");
		mes.add("\n" + "Junio:");
		mes.add("\n" + "Julio:");
		mes.add("\n" + "Agosto:");
		mes.add("\n" + "Septiembre:");
		mes.add("\n" + "Octubre:");
		mes.add("\n" + "Noviembre:");
		mes.add("\n" + "Diciembre:");

		int valorMes;

		for (int i = 0; i < longi; i++) {
			valorMes = estudiantes.get(i).getFecha().getMonthValue() - 1;

			mes.set(valorMes, mes.get(valorMes) + ", " + estudiantes.get(i).getNombre());
		}

		System.out.println(mes.toString());

	}

	// Mayor y menor
	public Alumno getMayor() {
		int longi = estudiantes.size();
		int fechaUno;
		int fechaDos;
		int cont = 0;
		boolean encontrado = false;
		Alumno mayor = new Alumno();

		for (int i = 0; i < longi; i++) {
			fechaUno = Fecha.verEdad(estudiantes.get(i).getFecha());
			
			while(cont < longi && !encontrado) {
				fechaDos = Fecha.verEdad(estudiantes.get(cont).getFecha());
				if (fechaUno > fechaDos) {
					mayor = estudiantes.get(i);
					encontrado = true;
				}
			}
		}

		return mayor;
	}

	public Alumno getMenor() {
		int longi = estudiantes.size();
		int fechaUno;
		int fechaDos;
		int cont = 0;
		boolean encontrado = false;
		Alumno menor = new Alumno();

		for (int i = 0; i < longi; i++) {
			fechaUno = Fecha.verEdad(estudiantes.get(i).getFecha());
			while(cont < longi && !encontrado) {
				fechaDos = Fecha.verEdad(estudiantes.get(cont).getFecha());
				if (fechaUno < fechaDos) {
					menor = estudiantes.get(i);
					encontrado = true;
				}
			}
		}

		return menor;
	}

	// Todos los alumnos +18
	public ArrayList<Alumno> alumnosMayorEdad() {
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		int longi = estudiantes.size();
		int edad;

		for (int i = 0; i < longi; i++) {
			edad = Fecha.verEdad(estudiantes.get(i).getFecha());

			if (edad >= 18) {
				lista.add(estudiantes.get(i));

			}
		}

		return lista;
	}

	// Alumnos rango de edades (Ej: 18-22)

	public ArrayList<Alumno> rangosEdad() {
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		int longi = estudiantes.size();
		int edad;
		int rango1 = 0;
		int rango2 = 0;
		boolean mayor = false;
		
		do {
			rango1 = pedirDatos.pedirInt("un rango 1");
			rango2 = pedirDatos.pedirInt("un rango 2");
			mayor = pedirDatos.pedirRango(rango1, rango2);
			if(!mayor) {
				System.out.println("Rango 1 es mayor que rango 2, intentelo de nuevo");
			}
		} while (!mayor);
		
		for (int i = 0; i < longi; i++) {
			edad = Fecha.verEdad(estudiantes.get(i).getFecha());

			if (edad >= rango1 && edad <= rango2) {
				lista.add(estudiantes.get(i));

			}
		}

		return lista;
	}

	// Lista ordenada por edad
	public void getOrdenEdad() {
		int longitud = estudiantes.size();
		Alumno mayor;
		int fechaUno;
		int fechaDos;
		int fechaMayor = 0;

		for (int i = 0; i < longitud; i++) {
			fechaUno = Fecha.verEdad(estudiantes.get(i).getFecha());
			for (int j = 0; j < longitud; j++) {
				fechaDos = Fecha.verEdad(estudiantes.get(j).getFecha());
				if (fechaUno > fechaDos) {
					mayor = estudiantes.get(i);
					estudiantes.set(i, estudiantes.get(j));
					estudiantes.set(j, mayor);
				}

			}
		}

		System.out.println(estudiantes.toString());

	}

	// Media edad
	public double mediaEdad() {
		double cont = 0;
		double suma = 0;
		int edad;
		int longi = estudiantes.size();

		try {
			for (int i = 0; i < longi; i++) {
				edad = Fecha.verEdad(estudiantes.get(i).getFecha());

				suma = suma + (double) edad;
				cont++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error");
		}

		return suma / cont;

	}

}
