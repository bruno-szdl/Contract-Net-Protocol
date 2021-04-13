#! /bin/bash

nRestaurants=50
nClients=20
nOrders=10

if [ $# -eq 3 ]; then
    nRestaurants=$1
    nClients=$2
    nOrders=$3
fi

echo "nOrders($nOrders).\nnClients($nClients)." > settings.asl
echo "MAS cnp {\n\tinfrastructure: Centralised\n\n\tagents:\n\t\tcontroller;\n\t\trestaurant #$nRestaurants;\n\t\tclient #$nClients;\n}" > cnp.mas2j

gradle -q --console=plain