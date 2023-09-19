import {Routes, Route} from 'react-router-dom'
import {BrowserRouter} from'react-router-dom'
import './App.css';
import Login from './Components/Login/Login';
import SigUp from './Components/SigUp/SigUp';
import Header from './Components/Header/Header';
import SideBar from './Components/SideBar/SideBar';
import Recommend from './Components/Recommend/Recommend';
import Products from './Components/Products/Products';
function App() {
  return (
    <div className="App">


     <BrowserRouter>
      <Routes>
      <Route path= "/" element={<SideBar/>}/>
        
      </Routes>
      <Routes>
          <Route path= "/" element={<Header/>}/>
          <Route path= "/login" element = {<Login/>}/>
          <Route path= "/register" element = {<SigUp/>}/>
        </Routes>
      <Routes>
      <Route path= "/" element={<Recommend/>}/>
        
      </Routes>
      <Routes>
      <Route path= "/" element={<Products/>}/>
        
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
