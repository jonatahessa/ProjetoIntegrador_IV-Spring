function main() {
  document.querySelector("#botao-novo").addEventListener("click", mostrarJanelaNovo);
}

function mostrarJanelaNovo() {
  document.querySelector("#cadastrar").style.display = 'block';
  document.querySelector("#nevoa").style.display = "block";
}

window.addEventListener("load", main);
