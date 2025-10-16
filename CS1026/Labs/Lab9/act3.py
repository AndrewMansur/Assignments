class CashRegister :    
    def __init__(self):  # need init      
        self._itemCount = 0         
        self._totalPrice = 0  
    def addItem(self,price):  # need self     
        self._itemCount = self._itemCount + 1         
        self._totalPrice = self._totalPrice + price          
    def clear(self):  # dont need total      
        self._itemCount = 0         
        self._totalPrice = 0.0              
    def getTotal(self):         
        return self._totalPrice 
                 
C1 = CashRegister()
C1.addItem(200) 
C1.addItem(100)
print(C1.getTotal()) 
C1.clear()
print(C1.getTotal())
