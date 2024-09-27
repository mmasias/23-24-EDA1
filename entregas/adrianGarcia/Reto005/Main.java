public class Main {
    public static void main(String[] args) {
        List<NodoCola> colas = new List<>();

        for (int i = 0; i < 4; i++) {
            colas.add(new NodoCola(0));
        }

        int cola = 0;

        for (int minuto = 1; minuto <= 720; minuto++) {
            int probLlegada = (int) ( Math.random() * 10 ) + 1;

            if (probLlegada <= 6) {
                if (cajasFull(colas)) {
                    cola++;
                } else {
                    for (int i = 0; i < colas.size(); i++) {
                        if (colas.get(i).getData() == 0) {
                            colas.get(i).setData((int) (Math.random() * 11) + 5);
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i < colas.size(); i++) {
                if (colas.get(i).getData() > 0) {
                    colas.get(i).setData(colas.get(i).getData() - 1);
                }
            }

            if (cola > 0) {
                for (int i = 0; i < colas.size(); i++) {
                    if (colas.get(i).getData() == 0) {
                        colas.get(i).setData((int) (Math.random() * 11) + 5);
                        cola--;
                        break;
                    }
                }
            }


            System.out.println("MINUTO " + minuto + " - " + (probLlegada <= 6 ? "Llega 1 persona" : "No llega nadie") + " - En cola: " + cola);
            for (int i = 0; i < colas.size(); i++) {
                System.out.print(" Caja" + (i + 1) + ":[" + colas.get(i).getData() + "] |");
            }
            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
        }
    }

    private static boolean cajasFull(List<NodoCola> colas) {
        for (int i = 0; i < colas.size(); i++) {
            if (colas.get(i).getData() == 0) {
                return false;
            }
        }
        return true;
    }
}