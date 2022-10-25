class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Character>> strings = new HashMap<String, List<Character>>();
        Map<List<Character>, List<String>> lists = new HashMap<List<Character>, List<String>>();
        List<List<String>> answer = new ArrayList<List<String>>();
        
        for(int i = 0; i < strs.length; i++){
            char[] temp = strs[i].toCharArray();
            List<Character> array_list = new ArrayList<Character>();
            for(char c : temp){
                array_list.add(c);
            }
            Collections.sort(array_list);
            strings.put(strs[i], array_list);
            
        }
        
        for(String s1 : strs){
            List<Character> chars = strings.get(s1);
            System.out.println(s1);
            if(lists.containsKey(chars)){
                List<String> temp = lists.get(chars);
                temp.add(s1);
                lists.put(chars, temp);
            }
            else{
                List<String> temp = new ArrayList<String>();
                temp.add(s1);
                lists.put(chars, temp);
            }
        }
        
        for(List<Character> c : lists.keySet()){
            answer.add(lists.get(c));
        }
        
        return answer;
    }
}