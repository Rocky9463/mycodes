class queue:
    def __init__(self):
        self.q_len = int(input("Enter length of queue : "))
        self.arr = [0]*self.q_len
        self.front = -1
        self.rear = -1
        self.start_q()

    def start_q(self):
        i=True
        while(i):
            print('''1.Enqueue
2.Dequeue
3.Peek
4.change
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
                    print('Stopping...')
                    i=False
            if choice>6 or choice<1:
                print('!!!!!!!!! Invalid input !!!!!!!!!!')
        
    def is_empty(self):
        if self.front==-1 and self.rear==-1:
            return True
        else:
            return False
    
    def is_full(self):
        if self.front==0 and self.rear==self.q_len-1:
            return True
        else:
            return False
    
    def enqueue(self):
        if self.is_full():
            print("!!!!!!! Overflow !!!!!!!")
            print()
            return
        if self.is_empty():
            self.front=0
        self.rear+=1
        item = input("Enter element : ")
        self.arr[self.rear]=item
        print("=== Element inserted ===")
        print()
        
    def dequeue(self):
        if self.is_empty():
            print("!!!!!!!! Underflow !!!!!!!!!")
            print()
            return
        print("Item removed : ",self.arr[self.front])
        self.arr[self.front]=0
        if self.front == self.rear:            
            self.front=-1
            self.rear=-1
        else:
            self.front+=1
        print()

    def peek(self):
        if self.is_empty():
            print("!!!!!!!! Underflow !!!!!!!!!")
            print()
            return
        print("Element at front : ", self.arr[self.front])
        print()
        
    def change(self):
        if self.is_empty():
            print("!!!!!!!! Underflow !!!!!!!!!")
            print()
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
