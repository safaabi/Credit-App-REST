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
      </div>
    </nav>
<section id="skills" style="height: 733px;">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 mx-auto">
					<h3 style ="text-align: center;" >Connectez-vous </h3>

					</div>
					<div class="container col-8 rounded border border-mycolor3 ">

						<form class="m-4 mt-3 needs-validation" method="POST"
							action="ConnexionServlet" novalidate>
							

							<div class="form-group">
								<input type="email" class="form-control" name="inputEmailCli"
									placeholder="Email" required>
							</div>
								<div class="form-group ">
									<input type="password" id="mdp1" class="form-control" name="inputPwdCli"
										placeholder="mot de passe" required>
								</div>
							
							<div class=" form-group row justify-content-around ">
								<input type="submit"
									class="mt-3 col-5  btn btn-dark text-black" id=""
									value="se connecter" />
							</div>
							<div class="text-muted text-center">
								Non Inscrit ? <a class="text-mycolor3" href="Inscription.jsp">Inscrivez-vous</a>
							</div>

						</form>
					</div>
				</div>
			</div>
	</section>
	
</body>

</html>