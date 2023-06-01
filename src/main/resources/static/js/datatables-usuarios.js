// Call the dataTables jQuery plugin


var userelim = '';
$(document).ready(function () {


    cargarusuarios()


    $('#tusuarios').DataTable();
});


async function cargarusuarios() {

    const request = await fetch('api/usuario', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const usuarios = await request.json();

    console.log(usuarios);

    let listadohtml = '';

    for (let usuario of usuarios) {
userelim=usuario.nombre;
        let btneliminar = '<a href="#"  onclick="eliminarusuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm">\n' +
            '                                        <i class="fas fa-trash"></i>\n' +
            '                                    </a>';

        let formatousuario = ' <tr>\n' +
            '                                    <td>' + usuario.id + '</td>\n' +
            '                                    <td>' + usuario.nombre + '</td>\n' +
            '                                    <td>' + usuario.apellido + '</td>\n' +
            '                                    <td>' + usuario.email + '</td>\n' +
            '                                    <td>' + usuario.telefono + '</td>\n' +
            '                                    <td>' + usuario.password + '</td>\n' +
            '                                    <td>' + btneliminar + '</td>\n' +
            '                                </tr>';

        listadohtml += formatousuario;
    }


//esta linea modifica el componente selecionado en este caso #tusuarios tbody(que es su cuerpo de la tabla
// y lo remplaza por el campo o varibale que le demos
    document.querySelector('#tusuarios tbody').outerHTML = listadohtml;
}

async function eliminarusuario(id){

if (!confirm('Se eliminara el usuario '+userelim+'\n ¿ Estas seguro ?')){
    return;
}

    const request = await fetch('api/usuario/'+id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    location.reload();


}
