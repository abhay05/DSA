class Solution {
    public int flipLights(int n, int presses) {
        if(presses==0)return 1;
        if(n==1){
            if(presses>=1){
                return 2;
            }
        }
        if(n==2){
            if(presses==1){
                return 3;
            }
            else if(presses>=2){
                return 4;
            }
        }
        
            if(presses==1){
                return 4;
            }
            else if(presses==2){
                return 7;
            }else{
                return 8;
            }
        
    }
}