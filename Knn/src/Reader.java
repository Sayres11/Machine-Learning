import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private final List<String> textList = new ArrayList<>();
    private final List<Iris> irisList = new ArrayList<>();

    public void read(String path, String fileName) {
        try {
            String string = null;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path + "/" + fileName));
            while ((string = bufferedReader.readLine()) != null) {
                textList.add(string);
            }
            findArguments(textList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findArguments(List<String> a) {
        for (int i = 0; i < a.size(); i++) {
            String[] dataBuffer = a.get(i).split(",");
            double[] data = new double[dataBuffer.length - 1];

            for (int j = 0; j < dataBuffer.length - 1; j++) {
                data[j] = Double.parseDouble(dataBuffer[j]);
            }

            irisList.add(new Iris(dataBuffer[0].replace("\"", ""),
                    data,
                    dataBuffer[dataBuffer.length - 1]));
        }
    }

    public void printAllData() {
        for (Iris iris : irisList) {
            System.out.println(iris);
            System.out.println("-----------------------------");
        }
        System.out.println(irisList.size() + " Elements printed");
    }

    public List<Iris> getIrisList() {
        return irisList;
    }
}
