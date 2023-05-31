// Call the dataTables jQuery plugin
$(document).ready(function () {


    cargarusuarios()


    $('#tusuarios').DataTable();
});


async function cargarusuarios() {

    const request = await fetch('usuario/144', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const usuarios = await request.json();

    console.log(usuarios);

}
