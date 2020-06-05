package patterns.behavioral_patterns.strategy_min_max;

public class FindMax implements FindingStrategy {

    @Override
    public int find(int[] numbers) {
        int result = Integer.MIN_VALUE;
        for (int num : numbers) {
            result = Math.max(num, result);
        }
        return result;
    }

}
