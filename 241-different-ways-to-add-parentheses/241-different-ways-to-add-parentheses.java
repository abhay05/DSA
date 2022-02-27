class Solution {
    
   
    
    public List<Integer> diffWaysToCompute(String expression) {
        List<String> intArr=new ArrayList<String>();
        int last=0;
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='+'){
                String x=expression.substring(last,i);
                intArr.add(x);
                intArr.add("+");
                last=i+1;
            }
            else if(expression.charAt(i)=='-'){
                String x=expression.substring(last,i);
                intArr.add(x);
                intArr.add("-");
                last=i+1;
            }
            else if(expression.charAt(i)=='/'){
                String x=expression.substring(last,i);
                intArr.add(x);
                intArr.add("/");
                last=i+1;
            }
            else if(expression.charAt(i)=='*'){
                String x=expression.substring(last,i);
                intArr.add(x);
                intArr.add("*");
                last=i+1;
            }
            
        }
        String vv=expression.substring(last,expression.length());
                intArr.add(vv);

        List[][] dp=new ArrayList[intArr.size()][intArr.size()];
        for(int i=0;i<intArr.size();i+=2){
            dp[i][i]=new ArrayList<Integer>();
            dp[i][i].add(Integer.valueOf(intArr.get(i)));
           // System.out.println("val "+(Integer.valueOf(expression.charAt(i))-48));
        }
        
        int length=intArr.size();
        for(int i=2;i<length;i+=2){
            for(int ind=0;ind+i<length;ind+=2){
                dp[ind][ind+i]=new ArrayList<Integer>();
                for(int j=ind+1;j<=ind+i;j+=2){
                 //   System.out.println(ind+" "+"length "+i+" "+"b/w "+j);
                    
                    for(int val1Ind=0;val1Ind<dp[ind][j-1].size();val1Ind++){
                        for(int val2Ind=0;val2Ind<dp[j+1][ind+i].size();val2Ind++){
                            int x=(int)dp[ind][j-1].get(val1Ind);
                            int y=(int)dp[j+1][ind+i].get(val2Ind);
                        //    System.out.println("x "+x+" y "+y);
                            if(intArr.get(j)=="-"){
                                dp[ind][ind+i].add((x-y));
                            }
                            else if(intArr.get(j)=="+"){
                                dp[ind][ind+i].add((x+y));
                            }
                            else if(intArr.get(j)=="*"){
                                dp[ind][ind+i].add((x*y));
                            }
                            else{
                                dp[ind][ind+i].add((x/y));
                            }
                        }
                    }
                    
                    
                    
                }
            }
            
        }
        return dp[0][length-1];
    }
}