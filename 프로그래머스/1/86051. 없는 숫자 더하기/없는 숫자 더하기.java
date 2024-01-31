class Solution {
    public int solution(int[] numbers) {
        
        int[] arr = {1,2,3,4,5,6,7,8,9};
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<numbers.length; j++){
                if(numbers[j] == arr[i]){
                    arr[i] =0;
                }
            }
        }
        
        int sum  = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        
    
        return sum;
    }
}