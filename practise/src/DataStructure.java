/**
 * Created by priyanka on 6/7/17.
 */
public class DataStructure {

    public static void main(String[] args) {
        ArrayStack s = new ArrayStack(5);
        s.push(1);
        s.push(7);
        System.out.println(s.top());
        s.push(8);
        s.pop();
        System.out.println(s.top());
        s.pop();s.pop();
        s.pop();
    }
}
