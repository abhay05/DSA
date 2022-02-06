class ListNode{
    String page;
    ListNode forward;
    ListNode backward;
    ListNode(){}
    ListNode(String val){this.page=val;}
}
class BrowserHistory {
    ListNode history=new ListNode("");
    public BrowserHistory(String homepage) {
        history.page=homepage;
        history.forward=null;
        history.backward=null;
    }
    
    public void visit(String url) {
        ListNode newH=new ListNode(url);
        history.forward=newH;
        newH.backward=history;
        history=history.forward;
    }
    
    public String back(int steps) {
        while(steps!=0 && history.backward!=null){
            history=history.backward;
            steps--;
        }
        return history.page;
    }
    
    public String forward(int steps) {
        while(steps!=0 && history.forward!=null){
            history=history.forward;
            steps--;
        }
        return history.page;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */