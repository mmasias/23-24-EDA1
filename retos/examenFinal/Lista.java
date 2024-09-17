import java.time.LocalDate;
import java.util.ArrayList;

public class Lista<T> extends DatosLista implements Comparable<Lista<T>> {
    private T valor;
    private Lista<Lista<T>> hijos;

    public Lista(T valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>();
    }

    @Override
    public int compareTo(Lista<T> o) {
        // TODO: Implementar la lógica de comparación según tus necesidades
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Lista<Lista<T>> getHijos() {
        return hijos;
    }

   
    public void setHijos(<Lista<T>> hijos) {
        this.hijos = hijos;
    }

    public void insertarHijo(Lista<T> hijo) {
        hijos.add(hijo);
    }

    public void setHijos(Lista<Lista<T>> hijos) {
        this.hijos = hijos;
    }

    public LocalDate getElementos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getElementos'");
    }

    public int totalCaloriasEnc() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'totalCaloriasEnc'");
    }

    public String totalTipoEnc(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'totalTipoEnc'");
    }
}

    
    

