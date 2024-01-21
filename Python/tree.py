from collections import deque
class node:
    def __init__(self, data):
        self.data = data
        self.right = None
        self.left = None

class BinarySearchTree:
    def __init__(self):
        self.root = None
        self.prev = None
        self.startlist()

    def startlist(self):
        i=1
        while(i):
            print('''\n__MENU__
1.Insert (append)
2.Display (Preorder tranversal)
3.Stop\n''')
            choice = int(input("Enter choice : "))
            match (choice):
                case 1:
                    self.insert()
                case 2:
                    self.display()
                case 3:
                    print("stopping.....")
                    i=0
            if (choice<1 or choice >3):
                    print("!!!! Invalid input !!!!!!")

    def createRoot(self, data):
        ptr = node(data)
        ptr.left = None
        ptr.right = None
        self.root = ptr
    
    def createLeftSon(self, data):
        ptr = node(data)
        ptr.left = None
        ptr.right = None
        self.prev.left = ptr

    def createRightSon(self, data):
        ptr = node(data)
        ptr.left = None
        ptr.right = None
        self.prev.right = ptr
    
    def insert(self):
        data = input("Enter value : ")
        if self.root == None:
            print("No root available")
            self.createRoot(data)
        else:
            ptr = self.root
            while(ptr is not None):
                self.prev = ptr
                if data < ptr.data:
                    ptr = ptr.left
                elif data > ptr.data:
                    ptr = ptr.right
                else:
                    break
            
            if data < self.prev.data:
                self.createLeftSon(data)
            elif data > self.prev.data:
                self.createRightSon(data)
            else:
                print("!!! DUPLICATE NUMBER !!!")

    def display(self):
        ptr = self.root
        stack = deque()
        while (ptr is not None) or (stack):
            while ptr is not None:
                print(ptr.data,end=" ")
                if ptr.right is not None:
                    stack.append(ptr.right)
                ptr = ptr.left
            if stack:
                ptr = stack.pop()
                
    # def display(self):
    #     stack = deque()
    #     stack.append(self.root)
    #     while stack:
    #         ptr = stack.pop()
    #         if ptr:
    #             print(ptr.data, " ", end="")
    #             stack.append(ptr.right)
    #             stack.append(ptr.left)





obj = BinarySearchTree()