import React from 'react';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import style from './style.module.scss'
import { Header } from './component/header';
import Layout from './pages/layout';

function App() {
  return (
    <div >
      <div className={style.Container}>
        <Header />
        <Router>
          <Routes>
            <Route exact path="/" element={<Layout />} />
          </Routes>
        </Router>
    </div>
    </div>
  );
}

export default App;
