class StockSpanner {
class box {
int cnt=1;
int val=0;
}
Stack<box>s=new Stack();
    public StockSpanner() {
    }
    public int next(int price) {
      int cnt=1;
      while(s.isEmpty()==false&&s.peek().val<=price)
      {
         cnt+=s.pop().cnt;
      } 
    box b=new box(); 
    b.val=price;
    b.cnt=cnt;
    s.push(b);
    return b.cnt;
    }

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */