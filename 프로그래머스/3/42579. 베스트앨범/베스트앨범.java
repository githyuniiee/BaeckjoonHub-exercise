import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> num = new HashMap<>(); // 장르별 총 재생 수
        Map<String, HashMap<Integer, Integer>> music = new HashMap<>(); // 장르별 (고유번호, 재생수)
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            num.put(genre, num.getOrDefault(genre, 0) + play);
            
            HashMap<Integer, Integer> songMap = music.getOrDefault(genre, new HashMap<>());
            songMap.put(i, play);
            music.put(genre, songMap);
        }

        // 장르를 재생 수 내림차순으로 정렬
        List<String> keySet = new ArrayList<>(num.keySet());
        Collections.sort(keySet, (o1, o2) -> num.get(o2) - num.get(o1));
        
        for (String key : keySet) {
            HashMap<Integer, Integer> songMap = music.get(key);
            List<Integer> songList = new ArrayList<>(songMap.keySet());

            // 해당 장르의 곡들을 재생 수 기준으로 정렬
            Collections.sort(songList, (a, b) -> songMap.get(b) - songMap.get(a));
            
            answer.add(songList.get(0)); // 가장 많이 재생된 곡
            if (songList.size() > 1) {
                answer.add(songList.get(1)); // 두 번째로 많이 재생된 곡 (있다면)
            }
        }
        
        // ArrayList를 int 배열로 변환 (스트림 없이)
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}
