class Solution {
    public String orderlyQueue(String s, int k) {
        String s1=s;
        int n=s1.length();
        if(k>1){
            char[] arr=s.toCharArray();
            Arrays.sort(arr,0,n);
            String ans=String.valueOf(arr);
            return ans;
        }
        String ans=s;
        while(true){
            String temp=s1.substring(k,n)+s1.substring(0,k);
            if(temp.equals(s)){break;}
            if(ans.compareTo(temp)>0){
                ans=temp;
            }
            s1=temp;
        }
        return ans;
    }
}