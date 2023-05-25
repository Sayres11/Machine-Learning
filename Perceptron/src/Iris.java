import java.util.Arrays;
import java.util.Objects;

public class Iris {
    private String nr;
    private double[] data;
    private String type;
    private int typeNumber;
    private int kindTypeNumber;

    public Iris(String nr, double[] data, String type) {
        super();
        this.nr = nr;
        this.data = data;
        this.type = type.replaceAll("\"", "");
        switch (this.type) {
            case "setosa" -> typeNumber = 0;
            case "virginica" -> typeNumber = 1;
        }
    }

    public Iris(){

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

    public String getNr() {
        return nr;
    }

    public int getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(int typeNumber) {
        this.typeNumber = typeNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public void setKindTypeNumber(int kindTypeNumber) {
        this.kindTypeNumber = kindTypeNumber;
    }

    public int getKindTypeNumber() {
        return kindTypeNumber;
    }

    @Override
    public String toString() {
        return "iris " +
                "number=" + nr +
                ", data=" + Arrays.toString(data) +
                ", type=" + type + ", Kind Type=" + kindTypeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Iris)) return false;
        Iris iris = (Iris) o;
        return getTypeNumber() == iris.getTypeNumber()
                && getKindTypeNumber() == iris.getKindTypeNumber()
                && getNr().equals(iris.getNr())
                && Arrays.equals(getData(), iris.getData())
                && getType().equals(iris.getType());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getNr(), getType(), getTypeNumber(), getKindTypeNumber());
        result = 31 * result + Arrays.hashCode(getData());
        return result;
    }
}
