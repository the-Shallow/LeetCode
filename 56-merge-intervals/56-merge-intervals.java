// Space Complexity = O(1)
// Time Complexity = O(n)
// class Solution {
//     public int[][] merge(int[][] intervals) {
//         if(intervals.length == 0) return null;
        
//         Arrays.sort(intervals , (a,b)-> a[0] - b[0]);
        
//         List<int[]> res = new ArrayList<>();
        
//         int[] currInterval = intervals[0];
        
//         for(int[] curr : intervals ){
//             int start = currInterval[0];
//             int end = currInterval[1];
//             int currStart = curr[0];
//             int currEnd = curr[1];
            
//             if( end >= currStart ){
//                 currInterval[1] = Math.max(end , currEnd);
//             }else {
//                 res.add( currInterval );
//                 currInterval = curr;
//             }
//         }
        
//         res.add(currInterval);
//         return getArray(res);
//     }
    
//     public int[][] getArray( List<int[]> list ){
//         int[][] res = new int[list.size()][2];
        
//         for(int i = 0;i<list.size();i++){
//             res[i][0] = list.get(i)[0];
//             res[i][1] = list.get(i)[1];
//         }
        
//         return res;
//     }
// }

// Approach 2

/*
Time complexity : O(n^2)

Building the graph costs O(V + E) = O(V) + O(E) = O(n) + O(n^2) = O(n^2)

  time, as in the worst case all intervals are mutually overlapping. Traversing the graph has the same cost (although it might appear higher at first) because our visited set guarantees that each node will be visited exactly once. Finally, because each node is part of exactly one component, the merge step costs O(V) = O(n)O(V)=O(n) time. This all adds up as follows:

O(n^2) + O(n^2) + O(n) = O(n^2)

Space complexity : O(n^2)

As previously mentioned, in the worst case, all intervals are mutually overlapping, so there will be an edge for every pair of intervals. Therefore, the memory footprint is quadratic in the input size.
*/


class Solution {
    Map<int[] , List<int[]>> map = new HashMap<>();
    Map<Integer , List<int[]>> components = new HashMap<>();
    Set<int[]> visited = new HashSet<>();
    
    public int[][] merge(int[][] intervals) {
        buildGraph(intervals);
        buildComponents(intervals);
        
        List<int[]> res = new ArrayList<>();
        for( int numComponent = 0 ; numComponent < components.size() ; numComponent++ ){
            res.add( mergeNodes( components.get(numComponent) ) );
        }
        
        return res.toArray( new int[ res.size() ][] );
    }
    
    public boolean isOverlap( int[] a , int[] b ){
        return a[0] <= b[1] && a[1] >= b[0];
    }
    
    public void buildGraph(int[][] intervals){
        
        
        for( int[] interval1 : intervals ){
            for( int[] interval2 : intervals ){
                if(isOverlap(interval1,interval2)){
                    List<int[]> node1 =  map.getOrDefault(interval1,new ArrayList<>());
                    node1.add(interval2);
                    map.put( interval1 , node1 );
                    List<int[]> node2 = map.getOrDefault(interval2,new ArrayList<>());
                    node2.add(interval1);
                    map.put(interval2,node2);
                }
            }
        }
    }
    
    public int[] mergeNodes(List<int[]> nodes){
        int start = nodes.get(0)[0];
        
        for(int[] node : nodes) start = Math.min(start,node[0]);
        
        int end = nodes.get(0)[1];
        
        for(int[] node : nodes) end = Math.max( end , node[1] );
        
        return new int[] {start,end};
    }
    
    public void markComponent(int[] interval , int numComponent){
        Stack<int[]> stack = new Stack<>();
        
        stack.push(interval);
        
        while( !stack.isEmpty() ){
            int[] node = stack.pop();
            
            if( !visited.contains(node) ){
                visited.add(node);
                List<int[]> component = components.getOrDefault( numComponent , new ArrayList<>() );
                
                component.add( node );
                components.put(numComponent,component);
                
                for( int[] child : map.get(node) ){
                    stack.add(child);
                }
                
            }
        }
    }
    
    public void buildComponents(int[][] intervals){
        int numComponents = 0;
        
        for( int[] interval : intervals ){
            if( !visited.contains(interval) ){
                markComponent( interval , numComponents );
                numComponents++;
            }
        }
    }
    
}