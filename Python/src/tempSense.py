import os

hexRead = os.popen('sudo i2cget -y 1 0x48 0x00 w')
hexRaw = hexRead.read()
msbCmd = os.popen('echo ${hexraw:4:2}')
msb = msbCmd.read()
lsbCmd = os.popen('echo ${hexraw:2:1}')
lsb = lsbCmd.read()
decCmd = os.popen('printf "%d\n" "0x$msb$lsb"')
dec = decCmd.read()
print(dec)
tempCmd = os.popen('echo "scale=4; $dec*0.0625" | bc')
