package serialization;

public class Dudes {
    static long flag =0;
     void chat(long id){
        if(flag==0){
            flag=id;
        }
        for(int x=1;x<3;x++){
            if(flag==id)
                System.out.println("yo ");
            else
                System.out.println("dude ");
        }
    }
}