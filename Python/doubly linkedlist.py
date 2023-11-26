class node:
    def __init__(self, data):
        self.data = data
        self.right = None
        self.left = None

class doublylinkedlist:
    def __init__(self):
        self.start = None
        self.last = None
        self.startlist()

    def startlist(self):
        i=1
        while(i):
            print('''\n__MENU__
1.Insert (append)
2.Insert before
3.Insert after
4.Delete
5.Delete before
6.Delete after
7.display
8.Stop\n''')
            choice = int(input("Enter choice : "))
            match (choice):
                case 1:
                    self.insert()
                case 2:
                    self.insertb4()
                case 3:
                    self.insertafter()
                case 4:
                    self.delete()
                case 5:
                    self.deleteb4()
                case 6:
                    self.deleteafter()
                case 7:
                    self.display()
                case 8:
                    print("stopping.....")
                    i=0
            if (choice<1 or choice >8):
                    print("!!!! Invalid input !!!!!!")

    def insert(self):
        data = input("Enter value : ")
        ptr = node(data)
        ptr.left = self.last
        ptr.right = None
        if self.start is None and self.last is None:
            self.start = ptr
            self.last = ptr
        else:
            self.last.right = ptr
            self.last = ptr
        print("__ Value inserted successfully__")

    def display(self):
        if (self.start is None and self.last is None):
            print("!!! Underflow !!!")
        else:
            ptr = self.start
            while (ptr is not None):
                print(ptr.data, end = " : ")
                ptr = ptr.right
    
    def searchElement(self):
        data = input("Enter element to find : ")
        ptr = self.start
        c = 0
        while ptr is not None:
            if ptr.data == data:
                c+=1
                break
            else:
                ptr = ptr.right
        if c==0:
            return None
        else:
            return ptr
    
    def insertafter(self):
        ptr = self.searchElement()
        if ptr is None:
            print("!!! Element not found !!!")
            return
        else:
            data = input("Enter value : ")
            new_node = node(data)
            new_node.left = ptr
            new_node.right = ptr.right
            ptr.right = new_node
            if ptr == self.last:
                self.last = new_node
            else:
                new_node.right.left = new_node
            print("__ Value inserted successfully__")
        
    def insertb4(self):
        ptr = self.searchElement()
        if ptr is None:
            print("!!! Element not found !!!")
            return
        else:
            data = input("Enter value : ")
            new_node = node(data)
            new_node.left = ptr.left
            new_node.right = ptr
            ptr.left = new_node
            if ptr == self.start:
                self.start = new_node
            else:
                new_node.left.right = new_node
            print("__ Value inserted successfully__")

    def delete(self):
        ptr = self.searchElement()
        if ptr is None:
            print("!!! Element not found !!!")
            return
        elif ptr == self.start and ptr ==  self.last:
            ptr.right = None
            ptr.left = None
            self.start = None
            self.last = None
        elif ptr == self.start:
            self.start = ptr.right
            ptr.right.left = None
            ptr.right = None
        elif ptr == self.last:
            self.last = ptr.left
            ptr.left.right = None
            ptr.left = None
        else:
            ptr.left.right = ptr.right
            ptr.right.left = ptr.left
            ptr.left = None
            ptr.right = None
        print("__ Element deleted successfully __")

    
    def deleteafter(self):
        ptr = self.searchElement()
        if ptr is None:
            print("!!! Element not found !!!")
            return
        elif ptr == self.last or ptr.right == None:
            print("!!! Deletion not possible !!!")
            return
        elif ptr.right == self.last:
            p = ptr.right
            ptr.right = None
            self.last = ptr
        else:
            p = ptr.right
            ptr.right = p.right
            p.right.left = ptr
        print("__ Element deleted successfully __")

    def deleteb4(self):
        ptr = self.searchElement()
        if ptr is None:
            print("!!! Element not found !!!")
            return
        elif ptr == self.start:
            print("!!! Deletion not possible !!!")
            return
        elif ptr.left == self.start:
            p = ptr.left
            p.left = None
            self.start = ptr
        else:
            p = ptr.left
            ptr.left = p.left
            p.left.right = ptr
            p.left = None
            p.right = None
        print("__ Element deleted successfully __")
        
obj = doublylinkedlist()