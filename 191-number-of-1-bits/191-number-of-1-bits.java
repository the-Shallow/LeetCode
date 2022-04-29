public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.toBinaryString(n).replace("0","").length();
    }
}