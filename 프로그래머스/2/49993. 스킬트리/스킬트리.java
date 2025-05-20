import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++){
            String[] str = skill_trees[i].split("");
            String s = "";
            
            for(int j=0; j<str.length; j++){
                if(skill.contains(str[j])){
                    s += str[j];
                }
            }
            
            if(skill.startsWith(s)){
                answer++;
            }
            
        }
        return answer;
    }
}