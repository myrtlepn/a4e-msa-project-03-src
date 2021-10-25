# Deploy with Docker Compose

## 개요

- Docker Compose를 활용하여 Microservice Architecture 구조의 Application 실행 환경 구축

## 목표

- Microservice Architecture의 구조에 대한 이해
- Docker를 활용한 Spring Boot Image 생성
- Docker Image & Container를 활용한 서버 구축
- Docker Compose를 활용한 개발 및 배포 환경 구축

## 준비 사항

- [Project #1](https://github.com/coupang-edu/a4e-msa-project-01)에서 작성한 Microservice Architecture 구조의 Application
  - 또는 아래와 같이 구성된 임의의 Application
    - Microservice * 2 (Database * 2)
    - Configuration Service * 1
    - Service Discovery * 1
    - Gateway Service * 1
- Docker Desktop (Docker Engine, CLI, Compose)


## 요구 사항

- Microservice Architecture 구조의 Application을 Docker 환경위에서 동작하도록 구성
- 각 서비스의 Docker Image를 생성하고, 해당 Image를 활용하여 Container 실행
- Docker Compose를 활용하여, 하나의 통합된 Application 환경 구축


### 0. 주의 사항

- Docker Image 생성 시 설정값이나 속성 등에 대한 외부화 및 환경변수화 작업 수행
- 아래의 명세에 명시되지 않은 내용은 **자유롭게** 구현


### 1. Services - Docker Image

- 각 서비스(Spring Boot Server)를 Docker Container로 실행하기 위한 **Dockerfile** 작성
- 각 서비스 마다 독립된 Database 사용
- 하나의 서비스에 대해 여러 개의 인스턴스를 생성할 수 있도록 설정에 유의하여 구성


### 2. Application - Docker Compose

- 해당 Application을 구성하는 모든 서비스들이 하나의 통합된 Docker 환경에서 동작하도록 하는 **docker-compose.yml** 파일 작성
- Application의 각 서비스 간의 통신을 위한 네크워크 설정
- Database 서버를 Docker Container로 실행할 경우, 데이터의 보존을 위한 볼륨 설정


### 3. Docker Registry 활용 (선택)

- Docker Hub, AWS ECR, Azure Container Registry 등의 Docker Registry에 Image를 등록
- Docker Compose에서 Local의 Dockerfile을 사용하지 않고, Registry에 등록된 Image를 사용하도록 설정



## 제출 방법

- Git을 통해 프로젝트 URL의 GitHub repository를 로컬로 clone

    ```bash
    $ git clone https://github.com/coupang-edu/a4e-msa-project-02
    $ cd a4e-msa-project-02
    ```

- 본인의 `사내 이메일의 아이디 부분`으로 branch 생성 및 이동

    ```bash
    $ git switch -c john
    ```

- 코드 작성이 완료된 프로젝트를, 아래와 같이 프로젝트 폴더명을 본인의 영문명으로 변경 (폴더 구조는 자유롭게 구성)

    ```bash
    README.md
    john/
        ├── config-server
        │   ├── ...
        │   └── Dockerfile
        ├── eureka-server
        │   ├── ...
        │   └── Dockerfile
        ├── product-service
        │   ├── ...
        │   └── Dockerfile
        ├── review-service
        │   ├── ...
        │   └── Dockerfile
        ├── ...
        └── docker-compose.yml
    ```

- 코드 작성 완료 후, 해당 branch를 push

    ```bash
    $ git push origin john
    ```

- Pull Request 생성하여 제출 완료
