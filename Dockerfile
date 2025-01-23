FROM docker.io/openjdk:21

COPY target/portal-servicos-1.0.jar portal-servicos-1.0.jar
ENTRYPOINT ["java","-jar","/portal-servicos-1.0.jar"]
