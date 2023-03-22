import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int a, b, r;

        // Чтение строки, преобразование в массив
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] m = s.split(" ");
        if (m.length != 3) {
            System.out.printf("Exception! Expression: '%s' does not correspond to the technical task \n", s);
            System.exit(0);
        }

        Map Rm = new HashMap();
        Rm.put("I", 1);
        Rm.put("II", 2);
        Rm.put("III", 3);
        Rm.put("IV", 4);
        Rm.put("V", 5);
        Rm.put("VI", 6);
        Rm.put("VII", 7);
        Rm.put("VIII", 8);
        Rm.put("IX", 9);
        Rm.put("X", 10);

// try - если арабские числа, catch - все остальное
        try
        {
            a = Integer.parseInt(m[0]);
            b = Integer.parseInt(m[2]);

            if (a > 10 || b > 10 || a < 1 || b < 1) {
                System.out.println("Exception! " + a + " or(and) " + b + "  does not correspond to the technical task");
                System.exit(0);
            }

            r = calculation(a, b, m[1]);
            System.out.println(r);
        }
        catch (NumberFormatException nfe)
        {

            boolean k1 = Rm.containsKey(m[0]);
            boolean k2 = Rm.containsKey(m[2]);

            if (k1 != true || k2 != true) {
                System.out.println("Exception! " + m[0] + " and(or) " + m[2] + " belong to different number systems or does not correspond to the technical task");
                System.exit(0);
            }

            int[] ma = {100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] mb = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            String r2 ="";

            a = (int) Rm.get(m[0]);
            b = (int) Rm.get(m[2]);

            r = calculation(a, b, m[1]);

            if (r < 1) {
                System.out.println("Exception! The result is less than I");
                System.exit(0);
            }

            for (int i=0; i < ma.length; i++) {
                if (r >= ma[i]) {
                    while (r >= ma[i]) {
                        r -= ma[i];
                        r2 += mb[i];
                    }
                }
            }
            System.out.println(r2);

        }
    }

    // Рассчет результата
    public static int calculation(int a, int b, String c) {
        int r = 0;
        switch (c) {
            case "+":
                r = a + b;
                break;

            case "-":
                r = a - b;
                break;

            case "*":
                r = a * b;
                break;

            case "/":
                r = a / b;
                break;

            default:
                System.out.printf("Exception! '%s' is unknown mathematical operator\n", c);
                System.exit(0);
        }
        return r;
    }

}
