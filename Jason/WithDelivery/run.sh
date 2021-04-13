#! /bin/bash

nDeliveryMen=50
nRestaurants=50
nClients=20
nOrders=5

if [ $# -eq 4 ]; then
    nDeliveryMen=$1
    nRestaurants=$2
    nClients=$3
    nOrders=$4
fi

echo "nOrders($nOrders).\nnClients($nClients)." > settings.asl
echo "MAS cnp {\n\tinfrastructure: Centralised\n\n\tagents:\n\t\tcontroller #1;\n\t\tdeliveryman #$nDeliveryMen;\n\t\trestaurant #$nRestaurants;\n\t\tclient #$nClients;\n}" > cnp.mas2j

gradle -q --console=plain