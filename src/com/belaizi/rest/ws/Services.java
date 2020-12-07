package com.belaizi.rest.ws;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.belaizi.rest.model.CreditModel;

@Path("/services")
public class Services {
	
	    @GET
	    @Path("/annuite/{inputCapital}/{inputDuree}/{inputTaux}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public  CreditModel annuite(@PathParam("inputCapital")double capital,@PathParam("inputDuree") int duree,
	    		@PathParam("inputTaux") double taux) {
	    	
	   	 double t =taux *0.01;
	     double tm = Math.pow(1 + t,(double)1/12) - 1;
	   	 double a = (Math.pow(1+tm, duree)* tm * capital)/(Math.pow(1+tm, duree) - 1 );
	   	 return new CreditModel(duree,t,a,capital);  
	   	 
	    }
	    
	    @GET
	    @Path("/capital/{inputAnnuite}/{inputDuree}/{inputTaux}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public CreditModel capital(@PathParam("inputAnnuite")double annuite ,@PathParam("inputDuree") int duree,
	    		@PathParam("inputTaux") double taux) {
	    	
		   	double t =taux *0.01; 
	    	double tm = Math.pow(1 + t,(double)1/12) - 1; 
		   	double C = ( annuite * (Math.pow(1+tm, duree) - 1 ) )/(Math.pow(1+tm, duree)* tm );
		   	
		   	 return new CreditModel(duree,t,annuite,C);  
		 }
		 
	    @GET
	    @Path("/duree/{inputCapital}/{inputAnnuite}/{inputTaux}")
	    @Produces(MediaType.APPLICATION_JSON)
        public CreditModel duree(@PathParam("inputCapital")double capital ,@PathParam("inputAnnuite") double annuite,@PathParam("inputTaux") double taux) {
		   	 double t =taux *0.01;
	    	 double tm = Math.pow(1 + t,(double)1/12) - 1; 
		   	 double d = Math.log(annuite/(annuite- tm*capital)) / Math.log(1+tm);
		   	 
		   	 return new CreditModel((int) Math.round(d),t,annuite,capital);  
		}
		
	
}
