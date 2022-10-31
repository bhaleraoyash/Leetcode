class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                int current = matrix[i][j];
                int row = i;
                int column = j;
                while(row < matrix.length && column < matrix[i].length){
                    if(matrix[row][column] != current){
                        return false;
                    }
                    row++;
                    column++;
                }
            }
        }
        
        return true;
    }
}