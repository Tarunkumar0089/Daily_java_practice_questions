class Solution {
    public String reverseVowels(String s) {
        char [] arr= s.toCharArray();
        reverse(arr);
        return String.valueOf(arr);
    }
    public static void reverse(char [] arr){
        int i=0;
        int j=arr.length-1;
        while(i<j){
        while(i<j && !isVowel(arr[i])) i++;
        while(i<j && !isVowel(arr[j])) j--;
            if(i>=0 && j<arr.length){
                char temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
            
            
        }
        
        
        
    }
    public static boolean isVowel(char ch){
        if(ch=='a' || ch=='A' || ch=='e' || ch=='E' || ch=='i' || ch=='I' || ch=='o' || ch=='O' || ch=='u' || ch=='U'){
            return true;
        }
        return false;
    }
}