class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
		int[] indegree = new int[numCourses];
		int[] order = new int[numCourses];
	
		for(int i = 0; i < prerequisites.length; i++){
			int src = prerequisites[i][1];
			int dest = prerequisites[i][0];

			List<Integer> temp = adjList.getOrDefault(src, new ArrayList<Integer>());
			temp.add(dest);
			adjList.put(src, temp);
			indegree[dest] += 1;
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < numCourses; i++){
			if(indegree[i] == 0){
				q.add(i);
			}
		}

		int i = 0;
		while(!q.isEmpty()){
			int node = q.remove();
			order[i] = node;
			i++;
	
			if(adjList.containsKey(node)){
				for(Integer neighbor : adjList.get(node)){
					indegree[neighbor]--;
				
					if(indegree[neighbor] == 0){
						q.add(neighbor);
					}
				}
			}
		}
		
		if(i == numCourses){
			return true;
		}
		return false;
    }
}