public class Fourth {
    public static void main(String[] args) {

        try
        {
            int first = Integer.parseInt(args[0]);
            int second = Integer.parseInt(args[1]);
            int third = Integer.parseInt(args[2]);

            if(first == second && first == third)
            {
                System.out.println("equal");
            } 
            else 
            {
                System.out.println("not equal");
            }
 
        } 
        catch (NumberFormatException nfe)                           //nfe - NumberFormatException
        {
            System.out.printf("%s %s %s ", args[0], args[1], args[2]);
            System.out.println("Are not entirely integers");
        }

    }
}
