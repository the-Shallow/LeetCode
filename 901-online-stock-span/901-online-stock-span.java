// Space Complexity = O(N)
// Time Complexity = O(N)
class StockSpanner {
    
    class Pair {
        int val;
        int span;
        
        public Pair(int val , int span){
            this.val = val;
            this.span = span;
        }
    }
    
    Stack<Pair> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while( !stack.isEmpty() && stack.peek().val <= price ){
            Pair pair = stack.pop();
            span += pair.span; 
        }
        
        stack.push( new Pair(price,span) );
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */