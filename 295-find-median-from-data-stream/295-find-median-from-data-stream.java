// Space Complexity = O(N)
// addNum Time Complexity = O(logn)
// findMedian Time Complexity = O(1)
class MedianFinder {
    double median;
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>( (a,b) -> b - a );
        minHeap = new PriorityQueue<>( (a,b) -> a - b );
        
        median = Double.MAX_VALUE;
    }
    
    public void addNum(int num) {
        if( num < median ){
            maxHeap.offer( num );
            
            if( maxHeap.size() - minHeap.size() > 1 ){
                int val = maxHeap.poll();
                minHeap.offer(val);
            }
        }else {
            minHeap.offer(num);
            
            if( minHeap.size() - maxHeap.size() > 1 ){
                int val = minHeap.poll();
                maxHeap.offer(val);
            }
        }
        
        median = ( maxHeap.size() == minHeap.size() ) ? ( minHeap.peek() + maxHeap.peek() ) / 2.0 : ( maxHeap.size() > minHeap.size() ) ? maxHeap.peek() : minHeap.peek() ;
    }
    
    public double findMedian() {
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */