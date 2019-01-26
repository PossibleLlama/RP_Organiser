FROM maven:3.6.0-jdk-8-alpine as builder

COPY . /src
WORKDIR /src/rpls.characters

RUN mvn install

FROM openjdk:8u191-jdk-alpine3.8

COPY --from=builder /src .
WORKDIR rpls.characters/target
