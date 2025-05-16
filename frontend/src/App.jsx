import React from "react";
import { Routes, Route } from "react-router-dom";
import HomePage from "../src/features/home/HomePage";
import SpaceDetail from "../src/features/spacedetail/SpaceDetail"



function App() {
  return (
    <Routes>
      {/* <Route path="/" element={<HomePage />} /> */}
      <Route path="/" element={<SpaceDetail />} />
    </Routes>
  );
}

export default App;
