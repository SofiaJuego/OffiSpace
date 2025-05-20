import React from "react";
import styles from "../footer/Footer.module.css";
import logo from "../../../assets/isologo.png"

function Footer(){
    const currentYear = new Date().getFullYear();

    return(

        <footer className={styles.footer}>
            <div className={styles.footerContent}>
                <img src={logo} alt="OffiSpace logo" className={styles.logo} />
                <p className={styles.text}>
                    &copy; {currentYear} OffiSpace. Todos los derechos reservados.
                </p>
            </div>

        </footer>
    );

}

export default Footer;