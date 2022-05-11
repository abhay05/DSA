class Solution {
    public String removeDuplicates(String s, int k) {
        int n=s.length();
        char[] sarr=s.toCharArray();
        char[] nsarr=new char[n];
        int[] cnt=new int[n];
        int ind=0;
        for(int i=0;i<n;i++){
            nsarr[ind]=sarr[i];
            if(ind>0 && sarr[i]==nsarr[ind-1]){
                cnt[ind]=cnt[ind-1]+1;
            }else{
                cnt[ind]=1;
            }
            if(cnt[ind]>=k){
                ind-=k;
            }
            ind++;
        }
        return new String(nsarr,0,ind);
        
    }
}