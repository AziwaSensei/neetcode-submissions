class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start = 0
        end = len(nums) - 1

        while(start <= end):
            mid = start + (end - start) // 2
            num = nums[mid]

            if target > num:
                start = mid + 1
            elif target < num:
                end = mid - 1
            else:
                return mid

        return -1
        