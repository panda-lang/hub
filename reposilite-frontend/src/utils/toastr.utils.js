import toastr from "toastr/toastr";

export const notification = {
    error,
    success,
    warning,
    info
};

function error(message) {
    printNotification(message, "error");
}

function success(message) {
    printNotification(message, "success");
}

function warning(message) {
    printNotification(message, "warning");
}

function info(message) {
    printNotification(message, "info");
}

function printNotification(message, type) {
    let options = {
        "progressBar": true,
        "positionClass": "toast-top-right",
        "showDuration": "300",
        "hideDuration": "500",
        "timeOut": "2000",
        "extendedTimeOut": "1000",
        "preventDuplicates": true
    };

    toastr[type](message, null, options);
}
