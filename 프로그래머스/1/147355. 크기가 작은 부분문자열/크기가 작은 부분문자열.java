class Solution {
    public int solution(String t, String p) {
      
        int len = p.length();
        long num_p = Long.parseLong(p);
        int answer = 0;
        
        for(int i=0; i<=t.length()-len; i++){
            String str = t.substring(i,i+len);
            long num_str = Long.parseLong(str);
            if(num_str <= num_p) answer++;
        }
        
        return answer;
    }
}