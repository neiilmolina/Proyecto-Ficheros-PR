import java.time.LocalDate;

public class Alumno  {
	private String nombre;
	private String grupo;
	private LocalDate fecha;
	
	public Alumno(LocalDate fecha, String nombre, String grupo) {
		this.fecha = fecha;
		this.nombre = nombre;
		this.grupo = grupo;
	}

	public Alumno() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", grupo=" + grupo + "fecha="+ fecha +"]";
	}
	
	
	
	
}
