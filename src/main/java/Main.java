import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите начальный IP: ");
        String s1 = in.nextLine();
        System.out.println("Введите конечный IP: ");
        String s2 = in.nextLine();
        int ip1[] = new int[4];
        int ip2[] = new int[4];
        String s[] = s1.split("\\.");
        for (int i = 0; i < s.length; i++) {
            ip1[i] = Integer.parseInt(s[i]);
        }
        s = s2.split("\\.");
        for (int i = 0; i < s.length; i++) {
            ip2[i] = Integer.parseInt(s[i]);
        }
//        for (int i:
//             ip2) {
//            System.out.println(String.valueOf(i));
//        }
    }
}
