import React from "react";
import { Routes, Route } from "react-router-dom";
import HomePage from "../src/features/home/HomePage";
import SpaceDetail from "../src/features/spacedetail/SpaceDetail"
import SearchResults from "./features/search/SearchResults";
import LoginPage from "./features/login-register/login/LoginPage"



function App() {
  return (
    <Routes>
      <Route path="/" element={<LoginPage />} />
      {/* <Route path="/" element={<SearchResults />} /> */}
      {/* <Route path="/" element={<HomePage />} />  */}
      {/* <Route path="/" element={<SpaceDetail />} /> */}
    </Routes>
  );
}

export default App;
