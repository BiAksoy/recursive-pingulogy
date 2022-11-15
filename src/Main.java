public class Main {
    public static void main(String[] args) {

        FinalOptimizedRecursivePingulogy finalOptimizedRecursivePingulogy = new FinalOptimizedRecursivePingulogy();

        for (int n = 0; n < 145; n++) {
            finalOptimizedRecursivePingulogy.pinguSequenceRec(n, 1, 1, 2);
        }

        for (int i = -122; i < 145; i++) {
            if (i < 0) {
                System.out.println("pinguSequenceRec(" + i + ") = " + 2 * finalOptimizedRecursivePingulogy.numbers.get(-i));
            } else {
                System.out.println("pinguSequenceRec(" + i + ") = " + finalOptimizedRecursivePingulogy.numbers.get(i));
            }
        }
    }
}