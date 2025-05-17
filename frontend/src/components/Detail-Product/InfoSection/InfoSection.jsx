import React from "react";
import styles from "../InfoSection/InfoSection.module.css";
import SpaceInfo from "../SpaceInfo/SpaceInfo";
import HostCard from "../HostCard/HostCard";

function InfoSection(){
    return(
        <section className={styles.infoSection}>
            <div className={styles.left}>
                <SpaceInfo/>
            </div>

            <div className={styles.right}>
                <HostCard/>
            </div>
        </section>
    );
}

export default InfoSection;