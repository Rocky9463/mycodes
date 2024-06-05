class stack:
    def __init__(self):
        self.stack_length = int(input("Enter your length for stack: "))
        self.top = -1
        self.arr = []
        self.start_stack()

    def start_stack(self):
        i=True
        while(i):
            print('''1.push
2.Pop
3.Peek
4.change
5.Display
6.Stop
    ''')
            choice = int(input("Enter your choice: "))
            match (choice):
                case 1:
                    self.push()   
                case 2:
                    if self.top == -1:
                        print("!!!!!!!!!!!Underflow!!!!!!!!!")
                    else:
                        print("Element removed : ",self.arr[-1])
                        print()
                        self.top -= 1
                        self.arr.pop()                    
                case 3:
                    self.peek()
                case 4:
                    self.change()
                case 5:
                    self.display()
                case 6:
                    print('Stopping....')
                    i=False
            if choice>6 or choice <1:
                    print('!!!!!!!Invalid input!!!!!!!!')

    def push(self):
        if self.top==self.stack_length-1:
            print('!!!!!!!!!!overflow!!!!!!!!!!')
            return
        else:
            item = input("Enter element : ")
            self.top += 1
            self.arr.append(item)
            print("===Element inserted.===")
            return
        
    def peek(self):
        if self.top == -1:
            print("!!!!!!!!Underflow!!!!!!!!!")
            return
        print('Element at top : ',self.arr[-1])
        print()
        return
    
    def change(self):
        if self.top == -1:
            print("!!!!!!!!Underflow!!!!!!!!!")
            return
        pos = int(input("Enter position :  "))
        element = input("Enter element : ")
        self.arr[pos] = element
        print("===element updated===")
        return
        
    def display(self):
        print(self.arr)
        


obj = stack()
