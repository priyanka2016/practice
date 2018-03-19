import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by priyanka on 19/6/17.
 */
public class Sorting  {




    public static void main(String[] args) throws InterruptedException {
        int a[] = {6,5,4,3,2,1};
        Sorting sorting = new Sorting();
        sorting.mergeSort(a,0,a.length-1);
        sorting.print(a);

    }


    public void bubbleSort(int a[]){
        for (int i=0;i<a.length-1;i++){
            boolean swap = false;
            for(int j=0;j<a.length-i-1;j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swap = true;
                }
            }
            print(a);
            System.out.println("\n");
            if(!swap){
                break;
            }
        }
    }

    public void insertionSort(int a[]){
        //Collections.sort();

        for(int i = 0;i<a.length-1;i++){
            for(int j=i;j>=0;j--){
                boolean swap  = false;
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swap = true;
                }
                if(!swap){
                    break;
                }
            }
            print(a);
            System.out.println("\n");
        }
    }

    public void selectionSort(int a[]){

        for(int i=0;i<a.length;i++){
            int min = i;
            for(int j=i+1;j<a.length;j++){
                if(a[min]>a[j]){
                    min = j;
                }
            }
            if(min ==i){
                break;
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
            print(a);
            System.out.println("\n");
        }
    }

    public void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(" " + a[i]);
        }
    }

    public void mergeSort(int a[],int l,int r){

        if(l<r){
            int m = (l+r)/2;
            mergeSort(a,l,m);
            mergeSort(a,m+1,r);
            merge(a,l,m,r);
        }
    }

    private void merge(int[] a, int l, int m, int r) {
        int left[] = new int[m-l+1];
        int right[]= new int[r-m];
        int i=0,j=0;
        for(int k=l;k<=m;k++,i++){
            left[i]=a[k];
        }
        for(int k = m+1;k<=r;k++,j++){
            right[j]=a[k];
        }
         i=0;j=0;int k=l;
        while(i<left.length&&j<right.length){
            if(left[i]<right[j]){
                a[k]=left[i];
                i++;
            }else{
                a[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<left.length){
            a[k]=left[i];
            i++;k++;
        }

    }

    public int[] mergeSort(int a[]){

        if(a.length==1){
            return a;
        }
        int l1[] = new int[a.length/2];
        int l2[] =new int[a.length-a.length/2];
        for(int i=0;i<a.length/2;i++){
            l1[i] = a[i];
        }
        for(int i =0;i<l2.length;i++){
            l2[i] = a[a.length/2+i];
        }

        l1 = mergeSort(l1);
        l2 = mergeSort(l2);

        return merge(l1,l2);
    }

    private int[] merge(int[] l1, int[] l2) {

        int l3[] = new int[l1.length+l2.length];
        int i=0,j=0,k=0;
        while(i<l1.length && j<l2.length){
            if(l1[i]<=l2[j]){
                l3[k] = l1[i];
                i++;
                k++;
            }
            else{
                l3[k] = l2[j];
                k++;
                j++;
            }
        }

        while(i<l1.length){
            l3[k] = l1[i];
            i++;
            k++;
        }

        while(j<l2.length){
            l3[k] = l2[j];
            j++;
            k++;
        }
        return l3;
    }

    public void quickSort(int[] a,int left,int right){
        if(right-left <=0){
            return;
        }
        int partition = partitionFunc(a,left,right);
        print(a);
        System.out.println("\n");
        quickSort(a,left,partition-1);
        quickSort(a,partition+1,right);

    }

    private int partitionFunc(int[] a, int left1, int right1){
        int pivot = a[right1];
        int left = left1 -1;
        int right = right1;

        while (true){
            while(a[++left]<pivot){

            }
            while (right>0&&a[--right]>pivot){

            }

            if(left<right){
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
            else {
                break;
            }
        }
        int temp = a[left];
        a[left] =a[right1];
        a[right1]= temp;

        return left;


    }

}
