class Solution {
    public List<Integer> getRow(int rowIndex) {
        int n=rowIndex+1;
        List<Integer>ans= new ArrayList<Integer>();
        ans.add(1);
        if(n==1){
            return ans;
        }
        for(int i=2;i<=n;i++){
            int cnt=i-2;
            List<Integer>temp=new ArrayList<Integer>();
            temp.add(1);
            for(int j=0;j<cnt;j++){
                temp.add(ans.get(j)+ans.get(j+1));
            }
            temp.add(1);
            ans=temp;
        }
        return ans;
    }
}