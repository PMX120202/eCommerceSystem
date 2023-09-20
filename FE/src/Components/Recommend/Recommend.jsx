import React from 'react'
import './Recommend.css'

const Recommend = () => {
  return (
    <div>
      <h2 className='recommended-title'>Recommend</h2>
        <div className='recommended-flex'>
            <button className='btn btn-success me-md-2'>All Products</button>
            <button className='btn btn-success me-md-2'>Books</button>
            <button className='btn btn-success me-md-2'>Clothes</button>
            <button className='btn btn-success me-md-2'>Shoes</button>
        </div>
    </div>
  )
}

export default Recommend
