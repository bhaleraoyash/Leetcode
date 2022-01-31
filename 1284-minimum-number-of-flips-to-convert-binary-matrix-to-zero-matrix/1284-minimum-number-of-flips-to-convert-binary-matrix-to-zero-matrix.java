class Solution{
	int n;
	int m;

	public int minFlips(int[][] mat){
		n = mat.length;
		m = mat[0].length;
		int state = 0;
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				state = (state << 1) | mat[i][j];
			}
		}

		boolean[] seen = new boolean[1 << 9];
		seen[state] = true;

		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(state);
		int step = 0;

		while(!queue.isEmpty()){
			int size = queue.size();
			while(-- size >= 0){
				int curr = queue.poll();
				if(curr == 0){
					return step;
				}

				for(int i = 0; i < n * m; i++){
					int next = flip(curr, i);
					if(seen[next]){
						continue;
					}
					queue.offer(next);
					seen[next] = true;
				}
			}
			step++;
		}
		return -1;
	}

	public int flip(int state, int pos){
		int r = pos / m;
		int c = pos % m;
		int[][] dirs = {{0,0}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		for(int[] dir : dirs){
			int nr = r + dir[0];
			int nc = c + dir[1];
			if(nr < 0 || nr == n || nc < 0 || nc == m){
				continue;
			}
			state ^= (1 << (nr * m + nc));
		}
		return state;
	}
}
