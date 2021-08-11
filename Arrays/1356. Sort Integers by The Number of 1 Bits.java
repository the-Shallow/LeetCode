class Solution {
    
    class Int {
        int noOf1s,val,num;
        
        public Int( int noOf1s , int val , int num  ){
            this.num = num;
            this.val = val;
            this.noOf1s = noOf1s;
        }
        
    }
    
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        
        Map<Integer, int[]> map = new LinkedHashMap<>();
        List<Int> list = new ArrayList<>();
        List<Integer> sortList = new ArrayList<>();
        
        // adding items to map first
        addToMap( arr,map );
        
        // adding items to list in form of Int Objects
        for( int num : map.keySet() ){
            list.add( new Int( map.get(num)[1] , map.get(num)[0] , num  ) );
        }
        
        // sorting the list based on noOf1s 
        sortlist( list );
        
        // addting item number to list and converting them to result array(res)
        addItemsToList( list,sortList );
                     
        int[] res = new int[sortList.size()];
        
        for(int i = 0;i<sortList.size();i++){
            res[i] = sortList.get(i);
        }
        
        return res;
    }
    
    
    public int noOfOnes(int num){
        String validString = Integer.toBinaryString(num);
        int count = 0;
        for(Character ch : validString.toCharArray()){
            if( ch == '1' ){
                count++;
            }
        }
        
        return count;
    }
    
    public void sortlist( List<Int> list ) {
        Collections.sort( list , (o1,o2)-> ( o1.noOf1s < o2.noOf1s )?-1:( o1.noOf1s > o2.noOf1s )?1:0 );
    }
    
    public void addItemsToList( List<Int> list , List<Integer> sortList ){
        for(int i = 0;i<list.size();i++){
            Int item = list.get(i);
            while( item.val > 0 ){
                sortList.add(item.num);
                item.val--;
            }
        }
    }
    
    public void addToMap( int[] arr , Map<Integer, int[]> map ){
        for( int num : arr ){
            int noOf1s = noOfOnes(num);
            int val = 1;
            if( map.containsKey( num ) ){
                val = map.get(num)[0] + 1;
            }
            map.put( num , new int[] {val,noOf1s} );
        }
    }
}