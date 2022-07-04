class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if( !wordList.contains(endWord) ) return 0;
        
        Map<String,List<String>> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        
        wordList.add(beginWord);
        
        for( String word : wordList ){
            for( int j = 0;j<word.length();j++ ){
                String pattern = word.substring(0,j) + "*" + word.substring(j+1);
                // System.out.println(pattern);
                List<String> temp = map.getOrDefault( pattern , new ArrayList<>() );
                temp.add(word);
                map.put( pattern , temp );
            }
        }
        
        int res = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        
        while( !queue.isEmpty() ){
            int size = queue.size();
            
            for(int i = 0;i<size;i++){
                String curr = queue.poll();
                // System.out.println(curr);
                if(curr.equals(endWord)) return res + 1;
                
                for(int j = 0;j<curr.length();j++){
                    String pattern = curr.substring(0,j) + "*" + curr.substring(j+1);
                   
                    for( String neighbor : map.getOrDefault(pattern,new ArrayList<>()) ){
                        if( visited.contains(neighbor) ) continue;
                        visited.add(neighbor);
                       
                        queue.offer(neighbor);
                    } 
                }
            }
            res++;
        }
        
        return 0;
    }
}