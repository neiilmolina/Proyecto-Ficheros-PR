import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Fecha {

	// metodo para convertir de una fecha en String a LocalDate
	public static LocalDate stringAFecha (String fechaNac) {
		
		// Spliteo el String
		String[] fechaArray = fechaNac.split("/");
		// convierto lo que hay en el array a int y luego lo meto en el LocalDate
		int dia = Integer.parseInt(fechaArray[0]);
		
		int mes = Integer.parseInt(fechaArray[1]);
		
		int año = Integer.parseInt(fechaArray[2]);
		
		return LocalDate.of(año, mes, dia);
		
	}
	
	// metodo para validar año
	public static int obtenerAño() {
		int año;
		
		do {
			año = pedirDatos.pedirInt("año");
			
		}while(año < 1940 || año > 2016 );
		
		return año;
	}
	
	// metodo para validar mes
	public static int obtenerMes(int año) {
		int eleccionMes;
		
		do {
			eleccionMes = pedirDatos.pedirInt("un numero del 1-12");
		}while(eleccionMes < 1 || eleccionMes > 12 );
		
		return eleccionMes;
	}
	
	// metodo para validar dia
	public static int obtenerDia(int año, int eleccionMes) {
		int dia;
    	int mes[]= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    	
		if (año % 4 == 0) {
			mes[1] = 29;
		}
		
		
		do {
			dia = pedirDatos.pedirInt("dia del mes" + eleccionMes + " (1-" + mes[eleccionMes - 1] + ")");
			
		}while(dia < 1 || dia > mes[eleccionMes - 1]);
		
		return dia;
	}
	
	// metodo para meter el dia, el mes y el año en una fecha 
	public static String obtenerFecha(int año, int eleccionMes, int dia ) {
		return String.valueOf(dia) + "/" + String.valueOf(eleccionMes) + "/" + String.valueOf(año);
	}
	
	public static long diferenciaFechas(LocalDateTime ahora, LocalDateTime despues) {
		long result = ChronoUnit.HOURS.between(ahora, despues);
		return result;
	}
	
	public static int verEdad(LocalDate fechaNacimiento) {
		return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	}
	
	public static int verMes(LocalDate fechaNacimiento) {
		return (int) ChronoUnit.MONTHS.between(fechaNacimiento, LocalDate.now());
	}
}

