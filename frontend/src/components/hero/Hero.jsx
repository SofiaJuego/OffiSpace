import React, { useState } from "react";
import { DateRange } from "react-date-range";
import { format } from "date-fns"
import { es } from "date-fns/locale";
import styles from "../hero/Hero.module.css";
import "../../styles/CalendarStyles.css"

function Hero(){

    const [openCalendar, setOpenCalendar] = useState(false);
    const [dateRange, setDateRange] = useState([
        {
            startDate: null,
            endDate: null,
            key:"selection"
        }
    ]);

    const [hasSelectedDates, setHasSelectedDates] = useState(false);


    const formattedRange = dateRange[0].startDate && dateRange[0].endDate
    ? `${format(dateRange[0].startDate, "dd/MM/yyyy")} - ${format(dateRange[0].endDate, "dd/MM/yyyy")}`: "";

    return(
        <section className={styles.hero}>
            <div className={styles.overlay}>
                <h1 className={styles.title}>Trabaja a tu manera, reserva en segundos</h1>
                
                <div className={styles.searchBar}>
                    <input type="text" 
                    placeholder="Buscar por ciudad o espacio" 
                    className={styles.inputText}
                    />

                    <div className={styles.dateInputWrapper}>
                        <input 
                        type="text"
                        value={hasSelectedDates ? formattedRange: ""}
                        onClick={() => setOpenCalendar(!openCalendar)}
                        readOnly
                        className={styles.inputDate}
                        placeholder="Check in - Check out"
                        />
                        {openCalendar && (
                            <div className={styles.calendarWrapper}>
                                <DateRange
                                editableDataInputs={true}
                                onChange={item => { 
                                    setDateRange([item.selection])

                                    const {startDate, endDate} = item.selection;

                                     console.log("Seleccionado:", startDate, endDate);

                                    if (startDate && endDate && startDate.getTime() != endDate.getTime()){
                                        setHasSelectedDates(true);
                                        setOpenCalendar(false);
                                    }
                                }}
                                moveRangeOnFirstSelection={false}
                                ranges={dateRange}
                                rangeColors={["#fa5d3e"]}
                                minDate={new Date()}
                                locale={es}
                                showDateDisplay = {false}
                                />
                            
                                
                            </div>
                                
                        )}
                    
                    </div>
                    <button className={styles.searchBtn}>Buscar</button>
                </div>

            </div>

        </section>
    );
}

export default Hero;