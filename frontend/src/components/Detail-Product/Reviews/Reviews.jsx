import React from 'react';
import styles from './Reviews.module.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faStar as solidStar } from '@fortawesome/free-solid-svg-icons';
import { faStar as regularStar } from '@fortawesome/free-regular-svg-icons';

const reviews = [
  {
    id: 1,
    user: 'Ana',
    date: '2025-05-10',
    rating: 5,
    comment: 'El lugar fue excelente, limpio y muy cómodo. ',
  },
  {
    id: 2,
    user: 'Carlos',
    date: '2025-05-08',
    rating: 4,
    comment: 'Buena ubicación y muy tranquilo.',
  },
];

function Reviews(){
  return(
    <section className={styles.reviewsContainer}>
      <h3 className={styles.title}>Reseñas</h3>
      <div className={styles.reviewsGrid}>
         {reviews.map((reviews) => (
        <div key={reviews.id} className={styles.reviewCard}>
            <strong className={styles.username}>{reviews.user}</strong>
            <span className={styles.date}>{new Date(reviews.date).toLocaleDateString('es-ES')}</span>
          <div className={styles.stars}>
            {[...Array(5)].map((_,i)=>(
              <FontAwesomeIcon
              key={i}
              icon={i < reviews.rating ? solidStar : regularStar}
              className={styles.starIcon} 
              />
            ))}
          </div>
          <p className={styles.comment}>{reviews.comment}</p>
        </div>
      ))}
      </div>
     
    </section>
  );
    
}

export default Reviews;