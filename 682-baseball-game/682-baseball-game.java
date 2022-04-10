class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        
        for(String op : ops ){
            if( !op.equals("C") && !op.equals("D") && !op.equals("+")  ){
                stack.add(Integer.parseInt(op));
            }else if( op.equals("C") ){
                stack.pop();
            }else if( op.equals("D") ){
                stack.push( stack.peek() * 2 );
            }else 
            {
                int size = stack.size();
                int score1 = stack.get(size - 1);
                int score2 = stack.get(size - 2);
                stack.push( score1  + score2 );
            }
        }
        
        int sum = 0;
        
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        
        return sum;
    }
}