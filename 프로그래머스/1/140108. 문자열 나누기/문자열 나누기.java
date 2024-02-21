class Solution {
    public int solution(String s) {
        int answer = 0;
        int sameCnt = 0;
        int diffCnt = 0;
        int strNumbs = 1;
        
        char firstStr = s.charAt(0);
        char[] stringArr = s.toCharArray();
        
        for(char str: stringArr){
            //첫번째 문자열과 비교
            if(firstStr == str){
                sameCnt++;
            }else {
                diffCnt++;
            }
        
        //문자가 같은 횟수와 다른 문자의 횟수가 같을 경우
        //첫 문자의 위치를 지금 까지 찾은 문자 다음으로 셋팅
        if(sameCnt == diffCnt){
            answer++;
            firstStr = stringArr[strNumbs];
            sameCnt = 0;
            diffCnt = 0;
        }
        
        if(strNumbs+1 >= stringArr.length){
            answer++;
            break;
        }else{
            strNumbs++;
        }
        }
    
        
        return answer;
    }
}