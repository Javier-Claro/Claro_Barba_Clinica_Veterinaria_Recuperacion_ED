package servicios;

import java.io.File;
import java.util.List;

import entidades.paciente;

public interface intPaciente {
	
	//Método para añadir un paciente en la base de datos:
	public void InsertarPaceinte(List<paciente> bd,File archivo);

	//Método para poder dar de alta a un paciente en la base de datos:
	public void ModificarPaciente(File archivo,List<paciente> bd);
}