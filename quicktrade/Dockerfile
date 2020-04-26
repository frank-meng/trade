FROM openjdk:8
VOLUME /tmp
ADD ./target/quicktrade-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'

ENV MYSQL_HOST exchange.cvrodvxrqjz6.us-east-1.rds.amazonaws.com
ENV MYSQL_PORT 3306
ENV MYSQL_USERNAME admin
ENV MYSQL_PASSWORD password
ENV SPRING_PROFILES_ACTIVE dev
ENV EXCHANGE_URL=http://exchange-dev.us-east-1.elasticbeanstalk.com
ENV TRADER_ID=1
ENV JWT_ISSUER_URL=http://localhost:8080/auth/realms/frankrealm
ENV SERVER_PORT 5000
EXPOSE 5000

ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]