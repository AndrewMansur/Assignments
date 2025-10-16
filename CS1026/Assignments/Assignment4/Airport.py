# Defining airport class
class Airport:
    # Defining initialize method
    def __init__(self, code, city, country):
        self.code = code
        self.city = city
        self.country = country
    
    # Defining representation method
    def __repr__(self):
        # Returning the airport code, city, and country
        return (f"{self.code} ({self.city}, {self.country})")

    # Defining code getter
    def getCode(self):
        return self.code
    
    # Defining city getter
    def getCity(self):
        return self.city

    # Defining country getter
    def getCountry(self):
        return self.country

    # Defining city setter
    def setCity(self, city):
        self.city = city
        
    # Defining country Setter
    def setCountry(self, country):
        self.country = country




