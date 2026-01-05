import React from "react";
import styles from "../recommendations/Recommendations.module.css";

import Card from "../../Cards/Card";


const mockProducts = [
  {
    image: "/web/oficina-privada.jpg",
    title: "Espacio Creativo",
    category: "Sala de reuniones",
    description: "Ideal para workshops y sesiones de brainstorming.",
    rating: 4.5,
    price: 25,
  },
  {
    image: "/web/oficina-privada.jpg",
    title: "Oficina Moderna",
    category: "Oficina privada",
    description: "Perfecta para equipos pequeños.",
    rating: 4.8,
    price: 30,
  },
  {
    image: "/web/oficina-privada.jpg",
    title: "Sala Ejecutiva",
    category: "Sala de juntas",
    description: "Diseñada para presentaciones y reuniones importantes.",
    rating: 4.2,
    price: 40,
  },
  {
    image: "/web/oficina-privada.jpg",
    title: "Espacio de Coworking",
    category: "Coworking",
    description: "Ambiente compartido con todas las comodidades.",
    rating: 4.7,
    price: 20,
  },
  {
    image: "/web/oficina-privada.jpg",
    title: "Estudio Creativo",
    category: "Estudio",
    description: "Ambiente perfecto para sesiones fotográficas.",
    rating: 4.4,
    price: 35,
  },
  {
    image: "/web/oficina-privada.jpg",
    title: "Loft Profesional",
    category: "Loft",
    description: "Diseño moderno para reuniones flexibles.",
    rating: 4.6,
    price: 28,
  },
];

function Recommendations(){
    const selected = mockProducts.slice(0,6);

    return(
        <section className={styles.sectionContainer}>
            <h2 className={styles.sectionTitle}>Espacios que te pueden interesar </h2>
            <div className={styles.gridContainer}>
              {selected.map((product, index) => (
                <Card key={index} product={product}/>
              ))}


            </div>
        </section>
    );
   
}
export default Recommendations;