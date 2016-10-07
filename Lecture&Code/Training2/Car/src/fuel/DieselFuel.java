package fuel;

/**
 * Created by student on 06.10.2016.
 */
public class DieselFuel extends Fuel {

    @Override
    public double burn(int qty) {
        return qty * 0.6;
    }

    @Override
    public void setQty(int qty) {
        this.qty = qty;
    }
}
