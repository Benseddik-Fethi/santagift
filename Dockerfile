FROM maven:3.8.1-openjdk-11-slim AS maven_build
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package


FROM openjdk
EXPOSE 8080
COPY --from=maven_build /tmp/target/santagift-0.0.1-SNAPSHOT.jar /data/santagift-0.0.1-SNAPSHOT.jar
CMD java -jar /data/santagift-0.0.1-SNAPSHOT.jar
