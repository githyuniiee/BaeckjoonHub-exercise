import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int start,end,weight;
        Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //그래프 구현
        Edge[] edgeArr = new Edge[m + 1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            edgeArr[i] = new Edge(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        //최단거리배열 초기화
        long[] dist = new long[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        //최단거리 갱신
        for(int i=0; i< n - 1;i++){ //엣지 리스트 n-1 순회
            for (int j = 0; j < m; j++) {
                Edge edge = edgeArr[j];

                if(dist[edge.start] != Integer.MAX_VALUE
                && dist[edge.end] > dist[edge.start] + edge.weight){
                    dist[edge.end] = dist[edge.start] + edge.weight;
                }
            }
        }

        //음수사이클 유무 확인
        for (int j = 0; j < m; j++) {
            Edge edge = edgeArr[j];

            if (dist[edge.start] != Integer.MAX_VALUE
                    && dist[edge.end] > dist[edge.start] + edge.weight) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(dist[i] != Integer.MAX_VALUE ? dist[i] : -1).append("\n");
            // 갱신되지 않은 노드 = 시작점 1에서 해당 노드로 가는 경로가 없음
        }
        System.out.println(sb);









    }

}

