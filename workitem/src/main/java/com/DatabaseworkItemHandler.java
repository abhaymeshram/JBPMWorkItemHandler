package com;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class DatabaseworkItemHandler implements WorkItemHandler,java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		String param1 = (String) workItem.getParameter("MyFirstParam");
		System.out.print("I am here" + param1);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("One", "One");
		Map<String, Object> results = new HashMap<String, Object>();
		results.put("Result", data);
		System.out.println("Result is: " + results);
		
		 HttpHeaders httpHeaders = new HttpHeaders();
         httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
         final String url = "http://localhost:9090/testService";
		/*
		 * Map<String, String> params = new HashMap<String, String>();
		 * params.put("code", "123456");
		 */
         HttpEntity<?> httpEntity  = new HttpEntity<Object>(httpHeaders); 
         RestTemplate restTemplate  = new RestTemplate();
         ResponseEntity<String> strResponse = restTemplate.exchange(url, HttpMethod.GET, httpEntity,String.class);
//         Map<String, String> output = (Map)strResponse.getBody();
         System.out.println(strResponse.getBody());
         results.put("Response", strResponse.getBody());
		
		manager.completeWorkItem(workItem.getId(), results);
		
	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		System.out.print("I am in out");
	}

	public static void main(String[] args) {
	     HttpHeaders httpHeaders = new HttpHeaders();
         httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
         final String url = "http://localhost:9090/testService";
		/*
		 * Map<String, String> params = new HashMap<String, String>();
		 * params.put("code", "123456");
		 */
         HttpEntity<?> httpEntity  = new HttpEntity<Object>(httpHeaders); 
         RestTemplate restTemplate  = new RestTemplate();
         ResponseEntity<String> strResponse = restTemplate.exchange(url, HttpMethod.GET, httpEntity,String.class);
//         Map<String, String> output = (Map)strResponse.getBody();
         System.out.println(strResponse.getBody());
	}
}
