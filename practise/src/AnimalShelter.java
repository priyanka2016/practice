import java.util.*;
import java.util.LinkedList;

/**
 * Created by priyanka on 26/7/17.
 */
public class AnimalShelter {

    Queue<Integer> dog;
    Queue<Integer> cat;
    int count;

    public AnimalShelter() {
        this.dog = new LinkedList<>();
        this.cat = new LinkedList<>();
        count=0;
    }

    public void enque(String type){
        count++;
        if(type.equals("dog")){
            dog.add(count);
        }else{
            cat.add(count);
        }
    }

    public int dequeAny(){
        if(dog.peek()>cat.peek()){
            return cat.poll();
        }
        else{
            return dog.poll();
        }
    }
}
