# spring-boot-elasticsearch-sample

# docker
## elasticsearch official image used
https://hub.docker.com/_/elasticsearch/
## docker run
'''docker run -d --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -e "cluster.name=js-cluster" elasticsearch:6.5.0'''
### env
version : 6.5.0
api port : 9200
node port : 9300
discovery.type=single-node
cluster.name=js-cluster

# spring boot
## dependency
~~~
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-elasticsearch</artifactId>
    <version>3.0.8.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.elasticsearch.client</groupId>
    <artifactId>transport</artifactId>
    <version>${elasticsearch.version}</version>
</dependency>
<dependency>
    <groupId>org.elasticsearch.plugin</groupId>
    <artifactId>transport-netty4-client</artifactId>
    <version>${elasticsearch.version}</version>
</dependency>
~~~
## configure
~~~
elasticsearch:
  host: localhost
  port: 9300
  clustername: js-cluster
~~~
~~~
add @EnableElasticsearchRepositories
create ElasticsearchTemplate bean
~~~
