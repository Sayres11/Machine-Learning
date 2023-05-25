
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private final Iris iris = new Iris();
    private List<Iris> irisList = new ArrayList<>();

    public void enter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data");
        String[] dataBuffer = sc.next().split(",");
        double[] data = new double[dataBuffer.length];
        for (int j = 0; j < dataBuffer.length ; j++) {
            data[j] = Double.parseDouble(dataBuffer[j]);
        }
        iris.setData(data);
        irisList.add(iris);
    }

    public Iris getIris() {
        return iris;
    }

    public List<Iris> getIrisList() {
        return irisList;
    }
}

