// 백준 13549 숨바꼭질 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n == k) {
            System.out.println(0);
            return;
        }

        Deque<Node> dq = new LinkedList<>();

        int[] nodes = new int[200001];
        Arrays.fill(nodes, Integer.MAX_VALUE);

        dq.add(new Node(n, 0));

        while(!dq.isEmpty()) {
            Node currentNode = dq.pollFirst();

            if(currentNode.node * 2 <= 200000 && currentNode.cost < nodes[currentNode.node * 2]) {
                dq.addLast(new Node(currentNode.node * 2, currentNode.cost));
                nodes[currentNode.node * 2] = currentNode.cost;
            }

            if(0 < currentNode.node && currentNode.cost + 1 < nodes[currentNode.node - 1]) {
                dq.addFirst(new Node(currentNode.node - 1, currentNode.cost + 1));
                nodes[currentNode.node - 1] = currentNode.cost + 1;
            }

            if(currentNode.node < 200000 && currentNode.cost + 1 < nodes[currentNode.node + 1]) {
                dq.addFirst(new Node(currentNode.node + 1, currentNode.cost + 1));
                nodes[currentNode.node + 1] = currentNode.cost + 1;
            }
        }

        System.out.println(nodes[k]);
    }
}
