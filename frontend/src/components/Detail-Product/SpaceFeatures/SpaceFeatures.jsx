import React from "react";
import styles from "../SpaceFeatures/SpaceFeatures.module.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faUsers, faWifi, faSnowflake, faVideo, faRulerCombined } from "@fortawesome/free-solid-svg-icons";

function SpaceFeatures(){
    return(
        <section className={styles.featuresContainer}>
            <h3 className={styles.sectionTitle}>Comodidades</h3>
            <ul className={styles.featuresList}>
                <li className={styles.featureChip}>
                    <FontAwesomeIcon icon={faWifi} className={styles.icon} />
                    Wi-Fi
                </li>
                 <li className={styles.featureChip}>
                    <FontAwesomeIcon icon={faSnowflake} className={styles.icon} />
                    Aire acondicionado
                    </li>
                <li className={styles.featureChip}>
                    <FontAwesomeIcon icon={faWifi} className={styles.icon} />
                    Wi-Fi
                </li>
                 <li className={styles.featureChip}>
                        <FontAwesomeIcon icon={faVideo} className={styles.icon} />
                        Proyector HD
                        </li>
                 <li className={styles.featureChip}>
                        <FontAwesomeIcon icon={faVideo} className={styles.icon} />
                        Proyector HD
                        </li>
                 <li className={styles.featureChip}>
                        <FontAwesomeIcon icon={faVideo} className={styles.icon} />
                        Proyector HD
                        </li>
                     <li className={styles.featureChip}>
                        <FontAwesomeIcon icon={faVideo} className={styles.icon} />
                        Proyector HD
                        </li>
                     <li className={styles.featureChip}>
                        <FontAwesomeIcon icon={faVideo} className={styles.icon} />
                        Proyector HD
                        </li>
                        
            </ul>
        </section>
    );
}

export default SpaceFeatures;