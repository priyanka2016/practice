import java.util.Scanner;

public class ThiefAndSack {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t--!=0){
            int n = s.nextInt();
            long a[]= new long[n];int i=0;
            while(n--!=0){
                a[i]=s.nextLong();
                i++;
            }
            System.out.println(findMax1(a));
        }
    }

    private static long findMax1(long[] a) {
        long max =0;

        for(int i=0;i<a.length;i++){
            int j=i+1,k=i-1;
            long m=a[i];
            while (j<a.length){
                if(a[j]>=a[i]){
                    m=m+a[i];
                    j++;
                }
                else{
                    break;
                }
            }
            while(k>=0){
                if(a[k]>=a[i]){
                    m=m+a[i];
                    k--;
                }
                else{
                    break;
                }
            }
            if(m>max){
                max=m;
            }
        }
        return max;
    }

}