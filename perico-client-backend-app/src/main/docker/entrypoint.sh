#!/bin/sh
#
# Authors:
#           - Abner Ballardo <aballardo@intercorp.com.pe>
#

java $JAVA_OPTS -Djavax.net.ssl.trustStorePassword=changeit -Djava.security.egd=file:/dev/./urandom -jar /app.jar
