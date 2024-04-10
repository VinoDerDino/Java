package SortingAlgorithms;

public class Bubblesort {
    public static void main(String[] args) throws Exception {
        if(!executable(args))
        {
            return;
        }
        double[] nums = new double[args.length];
        for(int i = 0; i < args.length; i++)
        {
            nums[i] = Double.parseDouble(args[i]);
        }

        while(!isSorted(nums))
        {
            //printArray(nums);
            for(int i = 0; i < nums.length - 1; i++)
            {
                if(!checkTwoNums(nums[i], nums[i + 1]))
                {
                    double a = nums[i];
                    nums[i]= nums[i + 1];
                    nums[i + 1] = a;
                }
            }
        }
        System.out.println("> Sorted array");
        System.out.print("> ");
        printArray(nums);
    }

    public static boolean executable(String[] args)
    {
        if(args.length == 0)
        {
            System.out.println("> No arguemnts were entered into the console when exectuing this program.");
            System.out.println("> Program terminated <");
            return false;
        }
        for(int i = 0; i < args.length; i++)
        {
            try{
                double num = Double.parseDouble(args[i]);
            }
            catch(NumberFormatException nfe)
            {
                System.out.printf("> Argument %d cannot be parsed to a double.\n", i);
                System.out.println("> Program terminated <");
                return false;
            }
        }
        return true;
    }

    public static boolean checkTwoNums(double a, double b)
    {
        if(a == b || a < b)
        {
            return true;
        }
        return false;
    }

    public static boolean isSorted(double[] nums)
    {
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i] > nums[i + 1])
            {
                return false;
            }
        }
        return true;
    }

    public static void printArray(double[] nums)
    {
        for(int i = 0; i < nums.length; i++)
        {
            System.out.printf("%.2f ", nums[i]);
        }
        System.out.println("");
    }

    public static double[] bubble(double[] nums)
    {
        while(!isSorted(nums))
        {
            //printArray(nums);
            for(int i = 0; i < nums.length - 1; i++)
            {
                if(!checkTwoNums(nums[i], nums[i + 1]))
                {
                    double a = nums[i];
                    nums[i]= nums[i + 1];
                    nums[i + 1] = a;
                }
            }
        }
        return nums;
    }
}
