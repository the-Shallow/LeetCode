class Solution {
    
    class Pair {
        int endTime;
        int roomNumber;
        
        public Pair(int endTime, int roomNumber){
            this.endTime = endTime;
            this.roomNumber = roomNumber;
        }
    }
    
    
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->a[0] - b[0]);
        
        PriorityQueue<Integer> available = new PriorityQueue<>();
        
        
        PriorityQueue<Pair> used = new PriorityQueue<>( (a,b) -> a.endTime != b.endTime ? a.endTime - b.endTime : a.roomNumber - b.roomNumber );
        
        int[] count = new int[n];
        
        
        for(int i = 0;i<n;i++) available.add(i);
        
        for(int i = 0;i<meetings.length;i++){
            int start = meetings[i][0];
            int end = meetings[i][1];
            
            while( used.size() > 0 && start >= used.peek().endTime ){
                Pair finishedMeet = used.poll();
                
                available.add( finishedMeet.roomNumber );
            }
            
            if(available.size() == 0){
                Pair forceFinishedMeet = used.poll();
                end = forceFinishedMeet.endTime + ( end - start );
                available.add(forceFinishedMeet.roomNumber);
            }
            
            int room = available.poll();
            
            used.add( new Pair(end, room) );
            count[room]++;
        }
        
        int max = -1;
        int res = -1;
        for(int i = n-1;i>=0;i--){
            if(count[i] >= max){
                max = count[i];
                res = i;
            }
            // System.out.println(i + " " + res + " " + max);
        }
        
        return res;
    }
}