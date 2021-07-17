<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	<title>Home</title>
</head>
<script>
$(function(){
	$('input[type="checkbox"]').click(function(){
		if($(this).prop('checked')){
			$('input[type="checkbox"]').prop('checked',false);
			$(this).prop('checked',true);
		}
	})
});
</script>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<input class="test" type="checkbox" value="213">가나다
<input class="test" type="checkbox" value="222">다라마
</body>
</html>
