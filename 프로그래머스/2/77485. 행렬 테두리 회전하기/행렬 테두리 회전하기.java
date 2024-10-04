class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        // 배열 초기화 (1-based indexing 사용)
        int[][] arr = new int[rows + 1][columns + 1];
        int value = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = value++;
            }
        }
        
        // 각 쿼리별로 배열 회전 처리
        for (int i = 0; i < queries.length; i++) {
            // 쿼리 값 불러오기 (1-based)
            int y1 = queries[i][0];
            int x1 = queries[i][1];
            int y2 = queries[i][2];
            int x2 = queries[i][3];
            
            // 첫 번째 값을 저장하고 최소값으로 초기화
            int firstNum = arr[y1][x2];
            int min = firstNum;
            
            // 1. 상단을 우측으로 이동
            for (int j = x2 - 1; j >= x1; j--) {
                min = Math.min(min, arr[y1][j]);
                arr[y1][j + 1] = arr[y1][j];
            }
            
            // 2. 좌측을 위로 이동
            for (int j = y1 + 1; j <= y2; j++) {
                min = Math.min(min, arr[j][x1]);
                arr[j - 1][x1] = arr[j][x1];
            }
            
            // 3. 하단을 좌측으로 이동
            for (int j = x1 + 1; j <= x2; j++) {
                min = Math.min(min, arr[y2][j]);
                arr[y2][j - 1] = arr[y2][j];
            }
            
            // 4. 우측을 아래로 이동
            for (int j = y2 - 1; j >= y1; j--) {
                min = Math.min(min, arr[j][x2]);
                arr[j + 1][x2] = arr[j][x2];
            }

            // 첫 번째 값을 복구
            arr[y1 + 1][x2] = firstNum;
            
            // 최소값을 정답 배열에 저장
            answer[i] = min;
        }
        
        return answer;
    }
}
