# Dockerfile : shop3프로젝트 폴더에 생성
# 도커 이미지 생성을 위한 파일
# 1단계 : 빌드 환경 (Gradle 사용)
FROM openjdk:17-jdk-slim AS builder
# 작업 폴더의 경로 app로 설정
WORKDIR /app
# 현재  shop3 전체를 app로 복사
COPY . .
# 리눅스 명령어  gradlew 파일에 실행 권한 부여
RUN chmod +x ./gradlew
# gradlew : 빌드 수행 기능. 빌드 수행
# clean package : 새로이 jar 파일 생성
RUN ./gradlew build -x test --stacktrace

# 2단계 : 실제 런타임 환경
FROM openjdk:17-jdk-slim
WORKDIR /app
# shop3-0.0.1-SNAPSHOT.jar : 빌드로 생성된 jar 파일
# app.jar 빌드된 파일의 이름 설정
COPY --from=builder /app/build/libs/shop3-0.0.1-SNAPSHOT.jar app.jar
#포트 번호 정의 .application.properties에 정의된 포토와 동일해야함
EXPOSE 8080
# java -jar app.jar 명령문으로 컨테이너가 실행
ENTRYPOINT ["java","-jar","app.jar"]