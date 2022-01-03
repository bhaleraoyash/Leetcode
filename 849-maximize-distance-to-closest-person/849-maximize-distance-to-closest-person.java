class Solution{
	public int maxDistToClosest(int[] seats){
		int answer = 0;

		for(int i = 0; i < seats.length; i++){
            if(seats[i] == 0){
                int left = i - 1;
                int right = i + 1;
                int leftCount = 0;
                int rightCount = 0;
                while(left >= 0){
                    if(seats[left] == 0){
                        left -= 1;
                        leftCount += 1;
                    }
                    else if(seats[left] == 1){
                        leftCount += 1;
                        break;
                    }
			    }
                while(right <= seats.length - 1){
                    if(seats[right] == 0){
                        right += 1;
                        rightCount += 1;
                    }
                    else if(seats[right] == 1){
                        rightCount += 1;
                        break;
                    }
                }
                
                int currentAnswer = 0;
                if(leftCount == 0 || rightCount == 0){
                    if(leftCount == 0){
                        currentAnswer = rightCount;
                    }
                    else if(rightCount == 0){
                        currentAnswer = leftCount;
                    }
                }
                else{
                    currentAnswer = Math.min(leftCount, rightCount);
                }
                answer = Math.max(answer, currentAnswer);
            }
		}
		return answer;
	}
}