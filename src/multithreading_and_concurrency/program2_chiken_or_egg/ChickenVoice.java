package multithreading_and_concurrency.program2_chiken_or_egg;

/** Два потока спорят на предмет философского вопроса «что было раньше, яйцо или курица?».
 * Главный поток уверен, что первой была курица, о чем он и будет сообщать каждые посекунды.
 * Второй же поток раз в полсекунды будет опровергать своего оппонента.
 * Победит тот поток, который последним изречет свой ответ.
 * */
public class ChickenVoice {
    public static void main(String[] args) {
        EggVoice anotherOpinion = new EggVoice();
        System.out.println("Спор начат:");
        anotherOpinion.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
            System.out.println("курица!");
        }

        if (anotherOpinion.isAlive()) {
            // Если оппонент еще не сказал последнее слово
            try {
                anotherOpinion.join();
            } catch (InterruptedException e) {}
            System.out.println("Первым появилось яйцо!");
        } else {
            // Если оппонент уже закончил высказываться
            System.out.println("Первой появилась курица!");
        }
        System.out.println("Спор закончен!");
    }
}
