//package test;
//
//import java.util.*;
//
//public class Test {
//
//    /**
//     *
//     *              Company
//     *
//     *           /           \
//     *
//     *         HR               Engg
//     *
//     *       /   \          /          \
//     *
//     *      Mona  Springs  BE          FE
//     *
//     *                     /  \        / \
//     *
//     *                   Alice Bob  Lisa Marley
//     *
//     * company -> HR -> Mona
//     * company -> Engg -> BE -> Bob
//     * company -> FE -> Lisa
//     *
//     *
//     * Node -> key value index
//     *
//     *
//     *
//     *
//     *
//     *
//     *
//     *
//     *
//     * @param args
//     */
//
//
//
//
//    public static void main(String[] args) {
//        Node alice = new Node("Alice");
//        Node bob = new Node("Bob");
//
//        Node BE = new Node("BE");
//        BE.nodes = new Node[2];
//        BE.nodes[0] = alice;
//        BE.nodes[1] = bob;
//
//        traverseNodes(BE);
//    }
//
//    private static void traverseNodes(Node root) {
//
//        Map<String, List<Node>> map = new HashMap<>();
//
//        // Map -> BE -> Alice, Bob
//
//
//
//        Queue<Node> queue = new ArrayDeque<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            Node curr = queue.poll();
//
//            int size = curr.nodes.length;
//            int index = 0;
//
//            while (index < size) {
//                map.putIfAbsent(curr.val, new ArrayList<>());
//                List<Node> nodes = map.get(curr.val);
//                nodes.add(curr.nodes[index]);
//                map.put(root.val, nodes);
//                index++;
//                if (curr.nodes[index] != null) {
//                    queue.add(curr.nodes[index]);
//                }
//            }
//        }
//
//        String searchString = "Mona";
//        if (root != null && root.val.equals(searchString)) {
//            System.out.println(root);
//        }
//
//        for (int i = 0; i < root.nodes.length; i++) {
//
//        }
//
//
//        // map -> BE -> {Alice, Bob}
//
//    }
//
//    static Node search(List<List<String>> nodes) {
//        if (root != null && root.val.equals(searchString)) {
//            System.out.println(root);
//        }
//
//        for (int i = 0; i < root.nodes.length; i++) {
//
//        }
//    }
//
//
//
//
//    static class Node {
//        Node[] nodes;
//        String val;
//
//        public Node(String val) {
//            this.val = val;
//        }
//    }
//}
