class Solution {
    
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,int[]> map = new HashMap<>();
        
        
        for( int[] match : matches ){
            int[] arr1 = map.getOrDefault(match[0],new int[2]);
            arr1[0]++;
            int[] arr2 = map.getOrDefault(match[1],new int[2]);
            arr2[1]++;
            
            // System.out.println(Arrays.toString(arr1));
            // System.out.println(Arrays.toString(arr2));
            map.put( match[0] , arr1 );
            map.put( match[1] , arr2 );
        }
        
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for(Map.Entry<Integer,int[]> entry : map.entrySet()){
            int player = entry.getKey();
            int[] stats = entry.getValue();
            
            if(stats[1] == 0 && stats[0] != 0){
                res.get(0).add(player);
            }else if(stats[1] == 1 ){
                res.get(1).add(player);
            }
        }
        
        Collections.sort(res.get(0));
        Collections.sort(res.get(1));
        return res;
    }
}