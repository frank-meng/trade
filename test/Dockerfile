FROM openjdk:8
VOLUME /tmp
ADD ./build/libs/exchange-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'

ENV MYSQL_HOST 192.168.2.10
ENV MYSQL_PORT 3326
ENV MYSQL_USERNAME root
ENV MYSQL_PASSWORD r00t
ENV SPRING_PROFILES_ACTIVE dev
ENV server.port 8888

ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]