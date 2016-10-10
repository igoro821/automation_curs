/**
 * Created by tarasenko on 10.10.16.
 */
public class Main {
    public static void main (String [] args){
        VerticalLoad oka = new VerticalLoad();
        HorizontalLoading lg = new HorizontalLoading();
        DishWasher panasonic = new DishWasherHouse();

        WashingMachine [] washers = new WashingMachine[] {oka, lg, panasonic};

        for (WashingMachine i : washers){
            i.breakMachine();
            i.wash();
//            panasonic.washingPlusDrying();
//            panasonic.drying();
//            lg.washingPlusDrying();
//            lg.drying();
            i.washingPlusDrying();
            i.drying();
//            lg.washClothes();
//            oka.washClothes();
            i.washClothes();
//            panasonic.washDishes();
            i.washDishes();
            }
        }




    }
