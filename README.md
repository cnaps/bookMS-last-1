# BookMS
- Book Domain Model
  ![image](https://github.com/cnaps/BookMS/assets/15258916/3053a14e-e445-438e-a9eb-deb848527251)
- 도메인 모델 vs 코드와 일치하지 않는 부분
  - serchBook 메소드 , book이 가질 책임이 아님
  - no의 타입은 long

- 도커 파일 생성
  - Dockerfile 생성
    ```
    FROM openjdk:11-jre-slim
    ARG JAR_FILE_PATH=target/*.jar
    COPY ${JAR_FILE_PATH} app.jar
    EXPOSE 8080
    CMD ["java", "-jar", "app.jar"]
     ```

- 빌드
  - 어플리케이션 빌드

    ```
    mvn clean package 
    ```

- 컨테이너 생성
  - 도커 컨테이너 이미지 생성

    ```
     docker build -t bookms:0.0.1 . 
    ```

    ```
    docker image 
    ```

  - 도커 컨테이너 실행

    ``` 
    docker run --name BookMS -p 8081:8081 bookms:0.0.1
    ```
