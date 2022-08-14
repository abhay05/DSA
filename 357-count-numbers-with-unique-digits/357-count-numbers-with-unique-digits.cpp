class Solution {
public:
    int countNumbersWithUniqueDigits(int n) {
        if(n==0)return 1;
        int ans=9;
        int last=0;
        for(int i=1;i<n;i++){
        ans=ans*(10-i);
            last+=ans;
        }
        return last+(n>=1?10:0);
    }
};