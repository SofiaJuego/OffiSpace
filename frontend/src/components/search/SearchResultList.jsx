import React, { useState } from 'react';
import styles from './SearchResultList.module.css';
import Card from '../../components/Cards/Card';


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
function SearchResultList(){
    const selected = mockProducts.slice(0,6);
    const [currentPage, setCurrentPage] = useState(1);

    //Simulación de resultados

    const totalResults = 100;
    const resultsPerPage = 6;
    const totalPages = Math.ceil(totalResults / resultsPerPage);
    
    const results = Array.from({ length: resultsPerPage }, (_, index) => ({
        id: index + 1 + (currentPage - 1) * resultsPerPage,
        host: "Nombre Anfitrión",
        price: 17000,}));
        
        const appliedFilters = ["Wi-Fi", "Oficina privada", "10 personas"];

        return(
            <section className={styles.resultSection}>
                <div className={styles.header}>
                    <h3>Resultado de busqueda</h3>
                    
                    <div className={styles.sortButtons}>
                      <p>Ordenar por</p>
                      <button>Mayor</button>
                      <button>Menor</button>
                    </div>
                </div>
                <p>{totalResults} Resultados</p>


                <div className={styles.appliedFilters}>
                    {appliedFilters.map((filter, index) => (
                        <span key={index} className={styles.filterTag}>
                            {filter} <button className={styles.removeBtn}>X</button>
                        </span>
                    ))}
                    <button className={styles.clearFilters}>Eliminar filtros</button>
                </div>

                    

                    <div className={styles.containerCard}>
                        {mockProducts.map((product, index) => (
                            <Card key={index} product={product} />
                            ))}
                    </div>

                    <div className={styles.pagination}>
                        <button onClick={() => setCurrentPage((p) => Math.max(1,p - 1))} disabled={currentPage === 1}>
                            Anterior</button>
                        {Array.from({length:totalPages}).map((_,i) =>(
                            <button
                            key={i}
                            className={currentPage === i + 1 ? styles.active: ''}
                            onClick={() => setCurrentPage(i + 1)}
                            >
                                {i + 1}
                            </button>
                        ))}
                        <button onClick={() => setCurrentPage((p) => Math.min(totalPages,p + 1))}disabled={currentPage === totalPages}>
                            Siguiente
                        </button>
                        </div>
               
            </section>
        );
}

export default SearchResultList;