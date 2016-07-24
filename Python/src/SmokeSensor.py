import RPi.GPIO as GPIO
from gpiozero import Button

class SenseSmoke(object):
   'Class to get the smoke sensor readings'
   
   def __init__(self, pin):
      self.pin = pin
      self.SmokeSense=Button(pin)
   def getSensorReading(self):
      if self.SmokeSense.is_pressed:
         return 1
      else:
         return 0
