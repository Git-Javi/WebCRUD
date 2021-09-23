// Añade la clase al elemento de la barra de navegación que permite colorearlo según la acción correspondiente
function addButtonFocusClass() {
    let url = window.location.href;
    if (url.includes('create')) {
        document.getElementById('createNavLink').classList.add('text-warning');
    } else if (url.includes('read')) {
        document.getElementById('readNavLink').classList.add('text-warning');
    } else if (url.includes('update')) {
        document.getElementById('updateNavLink').classList.add('text-warning');
    } else if (url.includes('delete')) {
        document.getElementById('deleteNavLink').classList.add('text-warning');
    }
}

function customizeDataFormElements() {
    let url = window.location.href;
    setSubmitButtonText(url);
    setDataFormProfile(url);
}

// Establece el texto del Botón de submit del formulario en función de la operación que se esté realizando
function setSubmitButtonText(url) {
    if (url.includes('create')) {
        document.getElementById('clienteActionSubmit').value = 'Create';
    } else if (url.includes('read')) {
        document.getElementById('clienteActionSubmit').value = 'Ok';
    } else if (url.includes('update')) {
        document.getElementById('clienteActionSubmit').value = 'Update';
    } else if (url.includes('delete')) {
        document.getElementById('clienteActionSubmit').value = 'Delete';
    }
}

// Habilita o desahabilita los inputs del formulario en función de la acción sobre la que haya sido llamado
function setDataFormProfile(url) {
    if (url.includes('create')) {
        document.getElementById('labelClienteId').innerText = '';
        document.getElementById('inputClienteId').type = 'hidden';
        document.getElementById('inputClienteNombre').readOnly = false;
        document.getElementById('inputClienteApellido').readOnly = false;
        document.getElementById('inputClienteEmail').readOnly = false;
    } else if (url.includes('update')) {
        document.getElementById('inputClienteId').readOnly = true;
        document.getElementById('inputClienteNombre').readOnly = false;
        document.getElementById('inputClienteApellido').readOnly = false;
        document.getElementById('inputClienteEmail').readOnly = false;
    }
}