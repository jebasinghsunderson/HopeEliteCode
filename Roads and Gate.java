//https://atcoder.jp/contests/abc463/submissions/77714013
// At coder E sum
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        long Y = sc.nextLong();
        int G1 = N + 1, G2 = N + 2;
        int[] gate_time = new int[N + 2];
        List<long[]>[] graph = new ArrayList[N + 3];
        for (int i = 0; i < N + 3; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), t = sc.nextInt();
            graph[u].add(new long[]{v, t});
            graph[v].add(new long[]{u, t});
        }

        for (int i = 1; i <= N; i++) {
            gate_time[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            graph[i].add(new long[]{G1, gate_time[i]});
            graph[G2].add(new long[]{i, gate_time[i]});
        }
        graph[G1].add(new long[]{G2, Y});
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        q.add(new long[]{1, 0});

        long[] dis = new long[N + 3];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[1] = 0;

        while (!q.isEmpty()) {
            long[] cur = q.poll();
            long v = cur[0], t = cur[1];
            if (t > dis[(int) v]) continue; // stale entry, skip
            for (long[] node : graph[(int)v]) {
                long nd = t + node[1];
                if (nd < dis[(int) node[0]]) {
                    dis[(int) node[0]] = nd;
                    q.offer(new long[]{node[0], nd});
                }
            }
        }
        for(int i= 2; i<=N; i++) {
            System.out.print(dis[i]+" ");
        }
    }
}

