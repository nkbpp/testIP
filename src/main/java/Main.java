import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IPvalid{
    private static final String IPADDRESS =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    private Pattern p;
    private Matcher m;

    IPvalid() {
        p = Pattern.compile(IPADDRESS);
    }
    public boolean valid(String s){
        m = p.matcher(s);
        return m.matches();
    }
}

public class Main {

    private static final String ERRIP = "Неверный формат IP адреса, повторите ввод!!!";

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String s1,s2;
        boolean b = true;
        do {
            System.out.println("Введите начальный IP: ");
            s1 = in.nextLine();
            IPvalid iPvalid = new IPvalid();
            if(iPvalid.valid(s1)) b = false;
            else {
                System.out.println(ERRIP);
            }
        }while (b);

        do {
            System.out.println("Введите конечный IP: ");
            s2 = in.nextLine();
            IPvalid iPvalid = new IPvalid();
            if(iPvalid.valid(s2)) b = false;
            else {
                System.out.println(ERRIP);
            }
        }while (b);

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
