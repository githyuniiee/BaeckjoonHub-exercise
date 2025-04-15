import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] players = new int[n];
            Map<Integer, Integer> countMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                players[i] = Integer.parseInt(st.nextToken());
                countMap.put(players[i], countMap.getOrDefault(players[i], 0) + 1);
            }

            Map<Integer, Integer> scoreMap = new HashMap<>();
            Map<Integer, Integer> fifthMap = new HashMap<>();
            Map<Integer, Integer> playerCount = new HashMap<>();

            int score = 1;
            for (int i = 0; i < n; i++) {
                int team = players[i];
                if (countMap.get(team) != 6) continue;

                int cnt = playerCount.getOrDefault(team, 0) + 1;
                playerCount.put(team, cnt);

                if (cnt <= 4) {
                    scoreMap.put(team, scoreMap.getOrDefault(team, 0) + score);
                } else if (cnt == 5) {
                    fifthMap.put(team, score);
                }
                score++;
            }

            int answer = 0;
            int minScore = Integer.MAX_VALUE;
            int minFifth = Integer.MAX_VALUE;

            for (int team : scoreMap.keySet()) {
                int teamScore = scoreMap.get(team);
                int fifthScore = fifthMap.get(team);

                if (teamScore < minScore || (teamScore == minScore && fifthScore < minFifth)) {
                    minScore = teamScore;
                    minFifth = fifthScore;
                    answer = team;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}
