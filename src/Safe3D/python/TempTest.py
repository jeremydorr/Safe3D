import os
class TempSensor:
   'Class to get the temperature read by the sensor'
   
   def __init__(self, units):
      self.units = units

   def getTemp(self):
      tempCmd = os.popen('./TempSense.sh')
      temp = tempCmd.read()
      print("temp is ", temp)
      return temp

   def setUnits(self, units):
      self.units = units
