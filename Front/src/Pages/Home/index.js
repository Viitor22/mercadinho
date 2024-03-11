import './index.css'

const formulario = document.querySelector("form")
const Inome = document.querySelector(".nome")
const Ipreco = document.querySelector(".preco")
const ICategoria = document.querySelector(".categoria")

function cadastrar() {
    fetch("http://localhost:8080",{
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method:'POST',
        body: JSON.stringify({
            nome: Inome.value,
            preco: Ipreco.value,
            categoria: ICategoria.value
        })
    })
    .then(function (res) { console.log(res)})
    .catch(function (res) {console.log(res)})
}

function limpar(){
    Inome.value = ""
    Ipreco.value = ""
    ICategoria.value = ""
}

formulario.addEventListener('submit', function (e) {
    e.preventDefault();

    cadastrar();
    limpar();
})

const Home = () => {
    return (
        <section>
            <div class="form-box">
                <div class="form-value">
                    <form>
                        <h2>Cadastrar produtos</h2>
                        <div class="inputbox">
                            <input type="nome" required/>
                            <label for="">Nome:</label>
                        </div>
                        <div class="inputbox">
                            <input type="preco" required/>
                            <label for="">Preço:</label>
                        </div>
                        <div class="inputbox">
                            <input type="categoria" required/>
                            <label for="">Categoria:</label>
                        </div>
                        <button type='submit'>Cadastrar</button>
                    </form>
                </div>
            </div>
        </section>
    )
}

export default Home