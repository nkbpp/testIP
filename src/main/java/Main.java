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

    IPvalid() {
        p = Pattern.compile(IPADDRESS);
    }
    boolean valid(String s){
        Matcher m = p.matcher(s);
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

        b=true;
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

if((ip1[0]>ip2[0])||((ip1[0]==ip2[0])&&(ip1[1]>ip2[1]))||((ip1[0]==ip2[0])&&(ip1[1]==ip2[1])&&(ip1[2]>ip2[2]))||((ip1[0]==ip2[0])&&(ip1[1]==ip2[1])&&(ip1[2]==ip2[2])&&(ip1[3]>ip2[3]))){
    System.out.println("Предупреждение второй ip меньше первого, программа перескочит через 255.255.255.255!!!");
}

        if(!Arrays.equals(ip1, ip2)){
            ip1 = iterip(ip1);
            if (Arrays.equals(ip1, ip2)){
                System.out.println("Нет промежуточных Ip адресов!!!");
            }else{
                System.out.println("Результат: ");
                while (!Arrays.equals(ip1, ip2)){
                    System.out.println(ip1[0]+"."+ip1[1]+"."+ip1[2]+"."+ip1[3]);
                    ip1 = iterip(ip1);
                }
            }
        }else{
            System.out.println("Значения Ip адресов равны!!!");
        }
    }

    private static short [] iterip(short [] ip){
        for (int i = ip.length-1; i >= 0; i--) {
            ip[i]++;
            if(ip[i]<=255){
                break;
            }else {ip[i]=0;}
        }
        return ip;
    }
}
