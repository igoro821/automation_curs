package fuel;

/**
 * Created by student on 06.10.2016.
 */
public abstract class Fuel implements BurnFuel {

    protected int qty;

    public abstract void setQty(int qty);
}
