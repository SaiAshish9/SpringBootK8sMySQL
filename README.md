```
configMap (k8s objects) will store the non sensitive data and secrets will store the sensitive data.
```

```
echo -n 'admin123' | base64
YWRtaW4xMjM=

echo -n 'testuser' | base64
dGVzdHVzZXI=

echo -n 'testuser@123' | base64
dGVzdHVzZXJAMTIz
```

```
docker rm $(docker ps -a -q) -f
docker rmi $(docker images -a -q) -f
```

```
minikube start                 
😄  minikube v1.29.0 on Darwin 12.6
✨  Using the docker driver based on existing profile
👍  Starting control plane node minikube in cluster minikube
🚜  Pulling base image ...
E0217 00:10:59.072180    2212 cache.go:188] Error downloading kic artifacts:  failed to download kic base image or any fallback image
🤷  docker "minikube" container is missing, will recreate.
🔥  Creating docker container (CPUs=2, Memory=4000MB) ...
🐳  Preparing Kubernetes v1.26.1 on Docker 20.10.23 ...
🔗  Configuring bridge CNI (Container Networking Interface) ...
🔎  Verifying Kubernetes components...
    ▪ Using image gcr.io/k8s-minikube/storage-provisioner:v5
    ▪ Using image docker.io/kubernetesui/dashboard:v2.7.0
    ▪ Using image docker.io/kubernetesui/metrics-scraper:v1.0.8
💡  Some dashboard features require the metrics-server addon. To enable all features please run:

	minikube addons enable metrics-server	


🌟  Enabled addons: storage-provisioner, default-storageclass, dashboard
🏄  Done! kubectl is now configured to use "minikube" cluster and "default" namespace by default
```

