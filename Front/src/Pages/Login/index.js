import './index.css'
import { useNavigate } from 'react-router-dom';

const Home = () => {
    const navigate = useNavigate();

    const RotaLogin = () => {
        navigate('/novo')
    }

    return (
        <section>
            <div class="form-box">
                <div class="form-value">
                    <form action="">
                        <h2>Login</h2>
                        <div class="inputbox">
                            <ion-icon name="mail-outline"></ion-icon>
                            <input type="email" required/>
                            <label for="">E-mail</label>
                        </div>
                        <div class="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input type="password" required/>
                            <label for="">Senha</label>
                        </div>
                        <div class="forget">
                            <label for=""><input type="checkbox"/>Manter conectado</label>
                        </div>
                        <button onClick={RotaLogin}>Log in</button>
                        <div class="register">
                            <p>Não tem uma conta ? <a href="#">Registre-se</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    )
}

export default Home