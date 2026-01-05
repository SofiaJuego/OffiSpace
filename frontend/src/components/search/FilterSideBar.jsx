import React, { useState } from "react";
import styles from "../search/FilterSidebar.module.css";


function FilterSidebar(){
    const [budget, setBudget]= useState([5000, 2500]);
const [capacity, setCapacity] = useState(1);
const [selectedType, setSelectedType] = useState('');
const [amenities, setAmenities] = useState({
    wifi: false,
    parking:false,
    cafeteria:false,
    hotWater:false,
    ac:false,
    projector:false
});

const toggleAmenity = (key) => {
    setAmenities({...amenities, [key]: !amenities[key]});
}

return(
    <aside className={styles.sidebar}>
        <h3>Filtros</h3>

        <div className={styles.section}>
            <h4>Presupuesto</h4>
            <div className={styles.budgetInputs}>
            <input 
            type="number"
            value={budget[0]} 
            onChange={(e) => setBudget([+e.target.value, budget[1]])}
            />
            <span>-</span>
            <input type="number" 
            value={budget[1]} 
            onChange={(e) => setBudget([budget[0], +e.target.value ])}
            />
        </div>
        </div>
        <div className={styles.section}>
            <h4>Tipo de espacio</h4>
            <div className={styles.options}>
                {['Oficina privada', 'Sala de reuniones', 'Sala para eventos', 'Networking'].map((type) =>(
                    <button
                    key={type}
                    className={`${styles.optionBtn} ${selectedType === type ? styles.active: ''}`}
                    onClick={() => setSelectedType(type)}
                    >
                        {type}

                    </button>
                ))}
            </div>
        </div>

        <div className={styles.section}>
            <h4>Comodidades</h4>
            <div className={styles.checkboxGroup}>
                {[
            ['wifi', 'Wi-Fi'],
            ['parking', 'Estacionamiento'],
            ['cafeteria', 'Cafetería'],
            ['hotWater', 'Agua caliente'],
            ['ac', 'Aire acondicionado'],
            ['projector', 'Proyector'],
          ].map(([key, label]) => (
            <label key={key} className={styles.checkboxLabel}>
              <input
                type="checkbox"
                checked={amenities[key]}
                onChange={() => toggleAmenity(key)}
              />
               {label}
            </label>
        ))}
        </div>
        </div>

        <div className={styles.section}>
            <h4>Capacidad</h4>
            <div className={styles.capacityControl}>
                <button onClick={() => setCapacity(Math.max(1, capacity - 1))}>-</button>
                <span>{capacity}</span>
                <button onClick={()=> setCapacity(capacity + 1)}>+</button>
            </div>
        </div>  
        
    </aside>
);
}
export default FilterSidebar;
