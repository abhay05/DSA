class Solution {
    public String convert(String s, int numRows) {
        int first=2*(numRows-1);
        int second=0;
        int n=s.length();
        int[] sarr=new int[s.length()];
        for(int i=0;i<s.length();i++){
            sarr[i]=0;
        }
        int ind=0;
        StringBuilder strb=new StringBuilder();
        while(ind<n && sarr[ind]==0){
            sarr[ind]=1;
            strb.append(s.charAt(ind));
            int tmpind=ind;
            int flag=0;
            if(first>0){
                tmpind+=first;
                flag=1-flag;
            }else if(second>0){
                tmpind+=second;
                flag=1-flag;
            }
            
            while(tmpind<n && (first>0 || second>0)){
           //     System.out.println(tmpind);
                sarr[tmpind]=1;
            strb.append(s.charAt(tmpind));
           //     System.out.println(s.charAt(tmpind)+" "+tmpind+" ");
                if(flag==0){
                //    System.out.println("in first");
                    if(first==0){
                        tmpind+=second;
                    }else{
                   tmpind+=first; 
                    }
                   // System.out.println(s.charAt(tmpind)+" "+tmpind+" "+first);
                }else{
                 //   System.out.println("in second");
                    if(second==0){
                       tmpind+=first;  
                    }else{
                        tmpind+=second;
                        
                    }
                }
                flag=1-flag;
                
            }
            if(first>0){
            first-=2;
            second+=2;}
            ind++;
        }
        return strb.toString();
    }
}