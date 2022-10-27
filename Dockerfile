FROM openjdk:11
ARG perico-client-backend-app
ARG 0.0.1
ENV artifact perico-client-backend-app-0.0.1.jar
  # Create app directory
RUN mkdir -p /usr/src/app/perico-client-backend/perico-client-backend-app
RUN mkdir -p /data
WORKDIR /usr/src/app/perico-client-backend/perico-client-backend-app/
  # Install app dependencies
COPY perico-client-backend-app/target/perico-client-backend-app-0.0.1-SNAPSHOT.jar /usr/src/app/perico-client-backend/perico-client-backend-app/perico-client-backend-app-0.0.1-SNAPSHOT.jar
COPY perico-client-backend-app/application.yml /usr/src/app/perico-client-backend/perico-client-backend-app/application.yml
EXPOSE 8080
CMD exec java -Duser.timezone=America/Lima -XX:+PrintFlagsFinal $JAVA_OPTIONS -jar perico-client-backend-app-0.0.1-SNAPSHOT.jar