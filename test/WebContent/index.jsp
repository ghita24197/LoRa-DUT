<%@page import="model.bean.Data"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Control page</title>
		<meta charset="UTF-8" />
		
		<link href="<%=request.getContextPath() %>/css/reset.css" type="text/css" rel="stylesheet" />
		<link href="<%=request.getContextPath() %>/css/style.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript">
		function showValue1(newValue)
		{
			document.getElementById("range1").innerHTML=newValue;
		}
		function showValue2(newValue)
		{
			document.getElementById("range2").innerHTML=newValue;
		}
		function showValue3(newValue)
		{
			document.getElementById("range3").innerHTML=newValue;
		}
		function showValue4(newValue)
		{
			document.getElementById("range4").innerHTML=newValue;
			$.ajax({
				url: '<%=request.getContextPath() %>/fade',
				type: 'POST',
				cache: false,
				data: {
					fade:newValue
				},
				success: function(){
				},
				error: function(){
					alert('Error');
				}
			});
		}
		// end <meta http-equiv="refresh" content="5">
		</script>
	</head>
	<body>
		<div class="wrapper">
		<%
			if (request.getAttribute("objD") != null){
				Data objD = (Data)request.getAttribute("objD");
		%>
			<table width="100%" class="left">
				<tr>
					<td>
						<p>Led</p>
					</td>
					<td class="rss">
						<input type="checkbox" id="buttonThree" style="display:none" name="checkbot" onclick="return checkBox(this.value)"/>
						<label for="buttonThree">
						<i></i>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						<p>Living Room Light</p>
					</td>
					<td>
						<input type="range" min="0" max="100" value="<%=objD.getLroom() %>" step="1" onchange="showValue1(this.value)" class="slide"/>
						<span id="range1"><%=objD.getLroom() %></span>
					</td>
				</tr>
				<tr>
					<td>
						<p>Porch Light</p>
					</td>
					<td>
						<input type="range" min="0" max="100" value="<%=objD.getLporch() %>" step="1" onchange="showValue2(this.value)" class="slide"/>
						<span id="range2"><%=objD.getLporch() %></span>
					</td>
				</tr>
				<tr>
					<td>
						<p>Fireplace</p>
					</td>
					<td>
						<input type="range" min="0" max="100" value="<%=objD.getFplace() %>" step="1" onchange="showValue3(this.value)" class="slide"/>
						<span id="range3"><%=objD.getFplace() %></span>
					</td>
				</tr>
				<tr>
					<td>
						<p>Fade Led</p>
					</td>
					<td>
						<input type="range" min="0" max="100" value="<%=objD.getFled() %>" step="1" onchange="showValue4(this.value)" class="slide"/>
						<span id="range4"><%=objD.getFled() %></span>
					</td>
				</tr>
			</table>
			
			<div class="right">
				<p><span id="temp"><%=objD.getTemp() %></span><sup>o</sup>C</p>
				<p><span id="humi"><%=objD.getHumi() %></span>%</p>
			</div>
			
			<div class="clr"></div>
		</div>
		<script>
			function reload(temp,humi){
				$.ajax({
					url: '<%=request.getContextPath() %>/trang-chu',
					type: 'POST',
					cache: false,
					data: {},
					success: function(data){
						$(".right").html(data);
					},
					error: function(){
						alert('Error');
					}
				});
			}
			setInterval('reload(temp,humi)',100);
			function checkBox(newValue){
	            if ($('#buttonThree').is(":checked") || !$('#buttonThree').is(":checked"))
	            {
	                $.ajax({
	                    url: '<%=request.getContextPath() %>/led',
	                    type: 'POST',
	                    cache: false,
	                    data: {
	                        led:$('#buttonThree').is(":checked")
	                    },
	                    success: function(data){
							$(".rss").html(data);
						},
	                    error: function(){
	                        alert('Error');
	                    }
	                });
	            } 
	        }
	        setInterval('checkBox(newValue)',100);
		</script>
		<%} %>
	</body>
</html>