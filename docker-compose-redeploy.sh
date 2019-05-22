#!/bin/bash
echo Compile Application...
./mvnw clean install

echo Redeploy Application...

sudo docker-compose stop vulpi-starter-dev
sudo docker-compose kill vulpi-starter-dev
sudo docker-compose build vulpi-starter-dev
sudo docker-compose up -d --no-deps vulpi-starter-dev
