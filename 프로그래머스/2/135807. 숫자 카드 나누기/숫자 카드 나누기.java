class Solution {
    private int gcd(int a, int b) {
        if (b == 0) {
            return a; // b가 0이면 a가 최대공약수
        }
        return gcd(b, a % b); // 유클리드 알고리즘
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        // arrayA와 arrayB의 최대공약수를 구합니다.
        int g1 = arrayA[0];
        int g2 = arrayB[0];

        // arrayA의 최대공약수 계산
        for (int i = 1; i < arrayA.length; i++) {
            g1 = gcd(g1, arrayA[i]);
        }

        // arrayB의 최대공약수 계산
        for (int i = 1; i < arrayB.length; i++) {
            g2 = gcd(g2, arrayB[i]);
        }

        // arrayB가 g1으로 나눠지는지 확인
        if (g1 != 0) {
            for (int i = 0; i < arrayB.length; i++) {
                if (arrayB[i] % g1 == 0) {
                    g1 = 0; // g1이 arrayB의 요소를 나눌 수 있으면 0으로 설정
                    break;
                }
            }
        }

        // arrayA가 g2로 나눠지는지 확인
        if (g2 != 0) {
            for (int i = 0; i < arrayA.length; i++) {
                if (arrayA[i] % g2 == 0) {
                    g2 = 0; // g2가 arrayA의 요소를 나눌 수 있으면 0으로 설정
                    break;
                }
            }
        }

        // g1과 g2 중 큰 값을 반환, 둘 다 0이면 0을 반환
        if (g1 != 0 && g2 != 0) {
            return Math.max(g1, g2);
        } else if (g1 != 0) {
            return g1;
        } else if (g2 != 0) {
            return g2;
        }

        return 0;
    }
}
