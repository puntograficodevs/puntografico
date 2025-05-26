/*document.addEventListener("DOMContentLoaded", function () {
  const tipoInput = document.getElementById("tipoBusqueda");
  const valorInput = document.getElementById("valorBusqueda");
  const buscarBtn = document.getElementById("buscarBtn");

  buscarBtn.addEventListener("click", (event) => {
    event.preventDefault();

    alert("hice click");

    const tipo = tipoInput.value;
    const valor = valorInput.value.trim();
    const username = document.getElementById("nombreEmpleado").value;

    alert("tipo: " + tipo + ", valor: " + valor + ", username: " + username);

    fetch(`/buscar-orden?tipo=${tipo}&valor=${valor}&key=asdghaer123riuhy12o34y12fh&username=${encodeURIComponent(username)}`)
      .then(res => res.json())
      .then(data => {
        alert("fue a buscar datos");
        alert("mira la consola, capo");
        console.log("Resultados:", data);
        // Acá mostrás resultados como quieras
      })
      .catch(err => console.error("Error al buscar:", err));
  });
});*/

document.getElementById('form-buscador').addEventListener('submit', function(e) {
  e.preventDefault();

  const tipo = document.getElementById('tipoBusqueda').value;
  const valor = document.getElementById('valorBusqueda').value.trim();
  if (!valor) return;

  fetch(`/buscar-orden?tipo=${tipo}&valor=${encodeURIComponent(valor)}&key=asdghaer123riuhy12o34y12fh`)
    .then(res => res.text())
    .then(fragmentoHtml => {
      document.getElementById('resultados').innerHTML = fragmentoHtml;
    })
    .catch(console.error);
});
