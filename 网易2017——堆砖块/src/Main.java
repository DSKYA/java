import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashSet;
class tnoed{
    int height;
    int leftn,rightn;
    int sum;
    public tnoed(int a,int b,int c,int d){
        height = a;
        leftn = b;
        rightn = c;
        sum = d;
    }
}

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Scanner in = new Scanner(System.in);
        LinkedList<tnoed> stack = new LinkedList<tnoed>();
        HashSet<tnoed> ishas = new HashSet<tnoed>();
        int n = in.nextInt();
        int tmpsum = 0;
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = in.nextInt();
            tmpsum += list[i];
        }
        int max = -1;

        stack.addLast(new tnoed(1,list[0],0,tmpsum - list[0]));
        stack.addLast(new tnoed(1,0,0,tmpsum - list[0]));
        ishas.add(new tnoed(1,list[0],0,tmpsum - list[0]));
        ishas.add(new tnoed(1,0,0,tmpsum - list[0]));
        while(!stack.isEmpty()){
            tnoed tt = stack.pollFirst();
            ishas.remove(tt);
            if(tt.height < n){
                if(Math.abs(tt.leftn - tt.rightn) <= tt.sum){
                    if(tt.rightn == 0 && tt.leftn == 0){
                        stack.addLast(new tnoed(tt.height + 1,list[tt.height],0,tt.sum - list[tt.height]));
                        stack.addLast(new tnoed(tt.height + 1,0,0,tt.sum - list[tt.height]));
                    }
                    else{
                        int tmpa = tt.leftn;
                        int tmpb = tt.rightn;
                        int tmpin = list[tt.height];
                        tnoed l = new tnoed(tt.height + 1,tmpa + tmpin,tmpb,tt.sum - tmpin);
                        if(tmpa + tmpin == tmpb && tmpb >= max)
                        {
                            max = tmpb;

                            if(!ishas.contains(l)){
                                if(Math.abs(tmpa + tmpin - tmpb) <= tt.sum - tmpin)stack.addLast(l);
                                ishas.add(l);
                            }


                        }
                        else if(!ishas.contains(l) && Math.abs(tmpa + tmpin - tmpb) <= tt.sum - tmpin){
                            stack.addLast(l);
                            ishas.add(l);
                        }
                        l = new tnoed(tt.height + 1,tmpa,tmpb + tmpin,tt.sum - tmpin);
                        if(tmpb + tmpin == tmpa && tmpa >= max){
                            max = tmpa;
                            if(!ishas.contains(l)){
                                if(Math.abs(tmpb + tmpin - tmpa) <= tt.sum - tmpin)stack.addLast(l);
                                ishas.add(l);
                            }

                        }
                        else if(!ishas.contains(l) && Math.abs(tmpb + tmpin - tmpa) <= tt.sum - tmpin){
                            stack.addLast(l);
                            ishas.add(l);
                        }
                        if(Math.abs(tmpb - tmpa) <= tt.sum - tmpin)stack.addLast(new tnoed(tt.height + 1,tmpa,tmpb,tt.sum - tmpin));
                    }
                }

            }
        }
        System.out.print(max);
    }
}
