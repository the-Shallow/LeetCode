class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        res = []
        count = 1
        left = 0
        
        for right in range(len(nums)):
            if right > 0 and nums[right-1] + 1 == nums[right]:
                count += 1
                
            if right - left + 1 > k:
                if nums[left] + 1 == nums[left+1]:
                    count -= 1
                left += 1
                    
            if right - left + 1 == k:
                res.append( nums[right] if count == k else -1  )
                
        return res
                    
        