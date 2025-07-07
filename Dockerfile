# 1단계 : 빌드 환경 (Gradle 사용)
FROM openjdk:17-jdk-slim AS builder
# 작업 폴더의 경로 app로 설정
WORKDIR /app

# gradlew 실행 스크립트와 Gradle 설정 파일/디렉토리를 복사 (캐싱 효율을 위해 먼저)
COPY gradlew .
COPY gradle gradle/
COPY settings.gradle .
COPY build.gradle .

# 필요한 경우 서브모듈 등 추가 소스 복사 (없으면 삭제 가능)
# COPY sub_module_folder sub_module_folder/

# gradlew 실행 권한 부여
RUN chmod +x ./gradlew

# 소스 코드 복사 (여기서 src 폴더 등이 복사됨)
COPY src src/

# 빌드 수행 기능: bootJar (bootJar 태스크가 jar 파일을 생성함)
# -x test : 테스트는 실행하지 않음
# --stacktrace : 오류 발생 시 상세 스택트레이스 출력 (디버깅용)
RUN ./gradlew bootJar -x test --stacktrace

# 2단계 : 실제 런타임 환경
FROM openjdk:17-jdk-slim
# 작업 폴더의 경로 app로 설정
WORKDIR /app
# shop3-0.0.1-SNAPSHOT.jar : 빌드로 생성된 jar 파일
# app.jar 빌드된 파일의 이름 설정
# builder 스테이지에서 생성된 jar 파일을 'app.jar'라는 이름으로 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 포트 번호 정의. application.properties에 정의된 포트와 동일해야 함
EXPOSE 8080

# java -jar app.jar 명령문으로 컨테이너가 실행
ENTRYPOINT ["java","-jar","app.jar"]