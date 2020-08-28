import java.util.*;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int power = 31, ret = 0;
        while(n!=0)
        {
            ret |= (n&1)<<power;
            n = n>>>1;
            power--;
        }
        return ret;
    }
}