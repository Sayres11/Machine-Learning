import java.util.*;
import java.util.stream.Collectors;

public class Algorithm {
    double mistake = 0;
    private List<String> types = new ArrayList<>();

    public void kNN(List<Iris> train, List<Iris> test, int k) {
        if (k == 0 || k > train.size()) {
            System.out.println("invalid K");
        } else
            getTypes(train);
        for (Iris iris :
                test) {
            determine(train, iris, k);
        }
        //determine(train, test.get(41), k);*/

        System.out.println(100 - mistake / test.size() * 100 + "% correct");
    }

    public void kNN(List<Iris> train, Iris iris, int k) {
        if (k == 0 || k > train.size()) {
            System.out.println("invalid K");
        } else {
            determine(train, iris, k);
            //System.out.println(100 - mistake / test.size() * 100 + "% correct");
        }
    }

    private void determine(List<Iris> trainingArray, Iris iris, int k) {
        List<Iris> distance = new ArrayList<>();

        System.out.println("K = " + k);

        for (Iris training :
                trainingArray) {
            double calculateDistance = 0;



            for (int i = 0; i < iris.getData().length ; i++) {
                calculateDistance += Math.pow((training.getData()[i] - iris.getData()[i]), 2);
            }

            distance.add(new Iris(Math.sqrt(calculateDistance)
                    , iris.getType()
                    , training.getType()));
        }

        distance.sort(Iris.comp);
        List<String> stringList = new ArrayList<>();

        for (int j = 0; j < k; j++) {
            stringList.add(distance.get(j).getKindType());
        }

        String answer = repetitiveElement(stringList);

        if (answer.equals("=")) {
            distance.sort(Iris.compName);
        }

        if (!answer.equals(iris.getType())) {
            mistake += 1;
        }

        System.out.println("K-NN ANSWER: " + answer);
        System.out.println("CORRECT ANSWER: " + iris.getType());
    }

    public String repetitiveElement(List<String> in) {
        List<String> neighborTypes = new ArrayList<>(in);
        List<String> possibleTypes = new ArrayList<>(getListTypes());

        // Check if the nearest neighbors all have the same type
        boolean sameType = true;
        String firstType = neighborTypes.get(0);
        for (int i = 1; i < neighborTypes.size(); i++) {
            if (!neighborTypes.get(i).equals(firstType)) {
                sameType = false;
                break;
            }
        }
        if (sameType) {
            return firstType;
        }

        // Sort possible types by their frequency in the nearest neighbors list
        Map<String, Integer> typeCounts = new HashMap<>();
        for (String type : neighborTypes) {
            int count = typeCounts.getOrDefault(type, 0);
            typeCounts.put(type, count + 1);
        }
        possibleTypes.sort((t1, t2) -> Integer.compare(typeCounts.get(t2), typeCounts.get(t1))); // sort in descending order of frequency

        // Check if the most common type occurs more frequently than all others
        String mostCommonType = possibleTypes.get(0);
        int maxCount = typeCounts.get(mostCommonType);
        boolean isMax = true;
        for (String type : possibleTypes.subList(1, possibleTypes.size())) {
            int count = typeCounts.get(type);
            if (count >= maxCount) {
                isMax = false;
                break;
            }
        }
        if (isMax) {
            return mostCommonType;
        }

        // If there is a tie, randomly select one of the most common types
        List<String> maxTypes = new ArrayList<>();
        for (String type : neighborTypes) {
            if (type.equals(mostCommonType)) {
                maxTypes.add(type);
            }
        }
        int randomIndex = (int) (Math.random() * maxTypes.size());
        return maxTypes.get(randomIndex);
    }


    public List<String> getTypes(List<Iris> iris) {
        for (Iris type :
                iris) {
            types.add(type.getType());
        }
        return types = types.stream().distinct().collect(Collectors.toList());
    }
    public List<String> getListTypes() {
        return types;
    }
}







