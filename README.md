# Talkers-App

[![Build Status](https://jenkins.rubenjg.com/buildStatus/icon?job=Talkers-App)](https://jenkins.rubenjg.com/job/Talkers-App/)

Skeleton for a Master's degree team project.

# Environment

We recommend the following tools for local development:
* [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows) 
* [SonarLint](https://www.sonarlint.org/intellij/)

# Ports in use

* Zuul: 9000
* Eureka: 9001
* Users: 9002
* Messages: 9003

# Base URLs

Locally:

* [Users](http://192.168.1.4:9000/api/v1/users/hello)
* [Messages](http://192.168.1.4:9000/api/v1/messages/hello)

# How to run

Please create Run Configuration in which you set the environment variable 
`SPRING_PROFILES_ACTIVE` to `default,local` when developing locally and to
`default,prod` when in production

