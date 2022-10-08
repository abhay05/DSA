class Solution {
public:
    
    int longestSubsequence(string s, int k) {
        long long temp=(long long)k;
        reverse(s.begin(),s.end());
        int ans=0;
        int pow=0;
        int temp1=k;
        int maxi=0;
        while(temp1>0){
            maxi++;
            temp1/=2;
        }
        for(int i=0;i<s.size();i++){
            if(s[i]=='0'){
            ans++;
                pow++;
            }else{
                if(pow<=maxi){
                    if(temp>0){
                    temp-=(long long)(1<<pow);
                    if(temp>=0){
                        ans++;
                        pow++;
                    }
                    }
                }
            }
        }
        return ans;
        
    }
};