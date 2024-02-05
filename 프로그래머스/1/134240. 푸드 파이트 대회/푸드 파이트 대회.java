class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<food.length; i++){
            if(food[i] % 2 != 0){
                food[i] -= 1;
            }
        }
        
        for(int i=1; i<food.length; i++){
            for(int j = 0; j<food[i]/2; j++){
                sb.append(Integer.toString(i));
            }
            food[i] = food[i]/2;
        }
        sb.append("0");
        
        for(int i=food.length-1; i>0; i--){
            for(int j = 0; j<food[i]; j++){
                sb.append(Integer.toString(i));
            }
        }
        
        
        return sb.toString();
    }
}