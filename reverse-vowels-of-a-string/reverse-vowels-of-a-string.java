class Solution {
    public String reverseVowels(String s){
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int j = 0;
        String vowel = "";
        String answer = "";
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(vowels.contains(c)){
                vowel += c;
                j++;
            }
        }
        
        j--;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(vowels.contains(c)){
                answer += vowel.charAt(j);
                j--;
            }
            else{
                answer += c;
            }
        }
        System.out.println(answer);
        return answer;
    }
}