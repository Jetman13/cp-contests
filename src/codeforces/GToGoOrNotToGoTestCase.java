package codeforces;

import net.egork.chelper.task.Test;
import net.egork.chelper.tester.TestCase;

import java.util.Collection;
import java.util.Collections;

public class GToGoOrNotToGoTestCase {
    @TestCase
    public Collection<Test> createTests() {
        StringBuilder input = new StringBuilder();
        int w = (int)1e9;
        int n = 2000;
        input.append(n).append(" ").append(n).append(" ").append(1000000000).append("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                input.append(w).append(" ");
            }
            input.append("\n");
        }
        Test test = new Test(input.toString());
        return Collections.singletonList(test);
    }
}
