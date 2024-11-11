#!/bin/bash



cd "/home/carlos/Documentos/AOS/Portfolio/Entrega_2/Actividad2/EurekaServer" || exit
mvn clean package
if [ $? -ne 0 ]; then
      echo "Failed to build Eureka"
      exit 1
fi
echo "Eureka built successfully"

cd "/home/carlos/Documentos/AOS/Portfolio/Entrega_2/Actividad2/Eventos" || exit
mvn clean package
if [ $? -ne 0 ]; then
      echo "Failed to build Eventos"
      exit 1
fi
echo "Eventos built successfully"

cd "/home/carlos/Documentos/AOS/Portfolio/Entrega_2/Actividad2/Funcionalidades_EventEase" || exit
mvn clean package
if [ $? -ne 0 ]; then
      echo "Failed to build Funcionalidades_EventEase"
      exit 1
fi
echo "Funcionalidades_EventEase built successfully"

cd "/home/carlos/Documentos/AOS/Portfolio/Entrega_2/Actividad2/Tickets" || exit
mvn clean package
if [ $? -ne 0 ]; then
      echo "Failed to build tickets"
      exit 1
fi
echo "tickets built successfully"

cd "/home/carlos/Documentos/AOS/Portfolio/Entrega_2/Actividad2/Usuarios" || exit
mvn clean package
if [ $? -ne 0 ]; then
      echo "Failed to build usuarios"
      exit 1
fi
echo "usuarios built successfully"


