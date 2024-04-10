public class First {
    public static void main(String[] args){
        System.out.println("Enter two string that you want to be add together.");
        System.out.print("1. > ");
        String first = new java.util.Scanner(System.in).next();

        System.out.print("2. > ");
        String second = new java.util.Scanner(System.in).next();

        String whole = first + " " + second;
        System.out.printf("Result > %s", whole);
    }
}
