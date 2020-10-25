FROM java:8
VOLUME /work_directory
ADD target/fetch_rewards-0.0.1-SNAPSHOT.jar fetch_rewards-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar","fetch_rewards-0.0.1-SNAPSHOT.jar"]