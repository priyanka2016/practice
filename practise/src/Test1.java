import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1 {
    static int maximum = 0;
    public static void main(String[] args) {

        Reader sc = new Reader();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        func(arr,k);
        if(maximum == 0){
            System.out.println("-1");
        }else{
            System.out.println(maximum);
        }


    }

    private static void func(int[] arr,int k) {

        for(int root = 0; root < arr.length ; root ++ ){
            func1(arr,root,k,0,root);
        }
    }

    private static void func1(int[] arr, int start, int k,int count,int root) {

        if(count == k){
            maximum = Math.max(arr[start] - arr[root],maximum);
            return;
        }
        int pivot = arr[start];
        for (int i = start + 1; i < arr.length; i++) {
            if(arr[i] > pivot){
                func1(arr,i,k,count+1,root);
            }
        }

    }

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        public Reader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

}
