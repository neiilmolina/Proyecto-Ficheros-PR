import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Main {

	public static void main(String[] args) {
    	
    	ArrayList<String>lista = new ArrayList<String>();
    	String nombre = "";
    	String fecha ="";
    	int dia=0;
    	int año=0;
    	int eleccionMes=0;
    	int opcion=0;
    	int opcion2=0;
    	String grupo="";
    	char validacion=' ';
    	LocalDate nuevaFecha= LocalDate.now();
    	
        Fichero miFichero=new Fichero("src/datos.txt");
        
        Lista miGrupo = new Lista();
        
        Alumno alumno = new Alumno();
        
        Scanner lector = new Scanner(System.in);
        
        try {
        	do {
            	System.out.println("¿Que quieres hacer?");
                System.out.println("1. Añadir usuario");
                System.out.println("2. Opciones extra");
                System.out.println("3. Salir");
                opcion = lector.nextInt();
                lector.nextLine();
                
                switch (opcion) {
        		
                case 1:
    	        	// Pregunto datos
    	        	do {
    	    			// nombre
    	    			System.out.println("Dime un nombre: ");
    	    			nombre = lector.nextLine();
    	    			
    	    			// validar año
    	    			año = Fecha.obtenerAño();
    	    			
    	    			// validar mes
    	    			eleccionMes = Fecha.obtenerMes(año);
    	    			
    	    			// validar dia
    	    			dia = Fecha.obtenerDia(año, eleccionMes);
    	    			
    	    			// fecha de nacimiento
    	    			fecha = Fecha.obtenerFecha(año, eleccionMes, dia);
    	    			
    	    			// grupo
    	    			System.out.println("Dime un grupo: ");
    	    			grupo = lector.nextLine();
    	    			
    	    			
    	    			// pregunto usuario si quiere añadir a más alumnos
    	    			System.out.println("Desea continuar(s/n)");
    	    			validacion = lector.next().charAt(0);
    	    			
    	    			// lo escribo en el fichero
    	    			miFichero.escribirFichero(nombre + ";" + fecha + ";" + grupo);
    	    			
    	    			// Convierto la fecha en LocalDate
    	    			nuevaFecha = Fecha.stringAFecha(fecha);
    	    			
    	    			
    	    		} while (validacion == 's' || validacion == 'S');
        	            
    				// Obtengo lo que contiene el fichero y lo guardo en un arraylist
    	            lista = miFichero.devolverFichero();
    	            
    	            // Leo lo que está en el fichero y lo meto en miGrupo(clase Lista)
    	            miGrupo.ficheroAlumno(lista, miGrupo);
    	            
    	            // Muestro lo que hay en el fichero
    	            System.out.println(lista);
    	            
    	            // Muestro el toString de miGrupo (Alumnos y características)
    	            System.out.println(miGrupo.toString());
        			break;
        			
                case 2:
            		do {
            			// Obtengo lo que contiene el fichero y lo guardo en un arraylist
        	            lista = miFichero.devolverFichero();
        	            
        	            // Leo lo que está en el fichero y lo meto en miGrupo(clase Lista)
        	            miGrupo.ficheroAlumno(lista, miGrupo);
        	            
        	            System.out.println("Has elegido las opciones extra");
        	            System.out.println("1. Ver los cumples de los alumnos por mes");
        	            System.out.println("2. Ver el alumno mayor y menor");
        	            System.out.println("3. Ver los alumnos mayores de edad");
                    	System.out.println("4. Ver los alumnos en un rango de edad");
                    	System.out.println("5. Ver una lista ordenada de alumnos por edad");
        	            System.out.println("6. Ver la media de los alumnos");
        	            System.out.println("7. Salir");
        	            opcion2 = lector.nextInt();
        	            lector.nextLine();
        	            
        	            switch (opcion2) {
        	            case 1:
        	            	System.out.println("Has elegido ver los cumples de los alumnos por mes");
        	            	miGrupo.getCumpleXMes();
        	            	break;
        				case 2:
        					System.out.println("Has elegido ver el alumno mayor y menor");
        					System.out.println("El mayor es " + miGrupo.getMayor());
        					System.out.println("El menor es " + miGrupo.getMenor());
        					break;
        					
        	            case 3:
        	            	System.out.println("Has elegido ver los alumnos mayores de edad");
        	            	System.out.println(miGrupo.alumnosMayorEdad());
        	            	break;
        	            	
        	            case 4:
        	            	System.out.println("Has elegido ver los alumnos en un rango de edad");
        	            	System.out.println(miGrupo.rangosEdad().toString());
        	            	break;
        	            
        	            case 5:
        	            	System.out.println("Has elegido ver una lista ordenada de alumnos por edad");
        	            	miGrupo.getOrdenEdad();
        	            	break;
        	            
        	            case 6:
        	            	System.out.println("Has elegido ver la media de los alumnos");
        	            	System.out.println(miGrupo.mediaEdad());
        	            	break;
        				}
        	            
        	            if(opcion2 < 1 || opcion2 > 6 && opcion2 != 7) {
        	            	System.out.println("Opción no valida");
        	            } 
					} while (opcion2 != 7);
        	            
                	break;
        		}
                if(opcion < 1 || opcion > 2 &&  opcion != 3) {
                	System.out.println("Opción no valida");
                }
            
    		}while(opcion != 3 );
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error");
		}

}

}
