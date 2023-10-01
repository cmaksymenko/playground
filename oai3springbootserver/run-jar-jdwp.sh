#!/bin/bash

JAR_NAME=$(ls ./target/*.jar | head -n 1)

if [[ ! -f "$JAR_NAME" ]]; then
    echo "No JAR file found in ./target/"
    exit 1
fi

# Run the jar with JDWP parameters in listen mode without suspension
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000 -jar "$JAR_NAME"
