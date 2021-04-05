FROM openjdk:12
VOLUME /tmp
EXPOSE 8090
ADD ./target/springboot.microservicio.zuul-server-v.1.0.jar zuul-server.jar
ENTRYPOINT [ "java","-jar","zuul-server.jar" ]