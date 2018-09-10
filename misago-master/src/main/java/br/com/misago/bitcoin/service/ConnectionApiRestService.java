package br.com.misago.bitcoin.service;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class ConnectionApiRestService {
	
	private RestTemplate restTemplate;
	
	public ConnectionApiRestService(){
		restTemplate = buildingRestTemplateWithSSL();
	}

	/**
	 * Build RestTemplate class using SSL connection
	 * @return instance of RestTemplate
	 */
	private RestTemplate buildingRestTemplateWithSSL(){
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		return new RestTemplate(requestFactory);
	}
	
	public RestTemplate getRestTemplate(){
		return restTemplate;
	}
	

}
