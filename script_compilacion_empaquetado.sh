#!/bin/bash

# Function to kill process running on a specific port
kill_process_on_port() {
    PORT=$1
    PID=$(sudo lsof -t -i :$PORT)
    if [ -n "$PID" ]; then
        echo "Killing process $PID running on port $PORT"
        sudo kill -9 $PID
    fi
}

# Kill any process running on the ports used by your services
kill_process_on_port 8888  # ConfigServer port
kill_process_on_port 8761  # EurekaServer port
kill_process_on_port 8081  # Eventos port
kill_process_on_port 8082  # Tickets port
kill_process_on_port 8083  # Usuarios port
kill_process_on_port 8084  # Funcionalidades_EventEase port

cd ConfigServer || exit
mvn clean package
if [ $? -ne 0 ]; then
      echo "Failed to build ConfigServer"
      exit 1
fi
echo "ConfigServer built successfully"

# Run ConfigServer in the background
java -jar target/*.jar &
CONFIG_SERVER_PID=$!
if [ $? -ne 0 ]; then
      echo "Failed to run ConfigServer"
      exit 1
fi
echo "ConfigServer running successfully"

# Wait for ConfigServer to be fully up and running
echo "Waiting for ConfigServer to be fully up and running..."
sleep 10

cd ../EurekaServer || exit
mvn clean package
if [ $? -ne 0 ]; then
      echo "Failed to build Eureka"
      kill $CONFIG_SERVER_PID
      exit 1
fi
echo "Eureka built successfully"

# Run EurekaServer in the background
java -jar target/*.jar &
EUREKA_SERVER_PID=$!
if [ $? -ne 0 ]; then
      echo "Failed to run Eureka"
      kill $CONFIG_SERVER_PID
      exit 1
fi
echo "Eureka running successfully"

# Wait for EurekaServer to be fully up and running
echo "Waiting for EurekaServer to be fully up and running..."
sleep 10

cd ../Eventos || exit
mvn clean package
if [ $? -ne 0 ]; then
      echo "Failed to build Eventos"
      kill $CONFIG_SERVER_PID $EUREKA_SERVER_PID
      exit 1
fi
echo "Eventos built successfully"

# Run Eventos in the background
java -jar target/*.jar &
EVENTOS_PID=$!
if [ $? -ne 0 ]; then
      echo "Failed to run Eventos"
      kill $CONFIG_SERVER_PID $EUREKA_SERVER_PID
      exit 1
fi
echo "Eventos running successfully"

# Wait for Eventos to be fully up and running
echo "Waiting for Eventos to be fully up and running..."
sleep 10

cd ../Tickets || exit
mvn clean package
if [ $? -ne 0 ]; then
      echo "Failed to build Tickets"
      kill $CONFIG_SERVER_PID $EUREKA_SERVER_PID $EVENTOS_PID
      exit 1
fi
echo "Tickets built successfully"

# Run Tickets in the background
java -jar target/*.jar &
TICKETS_PID=$!
if [ $? -ne 0 ]; then
      echo "Failed to run Tickets"
      kill $CONFIG_SERVER_PID $EUREKA_SERVER_PID $EVENTOS_PID
      exit 1
fi
echo "Tickets running successfully"

# Wait for Tickets to be fully up and running
echo "Waiting for Tickets to be fully up and running..."
sleep 10

cd ../Usuarios || exit
mvn clean package
if [ $? -ne 0 ]; then
      echo "Failed to build Usuarios"
      kill $CONFIG_SERVER_PID $EUREKA_SERVER_PID $EVENTOS_PID $TICKETS_PID
      exit 1
fi
echo "Usuarios built successfully"

# Run Usuarios in the background
java -jar target/*.jar &
USUARIOS_PID=$!
if [ $? -ne 0 ]; then
      echo "Failed to run Usuarios"
      kill $CONFIG_SERVER_PID $EUREKA_SERVER_PID $EVENTOS_PID $TICKETS_PID
      exit 1
fi
echo "Usuarios running successfully"

# Wait for Usuarios to be fully up and running
echo "Waiting for Usuarios to be fully up and running..."
sleep 10

cd ../Funcionalidades_EventEase || exit
mvn clean package
if [ $? -ne 0 ]; then
      echo "Failed to build Funcionalidades_EventEase"
      kill $CONFIG_SERVER_PID $EUREKA_SERVER_PID $EVENTOS_PID $TICKETS_PID $USUARIOS_PID
      exit 1
fi
echo "Funcionalidades_EventEase built successfully"

# Run Funcionalidades_EventEase in the background
java -jar target/*.jar &
FUNCIONALIDADES_PID=$!
if [ $? -ne 0 ]; then
      echo "Failed to run Funcionalidades_EventEase"
      kill $CONFIG_SERVER_PID $EUREKA_SERVER_PID $EVENTOS_PID $TICKETS_PID $USUARIOS_PID
      exit 1
fi
echo "Funcionalidades_EventEase running successfully"

# Wait for Funcionalidades_EventEase to be fully up and running
echo "Waiting for Funcionalidades_EventEase to be fully up and running..."
sleep 10

# Stop all servers after use
trap "kill $CONFIG_SERVER_PID $EUREKA_SERVER_PID $EVENTOS_PID $TICKETS_PID $USUARIOS_PID $FUNCIONALIDADES_PID" EXIT