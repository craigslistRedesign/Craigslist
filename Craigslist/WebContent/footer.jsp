<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>footer</title>
<script src="jquery.js"></script>
<script type="text/javascript">

var language = localStorage.getItem("language");
if(language!=null)
	loadLang(language);


function loadLang(language){
	$.ajax({
        url: 'craigslist_homepage.xml',
        success: function(xml) {
            $(xml).find('translation').each(function(){
                var id = $(this).attr('id');
                var text = $(this).find(language).text();
                $("." + id).html(text);
            });
        }
    });
	localStorage.setItem("language", language);
}
</script>
</head>
<body>
<footer class="container-fluid text-center">
<ul class="languages nav navbar-nav">
	<li>
		<a href="#" onClick="loadLang('english')"><strong>English</strong></a>
    </li>
    <li>
		<a href="#" onClick="loadLang('spanish')"><strong>Español</strong></a>
    </li>
     <li>
		<a href="#" onClick="loadLang('french')"><strong>Français</strong></a>
    </li>
     <li>
		<a href="#" onClick="loadLang('japanese')"><strong>日本語</strong></a>
    </li>
     <li>
		<a href="#" onClick="loadLang('hindi')"><strong>हिन्दी</strong></a>
    </li>
</ul>
</footer>
</body>
</html>