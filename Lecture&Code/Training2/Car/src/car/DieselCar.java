package car;

import fuel.DieselFuel;

/**
 * Created by student on 06.10.2016.
 */
public class DieselCar extends Car {

    public DieselCar() {
        fuel = new DieselFuel();
    }

    @Override
    public void fillIn(int qty) {
        fuel.setQty(qty);
    }

    @Override
    public void accelerate() {
        System.out.println(fuel.burn(3));
    }
}
