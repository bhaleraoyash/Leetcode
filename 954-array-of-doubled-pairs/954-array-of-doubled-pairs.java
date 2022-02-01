class Solution{
	public boolean canReorderDoubled(int[] arr){
		TreeMap<Integer, Integer> counter = new TreeMap<Integer, Integer>();

		for(int i : arr){
			counter.put(i, counter.getOrDefault(i, 0) + 1);
		}

		for(int num : counter.keySet()){
			if(counter.get(num) == 0){
				continue;
			}

			int target = num < 0 ? num / 2 : num * 2;

			if(num < 0 && num % 2 != 0){
				return false;
			}

			if(counter.get(num) > counter.getOrDefault(target, 0)){
				return false;
			}

			counter.put(target, counter.get(target) - counter.get(num));
		}
		return true;
	}
}
