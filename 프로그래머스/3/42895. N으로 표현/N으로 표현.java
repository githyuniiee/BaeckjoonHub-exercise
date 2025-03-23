import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number){
            return 1;
        }
        
        //가능한 숫자 집합 담을 리스트
        List<HashSet<Integer>> list = new ArrayList<>();
        for(int i=0; i<=8; i++){
            list.add(new HashSet<Integer>());
        }
        
        list.get(1).add(N); //숫자 1개만 쓸 때 -> 자기 자신
        
        //숫자 2개 쓸 때부터 탐색
        for(int i=2; i<=8; i++){
            
            //숫자 i개 썼을 때 들어갈 통
            HashSet<Integer> total = list.get(i);
            
            //이전 통들을 통한 경우의 수 찾기    
            for(int j=1; j<i; j++){
                HashSet<Integer> a = list.get(j);
                HashSet<Integer> b = list.get(i-j);
                
                for(int x : a){
                    for(int y : b){
                        total.add(x+y);
                        total.add(x-y);
                        total.add(x*y);
                        if(x!=0 && y!=0){
                            total.add(x/y);
                        }
                    }
                }
                //같은숫자로 된 것 추가
                total.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }
            if(total.contains(number)) return i;
        }
        
        return -1;
    }
}