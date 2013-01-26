<div class="container">

<form id="loginForm" class="form-horizontal span5" method="post" action="wydAuthenticate.java">
<fieldset>
	<legend>Sign In</legend>
	<div class="control-group">
       <label class="control-label" for="userId">User Id</label>
		<div class="controls">
			<input type="text" class="input-medium" id="userId" name="userId">
		</div>
	</div>
	<div class="control-group">
       <label class="control-label" for="password">Password</label>
		<div class="controls">
			<input type="password" class="input-medium" id="password" name="password">
		</div>
	</div>
	<div class="form-actions">
		<button type="submit" class="btn btn-primary">Sign In</button>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="reset" class="btn">Reset</button>
    </div>
</fieldset>	
<%
	if(request.getAttribute("callbackUrl") != null) {
%>
<input type="hidden" name="callbackUrl" value="<%=request.getAttribute("callbackUrl")%>">
<%
	}
%>
</form>

</div>

<script type="text/javascript">
$(document).ready(function() {
 	$('#userId').focus();
 	
 	$('#loginForm').validate({
		rules: {
	      	userId   : { required: true	},
	     	password : { required: true	}
	    },
	    
	    highlight: function(label) {
	    	$(label).closest('.control-group').addClass('error');
	    },
	    
	    success: function(label) {
	    	label.text('OK!').addClass('valid').closest('.control-group').addClass('success');
	    }
	    
	  });
 	
 });
</script>