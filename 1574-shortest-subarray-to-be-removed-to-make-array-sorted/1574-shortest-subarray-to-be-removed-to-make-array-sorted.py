class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        N = len(arr)
        
        left,right = 0,N - 1
        
        while right > 0 and arr[right-1] <= arr[right]:
            right -= 1
            
        res = right
        
        if right == 0:
            return right
        
        while left < N - 1 and arr[left+1] >= arr[left]:
            left += 1
            
            
        res = min(right, N - left - 1)
        
        
        i,j = 0, right;
        
        while i <= left and j < N:
            if arr[i] <= arr[j]:
                res = min(res, j - i - 1)
                i += 1
            else:
                j += 1
                
        return res