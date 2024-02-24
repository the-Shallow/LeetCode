class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Set<Integer> secrets = new HashSet<>();
        secrets.add(0);
        secrets.add(firstPerson);
        
        Map<Integer,Map<Integer,List<Integer>>> graph = new HashMap<>();
        
        for(int[] meet : meetings){
            Map<Integer,List<Integer>> curr = graph.getOrDefault( meet[2], new HashMap<>() );
            List<Integer> list1 = curr.getOrDefault(meet[0], new ArrayList<>());
            List<Integer> list2 = curr.getOrDefault(meet[1], new ArrayList<>());
            
            list1.add(meet[1]);
            list2.add(meet[0]);
            curr.put(meet[0],list1);
            curr.put(meet[1],list2);
            graph.put( meet[2], curr );
        }
        
        Set<Integer> temp = graph.keySet();
        List<Integer> sortedTime = new ArrayList<>(temp);
        Collections.sort(sortedTime);
        // Collections.sort(sortedTime);
        
        for(int time : sortedTime){
            // System.out.println(time);
            Set<Integer> visited = new HashSet<>();
            Map<Integer,List<Integer>> curr = graph.get(time);
            for( Map.Entry<Integer,List<Integer>> entry : curr.entrySet() ){
                int src = entry.getKey();
                if( secrets.contains(src) ) helper(src, curr, visited,secrets);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int secret : secrets) res.add(secret);
        
        return res;
    }
    
    public void helper(int src, Map<Integer,List<Integer>> adj, Set<Integer> visited, Set<Integer> secrets){
        if( visited.contains(src) ) return;
        
        visited.add(src);
        secrets.add(src);
        
        // helper( adj.get(src), adj,visited,secrets );
        for(int neighbor : adj.get(src)){
            helper(neighbor, adj,visited,secrets);
        }
    }
}