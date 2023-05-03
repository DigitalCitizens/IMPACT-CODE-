import java.util.*;


public class Main {
    public static void main(String[] args) {

        NumberRangeSummarizer summarizer = new NumberRangeSummarizer();
        Collection<Integer> input = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        String summary = summarizer.summarizeCollection(input);
        System.out.println(summary);
    }
}
