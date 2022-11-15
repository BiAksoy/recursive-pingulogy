public class RecursivePingulogy {

    public long pinguSequenceRec(int n, int p0, int p1, int p2) {
        if (n >= 0) {
            if (n == 0) {
                return p0;
            } else if (n == 1) {
                return p1;
            } else if (n == 2) {
                return p2;
            } else {
                return pinguSequenceRec(n - 1, p0, p1, p2) - pinguSequenceRec(n - 2, p0, p1, p2) + 2 * pinguSequenceRec(n - 3, p0, p1, p2);
            }
        } else {
            return 2 * pinguSequenceRec(-n, p0, p1, p2);
        }
    }
}