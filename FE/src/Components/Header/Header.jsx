import {FiHeart} from 'react-icons/fi'
import {AiOutlineShoppingCart, AiOutlineUserAdd} from 'react-icons/ai'
import {  useNavigate } from "react-router-dom";


import './Header.css'
import React from 'react'

const Header = ({handleInputChange, query }) => {
  const navigate = useNavigate();
  const handleSignUpClick = () => {
    navigate("/register");
  };

  const handleLogInClick = () => {
    navigate("/login");
  };
  return (
    <div>
      <nav>
          <div className='nav-container'>
              <input  type='text' 
                      className='search-input' 
                      onChange={handleInputChange}
                      value={query}
                      placeholder='Search here'/>
          </div>
          {/* <div className="profile-container">
              <a href='#'>
                  <FiHeart className='nav-icons'/>

              </a>
              <a href=''>
                  <AiOutlineShoppingCart className='nav-icons'/>
              </a>
          </div> */}
          <div class="d-grid gap-2 d-md-flex justify-content-md-end">
              <button class="btn btn-outline-info me-md-2" type="button" onClick={handleLogInClick}>Sigin</button>
              <button class="btn btn-outline-info me-md-2" type="button" onClick={handleSignUpClick} >Register</button>
          </div>
      </nav>
    </div>
    
  )

}

export default Header
