function mostrarCategoriaSeleccionada(){
    const selectorDeCategoria = document.getElementById("selectCategoriaProducto");
    const nombreCategoria = selectorDeCategoria.options[selectorDeCategoria.selectedIndex].text;

    if (selectorDeCategoria !== "" && selectorDeCategoria !== null) {
        alert("Seleccionaste la categoria: " + nombreCategoria);
    } else {
        alert("No seleccionaste ninguna categoria.");
    }
}
