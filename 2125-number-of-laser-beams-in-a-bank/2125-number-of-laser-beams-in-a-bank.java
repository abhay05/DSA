class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer>collect=new ArrayList<Integer>();
        for(int i=0;i<bank.length;i++){
            int cnt=0;
            for(int j=0;j<bank[i].length();j++){
                
                if(bank[i].charAt(j)=='1'){
                    cnt++;
                }
            }
            if(cnt==0)continue;
            collect.add(cnt);
        }
        if(collect.size()<=1)return 0;
        int ans=0;
        for(int i=0;i<collect.size()-1;i++){
            ans+=(collect.get(i+1)*collect.get(i));
        }
        return ans;
    }
}