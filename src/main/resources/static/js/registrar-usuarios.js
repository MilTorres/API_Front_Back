$(document).ready(function () {

});


async function registrarusuarios() {

    let datos = {};
    //estamos creando el objeto y asignando el nombre de las propiedades(atributos) esos nombres deben
    //ser igual a como aparecen en models en la clase usuario donde creamos el objeto y sus atributos
    datos.nombre = document.getElementById('txtnombre').value;
    datos.apellido = document.getElementById('txtapellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.telefono = document.getElementById('txttelefono').value;
    datos.password = document.getElementById('txtcontraseña').value;
    let  contraseña = document.getElementById('txtcontraseña').value;
    let repetircontraseña = document.getElementById('txtrepetircontraseña').value;


    if (!datos.nombre || !datos.apellido || !datos.telefono || !datos.password || !repetircontraseña){
        alert('Todos los campos deben estar llenos')
        return;
    }
if (repetircontraseña != contraseña){
    alert('Las controseñas no coinciden')
    return;
}
    const request = await fetch('api/usuario', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos) //convierte el Objeto String a Objeto con formato JSON
    });
alert("la cuenta fue creada con exito")
window.location.href='usuarios.html'

}

