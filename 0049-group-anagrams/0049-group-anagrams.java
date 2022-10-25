class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String temp = String.valueOf(c);
            if(!map.containsKey(temp)){
                map.put(temp, new ArrayList());
            }
            map.get(temp).add(s);
        }
        
        return new ArrayList(map.values());
    }
}
