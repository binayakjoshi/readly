#!/bin/zsh

if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <project_directory> <tomcat_directory>"
    exit 1
fi

PROJECT_DIR="$1"
TOMCAT_DIR="$2"


mvn clean install  && \
cp "$PROJECT_DIR/target/readly.war" "$TOMCAT_DIR/webapps" && \
"$TOMCAT_DIR/bin/shutdown.sh" && \
"$TOMCAT_DIR/bin/startup.sh"
