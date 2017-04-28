import java.util.Scanner;

public class No2 {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(),i,temp;
        temp=n;
        for(i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                while(n%i==0) n=n/i;
                temp=temp/i*(i-1);
            }
            if(n<i+1)
                break;
        }
        if(n>1)
            temp=temp/n*(n-1);
        System.out.print(temp);
    }
}
