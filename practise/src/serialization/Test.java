package serialization;

import all.BinaryTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test
{
    public static void main(String[] args)
    {
        try
        {
            BinaryTree binaryTree = new BinaryTree(1);
            binaryTree.postorder(binaryTree.root);
            FileOutputStream fos = new FileOutputStream("student.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(binaryTree);
            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("student.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            BinaryTree si = (BinaryTree)ois.readObject();
            binaryTree.postorder(binaryTree.root);
            System.out.println(si);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}