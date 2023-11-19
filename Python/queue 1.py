class queue:
    def __init__(self):
        self.q_len = int(input("Enter length of queue : "))
        self.arr = []
        #self.front = 0
        #self.rear = q_len-1
        self.start_q()

    def start_q(self):
        i=True
        while(i):
            print('''1.Enqueue
2.Dequeue
3.Peek
4.Change
5.Display
6.Stop
    ''')
            choice = int(input("Enter your choice: "))
            match (choice):
                case 1:
                    self.enqueue()
                case 2:
                    self.dequeue()
                case 3:
                    self.peek()
                case 4:
                    self.change()
                case 5:
                    self.display()
                case 6:
                    print('Stopping')
                    i=False
            if choice>6 or choice<1:
                print('Invalid input')
        
    def is_empty(self):
        return self.arr == []
    
    def is_full(self):
        return len(self.arr)==self.q_len
    
    def enqueue(self):
        if self.is_full():
            print("!!!!!!! Overflow !!!!!!!")
            return
        item = input("Enter element : ")
        self.arr.append(item)
        print("=== Element inserted ===")
        print()
        
    def dequeue(self):
        if self.is_empty():
            print("!!!!!!!! Underflow !!!!!!!!!")
            return
        print("Element removed : ",self.arr.pop(0))
        print()

    def peek(self):
        if self.is_empty():
            print("!!!!!!!! Underflow !!!!!!!!!")
            print()
            return
        print("Element at front : ", self.arr[0])
        print()
        
    def change(self):
        if self.is_empty():
            print("!!!!!!!! Underflow !!!!!!!!!")
            return
        pos = int(input("Enter position : "))
        item = input("Enter element : ")
        self.arr[pos]=item
        print("=== Element Updated ===")
        print()
        
    def display(self):
        print(self.arr)
        print()
        
    
obj = queue()
