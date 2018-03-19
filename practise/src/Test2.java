import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Test2 {

    static class Node{
        List<Integer> nodeList;
        int value;
        Node(int value){
            this.value = value;
            this.nodeList = new ArrayList<Integer>();
        }
    }

    public static void main(String[] args) {

        Reader sc = new Reader();
        int n = sc.nextInt();
        int q = sc.nextInt();
        int val;
        Map<Integer,Node> map = new HashMap<Integer, Node> ();

        int val1;
        for (int i = 0; i < n; i++) {
            val1 = sc.nextInt();
            map.put(i + 1,new Node(val1));
        }
        int u,v;
        for (int i = 1; i <=n-1; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            Node node = map.get(u);
            node.nodeList.add(v);
        }
        int x,t;
        long targetSum;

        while(q-- > 0){
            x = sc.nextInt();
            targetSum = sc.nextLong();

            t = func(map,x,(long)0,targetSum,0,n);

            if (t > n){
                System.out.println("-1");
            }else{
                System.out.println(t);
            }

        }


    }

    private static int func(Map<Integer, Node> map, int u, long currSum, long targetSum,int count,int n) {
        Node node = map.get(u);
        long val = (long)node.value;
        currSum = currSum + val;

        if(currSum >= targetSum){
            return count + 1;
        }
        int min = n + 1;
        int result;

        for(int v:node.nodeList){
            result = func(map,v,currSum,targetSum,count + 1,n);
            if(min  > result){
                min = result;
            }
        }

        return min;
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
