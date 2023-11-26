# Spring Boot demo application for Kubernetes

# For Local environmnet

echo "Creating Spring Boot demo application for Kubernetes on local environment"

### Create deployments and services
# db
kubectl apply -f ../db/statefulset.yaml
kubectl apply -f ../db/service.yaml

# apserver (For Local environment)
kubectl apply -f ../app/deployment.yaml
kubectl apply -f ../app/service.yaml

# LB
#kubectl apply -f ../lb/deployment.yaml
#kubectl apply -f ../lb/loadbalancer.yaml

CTX=$(kubectl config current-context)
echo ${CTX}

if [ "${CTX}" == "minikube" ]; then
    while true; do
        URL=$(minikube service my-app --url)
        echo ${URL}
        if [ "${URL}" == "" ]; then
            sleep 1
        else
            break;
        fi
    done
else
    URL="http://localhost"
fi
