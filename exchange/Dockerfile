FROM openjdk:8
VOLUME /tmp
ADD ./build/libs/exchange-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'

ENV MYSQL_HOST exchange.cvrodvxrqjz6.us-east-1.rds.amazonaws.com
ENV MYSQL_PORT 3306
ENV MYSQL_USERNAME admin
ENV MYSQL_PASSWORD password
ENV SPRING_PROFILES_ACTIVE dev

EXPOSE 5000

ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]