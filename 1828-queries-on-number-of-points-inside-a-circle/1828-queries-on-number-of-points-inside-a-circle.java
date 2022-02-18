public class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}


class Solution {
    
    public int lowerBound(Pair arr[],int n,int x,int y,int r){
        int l=0;int u=n-1;
        int ans=0;
        while(l<=u){
            int mid=(l+u)/2;
            if(x<=arr[mid].x){
                u=mid-1;
                ans=mid;
            }else if(x>arr[mid].x){
                l=mid+1;
            }
        }
        return ans;
    }
    
    public int[] countPoints(int[][] points, int[][] queries) {
        Pair[] arr=new Pair[points.length];
        int[] ans=new int[queries.length];
        for(int i=0;i<points.length;i++){
            Pair p=new Pair(points[i][0],points[i][1]);
            arr[i]=p;
        }
        Arrays.sort(arr,new Comparator<Pair>(){
             public int compare(Pair a,Pair b){
                if(a.x==b.x){
                    return a.y-b.y;
                }
                return a.x-b.x;
            }
        });
        for(int i=0;i<queries.length;i++){
            int x=lowerBound(arr,arr.length,queries[i][0]-queries[i][2],0,queries[i][2]);
            int cnt=0;
            for(int j=x; j<arr.length && arr[j].x<=queries[i][0]+queries[i][2];j++){
                if(queries[i][2]*queries[i][2] >=(arr[j].x-queries[i][0])*(arr[j].x-queries[i][0])+(arr[j].y-queries[i][1])*(arr[j].y-queries[i][1])){
                    cnt++;
                }
            }
            ans[i]=cnt;
        }
      //  ans[0]=0;
        return  ans;
    }
}