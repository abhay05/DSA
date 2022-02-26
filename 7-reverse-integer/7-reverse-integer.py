class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        sign = [-1,1][x>0]
        x  = sign * x 
        y = int(str(x)[::-1])
        y = y*sign
        if ((-1)*pow(2,31) <= y and y <= pow(2,31)-1):
            return y
        else:
            return 0