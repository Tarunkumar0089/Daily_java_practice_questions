class Solution {
    public int minimumNumbers(int num, int k) {
       if(num%2!=0&& k%2==0){
        return -1;
       } 
       if(num==0) return 0;
         for(int i=1;i<=10;i++){
           
           if(num%10==(k*i)%10 && k*i<=num){
            return i;
           }
            
         }
         return -1;
    }
}