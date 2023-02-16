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

kubectl get configmap

kubectl apply -f mysqldb-root-credentials.yml

kubectl apply -f mysqldb-credentials.yml

kubectl get secrets

kubectl apply -f mysql-deployment.yml

kubectl get deployments

kubectl get services

kubectl apply -f deployment.yml

kubectl get deployments

kubectl get pods

kubectl get services

minikube service springboot-k8s-mysql
```

