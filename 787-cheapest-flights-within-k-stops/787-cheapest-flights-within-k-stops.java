class Solution {
    
    class Node {
        int point;
        int price;
        int steps;
        
        public Node(int point){
            this.point = point;
            this.price = 0;
            this.steps = -1;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<Node>> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        
        for( int[] flight : flights ){
            int start = flight[0];
            int end = flight[1];
            int price = flight[2];
            
            Node node = new Node(end);
            node.price = price;
            List<Node> temp = map.getOrDefault(start,new ArrayList<>());
            
            temp.add(node);
            
            map.put( start , temp );
        }
        
        Node initial = new Node(src);
        initial.steps = k+1;
        
        int[] cost = new int[n];
        
        for( int i = 0;i<n;i++ ){
            cost[i] = Integer.MAX_VALUE;
        }
        
        cost[src] = 0;
        queue.offer(initial);
        
        int res = Integer.MAX_VALUE;
        
        while( !queue.isEmpty() ){
            int size = queue.size();
            
            for( int i = 0;i<size;i++ ){
                Node curr = queue.poll();
                if(curr.point == dst && curr.steps >= 0) res = Math.min(res, curr.price);
                
                List<Node> temp = map.get(curr.point);
                if(temp == null) continue;
                
                for( Node neighbor : temp ){
                    if( cost[ neighbor.point ] > neighbor.price + curr.price  ){
                        cost[neighbor.point] = curr.price + neighbor.price;
                        Node newNode = new Node(neighbor.point);
                        newNode.price = cost[neighbor.point];
                        newNode.steps = curr.steps - 1;
                        queue.offer(newNode);
                    }
                }
            }
        }
        
        
        return res == Integer.MAX_VALUE ? -1 : res;
        
    }
}