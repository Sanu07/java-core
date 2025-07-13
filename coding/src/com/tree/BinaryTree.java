package com.tree;

import java.sql.Array;
import java.util.*;

public class BinaryTree {

    public static void main(String[] args) {
        Node node = TreeUtil.createTree(1);
        BinaryTree binaryTree = new BinaryTree();

        System.out.println("***** PRE-ORDER *****");
        binaryTree.preOrder(node);
        System.out.println("\n");

        System.out.println("***** IN-ORDER *****");
        binaryTree.inOrder(node);
        System.out.println("\n");

        System.out.println("***** POST-ORDER *****");
        binaryTree.postOrder(node);
        System.out.println("\n");

        System.out.println("***** LEVEL-ORDER *****");
        binaryTree.levelOrder(node);
        System.out.println("\n");

        System.out.println("***** HEIGHT *****");
        int height = binaryTree.height(node);
        System.out.println(height);
        System.out.println("\n");

        System.out.println("***** SIZE *****");
        int size = binaryTree.size(node);
        System.out.println(size);
        System.out.println("\n");

        System.out.println("***** DIAMETER *****");
        int diameter = binaryTree.diameter(node);
        System.out.println(diameter);
        System.out.println("\n");

        // useful for zigzag and different types of processing
        System.out.println("***** LEVEL - ORDER WITH LEVEL and ELEMENTS LIST *****");
        binaryTree.levelOrderWithLevelAndElements(node);
        System.out.println("\n");

        System.out.println("***** LEFT-VIEW *****");
        binaryTree.printLeftView(node);
        System.out.println("\n");

        System.out.println("***** RIGHT-VIEW *****");
        binaryTree.printRightView(node);
        System.out.println("\n");

        System.out.println("***** TOP-VIEW *****");
        binaryTree.topView(node);
        System.out.println("\n");

        System.out.println("***** BOTTOM-VIEW *****");
        binaryTree.bottomView(node);
        System.out.println("\n");

        System.out.println("***** LOWEST COMMON ANCESTOR *****");
        Node lca = binaryTree.lca(node, 4, 1);
        System.out.println(lca.data);
        System.out.println("\n");

        System.out.println("***** LOWEST COMMON ANCESTOR2 *****");
        Node lca2 = binaryTree.lowestCommonAncestor(node, 4, 1);
        System.out.println(lca2.data);
        System.out.println("\n");

        System.out.println("***** INVERT BT Alternate *****");
        Node node2 = TreeUtil.createTree(1);
        binaryTree.invertBTAlternate(node2.left, node2.right, true);
        binaryTree.levelOrderWithLevelAndElements(node2);
        System.out.println("\n");

        System.out.println("***** ALL PATHS FROM NODE TO LEAF *****");
        binaryTree.allPathsFromNodeToLeaf(node);
        System.out.println("\n");

        System.out.println("***** PRINT DIAGONAL *****");
        Map<Integer, List<Integer>> diagonals = new TreeMap<>();
        binaryTree.printDiagonal(node, diagonals, 0);
        diagonals.forEach((k, v) -> System.out.print(v));
        System.out.println("\n");

        System.out.println("***** Invert BT *****");
        Node node3 = TreeUtil.createTree(1);
        binaryTree.levelOrderWithLevelAndElements(node3);
        System.out.println("\n");
        binaryTree.invertBT(node3);
        binaryTree.levelOrderWithLevelAndElements(node3);
        System.out.println("\n");
    }

    /**
     *                      1
     *                    /  \
     *                   2    3
     *                 /  \
     *                4    5
     *
     */

