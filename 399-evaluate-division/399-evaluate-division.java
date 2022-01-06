class Solution{
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
		Map<String, Map<String, Double>> results = new HashMap<String, Map<String, Double>>();

		for(int i = 0; i < equations.size(); i++){
			List<String> equation = equations.get(i);
			String dividend = equation.get(0);
			String divisor = equation.get(1);
			double quotient = values[i];
		
			if(!results.containsKey(dividend)){
				results.put(dividend, new HashMap<String, Double>());
			}
			if(!results.containsKey(divisor)){
				results.put(divisor, new HashMap<String, Double>());
			}
			
			results.get(dividend).put(divisor, quotient);
			results.get(divisor).put(dividend, 1 / quotient);
		
		}
		
		double[] answer = new double[queries.size()];
		for(int i = 0; i < queries.size(); i++){
			List<String> query = queries.get(i);
			String dividend = query.get(0);
			String divisor = query.get(1);

			if(!results.containsKey(dividend) || !results.containsKey(divisor)){
				answer[i] = -1.0;
			}
			else if(dividend == divisor){
				answer[i] = 1.0;
			}
			else{
				Set<String> visited = new HashSet<String>();
				answer[i] = backtrack(results, dividend, divisor, 1, visited);
			}
		}
		return answer;
	}

	public double backtrack(Map<String, Map<String, Double>> results, String currNode, String targetNode, double accProduct, Set<String> visited){
		visited.add(currNode);
		double ret = -1.0;

		Map<String, Double> neighbors = results.get(currNode);
		if(neighbors.containsKey(targetNode)){
			ret = accProduct * neighbors.get(targetNode);
		}
		else{
			for(Map.Entry<String, Double> pair : neighbors.entrySet()){
				String nextNode = pair.getKey();
				if(visited.contains(nextNode)){
					continue;
				}
				ret = backtrack(results, nextNode, targetNode, accProduct * pair.getValue(), visited);
				if(ret != -1.0){
					break;
				}
			}
		}
		
		visited.remove(currNode);
		return ret;
	}
}
