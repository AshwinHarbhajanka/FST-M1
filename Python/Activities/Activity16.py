class Car:
    def __init__(self,manufacturer,model,make,transmission,color):
        self.manufacturer=manufacturer
        self.model=model
        self.make=make
        self.transmission=transmission
        self.color=color
    def accelerate(self):
        print(self.manufacturer, " ", self.model, " is moving")
    def stop(self):
        print(self.manufacturer, " ", self.model, " has stopped")
    def details(self):
        print(self.manufacturer,self.model,self.make,self.color,self.transmission)
car1= Car("Maruti- Suzuki", "Baleno", "2020", "5- Gear", "Magma Metal Grey")
car2= Car("Toyota","Corolla","2019","5- Gear","Black")
car3= Car("Hyundai","Verna","2018","6- Gear","White")
car1.accelerate()
car1.stop()
car1.details()
car2.details()
car3.details()
