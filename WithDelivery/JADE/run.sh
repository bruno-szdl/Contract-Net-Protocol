#! /bin/bash

nDeliveryMen=50
nRestaurants=50
nClients=100
nOrders=10

if [ $# -eq 4 ]; then
    nDeliveryMen=$1
    nRestaurants=$2
    nClients=$3
    nOrders=$4
fi

java -cp ".:./jade-4.3.jar" StartJade $nDeliveryMen $nRestaurants $nClients $nOrders