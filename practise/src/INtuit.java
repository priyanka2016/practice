import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class INtuit {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int nodes = s.nextInt();
        int edges = s.nextInt();
        int operations = s.nextInt();
        while(nodes--!=0){
            s.nextInt();
        }
        ArrayList<Component> a = new ArrayList<>();
        int i=1;
        while(edges--!=0){
            Component component = new Component();
            component.setWeight(s.nextInt()|s.nextInt());
            component.setNumber(i);
            i++;
            a.add(component);
        }
        Collections.sort(a);
        for(i=0;i<operations;i++){
            System.out.print(a.get(i).getNumber()+ " ");
        }
    }
}

class Component implements Comparable {

    int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    int number;


    @Override
    public int compareTo(Object o) {
        Integer var1=((Component)o).getWeight();
        Integer var2=this.getWeight();
        return var2.compareTo(var1);
    }
}