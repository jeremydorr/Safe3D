import RPi.GPIO as GPIO

class RelayCtl:
   'Class to control the relay'
   
   def __init__(self, pin, defaultmode)
      GPIO.setup(pin, GPIO.OUT)
      self.pin = pin
      if(defaultmode == "on"):
         GPIO.output(pin, GPIO.HIGH)
      if (defaultmode == "off"):
         GPIO.output(ping, GPIO.LOW)
   def relayOn(self):
      GPIO.output(self.pin, GPIO.HIGH)
   def relayOff(self):
      GPIO.output(self.pin, GPIO.LOW)

