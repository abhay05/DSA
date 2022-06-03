class Solution {
    public int numberOfSteps(int num) {
        int tot=0;
        int one=0;
        int temp=num;
        while(temp!=0){
            tot++;
            temp=(temp>>1);
        }
        temp=num;
        while(temp!=0){
            one++;
            temp=(temp&(temp-1));
        }
        return Math.max(0,tot+one-1);
    }
}