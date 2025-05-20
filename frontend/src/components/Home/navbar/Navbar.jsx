import React, {useState} from "react";
import styles from "../navbar/Navbar.module.css";
import logo from "../../../assets/logo.png";
import { FaBars, FaTimes } from "react-icons/fa";



function Navbar(){
    const [menuOpen, setMenuOpen] = useState(false);
    const [closing, setClosing] = useState(false);

    const handleClose = () => {
        setClosing(true);
        setTimeout(() => {
            setMenuOpen(false);
            setClosing(false);
        }, 300);
    };


    return(
        <header className={styles.navbar}>
            <div className={styles.left}>
                <img src={logo} alt="logo de offispace" className={styles.logo}/>
                <span className={styles.lema}>Trabaja a tu manera</span>
            </div>

            <div className={styles.right}>
                <button className={styles.outlineBtn}>Crear cuenta</button>
                <button className={styles.outlineBtn}>Iniciar sesión</button>
            </div>
            {!menuOpen &&(
                <button className={styles.hamburger} 
                onClick={() => setMenuOpen(true)} aria-label="Abrir menu">
                <FaBars />
                </button>

            )}
            
            {menuOpen && (
                <div className={styles.mobileMenu}>
                    <button className={`${styles.closeBtn} ${closing ? styles.fadeOut : ""}` }
                    onClick={(handleClose)} 
                    aria-label="Cerrar menú">
                         <FaTimes />
                    </button>
                     <button className={styles.outlineBtn}>Crear cuenta</button>
                     <button className={styles.outlineBtn}>Iniciar sesión</button>
                </div>
            )}

        </header>
    );
}

export default Navbar;