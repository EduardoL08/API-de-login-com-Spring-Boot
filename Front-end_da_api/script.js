const formulario = document.querySelector("form");
const botao = document.querySelector("button")
const inome = document.querySelector(".nome");
const iemail = document.querySelector(".email");
const isenha = document.querySelector(".senha");
const itelefone = document.querySelector(".telefone");

function cadastrar (){
    fetch("http://localhost:8080/usuarios",
        {
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            },

            method: 'POST',
            body: JSON.stringify({
                nome: inome.value,
                email: iemail.value,
                senha: isenha.value,
                telefone: itelefone.value
            })


        })

        .then(function (res) {console.log("Success:",res)})
        .catch(function (err) { console.error("Error:",err)})
    }

    function limpar(){
        inome.value = "",
        iemail.value = "",
        isenha.value = "",
        itelefone.value = ""
    }

formulario.addEventListener("submit", function (event){

    event.preventDefault();

    cadastrar();
    limpar();
})