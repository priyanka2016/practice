

import java.util.*;


class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s1 = new Scanner(System.in);
        int N = s1.nextInt();
        while(N-- != 0){
            int s = s1.nextInt();
            int a[] = new int[s+1];
            for(int i=1;i<=s;i++){
                a[i] = s1.nextInt();
            }
            long weight = getWeight(a,s);
            System.out.println(weight);
        }

    }

    private static long getWeight(int[] a, int s) {
        long weight =0;
        int x[] = new int[100000000];
        int start =1,i=0;
        for(i =1;i<=s;i++){
            if(x[a[i]] == 0){
                x[a[i]] = i;
            }else{
                weight = weight + calculateWeight(i-start);
                start = x[a[i]]+1;
                weight=weight-calculateWeight(i-start);
                for(int k =1;k<10000000;k++){
                    x[k]=0;
                }
                x[a[i]]=i;
            }
        }
        weight =  weight + calculateWeight(i-start);
        return weight;
    }

    private static long calculateWeight(int s) {
        long weight = 0;
        for (int i = 1, j = s; i <= s && j > 0; i++, j--) {
            weight = weight + i * j;
        }
        return weight;
    }
}

