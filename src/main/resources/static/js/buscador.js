document.addEventListener("DOMContentLoaded", function () {
  const tipoInput = document.getElementById("tipoBusqueda");
  const valorInput = document.getElementById("valorBusqueda");

  let timeout = null;

  valorInput.addEventListener("input", () => {
    clearTimeout(timeout);
    timeout = setTimeout(() => {
      const tipo = tipoInput.value;
      const valor = valorInput.value.trim();

      if (valor === "") return;

      fetch(`/buscar-orden?tipo=${tipo}&valor=${encodeURIComponent(valor)}`)
        .then(res => res.json())
        .then(data => {
          console.log("Resultados:", data);
        })
        .catch(err => console.error("Error al buscar:", err));
    }, 300);
  });
});