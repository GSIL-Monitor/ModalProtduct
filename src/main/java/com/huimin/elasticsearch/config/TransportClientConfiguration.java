/*package com.huimin.elasticsearch.config;

import java.net.InetAddress;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.Settings.Builder;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = TransportProperties.class)
public class TransportClientConfiguration {

	@Autowired
	private TransportProperties transportProperties;
	
	 @Bean
     public TransportClient transportClient() throws Exception {
		 Builder builder = Settings.builder().put("cluster.name", transportProperties.getClusterName());
				                             //.put("client.transport.sniff", transportProperties.isTransportSniff());
         if (StringUtils.isNotEmpty(transportProperties.getUsername())) {
			builder.put("xpack.security.user", transportProperties.getUsername() +":" + transportProperties.getPassword());
		}
		 Settings settings = builder.build();
         //我用6.5.1版本的时候这里一直报异常说找不到InetSocketTransportAddress类，这应该和jar有关，当我改成5.6.8就不报错了
         TransportClient client = new PreBuiltTransportClient(settings);//6.5.1这里TransportAddress代替InetSocketTransportAddress
         List<String> uris = transportProperties.getUris();
         for (String uri : uris) {
			String[] split = uri.split(":");
			client.addTransportAddress(new TransportAddress(InetAddress.getByName(split[0]), Integer.valueOf(split[1])));
		}
         return client;
     }
}
*/