class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
        for(int i=0; i<queries.length; i++){
            String query = queries[i];
            int query_len = query.length();
            int count = 0;
            
            for(String word : words){
                
                if(query_len == word.length()){
                    
                    if(query.charAt(0) == '?'){ //시작에 ? 있는 경우
                        String st = query.replace("?","");
                        if(word.endsWith(st)) count++;
                    }else{ //끝에 ? 있는 경우
                        String st = query.replace("?","");
                        if(word.startsWith(st)) count++;
                    }
                }
            }
            
            answer[i] = count;
        }
        return answer;
    }
}