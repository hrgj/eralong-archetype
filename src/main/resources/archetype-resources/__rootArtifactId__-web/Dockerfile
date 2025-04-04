FROM openjdk:17-jdk-slim
RUN apt-get update && \
    apt-get install -y tzdata && \
    rm -rf /var/lib/apt/lists/*
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN mkdir -p /app/logs
WORKDIR /app
# 设置环境变量
ENV JAVA_OPTS="-Xmx512m -Xms256m"

COPY target/complex-web-0.0.1-SNAPSHOT.jar /app/complex-web.jar
EXPOSE 8083
CMD ["java", \
 "-Dlog4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector", \
 "-Dlog4j2.asyncLoggerWaitStrategy=TimeoutBlocking", \
 "-Dlog4j2.disableJmx=true", \
 "-Dlog4j2.enableThreadlocals=true", \
 "-Dlog4j2.asyncQueueFullPolicy=Enqueue", \
"-jar", "/app/complex-web.jar"]