import React, {useState} from 'react'
import './Login.css'

import { Link, useNavigate } from "react-router-dom";

import user_icon from '../Assets/person.png'
import email_con from '../Assets/email.png'
import password_icon from '../Assets/password.png'
import SigUp from '../SigUp/SigUp'

const Login = () => {
//   const navigate = useNavigate();

//   const [action, setAction]= useState("Login")
//   const handleSignUpClick = () => {
//     setAction("Sig Up");
//     navigate("/register");
//   };
  const [action, setAction]= useState("Login")

  return (
    <div className='container'>
        <div className='header'>
            <div className='text'>{action}</div>
            <div className='underline'></div>
        </div>
        <div className='inputs'>
            {/* {action === "Login"? <div></div> :<div className="input">
                <img src={user_icon} alt=""  />
                <input type="text" placeholder='Name' />
            </div> } */}
            
            <div className="input">
                <img src={email_con} alt=""  />
                <input type="email" placeholder='Email'/>
            </div>
            <div className="input">
                <img src={password_icon} alt=""  />
                <input type="password" placeholder='Password' />
            </div>
        </div>
        <div className="forgot-password">Loss Password? <pan>Click Here</pan></div>
        <div className="submit-container">
            {/* <div
                className={action === "Login" ? "submit gray" : "submit"}
                onClick={handleSignUpClick}
            >
                Sign Up
            </div> */}
            <div
                className={action === "Sign Up" ? "submit gray" : "submit"}
                onClick={() => {
                setAction("Login");
                }}
            >
                Login
            </div>
        </div>

    </div>
  )
}

export default Login