package controllers;

import models.Person;
import views.View;

public class Controller {
    private View view;
    private Person[] persons = new Person[0];
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
    }
    // Metodo que inicia la aplicacion y muestra un menu
    public void start() {
        int option;
        do {
            option = view.showMenu();
            switch (option) {
                case 1 -> inputPersons();
                case 2 -> addPersons();
                case 3 -> sortPersons();
                case 4 -> searchPerson();
            }
        } while (option != 0);
    }
    // Permite al usuario ingresar un conjunto nuevo de personas
    public void inputPersons() {
        System.out.print("¿Cuántas personas desea ingresar? ");
        int n = view.inputAge(); 
        persons = new Person[n];
        for (int i = 0; i < n; i++) {
            persons[i] = view.inputPerson();
        }
    }
    // Añade una nueva persona al arreglo existente
    public void addPersons() {
        Person newPerson = view.inputPerson();
        Person[] newArray = new Person[persons.length + 1];
        System.arraycopy(persons, 0, newArray, 0, persons.length);
        newArray[persons.length] = newPerson;
        persons = newArray;
    }
    // Ordena las personas según el método seleccionado por el usuario
    public void sortPersons() {
        int option = view.selectSortingMethod();
        switch (option) {
            case 1 -> sortingMethods.sortByNameWithBubble(persons);
            case 2 -> sortingMethods.sortByNameWithSelectionDes(persons);
            case 3 -> sortingMethods.sortByAgeWithInsertion(persons);
            case 4 -> sortingMethods.sortByNameWithInsertion(persons);
        }
        view.displayPersons(persons);
    }
    // Busca una persona según lo selecionado
    public void searchPerson() {
        int option = view.selectSearchCriterion();
        if (option == 1) {
            if (!searchMethods.isSortedByAge(persons)) {
                System.out.println("La lista no está ordenada por edad.");
                return;
            }
            int age = view.inputAge();
            Person p = searchMethods.binarySearchByAge(persons, age);
            view.displaySearchResult(p);
        } else if (option == 2) {
            if (!searchMethods.isSortedByName(persons)) {
                System.out.println("La lista no está ordenada por nombre.");
                return;
            }
            String name = view.inputName();
            Person p = searchMethods.binarySearchByName(persons, name);
            view.displaySearchResult(p);
        }
    }
}
