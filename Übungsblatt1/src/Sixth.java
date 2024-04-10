public class Sixth {
    public static void main(String[] args) {
        
        try
        {
            int first = Integer.parseInt(args[0]);
            int second = Integer.parseInt(args[1]);
            int third = Integer.parseInt(args[2]);

            int lower = Math.min(first, second);
            int evenLower = Math.min(lower, third);

            int higher = Math.max(first, second);
            int evenHigher = Math.max(higher, third);

            int check = Math.min(first, third);
            int middle = Math.max(lower, check);

            System.out.printf("> %d %d %d", evenLower, middle, evenHigher);

        } 
        catch (NumberFormatException nfe)                           //nfe - NumberFormatException
        {
            System.out.printf("%s %s %s ", args[0], args[1], args[2]);
            System.out.println("Are not entirely integers");
        }
    }
}
