class Solution {
    
    class Node {
        int end;
        int cost;
        int k;
        
        public Node(int end, int cost, int k){
            this.end = end;
            this.cost = cost;
            this.k = k;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<Node>> graph = new HashMap<>();
        initialize(graph,flights);
        
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int[] cost = new int[n];
        for(int i = 0;i<n;i++) cost[i] = Integer.MAX_VALUE;
        Node start = new Node(src,0,0);
        
        queue.add(start);
        cost[src] = 0;
        int res = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            // System.out.println( curr.end + " " + curr.cost + " " + curr.k );
            if(curr.end == dst && curr.k-1 <= k) res = Math.min( res, curr.cost );
            if(curr.k > k) continue;
            List<Node> neighbors = graph.get(curr.end);
            
            
            if(neighbors == null) continue;
            for(Node neighbor : neighbors ){
                // String str = neighbor
                // if( visited.contains(neighbor.end ) ) continue;
                if( cost[neighbor.end] < curr.cost + neighbor.cost  ) continue;
                cost[neighbor.end] = curr.cost + neighbor.cost;
                Node newNode = new Node( neighbor.end, curr.cost + neighbor.cost, curr.k + 1 );
                // System.out.println( newNode.end + " " + newNode.cost + " " + newNode.k );
                // visited.add(neighbor.end);
                queue.add(newNode);
            }
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    public void initialize(Map<Integer,List<Node>> graph, int[][] flights){
        for(int[] flight : flights){
            int start = flight[0];
            int end = flight[1];
            int cost = flight[2];
            
            Node curr = new Node(end,cost,0);
           
            List<Node> list = graph.getOrDefault(start,new ArrayList<Node>());
            list.add(curr);
            
            graph.put(start,list);
        }
    }
}