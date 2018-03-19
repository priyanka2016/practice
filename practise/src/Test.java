import java.util.*;
public class Test  {
    Integer id = 1;
    public static void main(String[] args) {
        Test test = new Test();
        test.method(1,2);
    }
//    int method(int i, int d)
//    {
//        return i+d;
//    }

    static int method(int i, double d)
    {
        return (int)(i+d);
    }
//
//    double method(double i, int d)
//    {
//        return i+d;
//    }
//
    static double method(double i, double d)
    {
        
        return i+d;
    }
//    static double method(float i, int d)
//    {
//        return i+d;
//    }
}