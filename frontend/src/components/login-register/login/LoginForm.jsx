import React, { useState } from "react";
import styles from "../login/Login.module.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faUser,faLock, faEnvelope } from "@fortawesome/free-solid-svg-icons";

function LoginForm(){

    const [action, setAction] = useState('');

    const registerLink = () => {
        setAction('active');
    };

    const loginLink = () => {
        setAction(' ');
    };

    return(

        <div className={`${styles.wrapper} ${action ? styles[action] : ""}`}>

        <div className={styles.formLogin}>
            <form action="">
                <h1 >Iniciar sesión</h1>

                <div className={styles.inputbox}>
                    <input type="text" placeholder="Correo electrónico" required/>
                    <FontAwesomeIcon icon={faEnvelope} className={styles.icon} />
                </div>

                <div className={styles.inputbox}>
                    <input type="password" placeholder="Contraseña" required/>
                    <FontAwesomeIcon icon={faLock} className={styles.icon} />
                </div>

                <div className={styles.remember}>
                    <label><input type="checkbox"/>Recordarme</label>
                    <a href="#">¿Olvidaste tu contraseña?</a>
                </div>

                <button type="submit">Iniciar sesión</button>

                <div className={styles.registerLink}>
                    <p>¿No tienes cuenta?<a href="#" onClick={registerLink} > Registrarme </a></p>
                </div>

            </form>
        </div>  
       
        <div className={styles.formRegister}>
            <form action="">
                <h1 >Registrarme</h1>
                
                <div className={styles.inputbox}>
                    <input type="text" placeholder="Nombre" required/>
                    <FontAwesomeIcon icon={faUser} className={styles.icon} />
                </div>

                <div className={styles.inputbox}>
                    <input type="text" placeholder="Correo electrónico" required/>
                    <FontAwesomeIcon icon={faEnvelope} className={styles.icon} />
                </div>

                <div className={styles.inputbox}>
                    <input type="password" placeholder="Contraseña" required/>
                    <FontAwesomeIcon icon={faLock} className={styles.icon} />
                </div>

                <div className={styles.proprietor}>
                    <label><input type="checkbox"/>Soy propietario</label>
                </div>

                <button type="submit">Crear cuenta</button>

                <div className={styles.loginLink}>
                    <p>¿Ya tienes cuenta?<a href="#" onClick={loginLink} > Iniciar sesión </a></p>
                </div>

            </form>
        </div>

    </div>
        

    );
    

}

export default LoginForm;
