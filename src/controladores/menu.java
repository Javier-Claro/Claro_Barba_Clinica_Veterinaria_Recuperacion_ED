package controladores;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entidades.paciente;
import servicios.implFichero;
import servicios.implPaciente;
import servicios.implMenu;
import servicios.intFichero;
import servicios.intPaciente;
import servicios.intMenu;

public class menu {

	public static void main(String[] args) {
		
		intMenu menu=new implMenu();
		intPaciente pacien=new implPaciente();
		intFichero fichero=new implFichero();
		
		//Creamos la lista donde guardaremos nuestros datos:
		List<paciente> bd = new ArrayList<>();
		
		//Creamos la ruta del fichero de texto a guardar los datos:
		File archivo = new File ("C:\\Users\\manuel\\eclipse-workspace\\fichero.txt");
		
		 int opcion=5;
	
				do{	
					try {
						 Scanner preguntar=new Scanner(System.in);
						//Mostramos el menú:
						menu.Menu();
						
						//Un bucle para asegurar que se escoge una opcion:
						do {
						System.out.print("Introduza la opción deseada: ");
						opcion = preguntar.nextInt();
						
						if(opcion < 0 || opcion > 3)
							System.err.println("\n***ERROR***La opción escogida debe ser un número entre 0 y 3.");
						
						}while(opcion < 0 || opcion > 3);
						
						//Entramos en un Switch
						switch (opcion) 
						{			
							case 1:
								fichero.AbrirFicheroLeer(archivo,bd);
								
								break;
							
							case 2:
								pacien.InsertarPaceinte(bd,archivo);
								fichero.AbrirFicheroEscritura(archivo,bd);
								
								break;
								
							case 3:
								pacien.ModificarPaciente(archivo, bd);
								
								break;
						}
				//Diferentes try catch ante posibles errores que se puedan causar al escribir la opción:
				}catch(InputMismatchException e) {
					System.err.println("\n***ERROR***No has introducido un entero");
				}
				catch(NullPointerException e) {
					System.err.println("\n***ERROR***No lo puedes dejar nulo");
				}
				catch(Exception e) {
					System.err.println("\n***ERROR***Se ha surgido otro error");
			}					
		}while(opcion != 0);
		
		//Al salir del bucle, una despedida:
		System.out.println("\n\nGracias por su visita, vuelva pronto.");
	}
}