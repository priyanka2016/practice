import java.util.ArrayList;

public class CheckIdenticalBSTs {
    boolean checkIfSameBSTs(ArrayList<Integer> listForTree1, ArrayList<Integer> listForTree2)
    {
        if (listForTree1.size() != listForTree2.size())
        {
            return false;
        }

        if (listForTree1.size() == 0)
        {
            return true;
        }

        if (listForTree1.get(0) == listForTree2.get(0))
        {
            ArrayList<Integer> listForLeftTree1 = new ArrayList();
            ArrayList<Integer> listForRightTree1 = new ArrayList();

            ArrayList<Integer> listForLeftTree2 = new ArrayList();
            ArrayList<Integer> listForRightTree2 = new ArrayList();

            for (int i = 1; i < listForTree1.size(); i++)
            {
                if (listForTree1.get(i) < listForTree1.get(0))
                {
                    listForLeftTree1.add(listForTree1.get(i));
                }
                else
                {
                    listForRightTree1.add(listForTree1.get(i));
                }

                if (listForTree2.get(i) < listForTree2.get(0))
                {
                    listForLeftTree2.add(listForTree2.get(i));
                }
                else
                {
                    listForRightTree2.add(listForTree2.get(i));
                }
            }

            return checkIfSameBSTs(listForLeftTree1, listForLeftTree2) &&
                    checkIfSameBSTs(listForRightTree1, listForRightTree2);
        }

        return false;
    }

    boolean checkIfSameBSTs(int[] arrayForTree1, int[] arrayForTree2)
    {
        if (arrayForTree1.length != arrayForTree2.length)
        {
            return false;
        }

        ArrayList<Integer> listForTree1 = new ArrayList();
        ArrayList<Integer> listForTree2 = new ArrayList();

        for (int i = 0; i < arrayForTree1.length; i++)
        {
            listForTree1.add(arrayForTree1[i]);
            listForTree2.add(arrayForTree2[i]);
        }
        return checkIfSameBSTs(listForTree1, listForTree2);
    }

    public static void main(String[] args)
    {
        CheckIdenticalBSTs solution = new CheckIdenticalBSTs();

        int[] arrayForTree1 = {3,5,4,6,1,0,2};

        int[] arrayForTree2 = {3,1,5,2,4,6,0};

        System.out.println("Check if identical BSTs: " + solution.checkIfSameBSTs(arrayForTree1, arrayForTree2));
    }
}