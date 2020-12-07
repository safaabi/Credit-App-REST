package com.belaizi.rest.client;

import javax.ws.rs.core.MediaType;

import com.belaizi.rest.model.CreditModel;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class AnnuiteRestClient {
   private String BASE_URL= "http://localhost:9092/BELAIZI_SAFAA_REST2/rest/services";
   private Client client;
   private WebResource webResource;
   
   public AnnuiteRestClient() {
	   this.client= Client.create(new DefaultClientConfig());
	   this.webResource=this.client.resource(BASE_URL);
	   
   }
   public CreditModel getAnnuite(String capital,String duree,String taux){
	       //GenericType <CreditModel> genericType= new GenericType<CreditModel>() {};
	       WebResource wb =this.webResource;
		   ClientResponse response= wb.path("/annuite").path(capital).path(duree).path(taux).accept(MediaType.APPLICATION_JSON)
				   .get(ClientResponse.class);
		   return response.getEntity(CreditModel.class);
	   
   }
   
   public CreditModel getCapital(String annuite,String duree,String taux){
       //GenericType <CreditModel> genericType= new GenericType<CreditModel>() {};
       WebResource wb =this.webResource;
	   ClientResponse response= wb.path("/capital").path(annuite).path(duree).path(taux).accept(MediaType.APPLICATION_JSON)
			   .get(ClientResponse.class);
	   return response.getEntity(CreditModel.class);
   
   }
   
   public CreditModel getDuree(String capital,String annuite,String taux){
       //GenericType <CreditModel> genericType= new GenericType<CreditModel>() {};
       WebResource wb =this.webResource;
	   ClientResponse response= wb.path("/duree").path(capital).path(annuite).path(taux).accept(MediaType.APPLICATION_JSON)
			   .get(ClientResponse.class);
	   return response.getEntity(CreditModel.class);
   
}
}
