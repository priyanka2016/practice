import java.util.Arrays;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        Arrays.stream(a).filter(value->value>=3).map(value->value*value).forEach(v->System.out.print(v) );
    }
}