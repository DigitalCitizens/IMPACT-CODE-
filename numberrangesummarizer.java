#pull request
import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberRangeSummarizer {

    public Collection<Integer> collect(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : input.split(",")) {
            try {
                int number = Integer.parseInt(token.trim());
                numbers.add(number);
            } catch (NumberFormatException e) {
                
            }
        }
        return numbers;
    }

    public String summarizeCollection(Collection<Integer> input) {
        if (input.isEmpty()) {
            return "";
        }
        List<Integer> sortedNumbers = new ArrayList<>(input);
        Collections.sort(sortedNumbers);
        StringBuilder sb = new StringBuilder();
        int start = sortedNumbers.get(0);
        int end = start;
        for (int i = 1; i < sortedNumbers.size(); i++) {
            int number = sortedNumbers.get(i);
            if (number == end + 1) {
                end = number;
            } else {
                appendRange(start, end, sb);
                start = end = number;
            }
        }
        appendRange(start, end, sb);
        return sb.toString();
    }

    private void appendRange(int start, int end, StringBuilder sb) {
        if (sb.length() > 0) {
            sb.append(", ");
        }
        if (start == end) {
            sb.append(start);
        } else {
            sb.append(start).append("-").append(end);
        }
    }

}


public class Main {
    public static void main(String[] args) {

        NumberRangeSummarizer summarizer = new NumberRangeSummarizer();
        Collection<Integer> input = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        String summary = summarizer.summarizeCollection(input);
        System.out.println(summary);
    }
}
