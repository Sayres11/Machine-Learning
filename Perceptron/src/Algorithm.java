import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Algorithm {
    private double threshold = 0; // prog
    private List<Double> weights;// waga

    public Algorithm(List<Iris> list) {
        calculateWeights(list.get(0).getData().length);
    }

    public void perceptron(List<Iris> irisList) {
        double mistake = 0;
        int result;
        int difference;
        for (Iris iris :
                irisList) {
            result = output(iris);
            difference = iris.getTypeNumber() - result;

            iris.setKindTypeNumber(result);

            if (iris.getKindTypeNumber() != iris.getTypeNumber()) {
                mistake++;
            }

            double ALPHA_LEARNING_VALUE = 0.1;
            for (int i = 0; i < weights.size(); i++) {
                double newWeight = weights.get(i) + difference * ALPHA_LEARNING_VALUE * iris.getData()[i];
                weights.set(i, newWeight);
            }
            setThreshold(getThreshold() + difference * ALPHA_LEARNING_VALUE);
        }

        if (irisList.size() > 2) {
            System.out.println(100 - mistake / irisList.size() * 100 + "% correct");
        } else {
            System.out.println("\n" + "Kind Type: " + irisList.get(0).getKindTypeNumber());
        }
    }

    public void calculateWeights(int dataSize) {
        weights = new ArrayList();
        Random ran = new Random();

        for (int i = 0; i < dataSize; i++) {
            weights.add(0 + (1) * ran.nextDouble());
        }
    }

    public int output(Iris iris) {
        double sum = 0;

        for (int j = 0; j < iris.getData().length; j++) {
            sum += iris.getData()[j] * weights.get(j);
        }
        return sum >= threshold ? 1 : 0;
    }

    public void setWeights(List<Double> weights) {
        this.weights = weights;
    }

    public void setThreshold(double newThreshold) {
        this.threshold = newThreshold;
    }

    public double getThreshold() {
        return threshold;
    }
}

