
public class CheckIdenticalBST
	{
        	    private boolean checkIfSameBSTs(int[] arrayForTree1, int[] arrayForTree2, int index1, int index2, int min, int max)
        	    {

        	        int i,j;
        	        for (i = index1; i < arrayForTree1.length; i++)
        	        {
        	            if ((min < arrayForTree1[i]) && (arrayForTree1[i] < max))
        	            {
        	                break;
        	            }
        	        }

        	        for (j = index2; j < arrayForTree2.length; j++)
        	        {
        	            if ((min < arrayForTree2[j]) && (arrayForTree2[j] < max))
        	            {
        	                break;
        	            }
        	        }


        	        if ((i == arrayForTree1.length) && (j == arrayForTree2.length))
        	        {
        	            return true;
        	        }

        	        if ((i == arrayForTree1.length) || (j == arrayForTree2.length))
        	        {
        	            return false;
        	        }


        	        if (arrayForTree1[i] == arrayForTree2[j])
        	        {
        	            return (checkIfSameBSTs(arrayForTree1, arrayForTree2, i+1, j+1, min, arrayForTree1[i]) &&
        	                    checkIfSameBSTs(arrayForTree1, arrayForTree2, i+1, j+1, arrayForTree1[i], max));
        	        }

        	        return false;
        	    }

        	    public boolean checkIfSameBSTs(int[] arrayForTree1, int[] arrayForTree2)
        	    {
        	        return checkIfSameBSTs(arrayForTree1, arrayForTree2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        	    }

        	    public static void main(String[] args)
        	    {
        	        CheckIdenticalBST solution = new CheckIdenticalBST();

        	        int[] arrayForTree1 = {3,5,4,6,1,0,2};

        	        int[] arrayForTree2 = {3,1,5,2,4,6,0};

        	        System.out.println("Check if identical BSTs: "  + solution.checkIfSameBSTs(arrayForTree1, arrayForTree2));
        	    }
        	}