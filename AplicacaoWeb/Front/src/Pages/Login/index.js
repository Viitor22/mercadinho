import './index.css'
import { useNavigate } from 'react-router-dom';

const Login = () => {
    const formulario = document.querySelector("form")
    const Iemail = document.querySelector(".email")
    const Isenha = document.querySelector(".senha")

async function cadastrar() {
    fetch("http://localhost:8080/cadastrar",{
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method:'POST',
        body: JSON.stringify({
            email: Iemail.value,
            senha: Isenha.value,
        })
    })
    .then(function (res) { console.log(res)})
    .catch(function (res) {console.log(res)})
}

function limpar(){
    Iemail.value = ""
    Isenha.value = ""
}

formulario?.addEventListener('submit', function (e) {
    e.preventDefault();

    cadastrar();
    limpar();
})


    const navigate = useNavigate();

    const RotaLogin = () => {
        navigate('/novo')
    }

    return (
        <section>
            <div className="form-box">
                <div className="form-value">
                    <form action="">
                        <h2>Login</h2>
                        <div className="inputbox">
                            <ion-icon name="mail-outline"></ion-icon>
                            <input className='email' type="email" required/>
                            <label>E-mail</label>
                        </div>
                        <div className="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input className='email' type="password" required/>
                            <label>Senha</label>
                        </div>
                        <div className="forget">
                            <label><input type="checkbox"/>Manter conectado</label>
                        </div>
                        <button type='submit' onClick={RotaLogin}>Log in</button>
                        <div className="register">
                            <p>Não tem uma conta ? <a href="#">Registre-se</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    )
}

export default Login