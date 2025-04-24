import controllers.*;
import views.View;

public class App {
    public static void main(String[] args) {
        // Crea una instancia de la vista
        View view = new View();
        // Crea una instancia de la clase que contiene los métodos de ordenamiento
        SortingMethods sortingMethods = new SortingMethods();
        // Crea una instancia de la clase que contiene los métodos de búsqueda
        SearchMethods searchMethods = new SearchMethods();
        // Crea el controlador principal pasándole las dependencias necesarias
        Controller controller = new Controller(view, sortingMethods, searchMethods);
        //inica la aplicacion utilizando el controlador
        controller.start();
    }
}
