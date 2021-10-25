docker kill config-server
docker rm config-server
docker rmi config-server
./gradlew bootJar
docker build ./ -t config-server:latest
docker run --name config-server --network edu -p 8888:8888 config-server:latest




cd ./bymin4/config-server/
./gradlew bootJar
docker build ./ -t config-server:latest



curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
wget "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -O /usr/local/bin/docker-compose