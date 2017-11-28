function checkLogin() {
    
    var userfield = $("input[name=loginname]");
    var passfield = $("input[name=password]");
    if ((userfield.val() != "") && (passfield.val() != "")) {
        return true;
    } else {
        $("#output").removeClass(' alert alert-success');
        $("#output").addClass("alert alert-danger animated fadeInUp").html("Please Enter Username & Password !!");
        return false;
    }
}

$('#btn_register').click(function(e) {
    e.preventDefault();
    $("#form_login").css({
        "display":"none"
    });
    $('#form_register').css({
        "display":"inline"
    });
    $('#form_init').css({
        "display":"none"
    });
    $(".avatar").css({
        "background-image": "url('img/the-book.gif')"
    });
});

$('#btn_cancel').click(function(e) {
    e.preventDefault();
    location.href = "login.jsp";
});

function checkRegister() {

    var itemfield1 = $('input[name=loginname]');
    var itemfield2 = $('input[name=password]');
    var itemfield3 = $('input[name=fullname]');
    var itemfield5 = $('input[name=phone]');
    if (itemfield1.val() == "" || itemfield2.val() == "" || 
        itemfield3.val() == "" || itemfield4.val() == "" || itemfield5.val() == "" ) {
        $("#form_register").removeClass(' alert alert-success');
        $("#for_register").addClass("alert alert-danger animated fadeInUp").html("Please Enter ALL Items !!");
        alert("Please Enter all items");
        return false;
    }
    return true;
}