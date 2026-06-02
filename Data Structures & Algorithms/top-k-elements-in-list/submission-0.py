class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
                # Ordering, maybe n log n

        # All numbers are integers
        # Negative or not negative? Positive only.
        # Assuming there is an upper limit
        # Assuming at lest 1 number
        # E Is there a unique anser?
        # Order answer at the end?
        # We need that map but it will be an array were the keys are the values and the values are the counts
        instances_map = defaultdict(int)
        # key = number, value = # of times the number is found (instances)
        # we want to invert that such that
        # key = instances, value = numbe
        # this means we need an array/map of length k
        len_nums = len(nums)
        frequency = [[] for num in range(len_nums + 1)] # we can store each number here in said position
        for number in nums:
            instances_map[number] = instances_map.get(number,0) + 1 #increase for each instance
            #instances_map[number] += 1
        # once we have the number of instances in the map
        # we need to build the frequency array
        for number, instances in instances_map.items():
            frequency[instances].append(number)
        # we know the length of the array, 1 to k, we will start at the end, why? becuase we want the most k frequent elements
        result = []
        for index in range(len(frequency) - 1, 0, -1):
            # add the for k num
            for numbers in frequency[index]:
                result.append(numbers)
                if len(result) >= k:
                    return result
