class MinStack:

    def __init__(self):
        # create the stack
        self.regular_stack = list()
        self.min_stack = list()

    def push(self, val: int) -> None:
        """We add the element and update min stack"""
        self.regular_stack.append(val)
        # Update min stack only when val is lower than current minstack top
        self.min_stack.append(min(val,self.min_stack[-1] if self.min_stack else val))
        
    def pop(self) -> None:
        """Get rid of top element in stack"""    
        self.regular_stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        """Return top element of regular stack"""
        return self.regular_stack[-1]


    def getMin(self) -> int:
        """Return top element of min stack"""
        return self.min_stack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()