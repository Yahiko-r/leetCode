package other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 从大到小排序，然后按照顺序进行一个个按照k，放到合适的位置上
 */
public class QueueReconstruction {
    class Node implements Comparable<Node> {
        int height;
        int k;

        Node(int h, int k) {
            height = h;
            this.k = k;
        }

        @Override
        public int compareTo(Node o) {
            if (height == o.height) {
                return k - o.k;
            } else
                return o.height - height;
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        //
        Node[] nodes = new Node[people.length];
        for (int i = 0; i < people.length; i++) {
            nodes[i] = new Node(people[i][0], people[i][1]);


        }
        Arrays.sort(nodes);
        List<Node> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int k = nodes[i].k;
            /*for (int j = 0; j < nodes[i].k; j++) {

            }*/
            list.add(k,nodes[i]);
        }
        int[][] rs=new int[people.length][2];
        for(int i=0;i<list.size();i++){
            rs[i][0]=list.get(i).height;
            rs[i][1]=list.get(i).k;
        }
        return rs;
    }

    public static void main(String[] args) {
        QueueReconstruction q=new QueueReconstruction();
        int[][] people={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] ints = q.reconstructQueue(people);
        for(int i=0;i<ints.length;i++){
            System.out.print(ints[i][0]+" ");
            System.out.print(ints[i][1]);
            System.out.println(" ");
        }
    }
}
