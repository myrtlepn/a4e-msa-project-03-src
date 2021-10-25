./gradlew bootJar
docker build ./ -t service-discovery:latest
