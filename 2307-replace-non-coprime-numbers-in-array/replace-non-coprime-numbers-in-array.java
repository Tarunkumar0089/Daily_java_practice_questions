class Solution {
    public boolean nonCoPrime(long a,long b){
        return gcd(a,b)>1;
    }
    public long gcd(long a,long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public long lcm(long a,long b){
        return (a*b)/gcd(a,b);
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Long> stack=new Stack<>();
        for(int num:nums){
            long x=num;
            stack.push(x);
            while(stack.size()>=2){ 
               long a=stack.pop();
               long b=stack.pop();     
               if(nonCoPrime(a,b)){
                  stack.push(lcm(a,b));
               }
               else{
                stack.push(b);
                stack.push(a);
                break;
               }
               }

        }
        ArrayList<Integer> list =new ArrayList<>();
        for(long num:stack){
            list.add((int)num);
        }
        return list;
    }
}