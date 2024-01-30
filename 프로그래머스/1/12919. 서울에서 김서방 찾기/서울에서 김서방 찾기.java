class Solution {
    public String solution(String[] seoul) {
        
        String kim = "Kin";
        int num = 0;
        
        for(int i=0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")) 
                num = i;
        }
        
        String n = "" + num;
        
        
        String answer = "김서방은 " + n + "에 있다";
        return answer;
    }
}