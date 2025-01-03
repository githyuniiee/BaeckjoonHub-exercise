import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        int[] doubleElements = new int[2*n];
        
        for(int i=0; i<n; i++){
            doubleElements[i] = elements[i];
            doubleElements[i+n] = elements[i];
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i< n ; i++){
            for(int j=i; j< i + n; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum += doubleElements[k];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}