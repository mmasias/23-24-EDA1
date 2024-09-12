public static void main(String[] args) {
        List nephews = new List();

        nephews.insertAtStart("Juanito");
        nephews.insertAtEnd("Pepito");
        nephews.insertAtIndex(1, "Anita");

        viewLine(nephews);

        nephews.deleteAtStart();
        nephews.deleteAtEnd();
        nephews.deleteAtIndex(0);

        viewLine(nephews);
        }
