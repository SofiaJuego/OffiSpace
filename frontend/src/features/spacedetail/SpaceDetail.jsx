
import React from 'react';
import Navbar from "../../components/Home/navbar/Navbar"
import ImageGallery from '../../components/Detail-Product/Gallery/ImageGallery';
import Footer from "../../components/Home/footer/Footer"
import InfoSection from '../../components/Detail-Product/InfoSection/InfoSection';
import SpaceFeatures from '../../components/Detail-Product/SpaceFeatures/SpaceFeatures';


function SpaceDetail() {
  return (

    <div>
    <Navbar/>
    <ImageGallery/>
    <InfoSection/>
    <SpaceFeatures/>
    <Footer/>

    
  </div>
  

);  
  
}

export default SpaceDetail;

