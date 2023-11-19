print("Stack implementation using linked list")
class node:
    def __init__(self, data):
        self.next  = None
        self.data = data

class stack:
    def __init__(self):
        self.top = None
        self.startStack()

    def startStack(self):
        i=1
        while(i):
            print('''\n__MENU__
1.push
2.pop
3.display
4.Stop\n''')
            choice = int(input("Enter choice : "))
            match (choice):
                case 1:
                    self.push()
                case 2:
                    self.pop()
                case 3:
                    self.display()
                case 4:
                    print("stopping.....")
                    i=0
            if (choice<1 or choice >4):
                    print("!!!! Invalid input !!!!!!")

    def isempty(self):
        if self.top == None:
            return True
        else:
            return False

    def display(self):
        if self.isempty():
            print("!!!! Underflow !!!!")
            return
        ptr = self.top
        while ptr != None:
            print(" -> ",ptr.data, end ="")
            ptr = ptr.next
        print()
        return

    def push(self):
        data = input("Enter element : ")
        if self.top == None:
            self.top = node(data)
            return
        else:
            new_node = node(data)
            new_node.next = self.top
            self.top = new_node
            return

    def pop(self):
        if self.top == None:
            print("!!!! Underflow !!!!!")
        else:
            ptr = self.top
            print("Element removed : ",ptr.data,'\n')
            self.top = ptr.next

obj = stack()
        
            
