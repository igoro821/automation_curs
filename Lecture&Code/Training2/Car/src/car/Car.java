package car;

import fuel.Fuel;

/**
 * Created by student on 06.10.2016.
 */
public abstract class Car implements Drive {

    protected Fuel fuel;

    public abstract void fillIn(int qty);
}
