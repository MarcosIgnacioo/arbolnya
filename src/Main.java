public class Main {//holaworld
    public static void main(String[] args) {
        Arbol arbolito = new Arbol(4);
        arbolito.addNodo(new Nodo(2));
        arbolito.addNodo(new Nodo(5));
        arbolito.addNodo(new Nodo(6));
        arbolito.addNodo(new Nodo(7));
        arbolito.addNodo(new Nodo(3));
        arbolito.addNodo(new Nodo(1));
        System.out.println("Inorden:");
        arbolito.inorden();
    }
}