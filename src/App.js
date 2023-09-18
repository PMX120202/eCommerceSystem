import {Routes, Route} from 'react-router-dom'
import './App.css';
import Login from './Components/Login/Login';
import SigUp from './Components/SigUp/SigUp';

function App() {
  return (
    <div className="App">
     <nav>
      <ul>
        <li>
          <a href='/'>Home</a>
        </li>
        <li>
          <a href='/login'>Login</a>
        </li>
        <li>
          <a href='/register'>SigUp</a>
        </li>
      </ul>
     </nav>
     <Routes>
      <Route path= "/" />
      <Route path= "/login" element = {<Login/>}/>
      <Route path= "/register" element = {<SigUp/>}/>
     </Routes>

    </div>
  );
}

export default App;
