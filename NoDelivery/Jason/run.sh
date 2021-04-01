#! /bin/bash

nRestaurants=50
nClients=200
nOrders=10

if [ $# -eq 3 ]; then
    nRestaurants=$1
    nClients=$2
    nOrders=$3
fi

echo "nOrders($nOrders).\nnClients($nClients)." > settings.asl
echo "MAS cnp {\n\tinfrastructure: Centralised\n\n\tagents:\n\t\controller;\n\t\trestaurant #$nRestaurants;\n\t\tclient #$nClients;\n}" > contracts.mas2j

jason cnp.mas2j