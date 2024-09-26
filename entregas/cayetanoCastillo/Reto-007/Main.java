package ProyectoFinal;

public class Main {
    public static void main(String[] args) {
        InterfazUsuario interfazUsuario = new InterfazUsuario();

        if (interfazUsuario.pedirConfirmacionInstrucciones()) {
            interfazUsuario.mostrarInstrucciones();
        }

        String nombrePaciente = interfazUsuario.solicitarNombrePaciente();
        double altura = interfazUsuario.solicitarAlturaPaciente();
        double peso = interfazUsuario.solicitarPesoPaciente();
        String sexo = interfazUsuario.solicitarSexoPaciente();
        int edad = interfazUsuario.solicitarEdadPaciente();
        String frecuenciaEjercicio = interfazUsuario.solicitarFrecuenciaEjercicio();

        // Crear instancia de EncuestaAlimentaria y proceder con la encuesta
        EncuestaAlimentaria encuesta = new EncuestaAlimentaria(nombrePaciente, altura, peso, sexo, edad,
                frecuenciaEjercicio);
        encuesta.iniciarEncuesta();
    }
}