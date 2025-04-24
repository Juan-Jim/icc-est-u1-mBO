package controllers;

import models.Person;

public class SortingMethods {
// Ordena un arreglo de personas por nombre usando el algoritmo Bubble Sort
    public void sortByNameWithBubble(Person[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].getName().compareToIgnoreCase(arr[j + 1].getName()) > 0) {
                    Person temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

// Ordena un arreglo de personas por nombre usando Selection Sort
    public void sortByNameWithSelectionDes(Person[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].getName().compareToIgnoreCase(arr[maxIndex].getName()) > 0) {
                    maxIndex = j;
                }
            }
            Person temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }
// Ordena un arreglo de personas por edad usando Insertion Sort por edad
    public void sortByAgeWithInsertion(Person[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Person key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getAge() > key.getAge()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
// Ordena un arreglo de personas por nombre usando Insertion Sort por nombre
    public void sortByNameWithInsertion(Person[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Person key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getName().compareToIgnoreCase(key.getName()) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
