public class BinaryTree<V extends Comparable<V>> {
    private Node root;

    private class Node {
        private int value;
        private Node left;
        private Node right;
    }

    private boolean seek(Node node, int value) {
        if (node.value == value) {
            return true;
        } else {
            if (value < node.value) {
                seek(node.left, value);
            }else if(value> node.value){
                seek(node.right, value);
            }
        }
        return false;
    }
}
