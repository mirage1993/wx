var ajaxHelper = function () {
    var ajaxOptions = {
        url: '',
        async: true,
        type: 'POST',
        contentType: "application/json;charset=utf-8", /*application/x-www-form-urlencoded*/
        dataType: "json",
        data: {},
        timeout: 30000,
        beforeSend: function () {

        },
        success: function (data) {

        },
        error: function (xhr, status, error) {
            console.log("request error message:xhr" + xhr + ";status" + status + ";error" + error);
        },
        complete: function (xhr, status) {

        }
    };
    var ajax = {
        submit: function () {
            var options = ajaxOptions;
            if (arguments.length > 0) {
                $.each(arguments, function (i, j) {
                    options = $.extend({}, ajaxOptions, arguments[i]);
                });
            };
            $.ajax(options);
        }
    };
    return ajax;
};