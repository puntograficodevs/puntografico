function buscarProductoAsociado() {
    const selectorDeCategoria = document.getElementById("categoriaProducto");
    const idCategoria = selectorDeCategoria.value;

    const formularioEtiqueta = document.getElementById("form-etiqueta");

    if (idCategoria === "12") {
        formularioEtiqueta.classList.remove("d-none");

        // Activo los required del formulario etiqueta
        formularioEtiqueta.querySelectorAll("input, select").forEach(el => {
            if (el.hasAttribute("required") || el.name === "medida" || el.name === "cantidad" || el.name === "total" || el.name === "abonado") {
                el.required = true;
            }
        });

        // Desactivo los required fuera del formulario etiqueta que no estén relacionados
        // (Por ejemplo, acá no tocamos nada porque el form completo tiene otros required)
    } else {
        formularioEtiqueta.classList.add("d-none");

        // Desactivo required en el formulario etiqueta
        formularioEtiqueta.querySelectorAll("input, select").forEach(el => el.required = false);

        // Limpio etiquetaId
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

function limitarCheckboxes(grupoClase) {
    const checkboxes = document.querySelectorAll(`.${grupoClase}`);
    checkboxes.forEach(chk => {
        chk.addEventListener('change', () => {
            if (chk.checked) {
                // Desmarcar todos menos el que activó el cambio
                checkboxes.forEach(otherChk => {
                    if (otherChk !== chk) otherChk.checked = false;
                });
            }
        });
    });
}

document.addEventListener("DOMContentLoaded", function () {
    buscarProductoAsociado(); // Por si hay un valor cargado al inicio

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

    // Limitar checkboxes en tipo papel y tipo laminado a uno solo
    limitarCheckboxes('tipo-papel-checkbox');
    limitarCheckboxes('tipo-laminado-checkbox');
});

// Bootstrap validation custom
(() => {
  'use strict'

  const forms = document.querySelectorAll('.needs-validation');

  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault();
        event.stopPropagation();
      }
      form.classList.add('was-validated');
    }, false);
  });
})();
