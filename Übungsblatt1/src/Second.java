public class Second {
    public static void main(String[] args) {
        System.out.println("Enter two doubles that you want to add together.");
        System.out.print("1. > ");
        double first = new java.util.Scanner(System.in).nextDouble();

        System.out.print("2. > ");
        double second = new java.util.Scanner(System.in).nextDouble();

        double result = first + second;
        System.out.printf("Result > %.2f", result);
    }
}
