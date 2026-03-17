class LC860 {
    public boolean lemonadeChange(int[] nums) {
        int n = nums.length, five = 0, ten = 0;
        
        for(int num : nums){
            if(num == 5) five++;
            else if(num == 10){
                if(five == 0){
                    return false;
                }
                five--;ten++;
            } 
            else{
                if(ten > 0 && five > 0){
                    ten--; five--;
                }else if(five >= 3){
                    five -= 3;
                }
                else return false;
            }
        }
        return true;
    }
}