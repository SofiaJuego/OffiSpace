import React from "react";
import styles from "../SpaceInfo/SpaceInfo.module.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStar } from "@fortawesome/free-solid-svg-icons";


function SpaceInfo(){
    return(
        <section className={styles.infoContainer}>
            <h2 className={styles.title}>Gran oficina en el centro</h2>

            <div className={styles.detailsRow}>
                <div className={styles.rating}>
                    <FontAwesomeIcon icon={faStar} style={{ color: "#636465", marginRight: "1px"}} />
                    <span className={styles.score}>4.5 </span>
                </div>
                <span className={styles.line}>|</span>
                <span className={styles.reviews}>10 Reseñas</span>
                <span className={styles.line}>|</span>
                <span className={styles.location}>Avenida Corrientes 800, Buenos Aires</span>
            </div>

            <p className={styles.description}>Somos el espacio de coworking que querrás que tus clientes visiten. Donde tu marca crecerá. 
                Si te encantan los detalles como a nosotros, este es tu lugar.
                Somos el espacio de coworking que querrás que tus clientes visiten. Donde tu marca crecerá. 
                Si te encantan los detalles como a nosotros, este es tu lugar.
                Somos el espacio de coworking que querrás que tus clientes visiten. Donde tu marca crecerá. 
                Si te encantan los detalles como a nosotros, este es tu lugar.
                Somos el espacio de coworking que querrás que tus clientes visiten. Donde tu marca crecerá. 
                Si te encantan los detalles como a nosotros, este es tu lugar.
                Somos el espacio de coworking que querrás que tus clientes visiten. Donde tu marca crecerá. 
                Si te encantan los detalles como a nosotros, este es tu lugar.
                Somos el espacio de coworking que querrás que tus clientes visiten. Donde tu marca crecerá. 
                Si te encantan los detalles como a nosotros, este es tu lugar.
                Somos el espacio de coworking que querrás que tus clientes visiten. Donde tu marca crecerá. 
                Si te encantan los detalles como a nosotros, este es tu lugar.
                Somos el espacio de coworking que querrás que tus clientes visiten. Donde tu marca crecerá. 
                Si te encantan los detalles como a nosotros, este es tu lugar.
            </p>
        </section>
    );

}

export default SpaceInfo;