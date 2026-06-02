class Solution:
    def maxProfit(self, prices: List[int]) -> int:
                # Initialize min_price to the highest possible value
        min_price = float('inf') 
        max_profit = 0
        
        # Iterate through the prices array once (O(N) time)
        for price in prices:
            # 1. Update the minimum price seen so far (potential buy day)
            min_price = min(min_price, price)
            
            # 2. Calculate the profit if we sell today (current price - lowest buy price)
            current_profit = price - min_price
            
            # 3. Update the overall maximum profit
            max_profit = max(max_profit, current_profit)
            
        return max_profit