```
kubectl apply -f mysql-configmap.yml
configmap/db-conf created

kubectl get configmap               
NAME               DATA   AGE
db-conf            2      46s
kube-root-ca.crt   1      13d
mongo-conf         2      7d15h

kubectl apply -f mysqldb-root-credentials.yml
secret/db-root-credentials created

kubectl apply -f mysqldb-credentials.yml
secret/db-credentials created

kubectl get secrets
NAME                  TYPE     DATA   AGE
db-credentials        Opaque   2      14s
db-root-credentials   Opaque   1      28s
db-user-pass          Opaque   2      13d
mongo-secret          Opaque   2      7d15h

kubectl apply -f mysql-deployment.yml
service/mysql created
persistentvolumeclaim/mysql-pv-claim created
deployment.apps/mysql created

kubectl get deployments
NAME                   READY   UP-TO-DATE   AVAILABLE   AGE
mongo                  1/1     1            1           7d14h
mysql                  0/1     1            0           14s
spring-mongo-service   0/2     2            0           46h

kubectl get services
NAME                   TYPE        CLUSTER-IP     EXTERNAL-IP   PORT(S)          AGE
kubernetes             ClusterIP   10.96.0.1      <none>        443/TCP          13d
mongodb-service        ClusterIP   None           <none>        27017/TCP        7d15h
mysql                  ClusterIP   None           <none>        3306/TCP         28s
spring-mongo-service   NodePort    10.106.6.107   <none>        8080:30081/TCP   46h

kubectl apply -f deployment.yml
service/springboot-k8s-mysql created
deployment.apps/springboot-k8s-mysql created

kubectl delete deploy springboot-k8s-mysql
deployment.apps "springboot-k8s-mysql" deleted

kubectl delete svc springboot-k8s-mysql   
service "springboot-k8s-mysql" deleted

kubectl delete svc mysql                  
service "mysql" deleted

kubectl delete deploy mysql            
deployment.apps "mysql" deleted

docker build -t springboot-k8s-mysql:1.0 .
[+] Building 1.7s (7/7) FINISHED                                                                                           
 => [internal] load build definition from Dockerfile                                                                  0.0s
 => => transferring dockerfile: 176B                                                                                  0.0s
 => [internal] load .dockerignore                                                                                     0.0s
 => => transferring context: 2B                                                                                       0.0s
 => [internal] load metadata for docker.io/adoptopenjdk/openjdk11:alpine-jre                                          1.6s
 => [internal] load build context                                                                                     0.0s
 => => transferring context: 173B                                                                                     0.0s
 => [1/2] FROM docker.io/adoptopenjdk/openjdk11:alpine-jre@sha256:99016d0d7a3c18d2591b6c4f436e646e86d19ee55f60354a08  0.0s
 => CACHED [2/2] ADD target/springboot-k8s-mysql.jar app.jar                                                          0.0s
 => exporting to image                                                                                                0.0s
 => => exporting layers                                                                                               0.0s
 => => writing image sha256:e1ff03f26ad5b7bf24ac02b48a6aa29565cf721e03ee5a2815e4530cae04ac2c                          0.0s
 => => naming to docker.io/library/springboot-k8s-mysql:1.0                                                           0.0s

Use 'docker scan' to run Snyk tests against images to find vulnerabilities and learn how to fix them

docker run springboot-k8s-mysql:latest    

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.6.RELEASE)

2023-02-16 19:07:33.449  INFO 1 --- [           main] c.s.k.s.SpringbootK8sMysqlApplication    : Starting SpringbootK8sMysqlApplication v0.0.1-SNAPSHOT on 49a4af5a13fd with PID 1 (/app.jar started by root in /)
2023-02-16 19:07:33.452  INFO 1 --- [           main] c.s.k.s.SpringbootK8sMysqlApplication    : No active profile set, falling back to default profiles: default
2023-02-16 19:07:34.047  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2023-02-16 19:07:34.106  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 49ms. Found 1 JPA repository interfaces.
2023-02-16 19:07:34.683  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-02-16 19:07:34.694  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-02-16 19:07:34.695  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.33]
2023-02-16 19:07:34.757  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-02-16 19:07:34.758  INFO 1 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1252 ms
2023-02-16 19:07:34.917  INFO 1 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2023-02-16 19:07:34.981  INFO 1 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.12.Final
2023-02-16 19:07:35.088  INFO 1 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.0.Final}
2023-02-16 19:07:35.161  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-02-16 19:07:36.325  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.

kubectl apply -f mysql-deployment.yml     
service/mysql created
persistentvolumeclaim/mysql-pv-claim unchanged
deployment.apps/mysql created

kubectl apply -f deployment.yml
service/springboot-k8s-mysql created
deployment.apps/springboot-k8s-mysql created

kubectl get deployments
NAME                   READY   UP-TO-DATE   AVAILABLE   AGE
mongo                  1/1     1            1           7d14h
mysql                  1/1     1            1           8m14s
spring-mongo-service   0/2     2            0           47h
springboot-k8s-mysql   0/3     3            0           20s

kubectl get pods       

kubectl get services
NAME                   TYPE        CLUSTER-IP     EXTERNAL-IP   PORT(S)          AGE
kubernetes             ClusterIP   10.96.0.1      <none>        443/TCP          13d
mongodb-service        ClusterIP   None           <none>        27017/TCP        7d15h
mysql                  ClusterIP   None           <none>        3306/TCP         9m6s
spring-mongo-service   NodePort    10.106.6.107   <none>        8080:30081/TCP   47h
springboot-k8s-mysql   NodePort    10.99.34.5     <none>        8080:30163/TCP   72s

minikube service springboot-k8s-mysql

http://127.0.0.1:50226/users

minikube dashboard

/users

kubectl exec -it mysql-86d6d9f779-k7vh7 /bin/bash
```

<img width="1134" alt="Screenshot 2023-02-17 at 12 18 14 AM" src="https://user-images.githubusercontent.com/43849911/219459357-9970036c-1479-4f7c-921e-c8207e470e3d.png">

