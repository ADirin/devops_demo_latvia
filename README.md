Average Speed Calculator – DevOps Demo (Latvia 2026)
This project demonstrates a complete DevOps pipeline using a simple Java function to calculate average speed.
It covers unit testing, code coverage, CI/CD with Jenkins, Docker image creation, Docker Hub publishing, and Kubernetes deployment.


## 📌 Functionality
The application calculates average speed using the formula:
Average Speed=distancetime\text{Average Speed} = \frac{\text{distance}}{\text{time}}Average Speed=timedistance​
Java method
````
public static double calAverageSpeed(double distance, double time) {
    if (time == 0) {
        throw new IllegalArgumentException("zero is not acceptable");
    }
    return distance / time;
}
````
## 🧪 Unit Testing
Unit tests are written using JUnit 5 (Jupiter).

###Test cases include:

✅ Normal calculation
❌ Exception when time is zero

Example test
```
@Test
void testCalAverageSpeed_NormalCase() {
    assertEquals(5.0, AverageSpeed.calAverageSpeed(100, 20), 0.0001);
}

@Test
void testCalAverageSpeed_TimeIsZero() {
    assertThrows(IllegalArgumentException.class,
        () -> AverageSpeed.calAverageSpeed(100, 0));
}

```
## 📊 Code Coverage
JaCoCo is used to measure test coverage.
Coverage reports are generated during the build:
````
 mvn jacoco:reportShow more lines
````
Report location:
````
target/site/jacoco/index.html
````
## 🔁 Jenkins CI/CD Pipeline
The project uses a Declarative Jenkins Pipeline.

### Pipeline stages:

1. Checkout source code
2. Build & test with Maven
3. Generate JaCoCo coverage report
4. Publish JUnit test results
5. Publish coverage report

Jenkinsfile (summary)
````
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/ADirin/devops_demo_latvia.git'
            }
        }
        stage('Build & Test') {
            steps {
                bat 'mvn clean verify'
            }
        }
        stage('Generate Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }
    }
}

````
## 🐳 Docker
The application is packaged as a Docker image.

### Dockerfile (simplified)
````
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
````

### Build image
````
docker build -t amirdirin/lectdemo2026_latvia_devops:1.0 .Show more lines
````

## 📦 Docker Hub
The image is published to Docker Hub.
### Push image
````
docker push amirdirin/lectdemo2026_latvia_devops:1.0Show more lines
````
Docker Hub repository:
````
https://hub.docker.com/r/amirdirin/lectdemo2026_latvia_devops
````

## ☸️ Kubernetes Deployment
 The application is deployed to Kubernetes (Minikube).

### Deployment uses:

- Explicit image tag (:1.0)
- Resource requests & limits

### Example deployment snippet
````YAM
Lcontainers:  
  - name: avg-speed-latvia    
  image: amirdirin/lectdemo2026_latvia_devops:1.0  
  imagePullPolicy: IfNotPresentShow more lines

````
Check pod status
````
kubectl get podsShow more lines
````
#### ✅ Expected:
````
avg-speed-latvia   1/1   Running
````

## ⚠️ Important Note: Console Input in Kubernetes
This application does not support interactive console input in Kubernetes.
Kubernetes pods:

❌ Do not support Scanner(System.in)
✅ Use arguments, environment variables, or REST APIs

This is expected Kubernetes behavior.

## ✅ Technologies Used

- Java 21
- Maven
- JUnit 5
- JaCoCo
- Jenkins
- Docker
- Docker Hub
- Kubernetes (Minikube)


## 🎓 Educational Purpose
This project is designed for:

DevOps teaching
CI/CD demonstrations
Jenkins + Docker + Kubernetes workflows

It shows how even a simple function can be integrated into a full DevOps pipeline.

## 👤 Author
####Amir Dirin

Metropolia University of Applied Sciences

Winter 2026 – Latvia

[pods, sq, jemter] https://github.com/ADirin/AverageSpeed_pod_jmeter.git
[FXML]https://github.com/ADirin/devops_demo_latvia.git
