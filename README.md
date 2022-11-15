# RecursivePingulogy

Optimizing a unique recursive function with dynamic programming and some math.

---

Let's take a look at the RecursivePingulogy problem. We still have a function called pinguSequenceRec that I still don't quite understand. Let me explain the function.

We have an initial vector **p = (p0, p1, p2)** and:

- **pinguSequenceRec(0) = p0**
- **pinguSequenceRec(1) = p1**
- **pinguSequenceRec(2) = p2**

- **pinguSequenceRec(n) = 2 \* pinguSequenceRec(-n), if n < 0**
- **pinguSequenceRec(n) = pinguSequenceRec(n - 1) - pinguSequenceRec(n-2) + 2 \* pinguSequenceRec(n - 3), else**

We have a code implemented with recursion, but the problem is that when the parameter n, which takes values ​​between -122 and 145, exceeds 30, the program starts to run very slowly and after a while it almost comes to a halt. Obviously it's not wise to start n from -122, so try starting n from 0.

Here is the code:

```
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
```

Frankly, I've experienced the inefficiency of recursion with the Fibonacci sequence before, so it wasn't hard to understand why the code was running so slowly. However, although I have heard of dynamic programming before, it would not be right to say that I have experienced it. After some effort, I thought it was much more efficient to save the pre-calculated values ​​instead of recalculating them, and solved the problem.

Here is the optimized code:

```
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
```

and also Main class:

```
public class Main {
    public static void main(String[] args) {

        OptimizedRecursivePingulogy optimizedRecursivePingulogy = new OptimizedRecursivePingulogy();

        for (int n = 0; n < 145; n++) {
            optimizedRecursivePingulogy.pinguSequenceRec(n, 1, 1, 2);
        }

        for (int i = -122; i < 145; i++) {
            if (i < 0) {
                System.out.println("pinguSequenceRec(" + i + ") = " + 2 * optimizedRecursivePingulogy.numbers.get(-i));
            } else {
                System.out.println("pinguSequenceRec(" + i + ") = " + optimizedRecursivePingulogy.numbers.get(i));
            }
        }
    }
}
```

Although I understood dynamic programming and successfully solved the problem, I was not satisfied that I had solved the problem because I did not fully understand the function in the problem, and I decided to do some math to understand the function. After messing around with the function, I realized that after n becomes 4, some values ​​cancel each other out and the function becomes simpler.

And here is the final version:

```
import java.util.ArrayList;

public class FinalOptimizedRecursivePingulogy {

    ArrayList<Long> numbers = new ArrayList<>();

    public void pinguSequenceRec(int n, long p0, long p1, long p2) {
        if (n >= 0) {
            if (n == 0) {
                numbers.add(p0);
            } else if (n == 1) {
                numbers.add(p1);
            } else if (n == 2) {
                numbers.add(p2);
            } else if (n == 3) {
                numbers.add(numbers.get(n - 1) - numbers.get(n - 2) + 2 * numbers.get(0));
            } else {
                numbers.add(2 * numbers.get(n - 4) + numbers.get(n - 3));
            }
        } else {
            numbers.add(numbers.get(n - 1) - numbers.get(n - 2) + 2 * numbers.get(n - 3));
        }
    }
}
```

I don't know how to write a test case yet, but while testing the code manually, I noticed that the upper limit of n was chosen as 144 because the limit of the long data type was exceeded for n = 145.
