FROM openjdk:8-jdk-alpine as build
ENV HOME=/build
RUN mkdir -p $HOME
WORKDIR $HOME
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
RUN ./mvnw dependency:go-offline
COPY . .
RUN echo "Building project"
RUN ./mvnw package
RUN echo "Build completed"

FROM openjdk:8-alpine
WORKDIR /app
ARG JAR_FILE=/build/target/*.jar
COPY --from=build $JAR_FILE app.jar
ENV WORD_STAT_PORT=8080
EXPOSE $WORD_STAT_PORT
ENTRYPOINT ["java","-jar","app.jar"]
