import SmokeSensor

SSense = SmokeSensor.SenseSmoke(26)

while True:
  smoke = SSense.getSensorReading()
  if smoke == 1:
    print("smoke!!!")

