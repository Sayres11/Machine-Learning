public class Main {
    public static void main(String[] args) {
        Reader train = new Reader();
        train.read("C:/Users/Aliaksei/Desktop", "wdbc.data");
        Reader test = new Reader();
        test.read("C:/Users/Aliaksei/Desktop", "wdbc.test.data");
        Algorithm k = new Algorithm();
      /*  User user = new User();
        user.enter();*/
        k.kNN(train.getIrisList(), test.getIrisList(), 3);
    }
}
