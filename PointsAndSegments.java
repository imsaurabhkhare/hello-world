import java.util.Scanner;
import java.util.*;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        
        List<Define> sta=new ArrayList<Define>();
        for(int i=0;i<starts.length;i++){
           sta.add(new Define(starts[i],'L',i));
     }
 
        for(int i=0;i<points.length;i++){
           sta.add(new Define(points[i],'P',i));      
     }
        for(int i=0;i<ends.length;i++){
           sta.add(new Define(ends[i],'R',i));       
     }
      Collections.sort(sta);
      int segment=0;
      int j=0;
          for(int i=0;i<sta.size();i++){
         if(sta.get(i).getabc()=='L')
            segment+=1;
          else if(sta.get(i).getabc()=='R')
            segment-=1;
          else{
              cnt[sta.get(i).getindex()]=segment;
              j++;
         }
}
        
       
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}
class Define implements Comparable<Define>{
int number;
char abc;
int index;
Define(int number,char abc,int index){
this.number=number;
this.abc=abc;
this.index=index;
}
public int getNumber(){
return number;
}
public char getabc(){
return abc;
}
public int getindex(){
return index;
}
@Override
public int compareTo(Define ac){
int compareage=((Define)ac).getNumber();
return this.number-compareage;
}
}

