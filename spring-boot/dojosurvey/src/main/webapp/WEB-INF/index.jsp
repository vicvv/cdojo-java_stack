<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="/css/style.css">
	
	<meta charset="UTF-8">
	<title>Dojo Survey</title>
</head>
<body>


<div class="container">
    <div class="row">
      <div class="col-lg-12">
        <h1 class="mt-5">Dojo Survey</h1>
        <p class="lead"></p>
        <div class="card text-white bg-warning mb-3" style="max-width: 100rem;">
		  <div class="card-header">Survey form</div>
		  <div class="card-body">
		  
	  
		   <form action="" method="post">
		   
		   <div class="form-group form-inline">                            
        		<label for="name">Name: </label>
            	<input type="text" class="form-control"  placeholder="Name" name="name">
    		</div>
    		
    		<div class="form-group form-inline">                            
        		<label for="location">Dojo Location: </label>
        		<select class="form-control" class="dropdown-menu" name="dojo">
      			<option></option> 			
				<option>San Jose</option>
				<option>Washington, DC</option>
				</select>            	
    		</div>
    		<div class="form-group form-inline" class="dropdown-menu">                            
        		<label for="language">Favorite Language: </label>
        		<select class="form-control"  name="lang"> 
        		<option></option>   						
				<option>Python Forever</option>
				<option>Java</option>
				</select>            	
    		</div>
    		
    		<div class="form-group form-inline">                            
        		<label for="language">Comment (optional): </label>
        		 <textarea class="form-control" name="comment" rows="3"></textarea>
    		</div>
    		
			<!-- <input type="submit" class="btn btn-outline-success">Submitt</button> -->
			<input type="submit" class="btn btn-outline-success" value="Submit">
			</form>
		  </div>
		</div>  
		
		     
      </div>
    </div>
  </div>


</body>
</html>