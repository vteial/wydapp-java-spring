<%@page import="java.util.*" %>

<div class="container">

<p>Build No. <b><%=application.getAttribute("version")%></b></p>
<ul id="wydEchoTab" class="nav nav-tabs">
	<li class="active"><a href="#requestInfo" data-toggle="tab">Request</a></li> 
	<li><a href="#contextInfo" data-toggle="tab">Context</a></li>
	<li><a href="#systemInfo" data-toggle="tab">System</a></li> 
	<li><a href="#jvmInfo" data-toggle="tab">JVM</a></li>
</ul>
<div id="wydEchoTabContent" class="tab-content">
	
	<div class="tab-pane fade in active" id="requestInfo">
		<table class="table table-striped table-condensed">
		<thead>
		<tr>
		    <th>Name</th>
		    <th>Value</th>
		</tr>
		</thead>
		<tbody>
		<%
			ArrayList hnames = Collections.list(request.getHeaderNames()); 
			for(int i = 0; i < hnames.size(); i++) {
		%>
		<tr>
			<td><%=hnames.get(i) %></td>
			<td><%=request.getHeader((String) hnames.get(i))%></td>
		</tr>
		<%	}	%>
		<tr>
			<td>Context Path</td>
			<td><%=request.getContextPath()%></td>
		</tr>
		<tr>
			<td>Path Info</td>
			<td><%=request.getPathInfo()%></td>
		</tr>
		<tr>
			<td>Request URI</td>
			<td><%=request.getRequestURI()%></td>
		</tr>
		<tr>
			<td>Request URL</td>
			<td><%=request.getRequestURL()%></td>
		</tr>
		<tr>
			<td>Servlet Path</td>
			<td><%=request.getServletPath()%></td>
		</tr>
		<tr>
			<td>Remote User</td>
			<td><%=request.getRemoteUser()%></td>
		</tr>
		<tr>
			<td>Remote Host</td>
			<td><%=request.getRemoteHost()%></td>
		</tr>
		<tr>
			<td>Remote IP</td>
			<td><%=request.getRemoteAddr()%></td>
		</tr>
		<tr>
			<td>Remote Port</td>
			<td><%=request.getRemotePort()%></td>
		</tr>
		</tbody>
		</table>
	</div>
	
	<div class="tab-pane fade" id="contextInfo">
		<table class="table table-striped table-condensed">
		<thead>
		<tr>
		    <th>Name</th>
		    <th>Value</th>
		</tr>
		</thead>
		<tbody>
		<%
			ArrayList context = Collections.list(application.getAttributeNames());
			for(int i = 0; i < context.size(); i++) {
		%>
		<tr>
			<td><%=context.get(i) %></td>
			<td><%=application.getAttribute((String) context.get(i)) %></td>
		</tr>
		<%	}	%>		
		</tbody>
		</table>
	</div>
	
	<div class="tab-pane fade" id="systemInfo">
		<table class="table table-striped table-condensed">
		<thead>
		<tr>
		    <th>Name</th>
		    <th>Value</th>
		</tr>
		</thead>
		<tbody>
		<%
			Map map = System.getenv();
			Iterator it = map.keySet().iterator();
			while (it.hasNext()) {
  				String key = (String) it.next();
  				String val = (String) map.get(key);
		%>
		<tr>
			<td><%=key%></td>
			<td><%=val%></td>
		</tr>
		<%	}	%>
		</tbody>
		</table>
	</div>
	
	<div class="tab-pane fade" id="jvmInfo">
		<table class="table table-striped table-condensed">
		<thead>
		<tr>
		    <th>Name</th>
		    <th>Value</th>
		</tr>
		</thead>
		<tbody>
		<%
			Properties p = System.getProperties();
			Enumeration keys = p.keys();
			while (keys.hasMoreElements()) {
		  		String key = (String) keys.nextElement();
		  		String val = (String) p.get(key);
		%>
		<tr>
			<td><%=key%></td>
			<td><%=val%></td>
		</tr>
		<%	}	%>		
		</tbody>
		</table>
	</div>
	
</div>

</div>