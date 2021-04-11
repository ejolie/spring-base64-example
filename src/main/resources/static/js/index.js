$(function() {
    $("#submitBtn").on("click", function() {
        $.ajax({
            url: "/image/base64",
            method: "GET",
            data: {
                imagePath: $("input[name=imagePath]").val()
            },
            dataType: "json"
        }).done(function(data, textStatus, jqXHR) {
            const { base64Str, mimeType, filename } = data;
            const myImage = $(".myImage");
            myImage.prop("src", `data:${mimeType};base64,${base64Str}`);
            myImage.prop("alt", filename);
        }).fail(function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseJSON.message);
        });
    });
})