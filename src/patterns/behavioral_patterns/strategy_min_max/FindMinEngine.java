package patterns.behavioral_patterns.strategy_min_max;

public class FindMinEngine implements FindingStrategy {

    @Override
    public int find(int[] numbers) {
        int result = Integer.MAX_VALUE;
        for (int num : numbers) {
            result = Math.min(num, result);
        }
        return result;
    }

}
