Recursive Solution (brute force solution with memoization)
​
```
class Solution {
HashMap<String,Integer>mp=new HashMap<String,Integer>();
int recur(int[] arr,int len){
int cnt1=0;
for(int i=0;i<len;i++){
if(arr[i]==2)cnt1++;
}
if(cnt1==len){
return 1;
}
String s="";
for(int i=0;i<len;i++){
s=s+(char)arr[i];
}
if(mp.containsKey(s))return mp.get(s);
int ans=0;
for(int i=0;i<len;i++){
if(arr[i]==0){
arr[i]=1;
ans=(ans+recur(arr,len))%1000000007;
arr[i]=0;
}
if(arr[i]==1){
arr[i]=2;
ans=(ans+recur(arr,len))%1000000007;
arr[i]=1;
}
}
mp.put(s,ans);
return ans;
}
public int countOrders(int n) {
int[] arr = new int[n];
for(int i=0;i<n;i++){
arr[i]=0;
}
return recur(arr,n);
}
}
```