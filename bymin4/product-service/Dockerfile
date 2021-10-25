FROM ubuntu:latest
WORKDIR /
# RUN apt update && apt upgrade -y
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk

ADD build/libs/app.jar app.jar

EXPOSE 10001

CMD ["/bin/bash", "-c", "exec java $JAVA_OPTS -jar app.jar"]