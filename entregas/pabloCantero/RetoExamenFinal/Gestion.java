import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gestion {

    private Scanner escaner;
    private Paciente paciente;
    private DateTimeFormatter formato;
    private Encuesta encuesta;

    public Gestion() {
        this.paciente = new Paciente(null, null, encuesta);
        this.escaner = new Scanner(System.in);
        this.formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.encuesta = new Encuesta();
    }

    public void insertarPaciente() {
        String nombre;
        LocalDate fechaAlta = null;
        boolean ok = true;
        System.out.println("Introduzca el nombre: ");
        nombre = escaner.nextLine();
        do {
            System.out.println("Introduzca la fecha de alta con el siguiente formato (dd/MM/yyyy): ");
            try {
                ok = true;
                fechaAlta = LocalDate.parse(escaner.nextLine(), formato);
            } catch (Exception e) {
                System.out.println("Fecha incorrecta, escriba una valida");
                ok = false;
            }
        } while (ok == false);

        paciente  = new Paciente(fechaAlta, nombre, encuesta);

       
    }

    public void insertarEncuesta() {
        LocalDate fechaEncuesta = null;
        boolean ok = true;
        LocalDate fechaAlta = paciente.getFechaDeAlta();
        encuesta = new Encuesta();
        
        
        do {
            System.out.println("Introduzca la fecha de la encuesta con el siguiente formato (dd/MM/yyyy): ");
            try {
                ok = true;
                fechaEncuesta = LocalDate.parse(escaner.nextLine(), formato);
                if (fechaEncuesta.isBefore(fechaAlta)) {
                    System.out.println("Error: La fecha de la encuesta no puede ser anterior a la fecha de alta.");
                    ok = false;
                }
            } catch (Exception e) {
                System.out.println("Fecha incorrecta, escriba una valida");
                ok = false;
            }
        } while (ok == false);

        
        paciente.getEncuesta().setFecha(fechaEncuesta);
        
    }

    public void insertarDias() {

        for (int i = 1; i <= 5; i++) {
            Dia d = new Dia(i);
            this.paciente.getEncuesta().insertarDias(d);

        }
    }



    public void insertarIngestas() {
        int dia = 0;
        boolean ok = true;
        String opcionAlimento = null;
        Ingesta ing = null;

        do {
            do {
                System.out.println("Seleccione dia (1-5) (0) para salir: ");
                try {
                    dia = escaner.nextInt();
                    ok = true;
                } catch (InputMismatchException e) {
                    escaner.nextLine();
                    dia=-1;
                    System.out.println("Ese numero de dia no existe");
                    ok = false;
                }
                if (dia < 0 || dia > 5) {
                    System.out.println("Número fuera del rango. Por favor, ingrese un dia entre 1 y 5, o pulse 0 para finalizar la encuesta.");
                    ok = false;  
                }
            

            } while (!ok);
            if (dia == 0) {
                break;
            }
            Dia diaSeleccionado = paciente.getEncuesta().getDias().getValorPorPosicion(dia - 1);
            Ingesta ingesta = null;
            int opcion = 0;
            do {
                ok = true;
                System.out.println(
                        "Seleccione ingesta: 1-Desayuno / 2-Media Mañana / 3-Almuerzo /4-Merienda / 5-Cena/ -1 - (Menu Anterior)");
                try {
                    opcion = escaner.nextInt();

                } catch (InputMismatchException e) {
                    System.out.println("Inserte un número, no una letra");
                    escaner.nextLine();
                    ok = false;
                }
                switch (opcion) {
                    case 1:
                        ing = new Ingesta(Horario.DESAYUNO);

                        break;
                    case 2:
                        ing = new Ingesta(Horario.MEDIAMAÑANA);

                        break;

                    case 3:
                        ing = new Ingesta(Horario.ALMUERZO);

                        break;
                    case 4:
                        ing = new Ingesta(Horario.MERIENDA);

                        break;
                    case 5:
                        ing = new Ingesta(Horario.CENA);

                        break;
                    case -1:
                        break;

                    default:
                        System.out.println("Opcion incorrecta, elige otra");
                        ok = false;
                        break;
                }
            } while (!ok);
            
            do {
                System.out.println("Inserte un alimento del " + ing.getHorario().getDescription() + " del dia " + dia
                        + " (-1 para terminar / -2 para listar alimentos ingresados / -3 para vaciar)");
                escaner = new Scanner(System.in);
                opcionAlimento = escaner.nextLine();

                if (opcionAlimento.equals("-2")) {
                    System.out.println("Los alimentos ya ingresados son: \n" + ing.getInformacion());
                } else if (opcionAlimento.equals("-3")){
                    ing.vaciar();
                } else if (!opcionAlimento.equals("-1")) {
                    boolean isNumeric = true;
                    int gramos= 0;
                    do {
                        try {
                            System.out.println("Introduzca la cantidad de gramos: ");
                            gramos = Integer.parseInt(escaner.nextLine());
                            if(gramos <= 0){
                                System.out.println("Error: La cantidad de gramos no puede ser negativa.");
                                isNumeric = false;
                            } else {
                                isNumeric = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Ingrese solo números para la cantidad de gramos.");
                            isNumeric = false;
                        }
                    } while (!isNumeric);
            
                    ing.insertarAlimento(new Alimento(opcionAlimento, gramos));
                }
            } while (!opcionAlimento.equals("-1"));

            if (ing != null) {
                diaSeleccionado.agregarIngesta(ing);   
            }

        } while (true);
    }
    
    

    public void capturarDatos() {
        insertarPaciente();
        insertarDias();
        insertarEncuesta();
        insertarIngestas();

    }

    public void mostrarDatos() {
         
          
        System.out.println(this.paciente.getInformacion());
        Encuesta encuesta = this.paciente.getEncuesta();
        System.out.println(encuesta.getInformacion());
        GenericList<Dia> dias = encuesta.getDias();

        for(int i= 0; i<dias.size();i++){
            Dia d= dias.getValorPorPosicion(i);
            System.out.println(d.getInformacion());
            GenericList<Ingesta> ingestas= d.getIngestas();
            for(int j=0; j< ingestas.size();j++){
                Ingesta ing = ingestas.getValorPorPosicion(j);
                System.out.println(ing.getInformacion());
            }
        }

    
    }
    
    
    
    

}

