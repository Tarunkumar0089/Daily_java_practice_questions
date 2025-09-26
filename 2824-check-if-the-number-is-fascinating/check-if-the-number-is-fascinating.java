class Solution {
    public boolean isFascinating(int n) {
        String str = Integer.toString(n);
        String str1 =Integer.toString(n*2);
        String str2 = Integer.toString(n*3);
        String s = str+str1+str2;
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        String sort = new String(ch);
        return sort.equals("123456789");

    }
}