//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Arbol {
    private Nodo raiz;
    private int altura;
    private int cantidad;

    public Arbol(int valor) {
        this.raiz = new Nodo(valor);
    }

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return this.raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    private void addNodo(Nodo nodo, Nodo raiz) {
        if (raiz == null) {
            this.setRaiz(nodo);
            raiz.setPadre((Nodo)null);
        } else if (nodo.getValor() < raiz.getValor()) {
            if (raiz.getHojaIzquierda() == null) {
                raiz.setHojaIzquierda(nodo);
                raiz.getHojaIzquierda().setPadre(raiz);
            } else {
                this.addNodo(nodo, raiz.getHojaIzquierda());
            }
        } else if (raiz.getHojaDerecha() == null) {
            raiz.setHojaDerecha(nodo);
            raiz.getHojaDerecha().setPadre(raiz);
        } else {
            this.addNodo(nodo, raiz.getHojaDerecha());
        }
    }

    public void addNodo(Nodo nodo) {
        this.addNodo(nodo, this.raiz);
    }

    private void recorridoInorden(Nodo nodo) {
        if (nodo.getHojaIzquierda() != null) {
            this.recorridoInorden(nodo.getHojaIzquierda());
        }
        System.out.print(nodo.getValor() + " ");
        if (nodo.getHojaDerecha() != null) {
            this.recorridoInorden(nodo.getHojaDerecha());
        }

    }


    public void inorden() {
        this.recorridoInorden(this.raiz);
    }


    private void recorridoPreorden(Nodo nodo) {
        if (nodo != null) {
            this.recorridoPreorden(nodo.getHojaIzquierda());
        }

        if (nodo.getHojaDerecha() != null) {
            this.recorridoPreorden(nodo.getHojaDerecha());
        }
        System.out.print(nodo.getValor() + " ");
    }

    public void preorden() {
        this.recorridoPreorden(this.raiz);
    }

    private void recorridoPostorden(Nodo nodo) {

        if (nodo.getHojaIzquierda() != null) {
            this.recorridoInorden(nodo.getHojaIzquierda());
        }
        if (nodo.getHojaDerecha() != null) {
            this.recorridoInorden(nodo.getHojaDerecha());
        }
        System.out.print(nodo.getValor() + " ");
    }

    public void postorden() {
        this.recorridoPostorden(this.raiz);
    }

    private void altura(Nodo visitado, int nivel) {
        if (visitado != null) {
            this.altura(visitado.getHojaIzquierda(), nivel + 1);
            if (nivel > this.altura) {
                this.altura = nivel;
            }

            this.altura(visitado.getHojaDerecha(), nivel + 1);
        }

    }

    public int altura() {
        this.altura = 0;
        this.altura(this.raiz, 0);
        return this.altura;
    }

    private void peso(Nodo reco) {
        if (reco != null) {
            ++this.cantidad;
            this.peso(reco.getHojaIzquierda());
            this.peso(reco.getHojaDerecha());
        }

    }

    public int peso() {
        this.cantidad = 0;
        this.peso(this.raiz);
        return this.cantidad;
    }

    public boolean removeNodo(Nodo nodo) {
        boolean tieneNodoDerecha = nodo.getHojaDerecha() != null;
        boolean tieneNodoIzquierda = nodo.getHojaIzquierda() != null;
        if (!tieneNodoDerecha && !tieneNodoIzquierda) {
            return this.removeNodoCaso1(nodo);
        } else if (tieneNodoDerecha && !tieneNodoIzquierda) {
            return this.removeNodoCaso2(nodo);
        } else if (!tieneNodoDerecha && tieneNodoIzquierda) {
            return this.removeNodoCaso2(nodo);
        } else {
            return tieneNodoDerecha && tieneNodoIzquierda ? this.removeNodoCaso3(nodo) : false;
        }
    }

    private boolean removeNodoCaso1(Nodo nodo) {
        Nodo hijoIzquierdo = nodo.getPadre().getHojaIzquierda();
        Nodo hijoDerecho = nodo.getPadre().getHojaDerecha();
        if (hijoIzquierdo == nodo) {
            nodo.getPadre().setHojaIzquierda((Nodo)null);
            return true;
        } else if (hijoDerecho == nodo) {
            nodo.getPadre().setHojaDerecha((Nodo)null);
            return true;
        } else {
            return false;
        }
    }

    private boolean removeNodoCaso2(Nodo nodo) {
        Nodo hijoIzquierdo = nodo.getPadre().getHojaIzquierda();
        Nodo hijoDerecho = nodo.getPadre().getHojaDerecha();
        Nodo hijoActual = nodo.getHojaIzquierda() != null ? nodo.getHojaIzquierda() : nodo.getHojaDerecha();
        if (hijoIzquierdo == nodo) {
            nodo.getPadre().setHojaIzquierda(hijoActual);
            hijoActual.setPadre(nodo.getPadre());
            nodo.setHojaDerecha((Nodo)null);
            nodo.setHojaIzquierda((Nodo)null);
            return true;
        } else if (hijoDerecho == nodo) {
            nodo.getPadre().setHojaDerecha(hijoActual);
            hijoActual.setPadre(nodo.getPadre());
            nodo.setHojaDerecha((Nodo)null);
            nodo.setHojaIzquierda((Nodo)null);
            return true;
        } else {
            return false;
        }
    }

    private boolean removeNodoCaso3(Nodo nodo) {
        Nodo nodoMasALaIzquierda = this.recorrerIzquierda(nodo.getHojaDerecha());
        if (nodoMasALaIzquierda != null) {
            nodo.setValor(nodoMasALaIzquierda.getValor());
            this.removeNodo(nodoMasALaIzquierda);
            return true;
        } else {
            return false;
        }
    }

    private Nodo recorrerIzquierda(Nodo nodo) {
        return nodo.getHojaIzquierda() != null ? this.recorrerIzquierda(nodo.getHojaIzquierda()) : nodo;
    }

    public static void main(String[] args) {
        Arbol arbolito = new Arbol(42);
        arbolito.addNodo(new Nodo(24));
        arbolito.addNodo(new Nodo(52));
        arbolito.addNodo(new Nodo(6123));
        arbolito.addNodo(new Nodo(75));
        arbolito.addNodo(new Nodo(33));
        arbolito.addNodo(new Nodo(13));
        System.out.println("Inorden:");
        arbolito.inorden();
        System.out.println();
        arbolito.postorden();
    }
}
