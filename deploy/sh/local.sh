# Spring Boot demo application for Kubernetes

# For Local environmnet

echo "Creating Spring Boot demo application for Kubernetes on local environment"
minikube stop
minikube start

kubectl apply -f ../db/postgres-configmap.yml
kubectl apply -f ../db/postgres-credentials.yml

### Create deployments and services
# db
kubectl apply -f ../db/deployment.yml

# apserver (For Local environment)
kubectl apply -f ../app/deployment.yml

CTX=$(kubectl config current-context)
echo ${CTX}

minikube service my-app
