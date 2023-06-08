package servicios;

public class implMenu implements intMenu {

	@Override
	public void Menu() {
		
			System.out.println("\n\tBienvenido");
			System.out.println("1---> Leer todos los pacientes");
			System.out.println("2---> Añadir a un aciente");
			System.out.println("3---> Modificar el alta de un paciente");
			System.out.println("0---> Salir");		
	}
}