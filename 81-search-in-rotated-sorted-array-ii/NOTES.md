```
Universally 8 cases -
n=nums.length
let's take l=0; u=n-1;
mid=(l+u)/2;
tartet is unknown
assume target is at position i
swap position -> sw is unknown
1st case target<nums[mid];
sw>mid
if target>nums[l] (i<sw)
u=mid-1
if target<nums[l] (i>sw)
l=mid+1
sw<mid
if target<nums[u] (i>sw)
u=mid-1
if target<nums[u] (i< sw) --> not possible with current contraints
2nd case target>nums[mid]:
sw>mid
if target>nums[l] (i<sw)
l=mid+1
if target>nums[l] (i>sw) --> not possible with current contraints
sw<mid
if target>nums[l] (i<sw)
u=mid-1
if target<nums[l] (i>sw)
l=mid+1
​
```
