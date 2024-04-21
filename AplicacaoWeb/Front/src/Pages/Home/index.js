import './index.css'

const formulario = document.querySelector("form")
const nomeDoProduto = document.querySelector(".nome")
const preco = document.querySelector(".preco")
const categoria = document.querySelector(".categoria")

async function cadastrar() {
    fetch("http://localhost:8080/products",{
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method:'POST',
        body: JSON.stringify({
            nomeDoProduto: nomeDoProduto?.value,
            preco: preco?.value,
            categoria: categoria?.value
        })
    })
    .then(function (res) { console.log(res)})
    .catch(function (res) {console.log(res)})
}

function limpar(){
    nomeDoProduto.value = ""
    preco.value = ""
    categoria.value = ""
}

formulario?.addEventListener('submit', function (e) {
    e.preventDefault();

    cadastrar();
    limpar();
})

const Home = () => {
    return (
        <section>
            <div className="form-box">
                <div className="form-value">
                    <form>
                        <h2>Cadastrar produtos</h2>
                        <div className="inputbox">
                            <input name="nome" className='nome' type="text" required/>
                            <label htmlFor="">Nome:</label>
                        </div>
                        <div className="inputbox">
                            <input name="preco" className='preco' type="text" required/>
                            <label htmlFor="">Preço:</label>
                        </div>
                        <div className="inputbox">
                            <input name="categoria" className='categoria' type="text" required/>
                            <label htmlFor="">Categoria:</label>
                        </div>
                        <button type='submit'>Cadastrar</button>
                    </form>
                </div>
            </div>
        </section>
    )
}

export default Home