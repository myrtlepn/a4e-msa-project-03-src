docker kill config-server
docker rm config-server
docker rmi config-server
./gradlew bootJar
docker build ./ -t config-server:latest
docker run --name config-server --network edu -p 8888:8888 config-server:latest

