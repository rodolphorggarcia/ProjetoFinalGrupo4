

function exibiraagentes(){
    fetch("http:localhost:8080/agentes")
    .then(res => res.json())
    .then(res => preenchercombo(res))
    
}

function preenchercombo(lista){

   var saida = "";
   for (contador=0; contador< lista.length; contador++){
       saida+=
       //<option value=''>texto</option>
       "<option value='" + lista[contador].id_agente + "'>" + lista[contador].nome_agente + "</option>";

   }
   document.getElementById("cmbagentes").innerHTML=saida;
}

function getTransacoes(){
    debugger
    var sucesso = 0;
    var falha = 0;
    var fraude = 0;
    window.alert(document.getElementById("cmbagentes").volume_transacional)
    /*
    fetch("http://localhost:8080/agente/"+document.getElementById("cmbagentes").value)
    .then(res => res.json())
    .then(res =>  total);*/
    

    fetch("http://localhost:8080/totalsucesso/"+document.getElementById("cmbagentes").value)
    .then(res => res.json())
    .then(res => {
        document.getElementById("dados").innerHTML = 
        document.getElementById("cmbagentes").options[document.getElementById("cmbagentes")].text
        + "<br> Total de Lancamentos: " + res

    });

    fetch("http://localhost:8080/totalfalha/"+document.getElementById("cmbagentes").value)
    .then(res => res.json())
    .then(res => falha);

    fetch("http://localhost:8080/totalfraude/"+document.getElementById("cmbagentes").value)
    .then(res => res.json())
    .then(res => fraude);
    
    window.alert(total, sucesso, falha, fraude)
    //preenchertabela(total, sucesso, falha, fraude)
    
}

function preenchertabela(total, sucesso, falha, fraude){
    var saida ="<table class='table'>" +
    "<thead class='thead-dark'>"+
    "<tr>" +
    "<th>Numero de transações do dia</th>" +
    "<th>Numero de transações com sucesso</th>" +
    "<th>Numero de transações com saldo insuficiente</th>" +
    "<th>Numero de transações com suspeita de fraude</th>" +
    "</tr>"+
    "</thead>";

    "<tbody>"+
    "<tr>" +
    "<td>"+ total+"</td>" +
    "<td>"+ sucesso+"</td>" +
    "<td>"+ falha+"</td>" +
    "<td>"+ fraude+"</td>" +
    "</tr>"+
    "</tbody>"+
    "</table>";

  
    

    saida+= "</table>";
    document.getElementById("dados").innerHTML=saida;

}
