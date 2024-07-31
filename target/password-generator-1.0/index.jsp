<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="generator.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Password Generator</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<header>
		<h2>Password Generator</h2>
	</header>
	<%
		String password = (String)request.getAttribute("password");
		if(password ==null){
			Generator gtor = new Generator();
			password = gtor.generatePassword();
		}
		String length = request.getParameter("length");
		if(length == null){
			length = "16";
		}
		
	%>
	<form>	  
	  <table class="table" style="table-layout:fixed">
	    <tbody>
		  <tr>
			<td width="40%">
			  <span>Password: </span>
			</td>
			<td style="word-wrap: break-word">
			  <input name="pwd" type="text" readonly="readonly" id="pwd-1" style="width:60%;" class="input-custom" value="<%=password%>">
			  <a onclick="copy(document.getElementById('pwd-1'))" class="button button-green short">Copy</a>
			</td>
		  </tr>
		</tbody>
	  </table>
	</form>
	<form id="passwordForm" method="post" action="s01" onsubmit="return check();">
	  <table class="table">
	    <tbody>
	      <tr class="header2">
	        <td colspan="2" >
	          <h2>Password Generator</h2>
	        </td>
	      </tr>
	      <tr>
	        <td width="50%">
	          <span class = "field_text">Password Length: </span>
	        </td>
	        <td>
	          <input name="length" type="text" style = "width:80%;" value = <%=length%> id="length">
	        </td>
	      </tr>
	      <tr>
	        <td width="40%">
	          <span class = "field_text">Lowercase Character: </span>
	        </td>
	        <td>
	          <span>
	            <input name="lowercase" type="checkbox" <%if(request.getParameter("lowercase") != null) {%>checked="checked"<%} %> id="lowercase">
	            <label>(e.g. abcdef)</label>
	          </span>
	        </td>
	      </tr>
	      <tr>
	        <td width="40%">
	          <span class = "field_text">Uppercase Character: </span>
	        </td>
	        <td>
	          <span>
	            <input name="uppercase" type="checkbox"  <%if(request.getParameter("uppercase") != null) {%>checked="checked"<%} %> id="uppercase">
	            <label>(e.g. ABCDEF)</label>
	          </span>
	        </td>
	      </tr>
	      <tr>
	        <td width="40%">
	          <span class = "field_text">Numbers: </span>
	        </td>
	        <td>
	          <span>
	            <input name="number" type="checkbox" <%if(request.getParameter("number") != null) {%>checked="checked"<%} %> id="number">
	            <label>(e.g. 12345)</label>
	          </span>
	        </td>
	      </tr>
	      <tr>
	        <td width="40%">
	          <span class = "field_text">Symbols: </span>
	        </td>
	        <td>
	          <span>
	            <input name="symbol" type="checkbox" <%if(request.getParameter("symbol") != null) {%>checked="checked"<%} %> id="symbol">
	            <label>(e.g. @$#*_)</label>
	          </span>
	        </td>
	      </tr>
	      <tr>
	      	<td width="40%">
	         
	        </td>
	        <td>
	          <button class="button button-main" type="submit" onclick="check()">Generate Password</button>
	        </td>
	      </tr>
	      <tr class="empty-row"></tr>
	    </tbody>
	  </table>		
	</form>
	<footer>
		<p>Created by Emma Han</p>
	</footer>
</body>
<script>
	function copy(copyText){
		navigator.clipboard.writeText(copyText.value).then(function() {
            alert("Password has been copied!");
        }).catch(function(error) {
            alert("Failed to copy text: " + error);
        });
	}

	function check() {
		var length = document.getElementById("length").value;
	    var lowercaseCheckbox = document.getElementById("lowercase");
	    var uppercaseCheckbox = document.getElementById("uppercase");
	    var numberCheckbox = document.getElementById("number");
	    var symbolCheckbox = document.getElementById("symbol");

	    if(isNaN(parseInt(length)) || length==""){
	    	return false;
	    }else if (!lowercaseCheckbox.checked && 
	        !uppercaseCheckbox.checked &&
	        !numberCheckbox.checked &&
	        !symbolCheckbox.checked) {
	        return false; // Prevent form submission
	    }
	    return true; // Allow form submission
	}

	// Add event listener to form submission event
	var form = document.getElementById("passwordForm");
	form.addEventListener("submit", function(event) {
	    if (!check()) {
	        alert("You must check one of the checkboxes and set a length!");
	        event.preventDefault(); // Prevent form submission if checkboxes are not checked
	    }
	});
</script>
</html>