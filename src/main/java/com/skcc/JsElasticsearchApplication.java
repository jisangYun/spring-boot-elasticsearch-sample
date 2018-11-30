package com.skcc;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class JsElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsElasticsearchApplication.class, args);
	}
	
	@Value("${elasticsearch.host}")
    private String EsHost;
 
    @Value("${elasticsearch.port}")
    private int EsPort;
 
    @Value("${elasticsearch.clustername}")
    private String EsClusterName;
 
    @Bean
    public Client client() throws Exception {
        
    	Settings esSettings = Settings.builder()
                .put("cluster.name", EsClusterName)
                .build(); 
        
        TransportClient client = new PreBuiltTransportClient(esSettings);
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
       
        return client;
    }
 
    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }
}
