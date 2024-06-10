def tails():
    print('''                      
                             .  .
                          .        .
                        .            .
                       .              .
                       .    TAILS     .                                                              
                        .            .
                          .        .
                             .  .     ''')

def heads():
    print('''                      
                             .  .
                          .        .
                        .            .
                       .              .
                       .    HEADS     .                                                              
                        .            .
                          .        .
                             .  .     ''')
    
import random 
value = random.randint(1,2)
if value == 1:
    tails()
elif value == 2:
    heads()
else:
    print('Someone tried to hack this program')