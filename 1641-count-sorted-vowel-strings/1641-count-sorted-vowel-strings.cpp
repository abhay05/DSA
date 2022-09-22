//STARS AND BARS
class Solution {
public:
    int countVowelStrings(int n) {
        int c[51][6];
        c[0][0]=1;
        for(int i=1;i<51;i++){
            c[i][0]=1;
        }
        for(int i=1;i<51;i++){
            for(int j=1;j<6;j++){
                if(i==j)c[i][j]=1;
                if(j>i)c[i][j]=0;
                if(i>j){
                    c[i][j]=c[i-1][j]+c[i-1][j-1];
                }
            }
        }

       int ans=c[5][1]*c[n-1][0]+c[5][2]*c[n-1][1]+c[5][3]*c[n-1][2]+c[5][4]*c[n-1][3]+c[5][5]*c[n-1][4];
        return ans;
    }
};