import RPi.GPIO as GPIO

class SmokeSensor:
   'Class to get the smoke sensor readings'
   
   def __init__(self, pin):
      self.pin = pin
      GPIO.setmode(GPIO.BOARD)
      GPIO.setup(pin, GPIO.IN, pull_up_down=GPIO.PUD_DOWN) 
   def getSensorReading(self):
      if(GPIO.input(self.pin) == 1):
         print("smoke detected")
         return 1
      else:
         return 0
   
