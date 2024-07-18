import React from 'react';
import Home from "./components/Home.js"
import {BrowserRouter, Routes, Route} from 'react-router-dom';

class App extends React.Component {
  render() {
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home name="John"/>}/>
            </Routes>
        </BrowserRouter>
    );
  }
}

export default App;
