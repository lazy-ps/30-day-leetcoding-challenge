class Solution:
    def calculate(self, s: str) -> int:
        nums = deque()
        operators = deque()
        num = ''
        for i in s:
            if i == ' ':
                continue
            if '0' <= i <= '9': # number
                num += i
            else: # operator
                nums.append(int(num))
                num = ''
                if len(operators) > 0 and (operators[-1] == '*' or operators[-1] == '/'):
                    nums.append(self.helper(nums.pop(), nums.pop(), operators.pop()))
                operators.append(i)
        if num != '':
            nums.append(int(num))
        if len(operators) > 0 and (operators[-1] == '*' or operators[-1] == '/'):
            nums.append(self.helper(nums.pop(), nums.pop(), operators.pop()))
        while len(operators) > 0:
            num1 = nums.popleft()
            num2 = nums.popleft()
            nums.appendleft(self.helper(num2, num1, operators.popleft()))
        return nums[0]
    
    def helper(self, num1, num2, operator):
        if operator == '+':
            return num1 + num2
        elif operator == '-':
            return num2 - num1
        elif operator == '*':
            return num1 * num2
        else:
            return num2 // num1
