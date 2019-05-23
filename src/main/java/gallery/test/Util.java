package gallery.test;

import act.test.func.Func;
import act.test.verifier.Verifier;
import org.osgl.$;
import org.osgl.util.*;

import java.util.List;

public class Util {

    public static class FibonacciFunc extends Func {

        private int max;

        @Override
        public void init(Object param) {
            int n = $.convert(param).toInt();
            E.invalidConfigurationIf(n < 2, "limit must be at least 2");
            max = n;
        }

        @Override
        public Object apply() {
            return loadFibonacciSeries(max);
        }

        @Override
        protected List<String> aliases() {
            return C.list("fs", "fibonacci");
        }
    }

    public static class FibonacciVerifier extends Verifier {

        private List<Integer> expected;

        @Override
        public void init(Object param) {
            int n = $.convert(param).toInt();
            E.invalidConfigurationIf(n < 2, "limit must be at least 2");
            expected = loadFibonacciSeries(n);
        }

        @Override
        public boolean verify(Object o) {
            return $.eq(expected, $.copy(o).to(List.class));
        }

        @Override
        protected List<String> aliases() {
            return C.list("fs", "fibonacci");
        }
    }


    public static List<Integer> loadFibonacciSeries(int max) {
        int n1 = 1, n2 = 1, f;
        List<Integer> list = C.newList();
        list.add(n1);
        list.add(n2);
        for (;;) {
            f = n1 + n2;
            n1 = n2;
            n2 = f;
            if (f < max) {
                list.add(f);
            } else {
                break;
            }
        }
        return list;
    }

}
