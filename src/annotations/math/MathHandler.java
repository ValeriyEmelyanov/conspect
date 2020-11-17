package annotations.math;

public class MathHandler {
    @MathSum(num1 = 10, num2 = 12)
    public void addTwoNumbers(int num1, int num2) {
        System.out.println(num1 + num2);
    }
}
