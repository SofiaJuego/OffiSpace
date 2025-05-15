import React from "react";
import Navbar from "../../components/navbar/Navbar";
import Hero from "../../components/hero/Hero";
import SpaceType  from "../../components/spaceType/SpaceTypeSection";
import Recommendations from "../../components/recommendations/Recommendations";
import Footer from "../../components/footer/Footer";

function HomePage() {
  return (

    <div>
    <Navbar/>
    <Hero/>
    <SpaceType/>
    <Recommendations/>
    <Footer/>
    
  </div>
  

);  
  
}

export default HomePage;