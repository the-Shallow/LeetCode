// TC: O(P + V + E)
// SC: O(V)  
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        
        
        for( int[] pre : prerequisites ){
            indegree[pre[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for( int i = 0;i<indegree.length;i++ ){
            if( indegree[i] == 0 ) queue.offer( i );
        }
        
        if( queue.isEmpty() ) return false;
        
        while( !queue.isEmpty() ){
            int size = queue.size();
            for( int i = 0;i<size;i++ ){
                int course = queue.poll();
                
                for( int[] pre : prerequisites ){
                    if( pre[1] == course ){
                        indegree[pre[0]]--;
                        
                        if( indegree[pre[0]] == 0 ){
                            queue.offer( pre[0] );
                        }
                    }
                }
            }
        }
        
        for( int i = 0;i<indegree.length;i++ ){
            if( indegree[i] > 0 ) return false;
        }
        
        return true;
         
    }
}