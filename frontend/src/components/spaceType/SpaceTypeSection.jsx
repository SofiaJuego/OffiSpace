import React from "react";
import styles from "../spaceType/SpaceType.module.css"

function SpaceType(){
    return(
        <section className={styles.sectionContainer}>
        <h2 className={styles.sectionTitle}>Elegí el tipo de espacio que necesitás hoy</h2>

        {/* Cards */}

        <div className={styles.cardsContainer}>
            <div className={styles.card}>
                <img src="../../../public/web/oficina-privada.jpg" alt="Oficina privada" />
                <h3>Oficina privada</h3>
                <p>Ideal para consultas, reuniones con clientes</p>
                <button>Ver más</button>
            </div>

            <div className={styles.card}>
                <img src="../../../public/web/sala-reuniones.jpg" alt="Sala de reuniones" />
                <h3>Sala de eventos</h3>
                <p>Ideal para presentaciones o espacios de networking.</p>
                <button>Ver más</button>
            </div>

              <div className={styles.card}>
                <img src="../../../public/web/sala-reuniones.jpg" alt="Sala de reuniones" />
                <h3>Sala de reuniones</h3>
                <p>Ideal para reuniones de equipo, presentaciones y más.</p>
                <button>Ver más</button>
            </div>

            
        </div>
    </section>
    );
    
}

export default SpaceType;