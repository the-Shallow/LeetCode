class Solution {
    public int tribonacci(int n) {
        int a = 0, b = 1, c = 1;
        
        if(n == 0) return a;
        if(n == 1) return b;
        if(n == 2) return c;
        
        int res = 0;
        
        for(int i = 3;i<=n;i++){
            // System.out.println(a + " " + b + " " + c);
            res = a + b + c;
            a = b;
            b = c;
            c = res;
        }
        
        return res;
    }
}