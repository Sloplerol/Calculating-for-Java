package Quiz;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double height = scanner.nextDouble();
        double weight = scanner.nextDouble();
        double normalWeight = (height - 100) * 0.9;
        double BMI = weight / (height * height);
        System.out.printf("%.3f %.3f %.1f", weight, normalWeight, BMI); // Use floating-point division

    }


}
