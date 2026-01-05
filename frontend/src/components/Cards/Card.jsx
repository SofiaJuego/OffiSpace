import styles from "../Cards/Card.module.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faHeart as solidHeart, faStar } from "@fortawesome/free-solid-svg-icons";
import { faHeart as regularHeart } from "@fortawesome/free-regular-svg-icons";

function Card({ product }){
    return(
          <div className={styles.card}>
            <img src={product.image} alt={product.title}/>
            <div className={styles.cardContent}>
                <div className={styles.titleRow}>
                    <h3>{product.title}</h3>
                    <FontAwesomeIcon icon={regularHeart} className={styles.heartIcon}/>
                    </div>
                      
                      <span className={styles.category}>{product.category}</span>
                      <p>{product.description}</p>
                      
                      <div className={styles.rating}>
                        <FontAwesomeIcon icon={faStar} className={styles.starIcon}/>
                        {product.rating}
                      </div>

                      <div className={styles.buttonRow}>
                        <div className={styles.price}>${product.price}/dia</div>
                        <button>Ver más</button>
                      </div>
                    </div>
                </div>
                
    )
}
export default Card;