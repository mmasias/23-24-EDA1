public class Ingesta {
    private String tiempoIngesta;
    private Alimento first;

    public Ingesta(String tiempoIngesta) {
        this.tiempoIngesta = tiempoIngesta;
        this.first=null;
    }

    public String getTiempoIngesta() {
        return tiempoIngesta;
    }

    public void anotarAlimento(String descripcion){
        Alimento nuevoAlimento = new Alimento(descripcion);
        if(this.first==null){
            this.first=nuevoAlimento;
        } else {
            Alimento iterador = first;
            while (iterador.getSiguiente() !=null){
                iterador=iterador.getSiguiente();
            }
            iterador.setSiguiente(nuevoAlimento);
        }
    }

    //caso que sea necesario borrar un alimento
    public void borrarAlimento(int n){
        int i=1;
        Alimento iterador=this.first;
        while ((iterador.getSiguiente()!=null)&&(i<n-1)){
            iterador=iterador.getSiguiente();
        }
        System.out.println("Alimento ("+iterador.getSiguiente().getDescripcion()+") borrado correctamente");
        iterador.setSiguiente(iterador.getSiguiente().getSiguiente());
    }

    public void listarAlimentos(){
        Alimento iterador = this.first;
        while (iterador!=null){
            System.out.print("                ");
            System.out.println(iterador.getDescripcion());
            iterador = iterador.getSiguiente();
        }
    }


}
