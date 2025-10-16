class Car:
    def __init__(self):
        self._type = None 

    def setType(self,type):
         self._type = type
         

    def getType(self):
        return self._type

c1 = Car()
c2 = Car()
c3 = Car()

c1.setType("Toyota")
c2.setType("Honda")
c3.setType("Nissan")

print(c1.getType())
print(c2.getType())
print(c3.getType())