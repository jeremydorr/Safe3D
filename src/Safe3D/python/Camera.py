from picamera import PiCamera
from time import sleep

class Camera:
   'Class to instantiate camera'
   def __init__(self):
      camera = PiCamera()
   def startCam(self):
      camera.start_preview()
   def stopCam(self)
      camera.stop_preview()
