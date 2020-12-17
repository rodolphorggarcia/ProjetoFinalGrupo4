

function exibirusuario(){
    var usuariostr = localStorage.getItem("userlogado");
    if(usuariostr==null){
        window.location="login.html";
    }
    else{
        var usuariojson = JSON.parse(usuariostr);
        document.getElementById("dados").innerHTML =
        "<h3>Usuário: " + usuariojson.nome + "<br>" +
        "Email: " + usuariojson.email + "(" + usuariojson.id + ")</h3>";

        document.getElementById("foto").innerHTML= 
        "<img alt'Não existe imagem' width='40%' height='80% 'src=images/" + usuariojson.foto + ">";
    }
}

function logar(){
    //window.alert("Oi");       Usado para testar se tava abrindo mesmo a funcao

    //Carregar os dados que o usuario digitar:
    var userjson = {
        "email": document.getElementById("txtemail").value,
        "senha": document.getElementById("txtsenha").value
    };

    //Vai pegar todo conteudo que tem que enviar via http do Front para o back
    var pacote = {
        method:"POST",
        body: JSON.stringify(userjson),
        headers : {
            "Content-type" : "application/json"
        }
    };

    //Funcao que nao é do java script ele herdou do hajax
    //Ele é o cara que vai trasnportar ele é o carteiro que vai entregar nesse endereco a funcao pacote
    fetch("http://localhost:8080/login", pacote)
    .then(res => res.json())
    .then(res => {
        localStorage.setItem("userlogado", JSON.stringify(res));
        window.location="usuario.html";
    })
    .catch(err =>{
        window.alert("Login Invalido");
    });
}

function novoUsuario(){

    var userjson = {

        "nome": document.getElementById("txtnome").value,
        "email": document.getElementById("txtemail").value,
        "senha": document.getElementById("txtsenha").value,
        "foto": document.getElementById("txtfoto").value
    };

    var pacote = {
        method:"POST",
        body: JSON.stringify(userjson),
        headers : {
            "Content-type" : "application/json"
        }
    };

    fetch("http://localhost:8080/cadastrar", pacote)
    .then(res => res.json())
    .then(res => {
        localStorage.setItem("userlogado", JSON.stringify(res));
        window.alert("Cadastrado com sucesso!!")
        window.location="novousuario.html"
    })
    .catch(err =>{
        window.alert("Cadastro inválido");
    });




}

