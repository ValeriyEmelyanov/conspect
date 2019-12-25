package structures.arrstack;

public class Stack {
    private int size; // Максимальный размер стека
    private int[] stackArray; // Массив для хранения элементов стека
    private int top; // Вершина стека

    public Stack(int size) {
        this.size = size;
        stackArray = new int[size];
        top = -1;
    }

    // Добавление элемента (в top позиции)
    public void push(int element) {
        stackArray[++top] = element;
    }

    // Удаление элемента (с top позиции)
    public int pop() {
        return stackArray[top--];
    }

    // Чтение верхушки стека - вернет значение элемента, который находится в позиции top
    public int peek() {
        return stackArray[top];
    }

    // Проверять стек на пустоту
    public boolean isEmpty() {
        return top == -1;
    }

    // Проверяет, что стек полный
    public boolean isFull() {
        return top == size - 1;
    }
}
