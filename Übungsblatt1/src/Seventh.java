public class Seventh {
    public static void main(String[] args) {
        
        try
        {
            int length = args.length;
            int[] array = new int[length];

            for(int i = 0; i < length; i++)
            {
                array[i] = Integer.parseInt(args[i]);   
            }

            ascendingSequence(length, array);
            descendingSequence(length, array);
 
        } 
        catch (NumberFormatException nfe)                           //nfe - NumberFormatException
        {
            System.out.println("> Error, not every number is an integer.");
        }

    }

    public static void ascendingSequence(int length, int[] array)
    {
        for(int i = 0; i < length - 1; i++)
        {
            if(Math.min(array[i], array[i + 1]) == array[i + 1])
            {
                System.out.println("> Numbers are not in ascending sequence.");
                return;
            }      
        }

        System.out.println("> Numbers are in ascending order.");  
    }

    public static void descendingSequence(int length, int[] array)
    {
        for(int i = 0; i < length - 1; i++)
        {
            if(Math.min(array[i], array[i + 1]) == array[i])
            {
                System.out.println("> Numbers are not in descending sequence.");
                return;
            }      
        }

        System.out.println("> Numbers are in descending order.");
    }
}
