package entidades;

public class paciente {
	
	//Entidades privadas, para que nadie pueda verlas excepto cuando se requiera:
	private String numeroTelefono;
	private String fechaAlta;
	private String fechaIngreso;
	private String nombrePaciente;
	
	//Getters y Setters:
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	//Un constructor para una posterior escritura en el fichero:
	public paciente(String numeroTelefono, String fechaAlta, String fechaIngreso, String nombrePaciente) {
		super();
		this.numeroTelefono = numeroTelefono;
		this.fechaAlta = fechaAlta;
		this.fechaIngreso = fechaIngreso;
		this.nombrePaciente = nombrePaciente;
	}
	
	//Constructor vacío para un nuevo paciente:
	public paciente() {
		super();	
	}
}