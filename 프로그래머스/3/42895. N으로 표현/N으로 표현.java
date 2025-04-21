import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        List<Set<Integer>> list = new ArrayList<>();
        
        for(int i=0; i<=8; i++){
            list.add(new HashSet<>());
        }
        
        //초기화
        list.get(1).add(N);
        
        for(int i=2; i<=8; i++){
            
            Set<Integer> now = list.get(i);
            
            for(int j=1; j<=i; j++){
                
                Set<Integer> set1 = list.get(j);
                Set<Integer> set2 = list.get(i-j);
                
                for(int a : set1){
                    for(int b : set2){
                        now.add(a + b);
                        now.add(a - b);
                        now.add(a * b);
                        
                        if( a > 0 && b > 0){
                            now.add(a / b);
                        }
                    }
                }
            }
            
            now.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        
        for(int i=1; i<=8; i++){
            for(int a : list.get(i)){
                if(a == number){
                    return i;
                }
            }
        }
        
        
        
        
        return answer;
    }
}