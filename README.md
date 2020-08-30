# demo
Demo restful springboot java application

## Dockerfile
```dockerfile
docker build -f Dockerfile -t stream:v1 .
docker run -p 8000:8080 7c4
```
http://localhost:8000/hello

## Dockerfile_test
```dockerfile
docker build -f Dockerfile -t stream_test:v1 .
docker run -p 7000:8080 7c4
```
http://localhost:7000/hello

## Dockerfile_prod
```dockerfile
docker build -f Dockerfile -t stream_prod:v1 .
docker run -p 8000:8080 7c4
```
http://localhost:8000/hello

```shell script
laptop@laptop-HP:~/IdeaProjects/demo$ docker images
REPOSITORY                             TAG                   IMAGE ID            CREATED             SIZE
stream                                 v1                    7c4ec477a2a9        3 minutes ago       121MB
stream_prod                            v1                    7c4ec477a2a9        3 minutes ago       121MB
stream_test                            v1                    7c4ec477a2a9        3 minutes ago       121MB
```

## ELK
#### elasticsearch:
http://localhost:9200

#### kibana:
http://localhost:5601

#### logstash:
```shell script
./bin/logstash -f myLogback.conf
```
http://localhost:9600

myLogback.conf
```shell script
input {
    file {
        path => "/home/laptop/IdeaProjects/demo/logs/*.log"
        codec => "json"
        type => "logback"
    }
}
 
output {
    if [type]=="logback" {
         elasticsearch {
             hosts => [ "localhost:9200" ]
             index => "logback-%{+YYYY.MM.dd}"
        }
    }
}
```