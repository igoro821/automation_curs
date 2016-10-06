import java.util.Scanner;

/**
 * Created by tarasenko on 05.10.2016.
 */
public class Main {

    public static void main (String args[]){

        boolean isExit;
        int tvChanel = 0;
        String [] program = {"cnn", "mdc", "rrr", "ddd", "sss", "fff", "sss", "ffff", "qqq", "eee", "vvv", "sss", "aaa", "ddd"};
        do {
            System.out.println("Enter TV Chanel(from 0 to 13) or enter \"exit\" for exit");
            Scanner scaner = new Scanner(System.in);
            String value =  scaner.nextLine();
            isExit = "exit".equalsIgnoreCase(value);
            if (isExit){
                continue;
            }
            try {
                tvChanel = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.err.println("Incorrect data - String Type");
                continue;
            }
            if (tvChanel <= 13 && tvChanel >=0){
                for (int i = 0; i <= program.length; i++) {
                    if (i == tvChanel) {
                        System.out.println("For button " + i + " " + program[i]);
                        continue;
                    }
                }
            } else {
                System.out.println("incorrect data try one more time");
                continue;
            }

        } while (!isExit);
    }
}