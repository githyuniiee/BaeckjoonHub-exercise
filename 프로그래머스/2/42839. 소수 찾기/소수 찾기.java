import java.util.*;

class Solution {
    
    static HashSet<Integer> set = new HashSet<>();
    
    static void recursive(String comb, String others){
        //1.현재 조합 set에 추가
        if(!comb.equals("")){
            set.add(Integer.parseInt(comb));
        }
   
        //2. 남은 숫자 중 하나 더해서 새로운 조합
        for(int i=0; i<others.length(); i++){
            recursive(comb + others.charAt(i), others.substring(0,i) + others.substring(i+1));
        }
       
    }
    
    static boolean isPrime(int num){
        if(num == 0 || num == 1) return false;
        
        int limit = (int)Math.sqrt(num);
        
        for(int i=2; i<=limit; i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
    
    public int solution(String numbers) {
        int count = 0;
        
        //모든 조합 수 만들기
        recursive("", numbers);
        //소수 개수 세기
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            int number = it.next();
            if(isPrime(number)){
                count++;
            }
        }
        
        //소수 개수 반환
        return count;
    }

}