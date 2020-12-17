
function exibiraagentes(){
    fetch("http:localhost:8080/agentes")
    .then(res => res.json())
    .then(res => preenchercombo(res))
    

    var usuariostr = localStorage.getItem("userlogado");

    if(usuariostr==null){
        window.location="login.html";
    }
    else{
        var usuariojson = JSON.parse(usuariostr);
        document.getElementById("dados").innerHTML =
        "<h3>Usuário: " + usuariojson.nome + "<br>";

        document.getElementById("foto").innerHTML= 
        "<img alt'Não existe imagem' width='30%' height='60% 'src=images/" + usuariojson.foto + ">";
    }
}

function preenchercombo(lista){
    var tabela ="<table class='table'>" +
    "<thead class='thead-dark'>"+
    "<tr>" +
    "<th>Parceiro</th>" +
    "<th>Volume Transacional</th>" +
    "</tr>"+
    "</thead>";
   
   var saida = "<option value=''>Selecione</option>";
   for (contador=0; contador< lista.length; contador++){
       saida+=
       "<option value='" + lista[contador].id_agente + "'>" + lista[contador].nome_agente + "</option>";

       tabela +=
        "<tbody>"+
        "<tr>" +
        "<td>"+ lista[contador].nome_agente+"</td>" +
        "<td>"+ lista[contador].volume_transacional+"</td>" +
        "</tr>"+
        "</tbody>";

   }
   document.getElementById("cmbagentes").innerHTML=saida;
   tabela+= "</table>";
   document.getElementById("top10").innerHTML=tabela;
   localStorage.setItem("escolha", JSON.stringify(lista));
}


function getTransacoes(){
    var agentestr = localStorage.getItem("escolha");
    var agentejson = JSON.parse(agentestr);
    window.alert(agentejson);
    
    fetch("http://localhost:8080/totalsucesso/"+agentejson.id_agente)
    .then(res => res.json())
    .then(res => {
        document.getElementById("sucesso").innerHTML = 
        "<br> Sucesso: " + res});


    fetch("http://localhost:8080/totalfalha/"+agentejson.id_agente)
    .then(res => res.json())
    .then(res => {
        document.getElementById("falha").innerHTML = 
        "<br> Falha: " + res});

    fetch("http://localhost:8080/totalfraude/"+agentejson.id_agente)
    .then(res => res.json())
    .then(res => {
        document.getElementById("fraude").innerHTML = 
        "<br> Fraude: " + res});
    
}


