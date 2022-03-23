class Solution {
    public int minimumMoves(String s) {
        int ans=0;
        int n=s.length();
        int st=-1;
        int end=-1;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='X'){
                if(i>end){
                    ans++;
                    st=i;
                    end=i+2;
                }
                
            }
        }
        return ans;
    }
}