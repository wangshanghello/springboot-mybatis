<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script>
        $(function () {
            window.onload = roll(50);
        })

        // 传入的 t 为滚动快慢的时间
        function roll(t) {
            console.log(1);
            var ul1 = document.getElementById("ul1");
            var ul2 = document.getElementById("ul2");
            var box = document.getElementById("box");
            ul2.innerHTML = ul1.innerHTML;
            // 初始化滚动高度
            box.scrollTop = 0;
            var timer = setInterval(rollStart, t);
            box.onmouseover = function () {
                clearInterval(timer)
            }
            box.onmouseout = function () {
                timer = setInterval(rollStart, t);
            }
        }

        function rollStart() {
            if (box.scrollTop >= ul1.scrollHeight) {
                box.scrollTop = 0;
            } else {
                box.scrollTop++;
            }
        }
    </script>
    <style>
        * {
            margin: 0;
            padding: 0
        }

        #box {
            height: 140px;
            width: 400px;
            border: 1px solid #cccccc;
            color: hotpink;
            overflow: hidden;
            margin: 50px auto;
            text-align: center;
        }
    </style>
</head>
<body>
<div id="box">
    <ul id="ul1">
        <li>1111111111111111111111</li>
        <li>2222222222222222222222</li>
        <li>3333333333333333333333</li>
        <li>4444444444444444444444</li>
        <li>5555555555555555555555</li>
        <li>6666666666666666666666</li>
        <li>7777777777777777777777</li>
        <li>8888888888888888888888</li>
        <li>9999999999999999999999</li>
    </ul>
    <ul id="ul2"></ul>
</div>
</body>
</html>
