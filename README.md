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

kubectl get deployments

kubectl get pods

kubectl get services

minikube service springboot-k8s-mysql

minikube dashboard

/users
```

<img width="1134" alt="Screenshot 2023-02-17 at 12 18 14 AM" src="https://user-images.githubusercontent.com/43849911/219459357-9970036c-1479-4f7c-921e-c8207e470e3d.png">

