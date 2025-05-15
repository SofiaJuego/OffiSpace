import React from "react";
import { Routes, Route } from "react-router-dom";
import HomePage from "./features/home/HomePage";


function App() {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
    </Routes>
  );
}

export default App;
