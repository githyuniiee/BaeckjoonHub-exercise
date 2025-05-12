import java.util.*;

class Solution {

    static class File {
        String original;
        String head;
        int number;
        int index; // 입력 순서

        File(String original, String head, int number, int index) {
            this.original = original;
            this.head = head;
            this.number = number;
            this.index = index;
        }
    }

    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            String s = files[i];
            int headEnd = 0;
            while (headEnd < s.length() && !Character.isDigit(s.charAt(headEnd))) {
                headEnd++;
            }

            int numberEnd = headEnd;
            while (numberEnd < s.length() && Character.isDigit(s.charAt(numberEnd))) {
                numberEnd++;
                if (numberEnd - headEnd >= 5) break; // 숫자는 최대 5자리
            }

            String head = s.substring(0, headEnd);
            int number = Integer.parseInt(s.substring(headEnd, numberEnd));

            fileList.add(new File(s, head, number, i));
        }

        Collections.sort(fileList, (f1, f2) -> {
            int headCompare = f1.head.toLowerCase().compareTo(f2.head.toLowerCase());
            if (headCompare != 0) return headCompare;

            int numberCompare = Integer.compare(f1.number, f2.number);
            if (numberCompare != 0) return numberCompare;

            return Integer.compare(f1.index, f2.index); // 입력 순서 유지
        });

        String[] answer = new String[files.length];
        for (int i = 0; i < fileList.size(); i++) {
            answer[i] = fileList.get(i).original;
        }

        return answer;
    }
}
