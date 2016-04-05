/**
 * Created by mura on 3/30/16
 */

// Call when the whole document loaded
$(document).ready(function () {

});

// Logout. Invoke LogoutAction
function logout() {
    window.location = "logout";
}

// Show logout confirmation modal
function showLogoutModal() {
    $('#logoutModal').modal();
}

// Show about modal
function showAboutModal() {
    $('#aboutModal').modal();
}

// Show about modal
function showDevelopingModal() {
    $('#developingModal').modal();
}
