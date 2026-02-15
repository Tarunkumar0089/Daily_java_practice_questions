class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        int sum=0;

        StringBuilder sb=new StringBuilder();

        while(i>=0||j>=0){
            sum=carry;

            if(i>=0){
                sum+=a.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                sum+=b.charAt(j)-'0';
                j--;
            }
             sb.append((sum%2==0)?'0':'1');

             carry=sum/2;//(sum>1)?1:0';
        }
        if(carry==1){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}