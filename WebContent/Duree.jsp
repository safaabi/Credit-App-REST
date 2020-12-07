<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="ISO-8859-1">
<title>Simulation de cr�dit</title>
<link href="bootstrap/css/bootstrap.min.css" rel= "stylesheet" >
<link href="css/style.css" rel= "stylesheet" >

</head>

<body id="page-top">

  <nav class="site-header sticky-top py-1">
      <div class="container d-flex flex-column flex-md-row justify-content-between">
 			<h4 class="text-white">Stimulation de cr�dit</h4> 
 			<div class="col-lg-6 mx-auto">
 			    <a class="btn btn-dark " id="list-home-list"  href="Annuite.jsp" >Annuit�</a>
 			      <a class="btn btn-dark  " id="list-home-list"  href="Capital.jsp" >Capital</a>
 			      <a class="btn btn-dark  active  " id="list-home-list"  href="Duree.jsp" >Dur�e</a>
 			</div>
 			   
<form action="DeconnexionServlet" method="POST" class="col">
 			   
  			               <button type="submit"  class="btn btn-dark">Se d�connecter</button>
  			              </form>		     
      
      </div>
    </nav>


  <section id="skills" style="height: 733px;">
      <div class="container">
        <div class="row">
          <div class="col-lg-10 mx-auto">
                      <div class="tab-content" id="pills-tabContent"> 
                      <div >
                                <h2 style ="text-align: center;"  >Calcule de la dur�e</h2>
                       </div>                      
                        <div class="mt-3 container-fluid tab-pane fade show active" id="pills-duree" role="tabpanel" aria-labelledby="pills-home-tab">

                            <form id="formDuree" action="DureeServlet" class="needs-validation" novalidate>
                                <div class="form-group row">
                                    <label  for="inputPassword" class="col-5 col-form-label">Entrez votre Annuite :</label>
                                    <div class="col-6">
                                    <%
                                       if (session.getAttribute("annuiteResD") != null){
                                    %>
                                      <input type="number" class="form-control " id="inputCapital" name="inputAnnuite" value=${annuiteResD } placeholder="Annuite" required>                                
                                     <%
                                       }else{
                                    	
                                    %>
                                       <input type="number" class="form-control " id="inputCapital" name="inputAnnuite" placeholder="Annuite" required>                                
                                     <%	
                                    }
                                    %>
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                      <label for="inputPassword" class="col-5 col-form-label">Entrez votre capital :</label>
                                      <div class="col-6">
                                       <%
                                       if (session.getAttribute("capitalResD") != null){
                                    %>
                                        <input type="number" class="form-control" id="inputCapital" name="inputCapital"  value=${capitalResD } placeholder="Capital" min="1" max="12" required>
                                       <%
                                       }else{
                                    	
                                    %>
                                     <input type="number" class="form-control" id="inputCapital" name="inputCapital" placeholder="Capital" min="1" max="12" required>
                                    
                                     <%	
                                    }
                                    %>
                                      </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputPassword" class="col-5 col-form-label">Entrez votre taux en (%) :</label>
                                        <div class="col-6">
                                          <%
                                             if (session.getAttribute("tauxResD") != null){
                                          %>
                                          <input type="number" class="form-control" id="inputTaux" name="inputTaux" value=${tauxResD }  placeholder="Taux en %" min="1" max="100" required>                                   
                                           <%
                                            }else{
                                    	
                                            %>
                                           <input type="number" class="form-control" id="inputTaux" name="inputTaux"  placeholder="Taux en %" min="1" max="100" required>                                   
                                            
		                                     <%	
		                                    }
		                                    %>
                                        </div>
                                      </div>
                                      <div class=" form-group row justify-content-around">
                                          <input type="submit" class="mt-3 col-5  btn btn-dark text-black" id="calculerSauvegarder" name="calculerSauvegarder" value="Calculer et sauvegarder"/>
                                        </div>
                                           <%
								          if (session.getAttribute("dureeResD") != null) {
							          		%>
							          		<div >
								        		<h5 style ="text-align: center;" >Duree = ${dureeResD}</h5>
							        	 	</div>
		                                      <%
										      }
									          %>
                            </form>

                          </div>
                          </div>

  
              </div>
          
          </div>
    </section>

</body>

</html>
