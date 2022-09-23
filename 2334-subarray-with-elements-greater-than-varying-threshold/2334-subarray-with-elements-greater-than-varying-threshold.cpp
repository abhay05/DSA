class Solution {
public:
    int validSubarraySize(vector<int>& nums, int threshold) {
        stack<int>st;
        int n=nums.size();
        int nextS[n];
        int prevS[n];
        for(int i=0;i<n;i++){
            nextS[i]=n;
            prevS[i]=-1;
        }
        for(int i=0;i<n;i++){
            while(st.size()>0 && nums[st.top()]>nums[i]){
                nextS[st.top()]=i;
                st.pop();
            }
            st.push(i);
        }
        stack<int>stp;
        for(int i=n-1;i>=0;i--){
            while(stp.size()>0 && nums[stp.top()]>nums[i]){
                prevS[stp.top()]=i;
                stp.pop();
            }
            stp.push(i);
        }
        
        for(int i=0;i<n;i++){
            int length=(nextS[i]==-1?0:nextS[i]-1-i)+(prevS[i]==i+1?0:i-1-prevS[i])+1;
            if(length<=0)length=1;
            //cout<<i<<' '<<' '<<nextS[i]<<' '<<prevS[i]<<' '<<length<<' '<<threshold<<'\n';
            if(nums[i]>threshold/length){
                return length;
            }
        }
        return -1;
    }
};