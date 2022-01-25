class Solution{
	public int[] findOriginalArray(int[] changed){
		if(changed.length % 2 != 0){
			return new int[0];
		}

		int[] answer = new int[changed.length];
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		Arrays.sort(changed);

		int index = 0;
		for(int i = changed.length - 1; i >= 0; i--){
            int current = changed[i];
			int twice = current * 2;
			if(count.containsKey(twice) && count.get(twice) > 0){
                answer[index++] = current;
                count.put(twice, count.get(twice) - 1);
            }
            else{
                count.put(current, count.getOrDefault(current, 0) + 1);
            }
		}
		return index == changed.length / 2 ? Arrays.copyOfRange(answer, 0, index) : new int[0];
	}
}
