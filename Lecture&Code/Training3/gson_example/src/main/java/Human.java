/**
 * Created by student on 11.10.2016.
 */
public class Human {

    private String name;
    private int age;
    private double weight;
    private double height;
    private double kmt;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setKmt() {
        kmt = weight /(height*height);
    }
}
