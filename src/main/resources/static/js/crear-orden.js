function buscarProductoAsociado() {
    const selectorDeCategoria = document.getElementById("categoriaProducto");
    const idCategoria = selectorDeCategoria.options[selectorDeCategoria.selectedIndex].value;

    if (idCategoria == 12) {
        const formularioEtiqueta = document.getElementById("form-etiqueta");
        formularioEtiqueta.classList.remove("d-none");
    } else {
        formularioEtiqueta.classList.add("d-none");
        document.getElementById("etiquetaId").value = "";
    }
}

function calcularResta() {
    const totalInput = document.getElementById('total');
    const abonadoInput = document.getElementById('abonado');
    const restaInput = document.getElementById('resta');

    if (totalInput && abonadoInput && restaInput) {
        const total = parseFloat(totalInput.value) || 0;
        const abonado = parseFloat(abonadoInput.value) || 0;
        const resta = total - abonado;
        restaInput.value = resta.toFixed(2);
    }
}

document.addEventListener("DOMContentLoaded", function () {
    const totalInput = document.getElementById('total');
    const abonadoInput = document.getElementById('abonado');
    const btnAgregarEtiqueta = document.getElementById('btnAgregarEtiqueta');

    if (totalInput && abonadoInput) {
        totalInput.addEventListener('input', calcularResta);
        abonadoInput.addEventListener('input', calcularResta);
    }

    if (btnAgregarEtiqueta) {
        btnAgregarEtiqueta.addEventListener('click', async function () {
            const inputs = document.querySelectorAll("#form-etiqueta input, #form-etiqueta select");
            const formData = new FormData();
            inputs.forEach(input => {
                if (input.name) {
                    formData.append(input.name, input.value);
                }
            });

            const response = await fetch("/guardar-etiqueta", {
                method: "POST",
                body: formData
            });

            if (response.ok) {
                const data = await response.json();
                document.getElementById("etiquetaId").value = data.id;
                alert("Producto de etiqueta agregado correctamente.");
            } else {
                alert("Error al guardar el producto de etiqueta.");
            }
        });
    }
});

(() => {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})()