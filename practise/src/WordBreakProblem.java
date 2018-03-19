import java.util.ArrayList;
import java.util.Scanner;

public class WordBreakProblem {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String s1 = s.next();
        boolean b[]=new boolean[s1.length()+1];
        System.out.println(wordBreak1(s1,b));

    }

    //understand complexity
    private static boolean wordBreak(String s1) {
        if(dictionaryHasWords(s1)){
            return true;
        }

        for(int i=1;i<s1.length();i++){
            if(dictionaryHasWords(s1.substring(0,i))&&wordBreak(s1.substring(i))){
                return true;
            }
        }
        return false;

    }

    private static boolean dictionaryHasWords(String s){
        String[] strings = {"I","am","a","fool","foolish"};
        for(int i=0;i<strings.length;i++){
            if(strings[i].compareTo(s)==0){
                return true;
            }
        }
        return false;
    }

    private static boolean  wordBreak1(String str,boolean wb[])
    {
        int size = str.length();
        if (size == 0)   return true;

        for (int i=1; i<=size; i++)
        {
            // if wb[i] is false, then check if current prefix can make it true.
            // Current prefix is "str.substr(0, i)"
            if (wb[i] == false && dictionaryHasWords( str.substring(0, i) ))
                wb[i] = true;

            // wb[i] is true, then check for all substrings starting from
            // (i+1)th character and store their results.
            if (wb[i] == true)
            {
                // If we reached the last prefix
                if (i == size)
                    return true;

                for (int j = i+1; j <= size; j++)
                {
                    // Update wb[j] if it is false and can be updated
                    // Note the parameter passed to dictionaryContains() is
                    // substring starting from index 'i' and length 'j-i'
                    if (wb[j] == false && dictionaryHasWords( str.substring(i, j)))
                        wb[j] = true;

                    // If we reached the last character
                    if (j == size && wb[j] == true)
                        return true;
                }
            }
        }

    /* Uncomment these lines to print DP table "wb[]"

        cout << " " << wb[i]; */

        // If we have tried all prefixes and none of them worked
        return false;
    }
}
