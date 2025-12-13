class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        HashMap<String, Integer> order = new HashMap<>();
        order.put("electronics", 0);
        order.put("grocery", 1);
        order.put("pharmacy", 2);
        order.put("restaurant", 3);

        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (isActive[i]
                    && order.containsKey(businessLine[i])
                    && validCode(code[i])) {
                list.add(new String[]{businessLine[i], code[i]});
            }
        }
        Collections.sort(list, (a, b) -> {
            int cmp = order.get(a[0]) - order.get(b[0]);
            if (cmp != 0) return cmp;
            return a[1].compareTo(b[1]);
        });

        List<String> ans = new ArrayList<>();
        for (String[] s : list) {
            ans.add(s[1]);
        }
        return ans;
    }
    
    public boolean validCode(String s) {
        if (s == null || s.length() == 0) return false;

        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_')
                return false;
        }
        return true;
    }
}
