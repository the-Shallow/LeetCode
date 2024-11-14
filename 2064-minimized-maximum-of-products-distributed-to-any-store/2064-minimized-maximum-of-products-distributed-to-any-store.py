class Solution:
    def minimizedMaximum(self, n: int, quantities: List[int]) -> int:
        left, right = 1, max(quantities)
        result = 0
        while left <= right:
            mid = left + (right - left) // 2
            
            if Solution.can_distribute(mid,quantities,n):
                result = mid
                right = mid - 1
            else:
                left = mid + 1
                
        return result
    
    def can_distribute(amount,quantities,n):
        stores = 0
        for store in quantities:
            stores += math.ceil( store / amount )
                
        return stores <= n
        