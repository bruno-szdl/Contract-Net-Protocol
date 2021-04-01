#! /bin/bash

nRestaurants=50
nClients=200
nCNPs=10

if [ $# -eq 3 ]; then
    nRestaurants=$1
    nClients=$2
    nCNPs=$3
fi

java -cp ".:./jade-4.3.jar" StartJade $nRestaurants $nClients $nCNPs