class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        List<Character> listS = new ArrayList<Character>();
        List<Character> listT = new ArrayList<Character>();

        for(int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            listS.add(charS);
            listT.add(charT);
        }

        Collections.sort(listT);
        Collections.sort(listS);
        
        return listS.equals(listT);
    }
}
