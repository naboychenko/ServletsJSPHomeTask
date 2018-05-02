<%@ taglib
        prefix="fmt"
        uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    Cookie[] cookies = request.getCookies();
    boolean cookieExist = false;

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("views_amount".equals(cookie.getName())) {
                cookieExist = true;
                Integer value = Integer.valueOf(cookie.getValue()) + 1;
                cookie.setValue(value.toString());
                response.addCookie(cookie);
            }
        }
    }
    if (!cookieExist) {
        Cookie viewsAmount = new Cookie("views_amount", String.valueOf(0));
        viewsAmount.setMaxAge(60 * 60 * 24);
        viewsAmount.setPath("/");
        response.addCookie(viewsAmount);
    }

%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Simple Java Web App</title>

    <script type="text/javascript" src="/webjars/jquery/2.1.4/jquery.min.js"></script>
    <script src="js/ajax.js" type="text/javascript"></script>
</head>
<body>
<h2>Servlet/JSP hometask</h2>


<button id="button_get">GET</button>
<button id="button_post">POST</button>
<button id="button_put">PUT</button>
<button id="button_delete">DELETE</button>

<br>
<br>
Servlet inner state:<div id="result"></div>
<br>
<br>
Amount of page views: ${cookie.views_amount.value}
<br>
<br>
JSTL fmt formatNumber usage example: <fmt:formatNumber type="percent" maxIntegerDigits="4" value="${cookie.views_amount.value}" />
</body>
</html>
