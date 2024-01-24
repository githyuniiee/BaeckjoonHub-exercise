import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        //문자열 배열
        String[] arr = new String[numbers.length];
        
        //int -> String
        for(int i=0; i<numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        //내림차순 정렬
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });
        
        //0값이 중복될 경우
        if(arr[0].equals("0")) return "0";
        
        //이 아니면
        for(String s: arr) answer += s;
        
        return answer;
        
    }
}