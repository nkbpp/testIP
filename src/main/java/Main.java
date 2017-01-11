import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите начальный IP: ");
        String s1 = in.nextLine();
        System.out.println("Введите конечный IP: ");
        String s2 = in.nextLine();
        short ip1[] = new short[4];
        short ip2[] = new short[4];
        String s[] = s1.split("\\.");
        for (int i = 0; i < s.length; i++) {
            ip1[i] = Short.parseShort(s[i]);
        }
        String s3[] = s2.split("\\.");
        for (int i = 0; i < s3.length; i++) {
            ip2[i] = Short.parseShort(s3[i]);
        }

        //short ip1[] = {255,255,255,1};
        //short ip2[] = {0,0,0,5};

        do{
            System.out.println(ip1[0]+"."+ip1[1]+"."+ip1[2]+"."+ip1[3]);
            ip1[3]++;
            if(ip1[3]>255){
                ip1[3]=0;
                ip1[2]++;
                if (ip1[2]>255){
                    ip1[2]=0;
                    ip1[1]++;
                    if (ip1[1]>255){
                        ip1[1]=0;
                        ip1[0]++;
                        if(ip1[0]>255)ip1[0]=0;
                    }
                }
            }
        }while (!Arrays.equals(ip1, ip2));
    }
}
