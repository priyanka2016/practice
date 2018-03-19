import java.util.*;


public class CandidateCode {

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        String s1= s.next();
//        String a[] = s1.split(",");
//        int[] b = new int[a.length];
//
//        int v[] =convert1(b,a);
//        String n = s.next();
//        String p[] = n.split("#");
//        findIndex(p,v);
        String s="Sachin";
        s.concat(" Tendulkar");//concat() method appends the string at the end
        System.out.println(s);//will print Sachin because strings are immutable objects


    }

    private static void findIndex(String[] p, int[] v) {
        StringBuilder stringBuilder = new StringBuilder();
        int t = totalVolume(v);
        int r = t;
        Map<Long,ArrayList<ArrayList<Integer>>> hash = getMap(v);
        int q = getQuantity(p[0]);
        int i=0;
        while(i<4){
            stringBuilder.append("[");
            if(q<=r) {
                ArrayList<ArrayList<Integer>> integers = hash.get(q);
                if (integers != null) {
                    ArrayList<Integer> f = integers.get(0);
                    print(stringBuilder, f);
                    for (Integer integer : integers.get(0)) {
                        v[integer] = 0;
                    }
                    integers.remove(0);
                    if (integers.size() > 0) {
                        hash.replace((long)q, integers);
                    } else {
                        hash.remove(q);
                    }
                } else {
                    int s = 0;
                    ArrayList<Integer> integers1 = new ArrayList<>();
                    for (int j = 0; j < v.length; j++) {
                        if (v[j] != 0) {
                            s = s + v[j];
                            integers1.add(j);
                        }
                        if (s >= q) {
                            for (Integer f : integers1) {
                                v[f] = 0;
                            }
                            if (s > q) {
                                v[j] = s - q;
                            }
                            break;
                        }
                    }
                    if (s < q) {
                        integers1 = null;
                    }
                    print(stringBuilder, integers1);
                    if (i != 3) {
                        stringBuilder.append(",");
                    }
                    hash=new HashMap<>();

                }
                r = r - q;
                i++;
                if (i < 4) {
                    q = getQuantity(p[i]);
                }
            }else{
                i++;
                if (i < 4) {
                    q = getQuantity(p[i]);
                }
            }
            stringBuilder.append("]");
            if(i!=4) {
                stringBuilder.append(",");

            }
        }
        System.out.println(stringBuilder.toString());
        
    }

    private static void print(StringBuilder stringBuilder, ArrayList<Integer> f) {
        for(int m=0;m<f.size();m++){

                stringBuilder.append(f.get(m));


            if(m!=f.size()-1){
                stringBuilder.append(",");
            }
        }
    }

    private static Map<Long, ArrayList<ArrayList<Integer>>> getMap(int[] v) {
        Map<Long, ArrayList<ArrayList<Integer>>> k = new HashMap<>();
        int i=1;
        while(i<v.length){
            long s=0;
            ArrayList<Integer> index=new ArrayList<>();
            while(i<v.length && v[i]!=0){
                s=s+v[i];
                index.add(i);
                i++;
            }
            if(s!=0) {
                if(k.containsKey(s)){
                    ArrayList<ArrayList<Integer>> arrayLists = k.get(s);
                    arrayLists.add(index);
                    k.replace(s,arrayLists);
                }else {
                    ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
                    arrayLists.add(index);
                    k.put(s, arrayLists);
                }
            }else{
                i++;
            }

        }
        return k;
    }

    private static int getQuantity(String s) {
        String p[]=s.split(":");
        return Integer.valueOf(p[1]);
    }

    private static int totalVolume(int[] v) {
        int t=0;
        for(int i=0;i<v.length;i++){
            t=t+v[i];
        }
        return t;
    }

    private static int[] convert1(int[] b, String[] a) {

        for(int i =0;i<a.length;i++){
            b[i]=Integer.valueOf(a[i]);
        }

        int s[]= calculateVolume(b);
        return s;


    }

    private static int[] calculateVolume(int[] b) {

        int a[]= new int[b.length];
        for(int i=0;i<b.length-1;i++){
            int j=0;
            int lh=0;
            while(j<i){
                if(lh<b[j]){
                    lh=b[j];
                }
                j++;
            }
            int rh=0;
            j++;
            while(j<b.length){
                if(rh<b[j]){
                    rh=b[j];
                }
                j++;
            }
            int small = rh>lh?lh:rh;
            if(small>b[i]) {
                a[i] = small - b[i];
            }
        }
       return a;

    }
}