    /**
     * PRE - ORDER traversal
     */
    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * IN - ORDER traversal
     */
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    /**
     * POST - ORDER traversal
     */
    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    private void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = size(root.left);
        int rh = size(root.right);
        return lh + rh + 1;
    }

    private int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int dl = diameter(root.left);
        int dr = diameter(root.right);
        int height = height(root.left) + height(root.right) + 1;
        return Math.max(height, Math.max(dl, dr));
    }

    private int diameterRecur(Node root, int[] res) {

        // Base case: tree is empty
        if (root == null)
            return 0;

        // find the height of left and right subtree
        // (it will also find of diameter for left
        // and right subtree).
        int lHeight = diameterRecur(root.left, res);
        int rHeight = diameterRecur(root.right, res);

        // Check if diameter of root is greater
        // than res.
        res[0] = Math.max(res[0], lHeight + rHeight);

        // return the height of current subtree.
        return 1 + Math.max(lHeight, rHeight);
    }

    private void levelOrderWithLevelAndElements(Node root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        levelOrderUtil(root, map, 0);
        map.forEach((key, value) -> System.out.print(value + " "));
    }

    private void levelOrderUtil(Node root, Map<Integer, List<Integer>> map, int level) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.data);
        levelOrderUtil(root.left, map, level + 1);
        levelOrderUtil(root.right, map, level + 1);
    }

    private void printLeftView(Node root) {
        List<Node> list = new ArrayList<>();
        printLeftViewUtil(root, list, 0);
        list.forEach(e -> System.out.print(e.data + " "));
    }

    private void printLeftViewUtil(Node root, List<Node> list, int level) {
        if (root == null) {
            return;
        }
        if (list.size() <= level) {
            list.add(root);
        }
        printLeftViewUtil(root.left, list, level + 1);
        printLeftViewUtil(root.right, list, level + 1);
    }

    private void printRightView(Node root) {
        List<Node> list = new ArrayList<>();
        printRightViewUtil(root, list, 0);
        list.forEach(e -> System.out.print(e.data + " "));
    }

    private void printRightViewUtil(Node root, List<Node> list, int level) {
        if (root == null) {
            return;
        }
        if (list.size() <= level) {
            list.add(root);
        }
        printRightViewUtil(root.right, list, level + 1);
        printRightViewUtil(root.left, list, level + 1);
    }

    private void topView(Node root) {
        if (root == null) {
            return;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<PairHd> q = new ArrayDeque<>();
        q.add(new PairHd(0, root));
        while (!q.isEmpty()) {
            PairHd pair = q.poll();
            if (!map.containsKey(pair.hd)) {
                map.put(pair.hd, pair.node.data);
            }

            if (pair.node.left != null) {
                q.add(new PairHd(pair.hd - 1, pair.node.left));
            }
            if (pair.node.right != null) {
                q.add(new PairHd(pair.hd + 1, pair.node.right));
            }
        }
        map.forEach((k, v) -> System.out.print(v + " "));
    }

    private void bottomView(Node root) {
        if (root == null) {
            return;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<PairHd> q = new ArrayDeque<>();
        q.add(new PairHd(0, root));
        while (!q.isEmpty()) {
            PairHd pair = q.poll();
            map.put(pair.hd, pair.node.data);

            if (pair.node.left != null) {
                q.add(new PairHd(pair.hd - 1, pair.node.left));
            }
            if (pair.node.right != null) {
                q.add(new PairHd(pair.hd + 1, pair.node.right));
            }
        }
        map.forEach((k, v) -> System.out.print(v + " "));
    }

    /**
     * here we are return any pf the below 3 values
     * 1. null when does not match
     * 2. left when left matches (i.e got null from right)
     * 3. right when right matches (i.e got null from left)
     * @param root
     * @param n1
     * @param n2
     * @return
     */
    private Node lca(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    private void invertBTAlternate(Node x, Node y, boolean level) {
        if (x == null || y == null) {
            return;
        }
        if (level) {
            int temp = x.data;
            x.data = y.data;
            y.data = temp;
        }
        invertBTAlternate(x.left, y.right, !level);
        invertBTAlternate(x.right, y.left, !level);
    }

    private void allPathsFromNodeToLeaf(Node root) {
        allPathsFromNodeToLeafUtil(root, new ArrayDeque<>());
    }

    private void allPathsFromNodeToLeafUtil(Node root, Deque<Integer> queue) {
        if (root == null) {
            return;
        }
        queue.addLast(root.data);
        if (root.left == null && root.right == null) {
            System.out.print(queue);
        }
        allPathsFromNodeToLeafUtil(root.left, queue);
        allPathsFromNodeToLeafUtil(root.right, queue);
        queue.removeLast();
    }

    private void printDiagonal(Node root, Map<Integer, List<Integer>> map, int diagonal) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(diagonal, new ArrayList<>());
        map.get(diagonal).add(root.data);
        printDiagonal(root.left, map, diagonal + 1);
        printDiagonal(root.right, map, diagonal);
    }

    private static class PairHd {
        int hd;
        Node node;
        public PairHd(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    private static class PairLevel {
        int level;
        Node node;
        public PairLevel(int hd, Node node) {
            this.level = hd;
            this.node = node;
        }
    }


    private Node invertBT(Node root) {
        if (root == null) {
            return null;
        }
        Node temp = root.left;
        root.left = invertBT(root.right);
        root.right = invertBT(temp);
        return root;
    }

    public Node lowestCommonAncestor(Node root, int p, int q) {
        if (root == null) return null;

        // Step 1: BFS to build parent map and find nodes with values p and q
        Map<Node, Node> parent = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node nodeP = null, nodeQ = null;

        parent.put(root, null);
        queue.offer(root);

        while (!queue.isEmpty() && (nodeP == null || nodeQ == null)) {
            Node node = queue.poll();

            if (node.data == p) nodeP = node;
            if (node.data == q) nodeQ = node;

            if (node.left != null) {
                parent.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                queue.offer(node.right);
            }
        }

        if (nodeP == null || nodeQ == null) return null; // One or both values not found

        // Step 2: Build ancestor set from nodeP
        Set<Node> ancestors = new HashSet<>();
        while (nodeP != null) {
            ancestors.add(nodeP);
            nodeP = parent.get(nodeP);
        }

        // Step 3: Walk from nodeQ upwards to find the first common ancestor
        while (!ancestors.contains(nodeQ)) {
            nodeQ = parent.get(nodeQ);
        }

        return nodeQ;
    }

    public HierarchyNode lowestCommonAncestorWithMultipleChildren(HierarchyNode root, int p, int q) {
        if (root == null) return null;

        Map<HierarchyNode, HierarchyNode> parentMap = new HashMap<>();
        Queue<HierarchyNode> queue = new LinkedList<>();

        HierarchyNode nodeP = null, nodeQ = null;

        parentMap.put(root, null);
        queue.offer(root);

        while (!queue.isEmpty() && (nodeP == null || nodeQ == null)) {
            HierarchyNode node = queue.poll();

            if (node.data == p) nodeP = node;
            if (node.data == q) nodeQ = node;

            for (HierarchyNode child : node.children) {
                parentMap.put(child, node);
                queue.offer(child);
            }
        }

        if (nodeP == null || nodeQ == null) return null;

        // Build ancestor set from nodeP
        Set<HierarchyNode> ancestors = new HashSet<>();
        while (nodeP != null) {
            ancestors.add(nodeP);
            nodeP = parentMap.get(nodeP);
        }

        // Walk up from nodeQ to find the common ancestor
        while (!ancestors.contains(nodeQ)) {
            nodeQ = parentMap.get(nodeQ);
        }

        return nodeQ;
    }

    public static class HierarchyNode {
        int data;
        List<HierarchyNode> children;

        public HierarchyNode(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
}
