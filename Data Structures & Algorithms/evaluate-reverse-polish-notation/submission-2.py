class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        
        # Defining the valid operators
        OPERATORS = {
            "+",
            "-",
            "*",
            "/"
        }
        
        for token in tokens:
            if token in OPERATORS:
                # 1. Pop the operands (order is crucial in RPN)
                # The second-to-last element (b) is the right operand
                # The last element (a) is the left operand
                b = stack.pop()
                a = stack.pop()
                
                # 2. Perform the operation and store the result
                if token == "+":
                    result = a + b
                elif token == "-":
                    result = a - b
                elif token == "*":
                    result = a * b
                elif token == "/":
                    result = int(a / b)
                
                # 3. Push the result back onto the stack
                stack.append(result)
            else:
                # FIX: Convert the number token from a string to an integer
                stack.append(int(token))
                
        # The final result is the only item left on the stack
        return stack[-1] 