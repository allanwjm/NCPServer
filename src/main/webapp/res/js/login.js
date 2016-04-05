/**
 * Created by mura on 3/30/16
 */

// Call when the whole document loaded
$(document).ready(function () {
    if (showErrorMessage != undefined && showErrorMessage == true) {
        $('#errorMessageModal').modal();
    }
});
