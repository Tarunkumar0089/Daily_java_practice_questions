class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int i=0;
        int j=people.length-1;
        int b=0;
        Arrays.sort(people);
        while(i<=j)
        {
            if(people[i]+people[j]<=limit)
            {
                i++;
                j--;
            }
            else
            {
                j--;
            }
            b++;
        }
        return b;
        
    }
}