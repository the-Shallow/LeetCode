// { Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

  public class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();
            if (ob.isHeap(root))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}// } Driver Code Ends


// User Function template for JAVA

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    boolean isHeap(Node tree) {
        int numNodes = countNodes(tree);
        
        return isComplete( tree , 0 ,numNodes ) && isHeapTree(tree,null);
    }
    
    int countNodes(Node root){
        if(root == null) return 0;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    boolean isComplete( Node curr , int index , int numNodes ){
        if(curr == null ) return true;
        
        if( index >= numNodes ) return false;
        
        return isComplete(curr.left , 2 * index + 1 , numNodes ) 
        && isComplete(curr.right, 2 * index + 2 , numNodes );
    }
    
    
    boolean isHeapTree(Node curr , Node prev ){
        if(curr == null) return true;
        
        if(prev != null && curr.data > prev.data ) return false;
        
        if( curr.left == null && curr.right != null ) return false;
        
        if( curr.left != null && curr.right == null ) return true;
        
        boolean isLeft = isHeapTree(curr.left,curr);
        boolean isRight = isHeapTree(curr.right,curr);
        
        return isLeft && isRight;
    }
}