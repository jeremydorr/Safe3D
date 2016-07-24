import RPi.GPIO as GPIO
from gpiozero import LED

class RelayCtl:
   'Class to control the relay'
   
   def __init__(self, pin, defaultmode):
      self.pin = pin
      self.relay=LED(pin)
      if(defaultmode == "on"):
         self.relay.on()
      if (defaultmode == "off"):
         self.relay.off()
   def relayOn(self):
      self.relay.on()
   def relayOff(self):
      self.relay.off()

