import java.util.Scanner;

public class MaxPower {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- != 0) {
            int n = s.nextInt();
            int a []= new int[n];
            int min1=s.nextInt(),max1=min1,minIndex=0,maxIndex=0;
            a[0]=min1;

            for(int i=1;i<n;i++){
                int k = s.nextInt();
                a[i]=k;
                if(k<min1){
                    min1=k;
                    minIndex=i;
                }
                if(k>max1){
                    max1=k;
                    maxIndex=i;
                }
            }
            int maxValue = max1-min1;

            if(a.length>2&&maxIndex==0&&minIndex==n-1){
                int max2=findMax(a);
                int min2 = findMin(a);
                maxValue=max2-min1>max1-min2?max2-min1:max1-min2;
            }
            System.out.println(Math.abs(maxValue));
        }
    }

    private static int findMin(int[] a) {
        int min = a[a.length-2];
        for(int i =a.length-3;i>0;i--){
            if(a[i]<min){
                min=a[i];
            }
        }
        return min;

    }

    private static int findMax(int[] a) {
        int max=a[1];
        for(int i =1;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
        }
        return max;
    }
}