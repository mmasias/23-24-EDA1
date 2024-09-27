package hojacalculo;

public class posicion {
    private int fila=0;
    private int columna=0;  
    public void setfila(int numero)
    {
        this.fila=numero;
    }
    public void setcolumna(int numero)
    {
        this.columna=numero;
    }    
    public int getfila()
    {
        return this.fila;
    }
    public int getcolumna()
    {
        return this.columna;
    }
    public void muevefila(char opera)
    {
        if (opera=='-')
            this.fila--;
        else
            this.fila++;
    }
    public void muevecol(char opera)
    {
        if (opera=='-')
            this.columna--;
        else
            this.columna++;
    }
}
