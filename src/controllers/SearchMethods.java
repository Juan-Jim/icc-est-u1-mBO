package controllers;

import models.Person;

public class SearchMethods {
// Realiza una búsqueda binaria por edad en un arreglo ordenado
    public Person binarySearchByAge(Person[] arr, int age) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid].getAge() == age) return arr[mid];
            else if (arr[mid].getAge() < age) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }
// Realiza una búsqueda binaria por nombre en un arreglo ordenado
    public Person binarySearchByName(Person[] arr, String name) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].getName().compareToIgnoreCase(name);
            if (cmp == 0) return arr[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }
// Verifica si un arreglo está ordenado por edad de forma ascendente
    public boolean isSortedByAge(Person[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].getAge() > arr[i + 1].getAge()) return false;
        }
        return true;
    }
// Verifica si un arreglo está ordenado por nombre de forma ascendente
    public boolean isSortedByName(Person[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].getName().compareToIgnoreCase(arr[i + 1].getName()) > 0) return false;
        }
        return true;
    }
}
