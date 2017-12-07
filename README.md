# Talkers-App

[![Build Status](https://jenkins.rubenjg.com/buildStatus/icon?job=Talkers-App)](https://jenkins.rubenjg.com/job/Talkers-App/)

Skeleton for a Master's degree team project.

# Environment

We recommend the following tools for local development:
* [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows) 
* [SonarLint](https://www.sonarlint.org/intellij/)

# Ports in use

* Zuul: 9900
* Eureka: 9901
* Users: 9902
* Messages: 9903
* Tawks: 9904

# Base URLs

Locally:

* [Users](http://localhost:9900/api/v1/users/hello)
* [Messages](http://localhost:9900/api/v1/messages/hello)
* [Tawks](http://localhost:9900/api/v1/tawks/hello)

# How to run

Please create Run Configuration in which you set the environment variable 
`SPRING_PROFILES_ACTIVE` to `default,local` when developing locally and to
`default,prod` when in production

