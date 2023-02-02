//[인증평가(5차) 기출] 업무 처리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        Queue<Integer> leftWorks = new LinkedList<>();
        Queue<Integer> rightWorks = new LinkedList<>();

        /* return root */
        public static Node[] makeBinaryTree(int depth){
            Node[] nodes = new Node[(int) Math.pow(2, depth) + 1];

            for(int i = 0 ; i < nodes.length ; i++) {
                nodes[i] = new Node();
            }
            return nodes;
        }
    }

    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken()); // depth
        int k = Integer.parseInt(st.nextToken()); // leaf works
        int r = Integer.parseInt(st.nextToken()); // works day

        Node[] tree = Node.makeBinaryTree(h);
        for(int i = 0 ; i < 2 * h ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < k ; j++){
                int ab = Integer.parseInt(st.nextToken());
                tree[(int) Math.pow(2, h - 1) + i].leftWorks.offer(ab);
            }
        }

        // 업무
        for(int i = 0 ; i < r ; i++){
            boolean isOdd = ((i + 1) % 2 == 1);

            if(isOdd && !tree[0].leftWorks.isEmpty())
                answer += tree[0].leftWorks.poll();
            else if(!tree[0].rightWorks.isEmpty())
                answer += tree[0].rightWorks.poll();

            for(int j = 1 ; j < tree.length ; j++){
                int parent = (j - 1) / 2;
                if(j == tree.length - 1){
                    if(j % 2 == 1)
                        tree[parent].leftWorks.offer(tree[j].leftWorks.poll());
                    else
                        tree[parent].rightWorks.offer(tree[j].leftWorks.poll());
                }
                else if(isOdd && !tree[j].leftWorks.isEmpty()){
                    if(j % 2 == 1)
                        tree[parent].leftWorks.offer(tree[j].leftWorks.poll());
                    else
                        tree[parent].rightWorks.offer(tree[j].leftWorks.poll());
                }
                else if(!tree[j].rightWorks.isEmpty()){
                    if(j % 2 == 1)
                        tree[parent].leftWorks.offer(tree[j].rightWorks.poll());
                    else
                        tree[parent].rightWorks.offer(tree[j].rightWorks.poll());
                }
            }
        }

        System.out.println(answer);
    }
}
