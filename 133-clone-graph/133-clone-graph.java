// Space Complexity = O(n)
// Time Complexity = O(n)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Map<Integer,Node> map = new HashMap<>();
        
        return helper(node , map);
    }
    
    public Node helper( Node node , Map<Integer,Node> map ){
        if( map.containsKey(node.val) ) return map.get(node.val);
        
        Node copyNode = new Node(node.val);
        map.put( node.val,copyNode );
        
        for( Node neighbor : node.neighbors ){
            copyNode.neighbors.add( helper( neighbor , map ) );
        }
        
        return copyNode;
    }
}