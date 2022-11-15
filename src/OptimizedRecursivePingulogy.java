import java.util.ArrayList;

public class OptimizedRecursivePingulogy {

    ArrayList<Long> numbers = new ArrayList<>();

    public void pinguSequenceRec(int n, long p0, long p1, long p2) {
        if (n >= 0) {
            if (n == 0) {
                numbers.add(p0);
            } else if (n == 1) {
                numbers.add(p1);
            } else if (n == 2) {
                numbers.add(p2);
            } else {
                numbers.add(numbers.get(n - 1) - numbers.get(n - 2) + 2 * numbers.get(n - 3));
            }
        } else {
            numbers.add(numbers.get(n - 1) - numbers.get(n - 2) + 2 * numbers.get(n - 3));
        }
    }
}