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
COPY perico-client-backend-app/application-dev.yml /usr/src/app/perico-client-backend/perico-client-backend-app/application-dev.yml
COPY perico-client-backend-app/application-uat.yml /usr/src/app/perico-client-backend/perico-client-backend-app/application-uat.yml
COPY perico-client-backend-app/application-prd.yml /usr/src/app/perico-client-backend/perico-client-backend-app/application-prd.yml
COPY perico-client-backend-app/elastic-apm-agent-1.7.0.jar /usr/src/app/perico-client-backend/perico-client-backend-app/elastic-apm-agent-1.7.0.jar
EXPOSE 8080
#CMD exec java -Duser.timezone=America/Lima -XX:+PrintFlagsFinal $JAVA_OPTIONS -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -Dazure.keyvault.uri=$KEY_VAULT_URI -Dazure.keyvault.client-id=$KEY_VAULT_CLIENT_ID -Dazure.keyvault.client-key=$KEY_VAULT_CLIENT_KEY -Dazure.keyvault.tenant-id=$KEY_VAULT_TENANT_ID -javaagent:$JAVA_AGENT -Delastic.apm.service_name=$ELASTIC_APM_SERVICE_NAME -Delastic.apm.application_packages=$ELASTIC_APM_APPLICATION_PACKAGES -Delastic.apm.enable_log_correlation=$ELASTIC_APM_ENABLE_LOG_CORRELATION -Delastic.apm.server_urls=$ELASTIC_APM_SERVER_URLS -Delastic.apm.instrument=$ELASTIC_APM_INSTRUMENT -Delastic.apm.log_level=$ELASTIC_APM_LOG_LEVEL -jar perico-client-backend-app-0.0.1-SNAPSHOT.jar
CMD exec java -Duser.timezone=America/Lima -XX:+PrintFlagsFinal $JAVA_OPTIONS -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -Dazure.keyvault.uri=$KEY_VAULT_URI -Dazure.keyvault.client-id=$KEY_VAULT_CLIENT_ID -Dazure.keyvault.client-key=$KEY_VAULT_CLIENT_KEY -Dazure.keyvault.tenant-id=$KEY_VAULT_TENANT_ID -jar perico-client-backend-app-0.0.1-SNAPSHOT.jar