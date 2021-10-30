from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        sum = 0
        for number in nums:
            sum ^= number
        k = -1
        for j in range(31, -1, -1):
            if ((sum >> j) & 1 == 1):
                k = j
                break
        result = [0, 0]
        for number in nums:
            if ((number >> k) & 1 == 1):
                result[1] ^= number
            else:
                result[0] ^= number
        return result
