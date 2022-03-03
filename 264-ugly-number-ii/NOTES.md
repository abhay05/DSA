Brute Force Solution
​
```
public int nthUglyNumber(int n) {
List<Integer>arr = new ArrayList<Integer>();
arr.add(1);
for(int i=2;i<=n;i++){
int val=arr.get(i-2);
int ans=2147483647;
for(int j=1;j<i;j++){
int jval=arr.get(j-1);
int x=jval*2;
int y=jval*3; //(long)
int z=jval*5;
if(x>val){
if(x<ans){
ans=x;
}
}
if(y>val){
if(y<ans){
ans=y;
}
}
if(z>val){
if(z<ans){
ans=z;
}
}
}
arr.add(ans);
}
return arr.get(n-1);
}
```