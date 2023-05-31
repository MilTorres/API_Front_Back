// Call the dataTables jQuery plugin
$(document).ready(function () {


    cargarusuarios()


    $('#tusuarios').DataTable();
});


async function cargarusuarios() {

    const request = await fetch('listausuario', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const usuarios = await request.json();

    console.log(usuarios);

    let listadohtml = '';
    for (let usuario of usuarios){
        let formatousuario= ' <tr>\n' +
            '                                    <td>1</td>\n' +
            '                                    <td>'+usuario.nombre+'</td>\n' +
            '                                    <td>'+usuario.apellido+'</td>\n' +
            '                                    <td>'+usuario.email+'</td>\n' +
            '                                    <td>'+usuario.telefono+'</td>\n' +
            '                                    <td>'+usuario.contraseña+'</td>\n' +
            '                                    <td><a href="#" class="btn btn-danger btn-circle btn-sm">\n' +
            '                                        <i class="fas fa-trash"></i>\n' +
            '                                    </a></td>\n' +
            '                                </tr>';

       listadohtml += formatousuario;
    }





//esta linea modifica el componente selecionado en este caso #tusuarios tbody(que es su cuerpo de la tabla
// y lo remplaza por el campo o varibale que le demos
    document.querySelector('#tusuarios tbody').outerHTML = listadohtml;
}
