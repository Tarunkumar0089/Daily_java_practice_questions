class Solution {
    static class Pair {
        int pos;
        int health;
        char dir;
        int idx;
        Pair(int pos, int health, char dir, int idx) {
            this.pos = pos;
            this.health = health;
            this.dir = dir;
            this.idx = idx;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Pair(positions[i], healths[i], directions.charAt(i), i));
        }
        Collections.sort(list, (a, b) -> Integer.compare(a.pos, b.pos));
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            Pair curr = list.get(i);
            if (curr.dir == 'R') {
                st.push(curr);
            } else {
                while (!st.isEmpty() && st.peek().dir == 'R') {

                    Pair top = st.peek();

                    if (top.health > curr.health) {
                        top.health--;
                        curr.health = 0;
                        break;
                    } 
                    else if (top.health < curr.health) {
                        curr.health--;
                        st.pop();
                    } 
                    else {
                        st.pop();
                        curr.health = 0;
                        break;
                    }
                }

                if (curr.health > 0) {
                    st.push(curr);
                }
            }
        }

        List<Pair> survivors = new ArrayList<>(st);
        Collections.sort(survivors, (a, b) -> Integer.compare(a.idx, b.idx));
        List<Integer> res = new ArrayList<>();
        for (Pair p : survivors) {
            res.add(p.health);
        }

        return res;
    }
}