package hw_13;

public class SolutionTwo {
    public int[] sortedSquares(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i] * nums[i];
        }
        int a = temp.length;
        int t = 0;
        while (a != 0) {
            for (int i = 0; i < a - 1; i++) {
                if (temp[i] > temp[i + 1]) {
                    t = temp[i];
                    temp[i] = temp[i + 1];
                    temp[i + 1] = t;
                }
            }
            a--;
        }
        return temp;
    }
}
