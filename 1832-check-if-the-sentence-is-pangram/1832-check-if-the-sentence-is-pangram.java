class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Integer> numbers = new HashSet<Integer>();
        for(int i = 0; i < 26; i++){
            numbers.add(i);
        }
        for(int i = 0; i < sentence.length(); i++){
            char c = sentence.charAt(i);
            int num = c - 'a';
            if(numbers.contains(num)){
                numbers.remove(num);
            }
        }
        return numbers.size() == 0;
    }
}