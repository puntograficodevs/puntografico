function buscarProductoAsociado() {
    const selectorDeCategoria = document.getElementById("categoriaProducto");
    const idCategoria = selectorDeCategoria.options[selectorDeCategoria.selectedIndex].value;

    if (idCategoria == 2) {
        const formularioPapeleria = document.getElementById("form-papeleria");
        formularioPapeleria.classList.remove("d-none");
    } else {
        formularioPapeleria.classList.add("d-none");
        document.getElementById("papeleriaId").value = "";
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
    const btnAgregarPapeleria = document.getElementById('btnAgregarPapeleria');

    if (totalInput && abonadoInput) {
        totalInput.addEventListener('input', calcularResta);
        abonadoInput.addEventListener('input', calcularResta);
    }

    if (btnAgregarPapeleria) {
        btnAgregarPapeleria.addEventListener('click', async function () {
            const inputs = document.querySelectorAll("#form-papeleria input, #form-papeleria select");
            const formData = new FormData();
            inputs.forEach(input => {
                if (input.name) {
                    formData.append(input.name, input.value);
                }
            });

            const response = await fetch("/guardar-papeleria", {
                method: "POST",
                body: formData
            });

            if (response.ok) {
                const data = await response.json();
                document.getElementById("papeleriaId").value = data.id;
                alert("Producto de papelería agregado correctamente.");
            } else {
                alert("Error al guardar el producto de papelería.");
            }
        });
    }
});
