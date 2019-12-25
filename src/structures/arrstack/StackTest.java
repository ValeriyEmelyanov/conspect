package structures.arrstack;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(79);
        stack.push(68);
        stack.push(57);
        stack.push(46);

        System.out.println("Top: " + stack.peek());

        System.out.print("Stack: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ", ");
        }
        System.out.println();
    }
}
