import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader train = new Reader();
        train.read("C:/Users/s22141/Desktop", "iristrain.csv");
        Reader test = new Reader();
        test.read("C:/Users/s22141/Desktop", "iristest.csv");
        
        Algorithm k = new Algorithm(train.getIrisList());
        System.out.println("1 train:");
        k.perceptron(train.getIrisList());
        System.out.println("2 train:");
        k.perceptron(train.getIrisList());
        System.out.println("3 train:");
        k.perceptron(train.getIrisList());

        System.out.println("test:");
        k.perceptron(test.getIrisList());

   /*     User user = new User();
        user.enter();
        k.perceptron(user.getIrisList());*/
    }
}
