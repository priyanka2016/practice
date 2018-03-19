import java.util.*;
import java.util.Stack;

/**
 * Created by priyanka on 6/7/17.
 */
public class LinkedList {

    Node head;

    public static class Node{
        Node next;
        int d;

        public Node(int d) {
            this.d = d;
        }
    }

    public void insert(Node d){
        Node temp =head;
        if(head==null)
        {
            head = d;
        }
        else{
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next=d;
        }
    }

    public void delete(int d){
        Node t=head;
        if(t==null){
            System.out.println("empty");
        }
        else if(t.d==d){
            head = head.next;
        }
        else{
            while(t.next!=null){
                if(t.next.d==d){
                    t.next = t.next.next;
                    break;
                }
                else {
                    t = t.next;
                }
            }
        }
    }

    public void deleteAtPosition(int position){
        Node temp =head;
        if(temp!=null&&position==0){
            head = head.next;
        }
        else{
            Node p =temp;
            while(temp.next!=null && position!=0){
                p = temp;
                temp = temp.next;
                position--;
            }
            if(position==0) {
                p.next = temp.next;
            }
        }
    }

    public void traverse(){
        Node h = head;
        while(h!=null){
            System.out.print(h.d + "->");
            h = h.next;
        }
    }

    public void traverseReverse(Node head){
        if(head==null){
            return;
        }
        traverseReverse(head.next);
        System.out.println(head.d);
    }


    public int length(){
        Node h = head;
        int c =0;
        while(h!=null){
            c++;
            h = h.next;
        }
        return c;
    }

    public int length(Node head){
        Node h = head;
        int c =0;
        while(h!=null){
            c++;
            h = h.next;
        }
        return c;
    }

    public void removeDuplicatesUsingBuffer(){
        int a[] = new int[100];
        Node temp = head;
        if(temp!=null) {
            a[temp.d] = 1;
            while (temp.next != null) {
                if (a[temp.next.d] == 1) {
                    temp.next = temp.next.next;
                } else {
                    a[temp.next.d] = 1;
                    temp = temp.next;
                }
            }
        }
    }

    public void removeDuplicatesWithoutUsingBuffer(){
        Node temp = head;
        if(temp!=null) {
            for (Node i = head; i != null; i = i.next) {
                for (Node j = i; j.next != null; ) {
                        if(i.d==j.next.d){
                            j.next=j.next.next;
                        }
                        else{
                            j=j.next;
                        }
                }
            }
        }
    }

    public int laskKelement(int k){
        int length = length();
        int position = length-k-1;
        Node temp =head;
        if(position<0 || position>=length){
            return -1;
        }
        else {
            while (temp != null && position > 0) {
                temp = temp.next;
                position--;
            }
            return temp.d;
        }

    }

    public Node laskKelementRec(int k,Node head){

        if(k==0){
            return head;
        }

       return laskKelementRec(k-1,head.next);
    }

    public int last(Node head,Node a){
        if(head.next==null){
            return a.d;
        }
        return last(head.next,a.next);
    }
    public int laskKelementUsingRunnig(int k){
        Node a =head,b=head;
        while(k--!=0&&b!=null){
            b =b.next;
        }
        Node prev = head;
        if(b==null){
            return -1;
        }
        while(b.next!=null){
            prev=a;
            a=a.next;
            b=b.next;
        }
        return a.d;
    }

    public static int printKthToLast(int k,Node head){
        if(head==null){
            return-1;
        }

        int index = printKthToLast(k,head.next)+1;
        if(index==k){
            System.out.println(head.d);
        }
        return index;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node node = new Node(1);
        //linkedList.insert(new Node(0));
        linkedList.insert(node);
        linkedList.insert(new Node(6));
        linkedList.insert(new Node(2));

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insert(new Node(2));
       // linkedList2.insert(node);
        linkedList2.insert(new Node(6));
        linkedList2.insert(node);
        System.out.println(node);
        System.out.println(linkedList.loopDetection(linkedList2.head));

    }

    public Node loopDetection(Node h){
        HashSet<Node> nodes = new HashSet<>();

        while(h!=null){
            if(nodes.contains(h)){
                return h;
            }
            nodes.add(h);
            h=h.next;
        }
        return null;
    }

