from collections import deque
class quicksort:
    def __init__(self, arr):
        self.a = arr
        self.lb = 0
        self.ub = 0
        print("Before sorting :", self.a)
        self.qs()

    def partition(self, p):
        down = p[0]
        up = p[1]
        x = self.a[down]
        while down <= up:
            while self.a[down] <=x:
                down+=1
            while self.a[up] > x:
                up-=1
            if down<=up:
                self.a[down], self.a[up] = self.a[up], self.a[down]
                #print("first swap ", self.a)
        self.a[up], self.a[self.lb] = self.a[self.lb], self.a[up]
        #print("second swap ", self.a)
        return up



    def qs(self):
        self.lb = 0
        self.ub = len(self.a)-1
        stack = deque()
        stack.append([self.lb, self.ub])
        while stack:
            p = stack.pop()
            self.lb = p[0]
            self.ub = p[1]
            while self.lb < self.ub:
                j = self.partition(p)
                if j-self.lb > self.ub-j:
                    i = self.ub
                    self.ub = j-1
                    stack.append([self.lb, self.ub])
                    self.lb = j+1
                    self.ub = i
                else:
                    i = self.lb
                    self.lb = j+1
                    stack.append([self.lb, self.ub])
                    self.lb = i
                    self.ub = j-1
        print("After sorting : ", self.a)
                    
                    
        
        


arr = [10,16,8,12,15,6,3,9,5,1,34]
obj = quicksort(arr)
