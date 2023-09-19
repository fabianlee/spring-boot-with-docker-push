# spring-boot-with-docker-push

Minimal Spring Boot project that shows how to use gradle and Palantir plugins
to create OCI-compatible (Docker) image.

Is instrumented with Actuator and documented using OpenDocs/Swagger.

Full blog: https://fabianlee.org/2022/06/30/java-creating-docker-image-for-spring-boot-web-app-using-gradle/

## Project initially created using Spring Intializer

[Spring Initializer Web UI](https://start.spring.io/)

```
id=spring-boot-with-docker-push
artifact_id="${id//-}"
SpringAppClassName=SpringMain
version="0.0.2-SNAPSHOT"
groupId="org.fabianlee"

curl https://start.spring.io/starter.zip \
    -d type=gradle-project \
    -d dependencies=web,prometheus,devtools,actuator \
    -d javaVersion=11 \
    -d bootVersion=2.7.0 \
    -d groupId=$groupId \
    -d artifactId=$artifact_id \
    -d name=$SpringAppClassName \
    -d baseDir=$id \
    -d version=$version \
    -o $id.zip

unzip $id.zip
cd $id
chmod +x ./gradlew
```

# Creating tag that invokes Github Action

```
newtag=v1.0.1
git commit -a -m "changes for new tag $newtag" && git push
git tag $newtag && git push origin $newtag
```

# Deleting tag

```
# delete local tag, then remote
todel=v1.0.1
git tag -d $todel && git push origin :refs/tags/$todel
```