    public boolean intersect(Node head1,Node head2){
        Node temp1 =head1;
        while(temp1!=null){
            Node temp2=head2;
            while(temp2!=null){
                if(temp1==temp2){
                    return true;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return false;
    }

    public boolean intersect1(Node head1,Node head2){
        int length1 =length(head1);
        int length2 =length(head2);
        int net =0;
        Node temp1,temp2;
        if(length1>length2){
            temp1 = head1;
            temp2=head2;
            net = length1-length2;
        }
        else{
            temp1=head2;
            temp2=head1;
            net= length2-length1;
        }
        while(net>0){
            temp1=temp1.next;
            net--;
        }
        while(temp1!=null&&temp2!=null){
            if(temp1==temp2){
                return true;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return false;
    }

    public boolean checkPalindrome(Node head){
       Node slow = head,fast= head;
        java.util.Stack<Integer> stack= new Stack<Integer>();
        while(fast!=null&&fast.next!=null){
            stack.push(slow.d);
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null){
            slow=slow.next;
        }
        while(slow!=null){
            if (slow.d!=stack.pop()){
                return false;
            }
            slow=slow.next;
        }

        if (slow==null){
            return true;
        }
        return false;

    }
    public Node sumReverseList(Node d1,Node d2){
        Node newNode = new Node(0);
        Node head =newNode;

        while(d1!=null&&d2!=null ){
            int d = d1.d+d2.d+newNode.d;
            if(d>9) {
                newNode.d = d % 10;
                newNode.next = new Node(d / 10);
            }
            else{
                newNode.d =d;
                newNode.next=new Node(0);
            }
            newNode=newNode.next;
            d1=d1.next;
            d2=d2.next;
        }
//        while(d1!=null){
//            int d = d1.d+newNode.d;
//            newNode.d = d%10;
//            newNode.next=new Node(d/10);
//            newNode=newNode.next;
//            d1=d1.next;
//        }
//        while(d2!=null){
//            int d = d2.d+newNode.d;
//            newNode.d = d%10;
//            newNode.next=new Node(d/10);
//            newNode=newNode.next;
//            d2=d2.next;
//        }
        System.out.println("in sum");
        while(head!=null){
            System.out.print(head.d + "->");
            head = head.next;
        }
        return head;
    }

    public Node reverse(Node head){
        Node reverse=null;
        while(head !=null){
            Node prev=head;
            head = head.next;
            Node temp = reverse;
            reverse =prev;
            reverse.next = temp;
        }
        return reverse;
    }

    public Node reverseAndClone(Node head){
        Node reverse=null;
        while(head !=null){
            Node n = new Node(head.d);
            n.next = reverse;
            reverse = n;
            head=head.next;
        }
        return reverse;
    }

    public void reverseAndCloneRecur(Node curr,Node prev){
        if(curr.next == null){
            head=curr;
            curr.next=prev;
            return ;
        }
        Node nexr1=curr.next;
        curr.next=prev;
        reverseAndCloneRecur(nexr1,curr);

    }

    public void reverseRecurssivly(Node head,Node r){
        if(head==null){
            return;
        }
        reverseRecurssivly(head.next,r);

        while(r.next!=null){
            r=r.next;
        }
        r.next = new Node(head.d);

    }
    public void sumRecursion(Node d1,Node d2,Node d3){
        if(d1==null || d2 ==null){
            return;
        }
        sumRecursion(d1.next,d2.next,d3);

        int d = d1.d+d2.d+d3.d;
        if(d>9) {
            Node temp=new Node(d % 10);
            temp.next=d3.next;
            d3.next = temp;
            d3.d = d/10;
        }
        else{
            Node temp=new Node(d);
            temp.next=d3.next;
            d3.next = temp;
            d3.d = 0;
        }
    }

    public void sumReverseRecursion(Node d1,Node d2,Node newNode){
        if(d1==null || d2 ==null){

            while (d1!=null){
                int d = d1.d+newNode.d;
                if(d>9) {
                    newNode.d = d % 10;
                    newNode.next = new Node(d / 10);
                }
                else{
                    newNode.d =d;
                    newNode.next=new Node(0);
                }
                d1=d1.next;
                newNode = newNode.next;
            }
            while (d2!=null){
                int d = d2.d+newNode.d;
                if(d>9) {
                    newNode.d = d % 10;
                    newNode.next = new Node(d / 10);
                }
                else{
                    newNode.d =d;
                    newNode.next=new Node(0);
                }
                d2=d2.next;
                newNode = newNode.next;
            }
            return ;
        }
        int d = d1.d+d2.d+newNode.d;
        if(d>9) {
            newNode.d = d % 10;
            newNode.next = new Node(d / 10);
        }
        else{
            newNode.d =d;
            newNode.next=new Node(0);
        }
        sumReverseRecursion(d1.next,d2.next,newNode.next);

    }
    public void delete(Node del){
        if(del==null){
            return;
        }
        Node n = del.next;
        del.d=n.d;
        del.next=n.next;

    }

    public void delete(Node del, Node n){
        if(n!=null && del!=null) {
            if (n == del) {
                head = head.next;
            } else {
                while (n.next != null) {
                    Node prev = n;
                    if (n.next != del) {
                        n = n.next;
                    } else {
                        prev.next = n.next.next;
                    }
                }
            }
        }

    }

    public void partition(int x){
        Node insertHead=null,temp=head;
        while(temp!=null&&temp.d<x){
            insertHead = temp;
            temp=temp.next;
        }
        while(temp!=null&&temp.next!=null){
            if(temp.next.d<x){
                Node n = new Node(temp.next.d);
                if(insertHead!=null){
                    n.next=insertHead.next;
                    insertHead.next=n;
                }
                else{
                    n.next=head;
                    head=n;
                }
                temp.next=temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
    }
}
