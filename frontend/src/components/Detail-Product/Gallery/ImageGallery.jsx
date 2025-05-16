import React from "react";
import styles from "../Gallery/ImageGallery.module.css"

function ImageGallery(){
    const mainImage = "public/web/oficina-privada.jpg"

    const sideImages = [
        "./web/oficina-privada.jpg",
        "./web/sala-reuniones.jpg",
        "./web/sala-reuniones.jpg",
        "./web/sala-reuniones.jpg"
    
    ];

    return(
        <section className={styles.galleryContainer}>
            <div className={styles.mainImageWrapper}>
                <img src={mainImage} alt="Imagen principal del espacio" className={styles.mainImage}/>
            </div>

            <div className={styles.sideImagesWrapper}>
                {sideImages.map((img,idx) => (
                    <img key={idx} src={img} alt={`Imagen secundaria ${idx + 1}`} className={styles.sideImage} />
                ))}
            </div>

            <button className={styles.viewMoreBtn}>Ver más</button>

        </section>
    );
}

export default ImageGallery;