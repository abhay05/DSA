Tortoise and Hare approach - O(1) space , O(n) time - ideal
```
class Solution {
public int findDuplicate(int[] nums) {
int slow=0;
int fast=0;
slow=nums[slow];
fast=nums[nums[fast]];
while(nums[slow]!=nums[fast]){
slow=nums[slow];
fast=nums[nums[fast]];
}
int ans=0;
while(nums[slow]!=nums[ans]){
slow=nums[slow];
ans=nums[ans];
}
return nums[ans];
}
}
```
​
Beautiful Pigeon Hole Principle -> O(1) space, O(nlogn) time
​
```
class Solution {
public int findDuplicate(int[] nums) {
int l=1;
int u=nums.length-1;
int ans=-1;
while(l<u){
int mid=(l+u)/2;
int cnt=0;
for(int i=0;i<nums.length;i++){
if(nums[i]<=mid){
cnt++;
}
}
if(cnt>mid){
u=mid;
}
else{
l=mid+1;
}