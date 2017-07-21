function logout() {
    var token = $("meta[name='_csrf']").attr("content");
    var name = $("meta[name='_csrf_header']").attr("content");

    var form = document.createElement("form");
    var input = document.createElement("input");
    document.body.appendChild(form);
    form.appendChild(input);
    input.name = name;
    input.value = token;
    form.action = "/logout";
    form.method = "post";
    form.submit();

    // $.ajax({
    //     url: "/logout",
    //     type: "post",
    //     headers: {
    //         'token': token,
    //         'name': name
    //     },
    //     success: function () {
    //
    //     }
    // })
}