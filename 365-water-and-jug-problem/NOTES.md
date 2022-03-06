​Math's Solution :

````
ax + by = d
d is the highest common divisor of a and b, d is also the smallest number that can be rewritten in form ax + by

e.g. -> -1 * 4 + 6 * 2 = 8

code (not mine)
if(x + y < z) return false;
    //case x or y is zero
if( x == z || y == z || x + y == z ) return true;
    
 //get GCD, then we can use the property of Bézout's identity
    return z%GCD(x, y) == 0;
		
```
