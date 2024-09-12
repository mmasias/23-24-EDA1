import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class CarrefourColas {
    public static int peopleInRow = 0; 
    public static void main(String[] args){

        Scanner siguiente = new Scanner(System.in);
        List fila1 = new List();
        List fila2 = new List();
        List fila3 = new List();
        List fila4 = new List();
        int hour = 0;

        do{
            
            hour ++;
            System.out.println("Gente en cola" + consumerToQueue(peopleInRow)); 
            consumerAttending(fila1, fila2, fila3, fila4, peopleInRow);
            siguiente.nextLine();

        }while(hour < 5);{
            printEnd();
        }

    }

    public static int consumerToQueue(int consumer){
        posibilityConsumer(consumer);
        return consumer;
    }

    public static int posibilityConsumer(int consumer){
        double posibility = 0.40;
        double randomPosibility = Math.random();

        if(randomPosibility <= posibility){
            consumer ++;
        }

        System.out.println(consumer);
        return consumer;
    }

    public static int consumerPacks() {
        Random random = new Random();
        int numberRandom = random.nextInt(11) + 5;
        
        return numberRandom;
    }

    public static void printEnd() {
        System.out.println("Personas en fila hay " + consumerToQueue(peopleInRow));
    }
    
    public static List consumerAttending(List fila1, List fila2, List fila3, List fila4, int consumer) {

        int people = consumerToQueue(consumer);

        if (people >= 1 && fila1.size() == 0) {
            addCostumer(fila1);
            System.out.println("Packs en la fila1: " + Arrays.toString(fila1.listAll()));
            return fila1;
            
        } if (people >= 1 && fila2.size() == 0){
            addCostumer(fila2);
            System.out.println("Packs en la de fila2: " + Arrays.toString(fila2.listAll()));
            return fila2;

        } if (people >= 1 && fila3.size() == 0){
            addCostumer(fila3);
            System.out.println("Packs en la de fila3: " + Arrays.toString(fila3.listAll()));
            return fila3;

        } if (people >= 1 && fila4.size() == 0){
            addCostumer(fila4);
            System.out.println("Packs en la de fila4: " + Arrays.toString(fila4.listAll()));
            return fila4;
        } 

        System.out.println("No hay clientes para atender en ninguna fila.");
        return null;
    }

    public static void addCostumer(List lista){

        for (int i = 1; i <= consumerPacks(); i++) {
            lista.insert(i);
        }
    }
}