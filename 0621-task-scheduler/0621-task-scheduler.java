class Solution {
    
    class Pair {
        int task;
        int time;
        
        public Pair(int task, int time){
            this.task = task;
            this.time = time;
        }
    }
    
    public int leastInterval(char[] tasks, int n) {
        Arrays.sort(tasks);
        
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        
        int count = 1;
        for(int i = 1;i<tasks.length;i++){
            char ch = tasks[i];
            
            if(ch == tasks[i-1]){
                count++;
            }else {
                maxHeap.add(count);
                count = 1;
            }
        }
        
        maxHeap.add(count);
        
        Queue<Pair> queue = new PriorityQueue<Pair>((a,b)->a.time-b.time);
        
        int time = 0;
        
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            
            while( !queue.isEmpty() &&  queue.peek().time == time ){
                Pair curr = queue.poll();
                maxHeap.offer(curr.task);
            }
            
            if(!maxHeap.isEmpty()){
                int max = maxHeap.poll();
                // System.out.println(max);
                int remainTimetoComeback = time + n + 1;
                if(max-1 != 0) queue.offer(new Pair(max-1,remainTimetoComeback) );
            }
            time++;
        }
        
        return time;
    }
     
}