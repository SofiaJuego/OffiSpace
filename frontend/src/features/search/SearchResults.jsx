import React from "react";
import Navbar from "../../components/Home/navbar/Navbar"
import Footer from "../../components/Home/footer/Footer";
import FilterSidebar from "../../components/search/FilterSideBar";
import SearchResultList from "../../components/search/SearchResultList";
import styles from "../search/SearchResults.module.css"
 

function SearchResults(){

    return(
        <div>
            <Navbar/>
            <div className={styles.container}>
                <FilterSidebar/>
                <SearchResultList/>
            </div>

            <Footer/>

        </div>
        
    );

}

export default SearchResults;