import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Iris {
    static Comparator<Iris> comp = Comparator.comparing(Iris::getDistance);
    static Comparator<Iris> compName = Comparator.comparing(Iris::getKindType);
    private String nr;
    private double[] data;
    private String type;
    private String kindType;
    private double distance;

    public Iris(String nr, double[] data, String type) {
        super();
        this.nr = nr;
        this.data = data;
        this.type = type.replaceAll("\"", "");
    }

    public Iris(double distance, String type, String kindType) {
        super();
        this.distance = distance;
        this.type = type;
        this.kindType = kindType;
    }

    public Iris() {

    }

    public String getKindType() {
        return kindType;
    }

    public double[] getData() {
        return data;
    }


    public void setData(double[] data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "iris " +
                "number=" + nr +
                ", data=" + Arrays.toString(data) +
                ", type=" + type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Iris)) return false;
        Iris iris = (Iris) o;
        return Double.compare(iris.getDistance(), getDistance()) == 0
                && getNr().equals(iris.getNr())
                && Arrays.equals(getData(), iris.getData())
                && getType().equals(iris.getType())
                && getKindType().equals(iris.getKindType());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getNr(), getType(), getKindType(), getDistance());
        result = 31 * result + Arrays.hashCode(getData());
        return result;
    }
}
