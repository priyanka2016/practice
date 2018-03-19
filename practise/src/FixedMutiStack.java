/**
 * Created by priyanka on 23/7/17.
 */
public class FixedMutiStack {

    public int numberOfStacks=3;
    int value[];
    int size[];
    int stackCapacity;

    public FixedMutiStack(int stackCapacity) {
        this.stackCapacity = stackCapacity;
        size = new int[numberOfStacks];
        value = new int[stackCapacity*numberOfStacks];
    }

    public void push(int stackNum,int data){

        if(isFull(stackNum)){
            System.out.println("full" +stackNum+ " "+data);
        }
        else {
            value[index(stackNum)] = data;
            size[stackNum]++;
        }
    }

    public void pop(int stackNum){
        if(isEmpty(stackNum)){
            System.out.println("empty");
        }
        size[stackNum]--;
    }

    public int top(int stackNum){
        if(isEmpty(stackNum)){
            System.out.println("empty");
            return -1;
        }
        int index = index(stackNum);
        return value[index-1];
    }

    private boolean isEmpty(int stackNum) {
        if(size[stackNum]==0){
            return true;
        }
        return false;
    }

    public int index(int stackNum){
        return stackNum*stackCapacity+size[stackNum];
    }
    private boolean isFull(int stackNum) {
        if(size[stackNum]==stackCapacity){
            return true;
        }
        return false;
    }
}
