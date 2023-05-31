import java.util.Scanner;

public class pedirDatos {

	public static int pedirInt(String dato) {
		int numero = 0;
		
		Scanner lector = new Scanner(System.in);
		try {
			System.out.println("Dime " + dato);
			numero = lector.nextInt();
			lector.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error");
		}
		
		return numero;
	}
	
	public static boolean pedirRango(int rango1, int rango2) {
		boolean mayor = false;
		
		if(rango1 <= rango2) {
			mayor = true;
		}
		
		return mayor;
	}
}
