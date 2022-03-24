class Solution {
    public boolean validPalindrome(String s) {
        int st=0;
        int end=s.length()-1;
        int flag=0;
        boolean ans=false;
        while(st<end){
            if(s.charAt(st)==s.charAt(end)){
                st++;
                end--;
            }else{
                if(flag==0){
                    flag=1;
                    st++;
                }else{
                    ans=(ans|false);
                    break;
                }
            }
        }
        if((st==end || st==end+1) && s.charAt(st)==s.charAt(end)){
            ans=(ans|true);
        }
        st=0;
        end=s.length()-1;
        flag=0;
        while(st<end){
            if(s.charAt(st)==s.charAt(end)){
                st++;
                end--;
            }else{
                if(flag==0){
                    flag=1;
                    end--;
                }else{
                    ans=(ans|false);
                    break;
                }
            }
        }
        if((st==end || st==end+1) && s.charAt(st)==s.charAt(end)){
            ans=(ans|true);
        }
        return ans;
    }
}