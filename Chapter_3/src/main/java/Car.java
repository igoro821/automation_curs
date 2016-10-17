/**
 * Created by tarasenko on 17.10.16.
 */
public class Car {

    public String type;
    public String mark;
    public int cost;

    Car (String type,String mark,int cost){
        this.type = type;
        this.mark = mark;
        this.cost = cost;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
