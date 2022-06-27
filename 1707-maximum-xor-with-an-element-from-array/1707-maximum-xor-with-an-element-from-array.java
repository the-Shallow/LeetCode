class Solution {
    
    class Node  {
        Node[] children;
        
        public Node(  ){
            this.children = new Node[2];
        }
        
        public void insert(Node curr, int num){
            for( int i = 31 ;i>=0;i-- ){
                int currBit = (num >> i) & 1;
                
                if( curr.children[currBit] == null ) curr.children[currBit] = new Node();
                
                curr = curr.children[currBit];
            }
        }
        
        public int maxXor(Node curr , int num){
            int xor = 0;
            
            for(int i = 31;i>=0;i--){
                int requiredBit = 1 - ( (num >> i) & 1 );
                
                if( curr.children[requiredBit] == null ){
                    curr = curr.children[1-requiredBit];
                }else {
                    xor |= (1 << i);
                    curr = curr.children[requiredBit];
                }
            }
            
            return xor;
        }
    }
    
    Node root = new Node();
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int[] res = new int[queries.length];
       int[][] list = new int[queries.length][3];
        
        
        for( int i = 0;i<queries.length;i++ ){
            int[] query = queries[i];
            list[i][0] = query[0];
            list[i][1] = query[1];
            list[i][2] = i;
        }
        
        Arrays.sort( list , new Comparator<int[]>() {
            public int compare(int[] a , int[] b){ 
                return Integer.compare(a[1], b[1]);
            }
        } );
        
        // System.out.println(Arrays.toString(queries));
        // System.out.println(Arrays.toString(queries));
        int counter = 0;
        for( int i = 0;i<list.length;i++ ){
            int num = list[i][1];
            int maxXor = -1;
            
            while( counter < nums.length && nums[counter] <= num ){
                root.insert(root,nums[counter]);
                counter++;
            }
            
            
            if(counter != 0) maxXor = root.maxXor(root,list[i][0]) ;
            res[ list[i][2] ] = maxXor;
        }
        
        return res;
    }
}