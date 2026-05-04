class LC48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length; //ye no. of rows calculate kr ke store kr dega n me

        for(int i = 0;i < n;i++){ 
            for(int j = i + 1; j < n;j++){
                int temp = matrix[i][j];   //It swaps elements above the diagonal with those below the diagonal.
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < n;i++){
            int left = 0; // ye left me har row ke pehle element pr point krega
            int right = n -1; //ye right me har row ke aakhri element pr point krega
            //in left right ki madad se hi ham inko swap krke reverse kr payenge
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}