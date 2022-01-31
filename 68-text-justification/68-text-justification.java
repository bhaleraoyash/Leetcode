class Solution{
	public List<String> fullJustify(String[] words, int maxWidth){
        List<String> answer = new ArrayList<String>();
        int n = words.length;

        int i = 0;
        while(i < n){
            int j = i + 1;
            int lineLength = words[i].length();
            while(j < n && (lineLength + words[j].length() + (j - i - 1) < maxWidth)){
                lineLength += words[j].length();
                j++;
            }

            int diff = maxWidth - lineLength;
            int numberOfWords = j - i;

            if(numberOfWords == 1 || j >= n){
                answer.add(leftJustify(words, i, j, diff));
            }
            else{
                answer.add(middleJustify(words, i, j, diff));
            }
            i = j;
        }
        return answer;
    }

    public String leftJustify(String[] words, int i, int j, int diff){
        StringBuilder temp = new StringBuilder(words[i]);
        int spacesOnRight = diff - (j - i - 1);

        for(int k = i + 1; k < j; k++){
            temp.append(" " + words[k]);
        }
        temp.append(" ".repeat(spacesOnRight));

        return temp.toString();
    }

    public String middleJustify(String[] words, int i, int j, int diff){
        StringBuilder temp = new StringBuilder(words[i]);
        int spacesNeeded = j - i - 1;
        int spaces = diff / spacesNeeded;
        int extraSpaces = diff % spacesNeeded;

        for(int k = i + 1; k < j; k++){
            int spacesToApply = spaces + (extraSpaces > 0 ? 1 : 0);
            extraSpaces--;
            temp.append(" ".repeat(spacesToApply) + words[k]);
        }

        return temp.toString();
    }
}