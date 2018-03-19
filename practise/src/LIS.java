/**
 * Created by priyanka on 3/9/17.
 */
public class LIS {

    public static void main(String[] args) {
        int a[] = {3,2};

        int max =0;

        for(int i=0;i<a.length;i++){
            int count =1;
            for(int j=i+1;j<a.length;j++){
                if(a[j-1]<a[j]){
                    count++;
                }
            }
            if(count>max){
                max =count;
            }
        }
        System.out.println(max);
    }
}
