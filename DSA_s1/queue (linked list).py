print("Queue implementation using linked list")
class node:
    def __init__(self, data):
        self.next  = None
        self.data = data

class queue:
    def __init__(self):
        self.front = None
        self.rear = None
        self.startStack()

    def startStack(self):
        i=1
        while(i):
            print('''\n__MENU__
1.Enqueue
2.Dequeue
3.display
4.Stop\n''')
            choice = int(input("Enter choice : "))
            match (choice):
                case 1:
                    self.enqueue()
                case 2:
                    self.dequeue()
                case 3:
                    self.display()
                case 4:
                    print("stopping.....")
                    i=0
            if (choice<1 or choice >4):
                    print("!!!! Invalid input !!!!!!")

    def isempty(self):
        if self.front == None and self.rear==None:
            return True
        else:
            return False

    def display(self):
        if self.isempty():
            print("!!!! Underflow !!!!")
            return
        ptr = self.front
        while ptr != None:
            print(ptr.data, end =" : ")
            ptr = ptr.next
        print()
        return

    def enqueue(self):
        data = input("Enter element : ")
        ptr = node(data)
        if self.front == None and self.rear == None:
            self.front = ptr
            self.rear = ptr
            return
        else:   
            self.rear.next = ptr
            self.rear = ptr
            return

    def dequeue(self):
        if self.isempty():
            print("!!!! Underflow !!!!")
            return
        else:
            print("Element removed : ", self.front.data, '\n')
            if self.front==self.rear:
                self.front=None
                self.rear=None
            else:
                ptr = self.front
                self.front = self.front.next

            
obj = queue()   
