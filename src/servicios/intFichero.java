package servicios;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import entidades.paciente;

public interface intFichero 
{

	//Método para abrir fichero escrito:
	public void AbrirFicheroEscritura(File archivo, List<paciente> bd);

	//Método para escribir en fichero:
	public void EscribirFichero(FileWriter fichero,File archivo, List<paciente> bd);


	//Método para cerrar el fichero escrito:
	public void CerrarFichero(FileWriter fichero);


	//Método para abrir un fichero para leer:
	public void AbrirFicheroLeer(File archivo, List<paciente> bd);


	//Método para cerrar el fichero:
	public void CerrarFicheroLeido(FileReader fr);


	//Método para el encabezado del archivo de texto:
	public void EscribirEncabezado(File archivo);
}