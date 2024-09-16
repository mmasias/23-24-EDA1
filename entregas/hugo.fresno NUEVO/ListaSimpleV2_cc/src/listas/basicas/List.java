package listas.basicas;

import java.nio.channels.ClosedSelectorException;

public class List {

    private Node first = null;
    int tamaño=0;

    /*public int size() {
        Node nodeIni = first;
        int count =0;
        if (nodeIni != null) {
            count++;
            while(nodeIni.getNext()!=null){
                count++;
                nodeIni= nodeIni.getNext();
            }
        }
            return count;

    }*/
        //TODO METODO OPTIMIZADO
    public int size(){
        return tamaño;
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        System.out.println("  > Llegó "+value);
        if (this.first == null){
            this.first = newNode;
            tamaño++;
        }
        else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            tamaño++;
            iterator.setNext(newNode);

        }
    }

    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null) {
            this.first = n;
            tamaño++;

        }else {
            n.setNext(this.first);
            this.first = n;
            tamaño++;

        }
    }

    public void insertPos(String value,int position){

        Node newNode = new Node(value);
        int actPosition=1;
        Node actual = first;
        Node previous = null;

        /*if (actual==null){
            first=newNode;
        } else if(position==1){
            newNode.setNext(actual);
            first=newNode;



        }*/
        if (actual==null || position ==1){
            insertFront(value);
            tamaño--;

        }else if(position>tamaño){
            insertEnd(value);
            tamaño--;

        }else {
            while (actual.getNext()!=null && actPosition<position){
                previous=actual;
                actual=actual.getNext();
                actPosition++;

            }


            previous.setNext(newNode);
            newNode.setNext(actual);
        }
        tamaño++;



    }

        //TODO FUNCIONA insertar medio, inicio y sin nada

        /*Node newNode = new Node(value);
        int actPosition=1;
        Node actual = first;
        Node previous = null;

        if (actual==null){
            first=newNode;
        } else if(position==1){
            newNode.setNext(actual);
            first=newNode;

        }else {
            while (actual.getNext()!=null && actPosition<position){
                previous=actual;
                actual=actual.getNext();
                actPosition++;

            }

            previous.setNext(newNode);
            newNode.setNext(actual);
        }
        tamaño++;*/


        //TODO primer intento
        /*Node newNode = new Node(value);
        Node actual=null;
        Node previous=null;
        int actPosition =1;


        if (this.first==null){
            this.first=newNode;

            } else{
             actual=first;
             previous=null;
           while(actual.getNext()!=null){
               previous=actual;
               actual=actual.getNext();
               actPosition++;

               if (position==actPosition){
                       previous.setNext(newNode);
                       newNode.setNext(actual);
                   }

           }


        }

        if (actual!=null){
            if (actual.getNext()==null ){
                actual.setNext(newNode);


             }
            }*/

    //TODO segundo intento
    /*Node newNode = new Node(value);
        int actPosition =0;


        if (this.first==null || position==0) {
            newNode.setNext(first);
            this.first=newNode;

        }
        else if (this.first!=null){
                Node previous=null;
                Node actual=first;


                while(actual.getNext()!=null && position==actPosition){
                    previous=actual;
                    actual=actual.getNext();
                    actPosition++;

                    if (actPosition==position){

                            newNode.setNext(actual);
                            previous.setNext(newNode);

                        } else if(position>actPosition && actual.getNext()==null){
                        previous = actual;
                        actual.getNext().setNext(newNode);

                    }


                    }


                }
        tamaño++;*/



    public void delete() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            System.out.println("Se fue "+iterator.getValue());
            previous.setNext(null);
            tamaño--;
        }
    }

    public void deleteEnd() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            System.out.println("Se fue "+iterator.getValue());
            previous.setNext(null);
            tamaño--;
        }
    }


    public void deleteFront() {

        if (this.first!=null){
            if (this.first.getNext()!=null){
                Node previous = first;
                first=previous.getNext();
                previous=null;
                tamaño--;
            }else {
                first=null;
                tamaño--;
            }

        }
    }

    public void deletePos(int position) {
        if (this.first == null || position < 1) {
            return;
        }

        if (position == 1) {
            this.first = this.first.getNext();
            tamaño--;
            return;
        }

        Node actual = first;
        Node previous = null;
        int actPosition = 1;

        while (actual != null && actPosition < position) {
            previous = actual;
            actual = actual.getNext();
            actPosition++;
        }

        if (actual != null) {
            previous.setNext(actual.getNext());
            tamaño--;
        } else {
        }
    }




    public String[] listAll() {
        //System.out.println("TAMAÑO --- "+size());
        String[] list = new String[this.size()];
        /*if (this.first!=null){
            System.out.println(this.first.getValue());
        }*/
        Node iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            //System.out.println(count);
            //System.out.println(iterator.getValue());
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
}

