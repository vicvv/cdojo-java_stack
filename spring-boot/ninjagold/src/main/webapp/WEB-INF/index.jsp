<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 <link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Ninja Gold</title>
</head>
<body><body>   
    <div class="jumbotron">
        <div class="row">
            <div class="col-12">
                <table class="table">
                        <thead class="thead-light">
                            <tr>
                            <th><h3>Your gold: <span class="border border-dark px-5 py-1"><%= session.getAttribute("gold") %></span></h3></th>
                            <th><h3 class="" class=""></h3></th>
                            <th>
                                <form action="/" method="post">
									<input type="hidden" name="place" value="reset">
									<input type="submit" value="Reset">
								</form>
                            </th>        
                            </tr>
                        </thead>
                </table>   
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Farm</h4>
                        <p class="card-title">(earn 10 - 20 gold)</p>
                        <form action="/" method="post">
                            <input type="hidden" name="place" value="farm">
                            <button class="btn btn-primary">Find Gold</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-2">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Cave</h4>
                        <p class="card-title">(earn 5 - 10 gold)</p>
                        <form action="/" method="POST">
                            <input type="hidden" name="place" value="cave">
                            <button class="btn btn-primary">Find Gold</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-2">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">House</h4>
                        <p class="card-title">(earn 2 - 5 gold)</p>
                        <form action="/" method="POST">
                            <input type="hidden" name="place" value="house">
                            <button class="btn btn-primary">Find Gold</button>
                        </form>
                    </div>
                </div>
            </div>
            
            
            
            <div class="col-2">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Spa</h4>
                        <p class="card-title">(lost 5 - 20 gold)</p>
                        <form action="/" method="POST">
                            <input type="hidden" name="place" value="spa">
                            <button class="btn btn-primary">Find Gold</button>
                        </form>
                    </div>
                </div>
            </div>
            
            
            <div class="col-3">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Casino</h4>
                        <p class="card-title">(Earn/Takes 0 - 50 gold)</p>
                        <form action='/' method='post'>
                            <input type="hidden" name="place" value="casino">
                            <button class="btn btn-primary">Find Gold</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-11 ">
                <h3>Activities</h3>
                <div class="card">
                    <div class="card-body anyClass" >
                    
                    <ul>
			          <% ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
						Collections.reverse(activities);
			          for(String activity : activities) {
						if(activity.toLowerCase().contains("lost".toLowerCase())) {%>
							<li class="red"><%= activity %></li>
						<% }else{ %>
							<li class="green"><%= activity %></li>
						<% }
					} %>
               </ul>  
                            
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>