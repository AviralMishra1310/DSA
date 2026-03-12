class LC904 {
    public int totalFruit(int[] arr) {
        int n = arr.length, l = 0, maxL = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int r = 0; r < n ; r++){
            map.put(arr[r], map.getOrDefault(arr[r],0)+1);

            if(map.size() > 2){
                map.put(arr[l], map.get(arr[l]) - 1);
                if(map.get(arr[l]) == 0) map.remove(arr[l]);
                l++;
            }

            maxL = Math.max(maxL, r-l+1);
        }
        return maxL;
    }
}