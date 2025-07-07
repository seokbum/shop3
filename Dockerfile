# 1단계: 빌드 환경
FROM openjdk:17-jdk-slim AS builder
WORKDIR /app

# 필수 유틸리티 설치
RUN apt-get update && apt-get install -y --no-install-recommends \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# Gradle Wrapper 파일 먼저 복사
COPY gradlew gradle-wrapper.jar ./
COPY gradle ./gradle
RUN chmod +x ./gradlew

# 의존성 다운로드 (캐시 활용)
COPY build.gradle settings.gradle ./
RUN ./gradlew dependencies --no-daemon --refresh-dependencies

# 나머지 소스 코드 복사
COPY . .

# 빌드 실행
RUN ./gradlew build -x test --stacktrace --no-daemon

# 2단계: 런타임 환경
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/shop3-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]