$(document).ready(function () {

});


async function iniciarsesion() {

    let datos = {};
    //estamos creando el objeto y asignando el nombre de las propiedades(atributos) esos nombres deben
    //ser igual a como aparecen en models en la clase usuario donde creamos el objeto y sus atributos
    datos.email = document.getElementById('txtEmail').value;
    datos.password =   document.getElementById('txtcontraseña').value;

//verifica que no exitan campos vacios
    if (!datos.email || !datos.password ){
        alert('Todos los campos deben estar llenoos')

        return window.location.href='login.html' ;
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
    window.location.href='login.html'

}

