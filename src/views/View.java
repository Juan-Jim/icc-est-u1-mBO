package views;

import java.util.Scanner;
import models.Person;

public class View {
// Scanner para leer la entrada del usuario
    private Scanner scanner = new Scanner(System.in);
// Menu pricipal
    public int showMenu() {
        System.out.println("====== MENU ======");
        System.out.println("1. Ingresar personas");
        System.out.println("2. Agregar persona");
        System.out.println("3. Ordenar personas");
        System.out.println("4. Buscar persona");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }
// Solicita al usuario los datos para crear una nueva persona
    public Person inputPerson() {
        System.out.print("Ingrese nombre: ");
        String name = inputName();
        System.out.print("Ingrese ");
        int age = inputAge();
        return new Person(name, age);
    }
// Muestra el menú de métodos de ordenamiento y obtiene la selección
    public int selectSortingMethod() {
        System.out.println("\nMétodo de ordenamiento:");
        System.out.println("1. Burbuja por nombre");
        System.out.println("2. Selección descendente por nombre");
        System.out.println("3. Inserción por edad");
        System.out.println("4. Inserción por nombre");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }
// Muestra el menú de criterios de búsqueda y obtiene la selección
    public int selectSearchCriterion() {
        System.out.println("\nCriterio de búsqueda:");
        System.out.println("1. Buscar por edad");
        System.out.println("2. Buscar por nombre");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }
// Muestra la lista de personas en la consola
    public void displayPersons(Person[] persons) {
        for (Person p : persons) {
            if (p != null) System.out.println(p);
        }
    }
// Muestra el resultado de una búsqueda
    public void displaySearchResult(Person p) {
        if (p != null) System.out.println("Encontrado: " + p);
        else System.out.println("Persona no encontrada.");
    }
// Solicita y obtiene la edad de una persona
    public int inputAge() {
        System.out.print("edad: ");
        return scanner.nextInt();
    }
// Solicita y obtiene el nombre de una persona
    public String inputName() {
        return scanner.next();
    }
}
