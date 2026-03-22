public class LC365 {
    public boolean canMeasureWater(int x, int y, int target) {
        if(x + y < target) return false;
        if( x == target || y == target || x + y == target ) return true;
        return target%GCD(x, y) == 0;
    }

    public int GCD(int a, int b){
        while(b != 0 ){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
