class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] res = new int[deck.length];
        Arrays.sort(deck);
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0;i<deck.length;i++) queue.offer(i);
        
        for(int num : deck){
            int index = queue.poll();
            
            res[index] = num;
            
            if(!queue.isEmpty()) queue.offer(queue.poll());
        }
        
        return res;
    }
}