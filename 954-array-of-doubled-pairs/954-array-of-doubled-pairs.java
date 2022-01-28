class Solution{
	public boolean canReorderDoubled(int[] arr){
		Map<Integer, Integer> freq = new TreeMap<Integer, Integer>();

		for(int i : arr){
			freq.put(i, freq.getOrDefault(i, 0) + 1);
		}

		for(int i : freq.keySet()){
			if(freq.get(i) == 0){
                continue;
            }
            int twice = i < 0 ? i / 2 : 2 * i;
            if(i < 0 && i % 2 != 0){
                return false;
            }
            if(freq.get(i) > freq.getOrDefault(twice, 0)){
                return false;
            }
            freq.put(twice, freq.get(twice) - freq.get(i));
        }
		return true;
	}
}