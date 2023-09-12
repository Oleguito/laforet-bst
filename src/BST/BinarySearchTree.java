package BST;

import Node.Node;

public class BinarySearchTree {
    
    private Node root;
    
    public Node getRoot() {
        return root;
    }
    
    public void setRoot(Node root) {
        this.root = root;
    }
    
    public void insert(int key, double data) {
        if (root == null) { root = new Node(key, data); }
        else { insertHelper(root, key, data); }
    }
    
    /* Функция удаления узла из BST. Принимает в качестве параметра удаляемый узел.
       Сначала я считаю количество потомков данного узла и в зависимости от этого значения
       применяю разные алгоритмы удаления.
       В каждом из case-ов я проверяю сначала, является ли узел корневым и если да то выполняю одни действия
       либо если узел не корневой, то другие действия */
    public void delete(Node node) {
        int numChildren = 0;
        if (node.getLeft() != null) ++numChildren;
        if (node.getRight() != null) ++numChildren;
        /* Родитель удаляемого узла. Для root будет null */
        Node parent = findParent(root, node.getKey());
        switch (numChildren) {
            case 0:
                if(parent == null) {
                    setRoot(null);
                    break;
                }
                if (parent.getLeft().getKey() == node.getKey()) {
                    parent.setLeft(null);
                    break;
                } else if (parent.getRight().getKey() == node.getKey()) {
                    parent.setRight(null);
                    break;
                }
                break;
            case 1:
                if(parent == null) {
                    if (node.getLeft() != null) {
                        setRoot(node.getLeft());
                        break;
                    } else if (node.getRight() != null) {
                        setRoot(node.getRight());
                        break;
                    }
                    break;
                } else {
                    Node toAttach = node.getRight() == null ? node.getLeft() : node.getRight();
                        if (parent.getLeft() == node) {
                        parent.setLeft(toAttach);
                        break;
                    }
                    if (parent.getRight() == node) {
                        parent.setRight(toAttach);
                        break;
                    }
                }
                break;
            case 2:
                Node successor = findSuccessor(root);
                Node leftChild = node.getLeft();
                Node rightChild = node.getRight();
                if (parent == null) {
                    delete(successor);
                    root = successor;
                    root.setLeft(leftChild);
                    root.setRight(rightChild);
                    break;
                }
                delete(successor);
                node = successor;
                node.setLeft(leftChild);
                node.setRight(rightChild);
                break;
        }
    }
    
    public Node find(Node node, int key) {
        if (key > node.getKey()) {
            return find(node.getRight(), key);
        } else if (key < node.getKey()) {
            return find(node.getLeft(), key);
        } else if (key == node.getKey()) {
            return node;
        } else {
            return null;
        }
    }
    
    public int calcDepth(Node root) {
        if (root == null) { return 0; }
        root.visit();
        int leftDepth = calcDepth(root.getLeft());
        int rightDepth = calcDepth(root.getRight());
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    public void traverseInOrder(Node root) {
        if (root == null) { return; }
        traverseInOrder(root.getLeft());
        root.visit();
        traverseInOrder(root.getRight());
    }
    
    public void traversePreOrder(Node root) {
        if (root == null) { return; }
        root.visit();
        traverseInOrder(root.getLeft());
        traverseInOrder(root.getRight());
    }
    
    public void traversePostOrder(Node root) {
        if (root == null) { return; }
        traverseInOrder(root.getLeft());
        traverseInOrder(root.getRight());
        root.visit();
    }
    
    private void insertHelper(Node node, int key, double data) {
        if (key > node.getKey()) {
            if (node.getRight() != null) {
                insertHelper(node.getRight(), key, data);
            } else {
                node.setRight(new Node(key, data));
                return;
            }
        }
        if (key < node.getKey()) {
            if (node.getLeft() != null) {
                insertHelper(node.getLeft(), key, data);
            } else {
                node.setLeft(new Node(key, data));
                return;
            }
        }
    }

    public Node findParent(Node parent, int key) {
        if (parent == null) {
            return null;
        } else {
            if (hasOneOfChildrenThisKey(parent, key)) {
                return parent;
            } else {
                Node foundNode = findParent(parent.getLeft(), key);
                if (foundNode == null) {
                    foundNode = findParent(parent.getRight(), key);
                }
                return foundNode;
            }
        }
    }
    
    private boolean hasOneOfChildrenThisKey(Node node, int key) {
        if (node == null) { return false; }
        if (node.getLeft() != null) {
            if (node.getLeft().getKey() == key) { return true; }
        }
        if (node.getRight() != null) {
            if (node.getRight().getKey() == key) { return true; }
        }
        return false;
    }
    
    public int findMaximum(Node node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(node.getKey(), findMaximum(node.getRight()));
        }
    }
    
    public int findMinimum(Node node) {
        if (node == null) {
            return 0;
        } else {
            return Math.min(node.getKey(), findMinimum(node.getLeft()));
        }
    }
    
    public Node findSuccessor(Node parent) {
        return find(parent.getLeft(), findMaximum(parent.getLeft()));
    }
}
