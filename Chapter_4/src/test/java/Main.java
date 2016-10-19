import org.testng.annotations.DataProvider;
import parser.JsonParser;
import shop.*;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Cart andrewCart = new Cart("andrew-cart");

        RealItem car = new RealItem();
        car.setName("Audi");
        car.setPrice(32026.9);
        car.setWeight(1560);

        VirtualItem disk = new VirtualItem();
        disk.setName("Windows");
        disk.setPrice(11);
        disk.setSizeOnDisk(20000);

        andrewCart.addRealItem(car);
        andrewCart.addVirtualItem(disk);
        andrewCart.showItems();

        JsonParser parser = new JsonParser();
        parser.writeToFile(andrewCart);

        Cart eugenCart = parser.readFromFile(new File("src/main/resources/eugen-cart.json"));
        eugenCart.showItems();
    }

    @DataProvider(name = "CartDataProvider")
    public static Object [][] cartProivider() {
        Cart vasaCart = new Cart("vasa-cart");
        Cart kolaCart = new Cart("kola-cart");
        Cart anotoleCart = new Cart("anotole-cart");
        Cart timaCart = new Cart("tima-cart");
        Cart romaCart = new Cart("roma-cart");

        RealItem car = new RealItem();
        car.setName("Mersedes");
        car.setPrice(32026.9);
        car.setWeight(1560);

        RealItem bycicle = new RealItem();
        car.setName("Aist");
        car.setPrice(31026.9);
        car.setWeight(15);

        RealItem bycicleMount = new RealItem();
        car.setName("GT");
        car.setPrice(101026);
        car.setWeight(10);

        VirtualItem disk = new VirtualItem();
        disk.setName("Windows");
        disk.setPrice(11);
        disk.setSizeOnDisk(50000);

        VirtualItem diskMac = new VirtualItem();
        disk.setName("Mac");
        disk.setPrice(11);
        disk.setSizeOnDisk(30000);

        vasaCart.addRealItem(car);
        vasaCart.addVirtualItem(disk);

        kolaCart.addRealItem(bycicle);
        kolaCart.addVirtualItem(disk);

        anotoleCart.addRealItem(bycicleMount);
        anotoleCart.addVirtualItem(diskMac);

        timaCart.addRealItem(bycicle);
        timaCart.addVirtualItem(disk);

        romaCart.addRealItem(bycicleMount);
        romaCart.addVirtualItem(diskMac);


        return new Object[][]{
                new Object[] {vasaCart},
                new Object[] {kolaCart},
                new Object[] {anotoleCart},
                new Object[] {timaCart},
                new Object[] {romaCart}

        };
    }
}
