package hw_14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SolutionTwo {
    int result;
    String string;
    int count;

    public boolean isHappy(int n) {
        string = String.valueOf(n);
        String[] strings = string.split("");
        List<Integer> ints = new ArrayList<>();
        for (String s : strings) ints.add(Integer.parseInt(s));
        ints.replaceAll(a -> (int) (Math.pow(a, 2)));
        for (int i : ints) result += i;
        string = String.valueOf(result);
        while (result != 1) {
            result = 0;
            ints.clear();
            strings = string.split("");
            for (String s : strings) ints.add(Integer.parseInt(s));
            ints.replaceAll(a -> (int) (Math.pow(a, 2)));
            for (int i : ints) result += i;
            System.out.println(ints + " = " + result);
            string = String.valueOf(result);
            count++;
            if (count >= 100) return false;
        }
        System.out.println("Is happy => " + (result == 1));
        return result == 1;
    }

    public static void main(String[] args) {
        SolutionTwo s = new SolutionTwo();
        s.isHappy(1154);
    }

}

