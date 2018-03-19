/**
 * Created by priyanka on 6/7/17.
 */
public class ArrayStack implements Stack {

    private static final int MAX_CAPACITY = 1024;
    private int[] s;
    private int t =-1;
    private int n;

    public ArrayStack() {
        this(MAX_CAPACITY);
    }
    public ArrayStack(int n) {
        this.n =n;
        this.s=new int[n];
    }


    @Override
    public int size() {
        return t++;
    }

    @Override
    public int top() {
        if(isEmpty()){
            throw new StackEmptyException("empty");
        }
        return s[t];

    }

    @Override
    public boolean isEmpty() {
        if(t<0){
            return true;
        }
        return false;
    }

    @Override
    public void push(int k) {

        if(size()==s.length) {
            s[++t] = k;
        }
        else{
            throw new StackFullException("stack full");
        }
    }

    @Override
    public void pop() {
        if(t<0){
            throw new StackEmptyException("empty");
        }
        t--;
    }
}
