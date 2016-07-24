#!/bin/bash

case $1 in

start)
  mkdir -p /tmp/stream
  raspistill --nopreview -vf -hf -w 640 -h 480 -q 5 -o /tmp/stream/pic.jpg -tl 100 -t 9999999 -th 0:0:0 &
  LD_LIBRARY_PATH=/usr/local/lib mjpg_streamer -i "input_file.so -f /tmp/stream -n pic.jpg" -o "output_http.so -w /usr/local/www"
  ;;
stop)
  pkill -f raspistill
  pkill -f mjpg_streamer
  ;;
*)
  echo "unsupported use of this script.  use start or stop"
  ;;
esac
