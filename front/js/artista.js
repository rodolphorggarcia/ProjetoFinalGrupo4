

function exibirartistas(){
    fetch("http:localhost:8080/artistas")
    .then(res => res.json())
    .then(res => preenchercombo(res))
    
}

function preenchercombo(lista){

   var saida = "";
   for (contador=0; contador< lista.length; contador++){
       saida+=
       //<option value=''>texto</option>
       "<option value='" + lista[contador].id + "'>" + lista[contador].nomeArtistico + "</option>";

   }
   document.getElementById("cmbartistas").innerHTML=saida;
}

function filtrar(){
    fetch("http://localhost:8080/artista/"+document.getElementById("cmbartistas").value)
    .then(res => res.json())
    .then(res => preenchertabela(res.musicas));
    
}

function preenchertabela(lista){
    var saida ="<table class='table'>" +
    "<thead class='thead-dark'>"+
    "<tr>" +
    "<th>#</th>" +
    "<th>Musica</th>" +
    "<th>Lançamento</th>" +
    "</tr>"+
    "</thead>";

    for(contador=0; contador<lista.length;contador++){
        saida +=
        "<tbody>"+
        "<tr>" +
        "<td>"+ contador+"</td>" +
        "<td>"+ lista[contador].titulo+"</td>" +
        "<td>"+ lista[contador].lancamento+"</th>" +
        "</tr>"+
        "</tbody>";
        
    }

    saida+= "</table>";
    document.getElementById("dados").innerHTML=saida;

}
