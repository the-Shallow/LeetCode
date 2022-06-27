// Space Complexity = O(N*M) (N == length of cost array and M == target )
// Time Complexity = O(N*M)
class Solution {
    Map<String,String> map =  new HashMap<>();
    String[][] memo;
    public String largestNumber(int[] cost, int target) {
        memo = new String[cost.length+1][target+1];
        
        for( int i = 0;i<=cost.length;i++ ){
            for(int j = 0;j<=target;j++) memo[i][j] = "0";
        }
        
        String res = helper(cost,cost.length-1,target);
        
        return res == "-1" ? "0" : res; 
        
    }
    
    public String helper( int[] cost , int index , int target){
        if(target == 0) {
            return "";
        }
        
        if(target < 0) return "-1";
        
        if(index < 0) return "-1";
        
        if( memo[index][target] != "0") return memo[index][target];
        
        String str1 = (index+1) + helper(cost,cost.length-1,target-cost[index]) ;
        String str2 = helper(cost,index-1,target);
        
        String res = getBigger(str1,str2);
        
        memo[index][target] =  res;
        
        return res;
    }
    
    public String getBigger(String num1 , String num2){
        if( num1.contains("-1") ) return num2;
        if( num2.contains("-1") ) return num1;
        if( num1.length() > num2.length() ) return num1;
        if( num2.length() > num1.length() ) return num2;
        return Double.parseDouble( num1 ) < Double.parseDouble( num2 ) ? num2 : num1;
    }
}


/*
As we can see we are given a cost array and a target value and we are asked to return the largest string which we can form.

To create the largest string:
we can take any cost value from index = (0,cost.length-1) + 1 ;(1-based indexing)

If we can not reach to our exact target value(target == 0) we return -1;


Approach:

    As we can see this question is quite similar to unbounded knapsack(we can select one digit and again can select from the whole cost array)
    
    Two things can happen at each index we either pick the value or not
    1--> If we pick the cost value then we add that (index+1_) to our curr string and decrment cost[index] value from target and again call helper method fro the whole cost array.
    2 --> We don't select current value and go index-1;target value remians the same as we have not selected the value.
    
    If target < 0(can not be form) return "-1" as there are no negative values.
    If target == 0 return "".
    
    Now At this point we have two string which are retuned.
    
    We compare them:
    if one of the string contains (-1) we return the other string.
    if one string has length greater than the other we return greater length string
    At last we compare both the string by  values and return string with greater value;
    
    This apprach can take a long amount of time and will give TLE if it is not memorize.
    So as index and target value are the one changing so we memorize respect to them.
    
    To fill the memorize array we use "0" as "0" is not present in the whole cost array.You can also choose "0" as the returned value if target goes less than 0 and "-1" to memorize array.I use it because i feel "-1" gives more meaning but its still the same thing.
    
*/