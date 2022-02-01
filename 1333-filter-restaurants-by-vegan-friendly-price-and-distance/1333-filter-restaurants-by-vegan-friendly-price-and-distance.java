class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> answer = new ArrayList<Integer>();
        List<int[]> filtered = new ArrayList<int[]>();
        
        for(int i = 0; i < restaurants.length; i++){
            int[] current = restaurants[i];
            int id = current[0];
            int rating = current[1];
            int vegan = current[2];
            int price = current[3];
            int distance = current[4];
            
            if(veganFriendly == 1 && vegan == 0){
                continue;
            }
            else{
                if(price > maxPrice || distance > maxDistance){
                    continue;
                }
                else{
                    filtered.add(current);
                }
            }
        }
        
        Collections.sort(filtered, (a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        for(int[] r : filtered){
            answer.add(r[0]);
        }
        return answer;
    }
}