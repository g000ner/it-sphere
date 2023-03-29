import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import style from "./style.module.scss";
import { Header } from "./component/header";
import Layout from "./pages/layout";
import Registration from "./pages/ registration";
import Entry from "./pages/ entry";
import PostPage from "./pages/post";
import Profile from "./pages/profile";
import NewPost from "./pages/new-post";

function App() {
  return (
    <div>
      <div className={style.Container}>
        <Header />
        <Router>
          <Routes>
            <Route exact path="/" element={<Layout />} />
            <Route exact path="/registration" element={<Registration />} />
            <Route exact path="/entry" element={<Entry />} />
            <Route exact path="/post" element={<PostPage />} />
            <Route exact path="/profile" element={<Profile />} />
            <Route exact path="/new-post" element={<NewPost/>} />
          </Routes>
        </Router>
      </div>
    </div>
  );
}

export default App;
