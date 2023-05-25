import java.util.Scanner;

public class User {
    private final Iris iris = new Iris();

    public void enter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data and type");
        String[] dataBuffer = sc.next().split(",");
        double[] data = new double[dataBuffer.length - 1];
        for (int j = 0; j < dataBuffer.length - 1; j++) {
            data[j] = Double.parseDouble(dataBuffer[j]);
        }
        iris.setType(dataBuffer[dataBuffer.length - 1]);
        iris.setData(data);
    }

    public Iris getIris() {
        return iris;
    }
}
