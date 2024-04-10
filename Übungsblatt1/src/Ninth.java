public class Ninth {
    public static void main(String[] args) {
        System.out.println("> Enter a string to check if it's a palindrome.");
        System.out.print("> ");
        String toBeChecked = new java.util.Scanner(System.in).next();
        if(checkForPalindrome(toBeChecked.toLowerCase()))
        {
            System.out.println("> The String is a palindrome.");
            return;
        }
        System.out.println("> The String is not a palindrome.");
    }

    public static boolean checkForPalindrome(String toBeChecked)
    {
        System.out.println(toBeChecked);
        int length = toBeChecked.length();
        int num = (int)Math.floor(length / 2);

        for(int i = 0; i < num; i++)
        {
            if(toBeChecked.charAt(i) != toBeChecked.charAt(length - (i + 1)))
            {
                return false;
            }
        }

        return true;
    }
}
