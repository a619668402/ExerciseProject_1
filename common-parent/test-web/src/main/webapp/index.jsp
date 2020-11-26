<html>
<body>
<h2>Hello World!</h2>
</body>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

<button id="btn">btn</button>

<script>

    $('#btn').click(function () {
        $.ajax({
            type: "POST",
            url: '${pageContext.request.contextPath}/login',
            data: 'username=123&password=123',
            dataType: "json",
            success: function (data) {
                alert(data.username + "---" + data.password)
            },
            error: function () {
                layer.msg("11")
            }
        })
    })
</script>

</html>
