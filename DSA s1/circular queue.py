class c_queue:
    def __init__(self):
        self.N = int(input("Enter the length of queue : "))
        self.front = -1
        self.rear = -1
        self.arr = [0]*self.N
        self.start_CQ()

    def start_CQ(self):
        i=True
        while(i):
            print('''___MENU___
1.Enqueue
2.Dequeue
3.Display
4.Stop
    ''')
            choice = int(input("Enter your choice: "))
            match (choice):
                case 1:
                    self.enqueue()
                case 2:
                    self.dequeue()
                case 3:
                    self.display()
                case 4:
                    print('Stopping')
                    i=False
            if choice>4 or choice<1:
                print('Invalid input\n')

    def enqueue(self):
        if (self.front == 0 and self.rear == self.N-1) or (self.front == self.rear+1):
            print("!!!!!! Overflow !!!!!!\n")
            return
        item = input("Enter element : ")
        if self.front == -1 and self.rear == -1:
            self.front = 0
            self.rear = 0
        elif self.rear == self.N-1:
            self.rear = 0
        else:
            self.rear += 1
        self.arr[self.rear] = item
        print("Element inserted\n")
        return
    
    def dequeue(self):
        if self.front==-1 and self.rear ==-1:
            print("!!!!!!! Underflow !!!!!!!!!\n")
            return
        item = self.arr[self.front]
        self.arr[self.front] = 0
        if self.front == self.rear:
            self.front = -1
            self.rear = -1
        elif self.front == self.N-1:
            self.front = 0
        else:
            self.front += 1
        print("Element removed : ", item,"\n")
        return

    def display(self):
        print(self.arr)
        print()
            
            

obj  = c_queue()
