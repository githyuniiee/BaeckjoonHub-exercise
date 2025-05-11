import java.util.*;

class Solution {

    // 방향 벡터: ↑ ↗ → ↘ ↓ ↙ ← ↖ (8방향)
    static final int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Vertex {
        public final int y;
        public final int x;
        public final String id;
        public final Set<String> connectedVertices;

        public Vertex(int y, int x){
            this.y = y;
            this.x = x;
            this.id = id(y, x);
            this.connectedVertices = new HashSet<>();
        }

        public static String id(int y, int x){
            return String.format("(%d, %d)", y, x);
        }
    }

    public int solution(int[] arrows) {
        int answer = 0;
        Map<String, Vertex> vertices = new HashMap<>();
        Vertex v = new Vertex(0, 0);
        vertices.put(v.id, v);

        for (int d : arrows) {
            // 교차점 처리를 위해 한 칸씩 두 번 이동
            for (int i = 0; i < 2; ++i) {
                int ny = v.y + dy[d];
                int nx = v.x + dx[d];
                String id = Vertex.id(ny, nx);

                // 새로운 정점이면 추가
                if (!vertices.containsKey(id)) {
                    vertices.put(id, new Vertex(ny, nx));
                } 
                // 이미 방문한 정점인데, 현재 정점과 연결된 적 없으면 방 생성
                else if (!v.connectedVertices.contains(id)) {
                    ++answer;
                }

                // 양방향 연결
                Vertex u = vertices.get(id);
                v.connectedVertices.add(u.id);
                u.connectedVertices.add(v.id);

                // 다음 이동을 위해 현재 위치 갱신
                v = vertices.get(id);
            }
        }

        return answer;
    }
}
