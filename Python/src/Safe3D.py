import RelayControl
import SmokeSensor
import Camera
import TempRead
import os

maxTemp=int(50)
# set up our objects
# first is our  relay.  Turn it on with RelayObj.relayOn() and off with RelayObj.relayOff()
RelayObj=RelayControl.RelayCtl(21,'on')

#next we set up our temperature reading.  get the temperature reading with TempObj.getTemp()
TempObj=TempRead.TempSensor('celsius')

# now we set up the smoke detection object
SmokeObj=SmokeSensor.SenseSmoke(16)

#turn on the relay to allow power to our load!
RelayObj.relayOn()

# kick off the stream, and nameit bob?
Cam=Camera.Camera('bob')
Cam.startCam()

# begin main loop
while True:
   temp=TempObj.getTemp()
   print("temperature is: ", temp)
   if(float(temp) > maxTemp):
      print("Max Temp Exceeded, shutting down")
      RelayObj.relayOff()
      break
   smoke=SmokeObj.getSensorReading()
   print("Smoke is: ", smoke)
   if(smoke == 1):
      print("Smoke Detected, shutting down")
      RelayObj.relayOff()
      break

#looks like we are shut down, shut down the stream
Cam.stopCam()
