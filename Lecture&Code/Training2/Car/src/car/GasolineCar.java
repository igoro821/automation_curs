package car;

import fuel.GasolineFuel;

/**
 * Created by student on 06.10.2016.
 */
public class GasolineCar extends Car {

    public GasolineCar() {
        fuel = new GasolineFuel();
    }
    
    @Override
    public void fillIn(int qty) {
        fuel.setQty(qty);
    }

    @Override
    public void accelerate() {
        System.out.println(fuel.burn(1));
    }
}
