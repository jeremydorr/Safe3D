import os

class TempSensor(object):
   'Class to get the temperature read by the sensor'
   
   def __init__(self, units):
      self.units = units

   def getTemp(self):
      tempCmd = os.popen('./TempSense.sh')
      if self.units == "celsius":
        temp = tempCmd.read()
        print("temp is ", temp)
      else:
        cel = float(tempCmd.read())
        step1 = float(cel * 9)
        step2 = float(step1 / 5)

        temp = float(step2 + 32)
        print("temp is ", temp)
      return temp

   def setUnits(self, units):
      self.units = units
