import BST.BinarySearchTree;
import Node.Node;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        BinarySearchTree bst = new BinarySearchTree();
        // Node node = new Node(50, 3.13);
        // System.out.println(node.left);
        
        int[] arr = { 50, 56, 25, 89, 14, 74, 19, 22, 41, 86 };
        // int[] arr = { 50, 75, 87 };
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i], random.nextDouble(-5.0, 10.0));
        }
        
        System.out.println("Tree:");
        bst.traversePreOrder(bst.getRoot());
        bst.delete(bst.getRoot().getLeft());
        System.out.println("Tree:");
        bst.traversePreOrder(bst.getRoot());
        
        // bst.findSuccessor(bst.getRoot()).visit();
        
        // bst.findParent(bst.getRoot(), bst.getRoot().getKey()).visit();
        
        // int res = bst.findMaximum(bst.root);
        // System.out.println(res);
        
        // System.out.println(bst.calcDepth(bst.root));
        
        // Node foundParent = bst.findParent(bst.root, 41);
        // if (foundParent == null) {
        //     System.out.println("null");
        // } else {
        //     foundParent.visit();
        // }
        
        
        // bst.find(bst.root, 41).visit();
        
        // System.out.println(bst.hasOneOfChildrenThisKey(bst.root, 25));
        
        // bst.insert(50, 2.12);
        // bst.insert(25, 2.13);
    }
}
