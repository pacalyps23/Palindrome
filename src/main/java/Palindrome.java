/**
 * Created by paco on 5/23/17.
 */
public class Palindrome
{
    private static int count = 0;

    private int [] numArraySwap;

    public int [] repeatSwapPalindrome(String [] arr)
    {
        numArraySwap = new int[arr.length];

        for(int i = 0; i < arr.length; i++)
        {
            count = 0;
            char [] charList = arr[i].toCharArray();
            int num = contSwapsToPalindrome(charList);
            numArraySwap[i] = num;
        }
        return numArraySwap;
    }

    public int contSwapsToPalindrome(char [] arr)
    {
        int sizeHalf = arr.length/2;
        int size = arr.length;
        while(!isPalindrome(arr))
        {
            for(int i = 0; i < sizeHalf; i++)
            {
                if(arr[i] < arr[size-i-1])
                {
                    char newChar = arr[size-i-1];
                    newChar = (char)(newChar-1);
                    arr[size-i-1] = newChar;
                    count++;
                }
                else if(arr[i] > arr[size-i-1])
                {
                    char newChar = arr[i];
                    newChar = (char)(newChar-1);
                    arr[i] = newChar;
                    count++;
                }
            }
        }
        for(int j = 0; j < size; j++)
            System.out.print(arr[j]);
        System.out.println();
        return count;
    }



    public boolean isPalindrome(char [] arr)
    {
        boolean result = true;
        int size = arr.length/2;
        for(int i = 0; i < size; i++)
        {
            if(arr[i] != arr[arr.length-i-1])
            {
                result = false;
            }
        }
        return result;
    }


    public static void main(String[] args)
    {
        Palindrome check = new Palindrome();
        String a = "abcdgesa";
        String b = "abcdefg";
        String c = "dknssadafaafa";
        String []  stringList = {a, b, c};
        int [] results = check.repeatSwapPalindrome(stringList);
        for(int i = 0; i < results.length; i++)
        {
            System.out.println(results[i]);
        }

    }

}
