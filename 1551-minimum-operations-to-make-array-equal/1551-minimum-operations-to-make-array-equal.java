class Solution {
    public int minOperations(int n) {
        int x=n/2;
        int mid=(2*x+1);
        mid=(n%2==0?(mid+(2*(x-1)+1))/2:mid);
        int ans=mid*x-(x*(2+(x-1)*2))/2;
        return ans;
    }
}