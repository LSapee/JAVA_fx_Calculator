package lotto;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] lottos = {44,1,0,0,31,25};
		int[] win_nums = {31,10,45,1,6,19};
		int[] result = solution.solution(lottos, win_nums);

		System.out.println(Arrays.toString(result).replace("[", "").replace("]", ""));
	}

}
