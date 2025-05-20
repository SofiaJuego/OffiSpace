
import React from 'react';
import Navbar from "../../components/Home/navbar/Navbar"
import ImageGallery from '../../components/Detail-Product/Gallery/ImageGallery';
import Footer from "../../components/Home/footer/Footer"
import InfoSection from '../../components/Detail-Product/InfoSection/InfoSection';
import SpaceFeatures from '../../components/Detail-Product/SpaceFeatures/SpaceFeatures';
import Calendar from '../../components/Detail-Product/Calendar/Calendar';
import Reviews from '../../components/Detail-Product/Reviews/Reviews';


function SpaceDetail() {
  return (

    <div>
    <Navbar/>
    <ImageGallery/>
    <InfoSection/>
    <SpaceFeatures/>
    <Calendar/>
    <Reviews/>
    <Footer/>   
  </div>
  

);  
  
}

export default SpaceDetail;

