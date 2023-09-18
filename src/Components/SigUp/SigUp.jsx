import React from 'react'
import './SigUp.css'

import user_icon from '../Assets/person.png'
import email_con from '../Assets/email.png'
import password_icon from '../Assets/password.png'

const SigUp = () => {
  return (
    <div className='container'>
        <div className='header'>
            <div className='text'>Sig Up</div>
            <div className='underline'></div>
        </div>
        <div className='inputs'>
            <div className="input">
                <img src={user_icon} alt=""  />
                <input type="text" placeholder='Name' />
            </div> 

            <div className="custom-select">
                <label for="sex">Choose your sex: </label>
                <select>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Undefine">Undefine</option>
                </select>
            </div> 

            <div className="input">
                <img src={email_con} alt=""  />
                <input type="email" placeholder='Email'/>
            </div>
            <div className="input">
                <img src={password_icon} alt=""  />
                <input type="password" placeholder='Password' />
            </div>
            <div className="input">
                <img src={password_icon} alt=""  />
                <input type="password" placeholder='Confirm Password' />
            </div>

        
            <div className="input">
                <img src={user_icon} alt=""  />
                <input type="text" placeholder='Address' />
            </div> 
            
   
            
        </div>
       
        <div className="submit-container">
            <div className="submit" >Submit</div>

        </div>
        
    </div>
  )
}

export default SigUp