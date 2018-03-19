package all;

import all.BinaryTree;

/**
 * Created by priyanka on 26/8/17.
 */
public class Queue1 {

    BinaryTree.Node node[];
    int front,tail;

    public Queue1() {
        node = new BinaryTree.Node[500];
        front=-1;
        tail=0;
    }

    public void enque(BinaryTree.Node n){
        if(tail==500){
            System.out.println("full");
        }
        else {
            node[tail] = n;
            tail++;
        }
    }

    public BinaryTree.Node deque(){
        front++;
        if(front<tail) {
            return node[front];
        }
        return null;
    }
}
