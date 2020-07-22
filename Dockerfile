FROM openjdk:8

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/vuttr_api

COPY /target/VUTTR-API*.jar vuttr_api.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 3000

CMD java ${ADDITIONAL_OPTS} -jar vuttr_api.jar --spring.profiles.active=${PROFILE}