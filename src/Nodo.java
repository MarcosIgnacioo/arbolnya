//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Nodo {
    private int valor;
    private Nodo padre;
    private Nodo hojaIzquierda;
    private Nodo hojaDerecha;

    public Nodo(int valor) {
        this.valor = valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    public Nodo getPadre() {
        return this.padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public Nodo getHojaIzquierda() {
        return this.hojaIzquierda;
    }

    public void setHojaIzquierda(Nodo hojaIzquierda) {
        this.hojaIzquierda = hojaIzquierda;
    }

    public Nodo getHojaDerecha() {
        return this.hojaDerecha;
    }

    public void setHojaDerecha(Nodo hojaDerecha) {
        this.hojaDerecha = hojaDerecha;
    }
}
