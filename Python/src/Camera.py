from picamera import PiCamera
from time import sleep
import os


class Camera(object):
   def __init__(self, name):
      self.name=name
   def startCam(self):
      os.popen('~/Safe3D/startstream.sh start')
   def stopCam(self):
      os.popen('~/Safe3D/startstream.sh stop')
