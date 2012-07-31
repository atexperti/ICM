<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="footer">
    	<div class="footer-l">
        	<div class="foot">&copy; 2012 -&nbsp;</div>
            <div class="foot-title">indian christian media &nbsp;</div>
            <div class="foot">&nbsp;| Enlighten...Enrich...Edify...</div>
			<div class="clear"></div>
      </div>
        <div class="footer-r">contact us</div>
        <div class="clear"></div>
    </div>
</div>
</div>
<script type="text/javascript">
window.onload = 
	function()
	{
		$('#carousel1').Carousel(
			{
				itemWidth: 450,
				itemHeight: 200,
				itemMinWidth: 50,
				items: 'a',
				reflections: .0,
				rotationSpeed: 1.8
			}
		);
	}
</script>
<s:debug></s:debug>
</body>

</html>
