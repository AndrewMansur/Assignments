class Coffee:
    def __init__(self):
        self._cost = 2.50
    
    def __add__ (self, other):
        if isinstance(other, Cream):
            return "Yum"

class Cream:
    def __init__(self):
        self._percent = 10

coffee = Coffee()
cream = Cream()

print(coffee + cream)