class Solution:
    def minimizedMaximum(self, n: int, quantities: List[int]) -> int:
        def can_distribute(amount):
            stores = 0
            for store in quantities:
                stores += math.ceil( store / amount )
                
            return stores <= n
                
            
            
        left, right = 1, max(quantities)
        result = 0
        while left <= right:
            mid = left + (right - left) // 2
            
            if can_distribute(mid):
                result = mid
                right = mid - 1
            else:
                left = mid + 1
                
        return result
        