class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                
                // 왼쪽 끝 요소
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                }
                // 오른쪽 끝 요소
                else if (j == i) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                }
                // 중간 요소
                else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }

        // 마지막 행에서 최댓값 찾기
        int answer = 0;
        for (int num : triangle[n - 1]) {
            answer = Math.max(answer, num);
        }

        return answer;
    }
}
