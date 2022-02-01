/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    int wordLength = 6;
    public void findSecretWord(String[] wordlist, Master master) {
        Random random = new Random();
        List<String> possibleWords = new ArrayList<>();
        for (String word : wordlist)
            possibleWords.add(word);
        
        int attempt = 0;
        while (attempt < 10){
            int candidate = random.nextInt(possibleWords.size());
            String candidateWord = possibleWords.get(candidate);
            int score = master.guess(candidateWord);
            
            if (score == 6) //found the match gg :)
                return;
            
            List<String> updatedPossibleWords = new ArrayList<>();
            for (String word : possibleWords){
                if (checkMatches(candidateWord, word) == score) // cool we found another possible Matched word add it to new list.
                    updatedPossibleWords.add(word);
            }
            possibleWords = updatedPossibleWords; // update base list with new words
            attempt++;
        }
    }
    
    private int checkMatches(String word1, String word2){
        int count = 0;
        for (int i = 0; i < wordLength; ++i)
            if (word1.charAt(i) == word2.charAt(i))
                count++;
        return count;
    }
}