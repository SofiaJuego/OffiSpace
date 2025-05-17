import React from "react";
import styles from "../HostCard/HostCard.module.css"
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faShareAlt, faHeart } from "@fortawesome/free-solid-svg-icons";

function HostCard(){
    return(
        <div className={styles.cardContainer}>
            <div className={styles.header}>
                <h3 className={styles.name}>Nombre Anfitrión</h3>
                <span className={styles.role}>Anfitrión</span>
            </div>

            <div className={styles.price}>
                <span>$17.000</span> reserva por hora
            </div>

            <button className={styles.reserveBtn}>Reservar</button>
            <div className={styles.actions}>
                <button className={styles.actionBtn}>
                <FontAwesomeIcon icon={faHeart} className={styles.icon} title="Favorito" />
                Favorito
            </button>

            <button className={styles.actionBtn}>
                   <FontAwesomeIcon icon={faShareAlt} className={styles.icon} title="Compartir" />
                   Compartir
            </button>
             
            </div>
            
                
            </div>
        
    );
}

export default HostCard;