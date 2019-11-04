package multithreading_and_concurrency.program3;
/** Incremenator — поток, который каждую секунду прибавляет или вычитает единицу
 * из значения статической переменной Program.value. Incremenator содержит закрытое поле – isIncrement.
 * То, какое действие выполняется, определяется булевой переменной isIncrement — если оно равно true,
 * то выполняется прибавление единицы, иначе — вычитание.
 * А завершение потока происходит по прерыванию потока.
 * */
public class Program {
    public static int value = 0;

    public static void main(String[] args) {
        Incremenator inc = new Incremenator();
        System.out.print("Значение = ");
        inc.start();

        // Троекратное изменение операции инкременатора с интервалом в i*2 секунд
        for (int i = 1; i <= 3 ; i++) {
            try {
                Thread.sleep(i * 2 * 1000);
            } catch (InterruptedException e) {}
            inc.changeAction();
        }

        // Прервать поток инкременатора
        inc.interrupt();
    }
}
