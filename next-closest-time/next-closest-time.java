class Solution{
	public String nextClosestTime(String time){
		Set<Integer> digits = new HashSet<Integer>();
		String answer = "";

		for(char c : time.toCharArray()){
			digits.add(c - '0');
		}

		int minutes = Integer.parseInt(time.substring(0, 2)) * 60;
		minutes += Integer.parseInt(time.substring(3));

		while(true){
			minutes = (minutes + 1) % (24 * 60);
			int[] nextTime = {minutes / 60 / 10, minutes / 60 % 10, minutes % 60 / 10, minutes % 60 % 10};

			boolean isValid = true;
			for(int i : nextTime){
				if(!digits.contains(i)){
					isValid = false;
				}
			}

			if(isValid){
				answer = nextTime[0] + "" + nextTime[1] + ":" + nextTime[2] + "" + nextTime[3];
				return answer;
			}
		}
	}
}
