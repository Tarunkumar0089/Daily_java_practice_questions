class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();   
        for (int h = 0; h <=11; h++) {
            for (int m = 0; m <=59; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {  
                    String time = h + ":" + (m < 10 ? "0" + m : m);
                    result.add(time);
                }
            }
        }
        return result;
    }
}
