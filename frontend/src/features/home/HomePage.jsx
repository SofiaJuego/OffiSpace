import React from "react";
import Navbar from "../../components/Home/navbar/Navbar"
import Hero from "../../components/Home/hero/Hero";
import SpaceType  from "../../components/Home/spaceType/SpaceTypeSection";
import Recommendations from "../../components/Home/recommendations/Recommendations";
import Footer from "../../components/Home/footer/Footer";

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