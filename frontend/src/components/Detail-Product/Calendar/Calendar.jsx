import React, { useState } from "react";
import { DayPicker } from 'react-day-picker';
import 'react-day-picker/dist/style.css';
import { es } from 'date-fns/locale';
import styles from "../Calendar/Calendar.module.css"

// Fechas reservadas de ejemplo
const reservedDates = [
  new Date("2025-05-18"),
  new Date("2025-05-20"),
  new Date("2025-05-25"),
];

function Calendar(){
    return(
        <section className={styles.calendarContainer}>
            <h3 className={styles.title}>Disponibilidad</h3>
            
            <DayPicker 
            disabled={reservedDates}
            modifiersClassNames={{ disabled: 'reservedDay' }}
            numberOfMonths={2}
            pagedNavigation
            locale={es}
            />
 
        </section>
    );

}

export default Calendar;