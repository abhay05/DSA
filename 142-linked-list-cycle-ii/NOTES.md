Double for loop solution - brute force
​
public class Solution {
public ListNode detectCycle(ListNode head) {
if(head==null || head.next==null)return null;
ListNode heada=head;
ListNode headb=head;
heada=head.next;
headb=head.next.next;
int f=0;
while(heada!=null && headb!=null && headb.next!=null){
heada=heada.next;
headb=headb.next.next;
if(heada==headb){
f=1;
break;
}
}
if(f==0){return null;}
ListNode headT=head;
heada=heada.next;
headb=headb.next.next;
while(headT!=heada && headT!=headb){
while(heada!=headb){
heada=heada.next;
headb=headb.next.next;
if(headT==heada || headT==headb){
return headT;
}
}
headT=headT.next;
heada=heada.next;
headb=headb.next.next;
}
return headT;
}
}