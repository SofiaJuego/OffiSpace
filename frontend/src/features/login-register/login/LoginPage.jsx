import React from "react";
import Footer from "../../../components/Home/footer/Footer";
import LoginForm from "../../../components/login-register/login/LoginForm";
import "../../login-register/login/login.css"


function LoginPage(){
    return(
        
        <div className="loginPage">
             <LoginForm/>
            
            <Footer/>
        </div>
      
        
         
        


    );
}

export default LoginPage;