import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;

public class Test3 {
    public static void main(String[] args) {

        Reader sc = new Reader();
        int t = sc.nextInt();
        Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
        int val,temp;
        int max = 0;
        int count = 0;
        while(t-- > 0){
            val = sc.nextInt();
            if(!map.containsKey(val)){
                map.put(val,0);
            }
            temp = map.get(val);
            map.put(val,temp + 1);

            if(val > max){
                max = val;
            }
            count++;
        }

        int q = sc.nextInt();
        while(q-- > 0){
            val = sc.nextInt();

            if(max == val){
                System.out.println(count);
            }else if (val > max){
                count++;
                map.put(val,1);
                max = val;
                System.out.println(count);
            }else{

                if(map.containsKey(val)){
                    if(map.get(val) ==1){
                        count++;
                        System.out.println(count);
                        map.put(val,2);
                    }else{
                        System.out.println(count);
                    }
                }else{
                    count++;
                    System.out.println(count);
                    map.put(val,1);
                }

            }

        }
        Stack<Integer> stack = new Stack<Integer>();

        //List<Integer> list = new ArrayList<Integer>(map.keySet());
        //Collections.sort(list);

        for(int key:map.keySet()){
            if(map.get(key) == 2){
                stack.push(key);
            }
            System.out.print(key + " ");
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
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
