package hw_13;

import lombok.Data;
import lombok.experimental.var;

import java.util.Scanner;

@Data

public class SolutionOne {
    public int maxProduct(int[] nums) {
        if (nums.length < 3) return nums[0] * nums[1];
        int temp = 0;
        int indexFirstMax = 0;
        for (int a = 0; a < nums.length; a++) if (nums[a] > temp) {
            temp = nums[a];
            indexFirstMax = a;
        }
        int i = temp;
        temp = 0;
        for (int b = 0; b < nums.length; b++) if (nums[b] > temp && indexFirstMax != b) temp = nums[b];
        int j = temp;
        return (i - 1) * (j - 1);
    }
}
