FROM daocloud.io/library/java:openjdk-8u40-jdk

ENV JAVA_OPTS="" \
    SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    SPRING_PROFILES_ACTIVE=prod \
    SPRING_OPTS=""

# add directly the jar
ADD *.war /app.war
RUN sh -c 'touch /app.war'

VOLUME /tmp
EXPOSE 8761


CMD java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.war \
    --spring.profiles.active=${SPRING_PROFILES_ACTIVE} \
    ${SPRING_OPTS}
