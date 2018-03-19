import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserDefinedComparator {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(89);
        integers.add(null);

        integers.add(59);
        integers.add(null);
        integers.add(9);
        print(integers);



        Comparator<Integer> integerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer t2, Integer t1) {
                if(t1==null&&t2==null){
                    return 0;
                }
                if(t2==null){
                    return 1;
                }
                if(t1==null){
                    return -1;
                }
                return t2.compareTo(t1);
            }
        };

        Collections.sort(integers,integerComparator);

        System.out.println("after sorting");
        print(integers);
    }

    private static void print(ArrayList<Integer> integers) {
        for(Integer s : integers){
            System.out.println(s);
        }
    }
}