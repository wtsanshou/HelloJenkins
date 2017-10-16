# Aerobics Project

## Objectives


## Install Lombok

1. Add dependencies in gradle, refresh
2. Find the lombok.jar and run `java -jar <lombok-version>.jar
3. Select your IDE --> install/update
4. Restart the IDE

## Setup Docker 17

```bash
## Download deb
wget https://download.docker.com/linux/ubuntu/dists/xenial/pool/stable/amd64/docker-ce_17.03.2~ce-0~ubuntu-xenial_amd64.deb

## Install
sudo dpkg -i /path/to/package.deb
```

## Install Docker compose

```bash
sudo apt-get -y install python-pip

sudo pip install docker-compose
```
* Run containers

```bash
sudo docker-compose -f docker-compose-local.yaml up -d
```

* Tear down

```bash
sudo docker-compose -f docker-compose-local.yaml down
```

## Mysql

download workbench at https://dev.mysql.com/downloads/workbench/

```bash
sudo dpkg -i mysql-workbench-community-6.3.9-1ubuntu16.04-amd64.deb
```

## Mysql Workbench

download DEB

```bash
sudo dpkg -i mysql-workbench-community-6.3.9-1ubuntu16.04-amd64.deb

sudo apt-get update

sudo apt-get install mysql-workbench-community
```

## Jenkins

1. using gradle to build war file
2. In Jenkins build job, run `./gradle build`
3. In Jenkins deploy job, copy the `**.war` to the `/home/sanshou/Jenkins/jenkinsHome/workspace/AerobicsDeployJob/`, and config the `deploy war/ear to a container`
