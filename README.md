# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/gradle-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Using Apache Camel with Spring Boot](https://camel.apache.org/camel-spring-boot/latest/index.html)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)


### To push image to Amazon ECR below are the prerequisite
- [Amazon-ecr-credential-helper](https://github.com/awslabs/amazon-ecr-credential-helper)
- Download [go](https://golang.org/dl/), which needed to install amazon-ecr-credential-helper, install & add to path
- Download [AWS CLI](https://aws.amazon.com/cli/), install & add to path

You can install Amazon-ecr-credential-helper via `go get` with:
```
go get -u github.com/awslabs/amazon-ecr-credential-helper/ecr-login/cli/docker-credential-ecr-login
```

To configure Amazon-ecr-credential-helper check the [configuration](https://github.com/awslabs/amazon-ecr-credential-helper#configuration) 

Docker build using google jib gradle plugin
* Open gradle/docker.gradle in project & start pushing image
* Configure all the credentials 
- go root project use below command to builds a container image to a registry
```sh
$ ./gradlew jib
```


