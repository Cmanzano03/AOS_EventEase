#!/bin/bash

# OJO!! El config server debe empaquetarse y lanzarse por separado antes de lanzar este script, dado que este necesita 
# estar en ejecución para que los demás microservicios puedan obtener la configuración de sus propiedades durante el empaquetado.

# Script para ejecutar todos los microservicios con redundancia,  el Eureka Server , y el microservicio central

echo "Iniciando Eureka Server..."
gnome-terminal --tab -- bash -c "cd ./EurekaServer; mvn spring-boot:run" &
sleep 10

echo "Iniciando Funcionalidades_EventEase ..."
gnome-terminal --tab -- bash -c "cd Funcionalidades_EventEase; java -jar target/Funcionalidades_EventEase-0.0.1-SNAPSHOT.jar" &
sleep 5

echo "Iniciando dos instancias de Microservicio de Eventos ..."
gnome-terminal --tab -- bash -c "cd Eventos; java -jar target/Eventos-0.0.1-SNAPSHOT.jar --server.port=8081" &
gnome-terminal --tab -- bash -c "cd Eventos; java -jar target/Eventos-0.0.1-SNAPSHOT.jar --server.port=8082" &
sleep 5

echo "Iniciando dos instancias de Microservicio de Tickets..."
gnome-terminal --tab -- bash -c "cd Tickets; java -jar target/Tickets-0.0.1-SNAPSHOT.jar --server.port=8083" &
gnome-terminal --tab -- bash -c "cd Tickets; java -jar target/Tickets-0.0.1-SNAPSHOT.jar --server.port=8084" &
sleep 5

echo "Iniciando dos instancias de Microservicio de Usuarios..."
gnome-terminal --tab -- bash -c "cd Usuarios; java -jar target/Usuarios-0.0.1-SNAPSHOT.jar --server.port=8085" &
gnome-terminal --tab -- bash -c "cd Usuarios; java -jar target/Usuarios-0.0.1-SNAPSHOT.jar --server.port=8086" &
sleep 5

echo "Todos los microservicios están en proceso de ejecución."

# Espera a que todos los procesos en segundo plano terminen (opcional)
wait
