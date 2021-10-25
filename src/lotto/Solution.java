package lotto;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
    	int min =0;
    	int max =0;
    	for(int i = 0; i<lottos.length; i++) {
    		for(int j =0; j<win_nums.length; j++) {
    			if(lottos[i] == win_nums[j] ) {
    				min += 1;
    			}
    		}
    		if(lottos[i] == 0) {
				max += 1;
			}
    	}
    	max = max+min;
    	
        int[] answer = {max , min};
        
        return answer;
    }
}
