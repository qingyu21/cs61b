import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestArrayDequeGold {
    private String message(List<String> list) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i));
            if (i != list.size() - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    @Test
    public void autograder() {
        ArrayDequeSolution<Integer> correct = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> incorrect = new StudentArrayDeque<>();
        List<String> methodsList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            //select a methods
            Integer choice = StdRandom.uniform(4);
            if (choice == 0) {
                //addFirst
                Integer value = StdRandom.uniform(-1000, 1000);
                methodsList.add("addFirst(" + value + ")");
                correct.addFirst(value);
                incorrect.addFirst(value);
            } else if (choice == 1) {
                //addLast
                Integer value = StdRandom.uniform(-1000, 1000);
                methodsList.add("addLast(" + value + ")");
                correct.addFirst(value);
                incorrect.addFirst(value);

            } else if (choice == 2) {
                //removeFirst
                if (!correct.isEmpty() && !incorrect.isEmpty()) {
                    methodsList.add("removeFirst()");
                    Integer correctValue = correct.removeFirst();
                    Integer incorrectValue = incorrect.removeFirst();
                    assertEquals(message(methodsList), correctValue, incorrectValue);
                }
            } else if (choice == 3) {
                //removeLast
                if (!correct.isEmpty() && !incorrect.isEmpty()) {
                    methodsList.add("removeLast()");
                    Integer correctValue = correct.removeLast();
                    Integer incorrectValue = incorrect.removeLast();
                    assertEquals(message(methodsList), correctValue, incorrectValue);
                }
            }
        }
    }
}
