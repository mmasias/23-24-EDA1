public class Main {
    public static void main(String[] args) {

        User user = User.registerUser();

        user.registerFood();
        user.printAll();

    }

}
