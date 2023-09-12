package Node;

public class Node {
    private int key;
    private double data;
    private Node left;
    private Node right;
    
    public int getKey() {
        return key;
    }
    
    public void setKey(int key) {
        this.key = key;
    }
    
    public double getData() {
        return data;
    }
    
    public void setData(double data) {
        this.data = data;
    }
    
    public Node getLeft() {
        return left;
    }
    
    public void setLeft(Node left) {
        this.left = left;
    }
    
    public Node getRight() {
        return right;
    }
    
    public void setRight(Node right) {
        this.right = right;
    }
    
    public Node(int key, double data) {
        this.key = key;
        this.data = data;
    }
    
    public void visit() {
        String leftKey = left == null ? "N/A" : String.valueOf(left.key);
        String rightKey = right == null ? "N/A" : String.valueOf(right.key);
        System.out.printf("Node with key %d\tdata\t%5.2f\tleft key:\t%s\t\tright key:\t%s\n", key, data, leftKey, rightKey);
    }
}
